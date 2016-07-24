package ifpb.dac.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList; 
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/02/2016, 08:07:24
 */
@Entity
@Access(AccessType.FIELD)
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    
    
    private LocalDate nascimento;
    
    
    
    @Enumerated(value = EnumType.ORDINAL)
    private Sexo sexo;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] foto;
    
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(nullable = true)
    private String postagem;
    
    @Embedded
    private Endereco endereco;
    
    @Transient
    private int idade;
    
    @ElementCollection
    @CollectionTable(name = "Telefones")
    private List<String> telefones;
    
//    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
//    private Temporario temp;

    public Funcionario() {
        
    }

    public Funcionario(String nome, LocalDate nascimento, Sexo sexo, byte[] foto) {

        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.foto = foto;
        this.telefones= new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Temporal(value = TemporalType.DATE)
    @Convert(converter = ConvertLocalDate.class)
    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }
    
    public void addTel(String tel){
        this.telefones.add(tel);
    }
    
    @Access(AccessType.PROPERTY)
    @Column(name = "prazo")
    public int getPrazo() {
        
        
       return nascimento.getDayOfYear()+15;
    }
    
    public void setPrazo(int i){
        
    }

//    public Temporario getTemp() {
//        return temp;
//    }
//
//    public void setTemp(Temporario temp) {
//        this.temp = temp;
//    }

    
}
