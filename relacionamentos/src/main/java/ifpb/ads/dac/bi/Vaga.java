package ifpb.ads.dac.bi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 22/07/2016, 09:28:55
 */
@Entity
public class Vaga implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String localizacao;

    @OneToOne(mappedBy = "vaga")
    private Empregado empregado;

    public Vaga() {
    }

    public Vaga(String localizacao, Empregado empregado) {
        this.localizacao = localizacao;
        this.empregado = empregado;
        this.empregado.setVaga(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

}
