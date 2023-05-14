
package br.test.objetos.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="carros")
public class Carro implements Serializable{
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;  
  private String modelo;
  @ManyToOne
  private Fabrica fabrica;
  
  private String cor;
  
  @Temporal(TemporalType.DATE)
  private Date ano;
  
  public Carro() {
       
    }
  
  public Fabrica getFabrica() {
        return fabrica;
    }

  public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

  
  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
        this.modelo = modelo;
    }

  public String getCor() {
        return cor;
    }

  public void setCor(String cor) {
        this.cor = cor;
    }

  public Date getAno() {
        
        return ano;
    }

  public void setAno(Date ano) {
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
