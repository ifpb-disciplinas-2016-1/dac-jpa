package ifpb.ads.dac.bi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/07/2016, 09:27:58
 */
@Entity
public class Empregado implements Serializable {

    @Id
    private String matricula;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Vaga vaga;

    @OneToMany(mappedBy = "gerente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Projeto> projetos;

    public Empregado() {
        this.projetos = new ArrayList<>();
    }

    public Empregado(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.projetos = new ArrayList<>();
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Collection<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(Collection<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void addProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

}
