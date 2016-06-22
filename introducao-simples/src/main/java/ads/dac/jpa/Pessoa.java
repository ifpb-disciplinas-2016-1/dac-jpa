package ads.dac.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/06/2016, 07:46:50
 */
@Entity
@Table(name = "TB_Pessoa")
@SequenceGenerator(name = "pessoa_id",allocationSize = 5)
@TableGenerator(name = "tabela_id",
        table = "GENERATOR",
        pkColumnName = "SEQ_NAME",
        valueColumnName = "SEQ_COUNT",
        
        pkColumnValue = "SEQ_GEN")
//@TableGenerator(name = "tabela_id2",
//        table = "GENERATOR",
//        pkColumnName = "SEQ_NAME",
//        valueColumnName = "SEQ_COUNT",
//        
//        pkColumnValue = "SEQ_GEN2")
public class Pessoa implements Serializable{

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,    
//            generator = "pessoa_id")
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "tabela_id")
    private int codigo;
    
    @Column(name = "nome_Completo",length = 60)
    private String nome ;
    private int idade;

    public Pessoa() {
    }

    public Pessoa(String nome, int idade) {
        this(0, nome, idade);
    }

    public Pessoa(int codigo, String nome, int idade) {
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
}
