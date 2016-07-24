package ifpb.ads.dac;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 20/07/2016, 07:56:34
 */
@Entity
public class Endereco implements Serializable {

    private String rua;
    private String cidade;
    private String bairro;
    @Id
    @GeneratedValue
    private int id;

    public Endereco() {
    }

    public Endereco(String rua, String cidade, String bairro) {
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
