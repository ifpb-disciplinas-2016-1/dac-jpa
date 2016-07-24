package ifpb.dac.domain;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/02/2016, 10:53:59
 */
@Entity
@Access(AccessType.FIELD)
public class Compra implements Serializable {

    @Id
    @GeneratedValue
//    @Access(AccessType.FIELD)
    private int id;
    private int quantidade;
    private double valor;

    public Compra() {
    }

    
    public Compra(int quantidade, double valor) {
        
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidades() {
        return quantidade;
    }

    public void setQuantidades(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Access(AccessType.PROPERTY)
    @Column(precision = 3, columnDefinition = "Decimal(10,2) default '100.00'")
    public double getSubTotal(){
        return quantidade * valor;
    }
    
    public void setSubTotal(double total){}
     
    

}
