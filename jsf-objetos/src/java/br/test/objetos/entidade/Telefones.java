
package br.test.objetos.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name="telefone")
public class Telefones implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer telefone_id; 
    
    @ManyToOne
    @JoinColumn(name="nome_fabrica",referencedColumnName = "nome",insertable=false,updatable = true)
   
    private Fabrica fabrica;
    
    public Telefones() {
    }

    public Fabrica getFabrica() {
        return fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        this.fabrica = fabrica;
    }
    
  

    public Integer getTelefone_id() {
        return telefone_id;
    }

    public void setTelefone_id(Integer telefone_id) {
        this.telefone_id = telefone_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.telefone_id);
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
        if (!Objects.equals(this.telefone_id, other.telefone_id)) {
            return false;
        }
        return true;
    }


   
    

    
    
    
    
    
}


