package ads.dac;

import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/06/2016, 09:24:14
 */
//@Stateful
//@Singleton
//@Startup
@Stateless
public class Alunos {

    @PersistenceContext(unitName = "ExemploPU")
//            , type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public void persist(Aluno aluno) {
        em.persist(aluno);
    }

    public void merge(Aluno aluno) {
        aluno.setNome("Edit-" + aluno.getNome());
    }

    public List<Aluno> all() {
        return em.createQuery("Select p From Aluno p", Aluno.class)
                .getResultList();
    }

}
