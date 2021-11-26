package bananas.premium.web.modelos;

/**
 *
 * @author cruza
 */
public class Sucursal {
    private int id;
    private String nombre;
    private String ubicacion;
    private String imagen;
    
    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getUbicacion(){
        return this.ubicacion;
    }

    public String getImagen(){
        return this.imagen;
    }


    public void setId(int id){
        this.id=id;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setUbicacion(String param){
        this.ubicacion=param;
    }

    public void setImagen(String param){
        this.imagen=param;
    }
}
