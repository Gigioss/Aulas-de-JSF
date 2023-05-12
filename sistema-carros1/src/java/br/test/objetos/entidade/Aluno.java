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
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
/**
 *
 * @author pc
 */
@Table(name="aluno")
@Entity
public class Aluno implements Serializable{
    private static final long serialVersionUID = -4292880217218734067L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private Long matricula;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(name="ALUNO_TELEFONE",
             joinColumns={@JoinColumn(name = "ALUNO_ID")},
             inverseJoinColumns={@JoinColumn(name = "TELEFONE_ID")})
  private List<Telefone> telefones;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getMatricula() {
    return matricula;
  }
  public void setMatricula(Long matricula) {
    this.matricula = matricula;
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
