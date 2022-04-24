package com.gama.academy.dto;

import com.gama.academy.model.Endereco;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmpresaDTO {

    public Endereco getEndereco;

    private Long id;

    @NotBlank(message = "Nome Fantasia: ")
    private String nomeFantasia;

    @NotBlank(message = "Razão Social: ")
    private String razaoSocial;

    @CNPJ(message = "CNPJ: ")
    private String cnpj;

    @Email(message = "Email: ")
    private String email;

    @NotNull(message = "Tefone: ")
    private String telefone;

    public EmpresaDTO(Long id, String nomeFantasia, String razaoSocial, String cnpj, String email, String telefone, Endereco endereco) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.getEndereco = endereco;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getGetEndereco() {
        return getEndereco;
    }
}
