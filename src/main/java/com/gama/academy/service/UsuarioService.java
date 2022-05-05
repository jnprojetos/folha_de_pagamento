package com.gama.academy.service;

import com.gama.academy.exception.RegraNegocioException;
import com.gama.academy.model.Perfil;
import com.gama.academy.model.Usuario;
import com.gama.academy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilService perfilService;

    public Usuario novoUsuario(Usuario usuario){
        Perfil perfil = perfilService.buscaPorId(usuario.getPerfil().getId());
        boolean emailEmUso = usuarioRepository.findByEmail(usuario.getEmail())
                .stream().anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));
        if (emailEmUso){
            throw new RegraNegocioException("Já existe um usuário cadastrado com esse e-mail.");
        }else{
            usuario.setPerfil(perfil);
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }
    }
    public Usuario buscarUsuarioEmail(String email){
        var usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário ou senha inválido"));
        return usuario;
    }

    public Usuario buscaPorId(Long id){
        return usuarioRepository.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buscarUsuarioEmail(username);
    }
}
