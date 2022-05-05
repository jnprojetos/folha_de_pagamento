package com.gama.academy.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class EnderecoDTO {

    private Long id;

    @NotBlank(message = "É necessário informar o logradouro")
    String logradouro;

    @NotBlank(message = "É necessário informar o número do endereço")
    String numero;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String complemento;

    @NotBlank(message = "É necessário informar o bairro")
    String bairro;

    @NotBlank(message = "É necessário informar a cidade")
    String cidade;

    @NotBlank(message = "É necessário informar o estado")
    String uf;

    @NotBlank(message = "É necessário informar o país")
    String pais;

    public EnderecoDTO(Long id, String logradouro, String numero, String complemento, String bairro, String cidade, String uf, String pais) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoDTO that = (EnderecoDTO) o;
        return Objects.equals(id, that.id) && logradouro.equals(that.logradouro) && numero.equals(that.numero) && Objects.equals(complemento, that.complemento)
            && bairro.equals(that.bairro) && cidade.equals(that.cidade) && uf.equals(that.uf) && pais.equals(that.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, logradouro, numero, complemento, bairro, cidade, uf, pais);
    }
}
