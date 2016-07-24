package ifpb.dac.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 04/02/2016, 08:11:45
 */
@Entity
//@TableGenerator(
//        name = "gerador_chave_aluno",
//        table = "Generator_aluno",
//        pkColumnName = "chave_primaria",
//        valueColumnName = "valor_chave",
//        pkColumnValue = "aluno_id",
//        allocationSize = 1)
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//            TABLE,
//            generator = "gerador_chave_aluno")
    private int id;

    // http://stackoverflow.com/a/36327608
    // @Basic(fetch = FetchType.LAZY)
    private String matricula;

//    @Lob
//    @Basic(fetch = FetchType.LAZY)
//    private String textoGrande;
//    @Basic(fetch = FetchType.LAZY)
    //
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TabelaDoMEIO")
    private List<Exemplo> listas;

    public Aluno() {
        this("");
    }

    public Aluno(String matricula) {

        this.matricula = matricula;
//        this.textoGrande = textoGrande;
        this.listas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", matricula=" + matricula + '}';
    }

    public List<Exemplo> getListas() {
        return listas;
    }

    public void setListas(List<Exemplo> listas) {
        this.listas = listas;
    }

    public void add(String a) {
        this.listas.add(new Exemplo(a));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        hash = 67 * hash + Objects.hashCode(this.listas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.listas, other.listas)) {
            return false;
        }
        return true;
    }

}
