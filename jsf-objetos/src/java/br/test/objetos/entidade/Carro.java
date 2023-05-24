
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
import javax.persistence.JoinColumn;
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
  private String cor;
  
  @ManyToOne
  @JoinColumn(name = "fabrica_id")
  private Fabrica fabrica_carro;
  
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Carro carro_modelo;

    public Carro getCarro_modelo() {
        return carro_modelo;
    }

    public void setCarro_modelo(Carro carro_modelo) {
        this.carro_modelo = carro_modelo;
    }
  
  
  
  
  
  @Temporal(TemporalType.DATE)
  private Date ano;
  
 
  public Carro() {
       
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

    /**
     * @return the fabrica_carro
     */
    public Fabrica getFabrica_carro() {
        return fabrica_carro;
    }

    /**
     * @param fabrica_carro the fabrica_carro to set
     */
    public void setFabrica_carro(Fabrica fabrica_carro) {
        this.fabrica_carro = fabrica_carro;
    }

  

}
