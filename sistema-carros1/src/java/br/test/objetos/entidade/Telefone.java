/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.test.objetos.entidade;

/**
 *
 * @author pc
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe utilizada para representar um Telefone.
 */
@Table(name="telefones1")
@Entity
public class Telefone implements Serializable {
  private static final long serialVersionUID = 7526502149208345058L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String tipo;
  private Integer numero;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Integer getNumero() {
    return numero;
  }
  public void setNumero(Integer numero) {
    this.numero = numero;
  }
  public String getTipo() {
    return tipo;
  }
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}