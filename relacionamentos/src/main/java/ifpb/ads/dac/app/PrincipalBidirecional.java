package ifpb.ads.dac.app;

import ifpb.ads.dac.bi.Empregado;
import ifpb.ads.dac.bi.Vaga;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/07/2016, 09:32:46
 */
public class PrincipalBidirecional {

    public static void main(String[] args) {
        Empregado empregado = new Empregado("422", "Florinda"); //Possuidor
        Vaga vaga = new Vaga("B-322", empregado); //Inverso
//        Projeto projeto = new Projeto("DAC-Projeto 1", empregado);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelacionamentoPU");
        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(vaga);
//        em.persist(empregado);
//        em.persist(projeto);

//        em.getTransaction().commit();
//        
//        Vaga vagaResult = em.find(Vaga.class, 51);
//        System.out.println(vagaResult.getEmpregado().getNome());
        Empregado empregadoResult = em.find(Empregado.class, "432");
        System.out.println(empregadoResult.getNome());
//        empregadoResult.setNome("Madruga 14");
//        empregadoResult.getVaga().setLocalizacao("C-3335");
        
//        em.clear(); 
        
        em.getTransaction().begin();
//        em.merge(empregadoResult);
        em.remove(empregadoResult);
        em.getTransaction().commit();

//        em.getTransaction().begin();
//        for (Projeto proj : empregadoResult.getProjetos()) {
//            System.out.println(proj.getDescricao());
//        }

//        empregadoResult.getProjetos().stream()
//                .forEach(p -> System.out.println(p.getDescricao()));
//        em.getTransaction().commit();
//        List<Projeto> ps = new ArrayList<>(empregadoResult.getProjetos());
//        ps.forEach(p -> System.out.println(p.getDescricao()));

    }
}
