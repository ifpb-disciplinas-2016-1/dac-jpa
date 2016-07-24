package ifpb.ads.dac;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/07/2016, 07:53:55
 */
@Entity
public class Pessoa implements Serializable {

    private String nome;
    @Id
    @GeneratedValue
    private int id;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", unique = true)
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private Set<Telefone> telefones;

    @ManyToOne(cascade = CascadeType.ALL)
    private Faculdade faculdade;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Hobby> hobbies;
    
    public Pessoa() {
        this("");
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.telefones = new HashSet<>();
        this.hobbies = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void addTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
    public void addHobby(Hobby hobby){
        this.hobbies.add(hobby);
    }
    

}
