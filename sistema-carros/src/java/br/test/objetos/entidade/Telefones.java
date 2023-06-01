
package br.test.objetos.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="telefone")
public class Telefones implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    private String numero_telefone;
    
    @ManyToOne(optional = false,cascade = CascadeType.MERGE)
    private Fabrica fabrica;
    
    
    public Telefones() {
       
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the numero_telefone
     */
    public String getNumero_telefone() {
        return numero_telefone;
    }

    /**
     * @param numero_telefone the numero_telefone to set
     */
    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    /**
     * @return the fabrica
     */
    public Fabrica getFabrica() {
        return fabrica;
    }

    /**
     * @param fabrica the fabrica to set
     */
    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Telefones other = (Telefones) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  
    
  


   
    
    
    
}


