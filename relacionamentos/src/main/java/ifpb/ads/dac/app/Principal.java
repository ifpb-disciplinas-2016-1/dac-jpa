package ifpb.ads.dac.app;

import ifpb.ads.dac.Endereco;
import ifpb.ads.dac.Faculdade;
import ifpb.ads.dac.Hobby;
import ifpb.ads.dac.Pessoa;
import ifpb.ads.dac.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/07/2016, 07:58:16
 */
public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RelacionamentoPU");
        EntityManager em = emf.createEntityManager();

        Pessoa pessoa = new Pessoa("kiko");
//        Pessoa pessoa = em.find(Pessoa.class, 52);
        Endereco endereco = new Endereco("Rua dela", "Cidade dele", "Bairro dele");
//        Endereco endereco = em.find(Endereco.class, 1);
        pessoa.setEndereco(endereco);

        pessoa.addTelefone(new Telefone("46781432", "CELULAR"));
//        pessoa.addTelefone(new Telefone("24141241412", "COMERCIAL"));
//        pessoa.addTelefone(new Telefone("12412412412", "CELULAR"));

//        Faculdade faculdade = em.find(Faculdade.class,"IFPB");
        Faculdade faculdade = new Faculdade("IFPB", "Rua Antonio");
        pessoa.setFaculdade(faculdade);
        
        Hobby futsal = new Hobby("Futsal");
        Hobby musica = new Hobby("Música");
        
//        pessoa.addHobby(musica);
//        pessoa.addHobby(futsal);
        
        em.getTransaction().begin();
        em.persist(endereco);
//        pessoa.getEndereco().setRua("Rua dele");
//        em.remove(pessoa);
        em.persist(pessoa);
        em.getTransaction().commit();
    }

}
