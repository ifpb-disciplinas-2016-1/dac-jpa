package ifpb.dac.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2016, 23:44:43
 */
@Entity
@Table(name = "Exemplo")
public class Exemplo implements Serializable{

    @Id
    private String babas;

    private String cadassda;
    
    public Exemplo() {
    }

    
    public Exemplo(String b) {
        this.babas = b;
        this.cadassda = b+" sfasfas ";
    }

    public String getBabas() {
        return babas;
    }

    public void setBabas(String babas) {
        this.babas = babas;
    }

    public String getCadassda() {
        return cadassda;
    }

    public void setCadassda(String cadassda) {
        this.cadassda = cadassda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.babas);
        hash = 67 * hash + Objects.hashCode(this.cadassda);
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
        final Exemplo other = (Exemplo) obj;
        if (!Objects.equals(this.babas, other.babas)) {
            return false;
        }
        if (!Objects.equals(this.cadassda, other.cadassda)) {
            return false;
        }
        return true;
    }
    

}
