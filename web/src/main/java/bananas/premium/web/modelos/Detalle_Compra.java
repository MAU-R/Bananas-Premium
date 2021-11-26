package bananas.premium.web.modelos;

/**
 *
 * @author cruza
 */
public class Detalle_Compra {
    private int id;
    private int id_compra;
    private int id_sucursal;
    private int id_usuario;
    private int id_helado;
    private int canridad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_helado() {
        return id_helado;
    }

    public void setId_helado(int id_helado) {
        this.id_helado = id_helado;
    }

    public int getCanridad() {
        return canridad;
    }

    public void setCanridad(int canridad) {
        this.canridad = canridad;
    }
    
}
