package com.jeangabriel.cursomc.domain;

import com.jeangabriel.cursomc.domain.enums.TipoCliente;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private Integer tipoCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    //não precisa criar uma classe nova pois só tem um atributo simples e dependente de cliente
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, String cpf, TipoCliente tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipoCliente = tipoCliente.getCod();
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoCliente getTipoCliente() {
        return TipoCliente.toEnum(tipoCliente);
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente.getCod();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTipoCliente(Integer tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}