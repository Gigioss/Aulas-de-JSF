
package br.test.objetos.entidade;

import br.test.objetos.jpa.EntityManagerUtil;
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
import javax.persistence.FetchType;


@Entity
@Table(name="fabrica")
public class Fabrica implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome_fabrica")
    private String nome;
    @Column(name="numero")
    private String numero_telefone;
    
    public String getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(String numero_telefone) {
        this.numero_telefone = numero_telefone;
    }
    
    
    
    @OneToMany(mappedBy="fabrica",fetch=FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL )
    private List<Telefones> lista_telefones= new ArrayList<Telefones>();

    public List<Telefones> getLista_telefones() {
        return lista_telefones;
    }
    
    public void setLista_telefones(List<Telefones> lista_telefones) {
        this.lista_telefones = lista_telefones;
    }
    
    @OneToMany(mappedBy="fabrica",fetch=FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL )
    private List<Carro> lista_carro= new ArrayList<Carro>();

    public List<Carro> getLista_carro() {
        return lista_carro;
    }

    public void setLista_carro(List<Carro> lista_carro) {
        this.lista_carro = lista_carro;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
      
}


