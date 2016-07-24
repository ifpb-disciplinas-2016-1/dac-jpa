package ifpb.dac.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 04/02/2016, 07:25:57
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Aluno> alunos;

    public Pessoa() {
        this.alunos = new ArrayList<>();
    }

    public Pessoa(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void removeAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

}
