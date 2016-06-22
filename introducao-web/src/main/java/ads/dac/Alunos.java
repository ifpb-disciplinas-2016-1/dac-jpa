package ads.dac;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/06/2016, 09:24:14
 */
@Stateless
public class Alunos {

    @PersistenceContext(unitName = "ExemploPU")
    private EntityManager em;

    public void persist(Aluno aluno) {
        em.persist(aluno);
    }
    
    public List<Aluno> all(){
        return em.createQuery("Select p From Aluno p", Aluno.class)
                .getResultList();
    }
}
