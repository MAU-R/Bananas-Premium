package bananas.premium.web.modelos;

/**
 *
 * @author cruza
 */
public class Usuario {
    private int id;
    private String contraseña;
    private String rol;
    private String nombre;
    // private List<DetalleCompras> compras;
    public int getId(){
        return this.id;
    }

    public String getContraseña(){
        return this.contraseña;
    }

    public String getRol(){
        return this.rol;
    }

    public String getNombre(){
        return this.nombre;
    }


    public void setId(int id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setRol(String param){
        this.rol=param;
    }

    public void setContraseña(String param){
        this.contraseña=param;
    }
    /*
    public List<DetalleCompras> getCompras() {
        return compras;
    }

    public void setCompras(List<DetalleCompras> compras) {
        this.compras = compras;
    }
    */
    
}
