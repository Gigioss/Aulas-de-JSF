
package br.test.objetos.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Column;


@Entity
@Table(name="fabrica")
public class Fabrica implements Serializable{
    @Id
    @Column(name="fabrica_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer fabrica_id;
    private String nome;
    @OneToMany(mappedBy="fabrica",cascade=CascadeType.ALL,orphanRemoval =true)
   
    private List<Telefones> telefones = new ArrayList<>();
            
    public Fabrica() {
        
    }
    
    public void adionarTelefones(Telefones obj){
        obj.setFabrica(this);
        this.telefones.add(obj);
    }
    
     public void removerTelefones(int index){
        this.telefones.remove(index);
    }
   
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFabrica_id() {
        return fabrica_id;
    }

    public void setFabrica_id(Integer fabrica_id) {
        this.fabrica_id = fabrica_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.fabrica_id);
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
        final Fabrica other = (Fabrica) obj;
        if (!Objects.equals(this.fabrica_id, other.fabrica_id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the telefones
     */
    public List<Telefones> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<Telefones> telefones) {
        this.telefones = telefones;
    }


 
    
    
    
    
}


