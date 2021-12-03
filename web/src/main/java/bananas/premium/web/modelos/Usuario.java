package bananas.premium.web.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name= "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
