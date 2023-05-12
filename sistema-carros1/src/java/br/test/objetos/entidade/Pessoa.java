/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe utilizada para representar uma Pessoa.
 */
@Table(name="pessoa")
@Entity
public class Pessoa implements Serializable {
  private static final long serialVersionUID = -1905907502453138175L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String cpf;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name="PESSOA_TELEFONE",
             joinColumns={@JoinColumn(name = "PESSOA_ID")},
             inverseJoinColumns={@JoinColumn(name = "TELEFONE_ID")})
  private List<Telefone> telefones;

  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public List<Telefone> getTelefones() {
    return telefones;
  }
  public void setTelefones(List<Telefone> telefones) {
    this.telefones = telefones;
  }
}