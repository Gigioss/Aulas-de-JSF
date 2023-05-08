
package br.test.objetos.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="carro")
public class Carro implements Serializable{
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer carro_id;
  
  
  private String modelo;
  private String fabricante;
  private String cor;
  
  @Temporal(TemporalType.DATE)
  private Date ano;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
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

    public Integer getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(Integer carro_id) {
        this.carro_id = carro_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.carro_id);
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
        if (!Objects.equals(this.carro_id, other.carro_id)) {
            return false;
        }
        return true;
    }

   

    
   
  
}
