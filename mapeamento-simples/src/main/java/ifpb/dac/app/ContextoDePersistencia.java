package ifpb.dac.app;

import ifpb.dac.domain.Compra;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 25/02/2016, 08:20:05
 */
public class ContextoDePersistencia {

    public static void main(String[] args) {
        EntityManager em = Persistence.
                createEntityManagerFactory("pessoaPU-postgres").
                createEntityManager();

//        EntityManager em2 = Persistence.
//                createEntityManagerFactory("pessoaPU").
//                createEntityManager();
        Compra compra = new Compra(90, 35.56);

        em.getTransaction().begin();
        em.persist(compra);
        em.getTransaction().commit();
        em.clear();

        //Compra comp = em.find(Compra.class, 1);
        em.getTransaction().begin();
        compra.setQuantidades(23);
        em.getTransaction().commit();

//        em.close();

//        em2.getTransaction().begin();
//        em2.persist(compra);
//        em2.getTransaction().commit();
    }
}
