package ifpb.dac.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/02/2016, 09:07:19
 */
@Embeddable
public class Endereco implements Serializable{

    private String rua;
    private String estado;

    public Endereco() {
    }

    public Endereco(String rua, String estado) {
        this.rua = rua;
        this.estado = estado;
    }
    

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
