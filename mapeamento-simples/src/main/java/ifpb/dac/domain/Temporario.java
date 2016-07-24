package ifpb.dac.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/02/2016, 08:43:21
 */
@Entity
public class Temporario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    public Temporario() {
    }

    public Temporario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Temporario( String nome) {
            
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
