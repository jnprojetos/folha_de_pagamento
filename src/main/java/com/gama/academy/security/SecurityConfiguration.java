package com.gama.academy.security;

import com.gama.academy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(Encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/v1/auth").permitAll()
                .antMatchers("/swagger/**").permitAll()
                .antMatchers(HttpMethod.GET, "/v1/dependetes").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/v1/dependentes/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/v1/fechamentos/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/v1/fechamentos/**").hasAuthority("ADMIN")
                .antMatchers("/v1/usuarios/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/v1/cargos/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/v1/cargos/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/v1/empresas/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/v1/empresas/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/v1/enderecos/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/v1/enderecos/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/v1/enderecos/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/v1/enderecos/**").hasAuthority("ADMIN")
                .antMatchers("/v1/alteracoes-salariais/**").hasAuthority("ADMIN")
            .anyRequest().authenticated()
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioService), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }

    @Bean
    public PasswordEncoder Encoder() {
        return new BCryptPasswordEncoder();
    }


}

