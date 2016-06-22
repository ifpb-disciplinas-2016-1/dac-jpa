package ads.dac;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/06/2016, 09:23:16
 */
@Named
@RequestScoped
public class Controlador {

    private Aluno aluno = new Aluno();
    @Inject
    private Alunos alunos;
    
    public String salvar(){
        alunos.persist(aluno);
        aluno= new Aluno();
        return null;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public List<Aluno> getTodosAlunos(){
        return alunos.all();
    }
    
}
