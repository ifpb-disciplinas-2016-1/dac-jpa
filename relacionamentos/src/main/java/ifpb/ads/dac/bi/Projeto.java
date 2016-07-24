package ifpb.ads.dac.bi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/07/2016, 09:54:20
 */
@Entity
public class Projeto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String descricao;

    @ManyToOne
//    @JoinColumn()
    private Empregado gerente;
    
    public Projeto() {
    }

    public Projeto(String descricao, Empregado gerente) {
        this.descricao = descricao;
        this.gerente = gerente;
        this.gerente.addProjeto(this);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
