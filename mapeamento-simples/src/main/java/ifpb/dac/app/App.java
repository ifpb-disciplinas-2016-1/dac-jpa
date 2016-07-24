package ifpb.dac.app;

import ifpb.dac.domain.Aluno;
import ifpb.dac.domain.Endereco;
import ifpb.dac.domain.Funcionario;
import ifpb.dac.domain.Pessoa;
import ifpb.dac.domain.Sexo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 04/02/2016, 07:29:49
 */
public class App {

    public static void main(String[] args) throws IOException {

        // Turma t = new Turma("DAC");
//       Aluno aluno = new Aluno("3132131");
//        Venda venda =  new Venda(893);
        byte[] foto = imageToByte("/Users/job/Documents/dev/ifpb/dac-jpa-atributos/src/main/resources/imagens/chaves.jpg");
        Funcionario funcionario
                = new Funcionario("Chaves", LocalDate.now(), Sexo.M, foto);
        funcionario.setPostagem("O programa utiliza interface com mix das principais cores do Facebook com o padrão visual do Instagram. O resultado é um visual agradável, familiar e fácil de usar, onde é possível ver os canais mais populares, os canais do usuário e aqueles que estã próximos.\n"
                + "\n"
                + "Apesar de permitir chats públicos, o app permite bate papo privado. Isso certamente irá agradar aqueles que precisam ter uma conversa em um cantinho, bem longe dos olhos dos outros participantes.\n"
                + "\n"
                + "E se no meio de tanta conversa os chat privados estiverem perturbando, o programa possui uma opção que serve para silenciar todos eles de uma única vez. Bem prática e útil essa função.\n"
                + "\n"
                + "A entrada no programa é feita através de uma conta do Facebook. Embora seja bastante popular, seria bem legal se o programa suportasse outras redes como Twitter, Google+ e etc.");
        funcionario.setEndereco(new Endereco("Rua do Kiko", "louco"));
        funcionario.addTel("123123131");
        funcionario.addTel("98678968756957");
        
//        salvar(funcionario, Unidade.POSTGRESQL);
//        salvar(new Compra(14, 34.7391d), Unidade.POSTGRESQL);

        
        
        
        Pessoa p = new Pessoa("Kiko");
//        Aluno aluno = new Aluno("132.1231.132");
//        p.addAluno(new Aluno("132.1231.132"));
//        p.addAluno(new Aluno("1986876988959"));
//        p.addAluno(aluno);
        
//        salvar(aluno, Unidade.DERBY);
//        salvar(p, Unidade.DERBY);
//       funcionario.setTemp(new Temporario("Kiko"));
       
//        remover(151L,funcionario, Unidade.POSTGRESQL);
//        salvar(funcionario, Unidade.POSTGRESQL);
        listarTodos(Aluno.class, Unidade.DERBY)
                .forEach(System.out::println);
        System.out.println("Persistindo"); 

    }

    public static void salvar(Object obj, Unidade unidade) {
        EntityManagerFactory em = Persistence.
                createEntityManagerFactory(unidade.nome());
        EntityManager e = em.createEntityManager();

        e.getTransaction().begin();
        e.persist(obj);
        e.getTransaction().commit();
        
        e.close();
        em.close();
    }
    public static void remover(Object key, Object obj, Unidade unidade) {
        EntityManagerFactory em = Persistence.
                createEntityManagerFactory(unidade.nome());
        EntityManager e = em.createEntityManager();

        e.getTransaction().begin();
        Object retorno = e.find(obj.getClass(), key);
        e.remove(retorno);
        e.getTransaction().commit();
        e.close();
        em.close();
    }
    public static<T> List<T> listarTodos(Class<T> classz, Unidade unidade) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory(unidade.nome());
        EntityManager em = emf.createEntityManager();
        TypedQuery<T> retorno = 
                em.createQuery("Select a From "+classz.getSimpleName()+" a ", classz);
        return retorno.getResultList();
    }

    public static byte[] imageToByte(String filePath) throws IOException {
        InputStream is = null;
        byte[] buffer = null;
        is = new FileInputStream(filePath);
        buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        return buffer;
    }

    public enum Unidade {

        DERBY("pessoaPU"),
        POSTGRESQL("pessoaPU-postgres");

        private String nome;

        private Unidade(String nome) {
            this.nome = nome;
        }
        
        public String nome() {
            return this.nome;
        }

    }
}
