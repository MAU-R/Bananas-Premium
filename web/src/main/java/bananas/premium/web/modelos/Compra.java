package bananas.premium.web.modelos;

import java.util.Date;

/**
 *
 * @author cruza
 */
public class Compra {
    private int id;
    private Date fecha;
    private double monto;
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Compra () {
        
    }
    
}
