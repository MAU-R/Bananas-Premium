package bananas.premium.web.controladores.admin;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bananas.premium.web.Data.Dao.UsuarioDao;
import bananas.premium.web.modelos.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/usuarios")
public class UsuarioControler {

    UsuarioDao dao = new UsuarioDao();
    ObjectMapper obj = new ObjectMapper();

    @GetMapping("/")
    public String getUsuarios(){
        
        List<Usuario> usuarios = dao.getAll();
        for(Usuario s:usuarios){
            System.out.println(s.getNombre());
        }
        return "admin/usuarios";
    }


    @PostMapping(value="/crear")
    public String insertarUsuario(HttpEntity<String> httpEntity){
        Usuario usu = new Usuario();
        String json = httpEntity.getBody();
        System.out.println("json: " +json);
        try{
        usu= obj.readValue(json,Usuario.class);
        System.out.println("usuario: " +usu.getNombre());
        }catch(Exception e){
            e.printStackTrace();
        }

       int nuevoID= dao.insert(usu);
       System.out.println("id nuevo: " +nuevoID);
        return getUsuarios();
    }


    @PostMapping(value="/elim")
    public String eliminarUsuario(@RequestParam int id) {
        int elim= dao.delete(id);
        System.out.println("AAAAHHHH \n\n Eliminado: "+elim+"   ***\n****");
         return getUsuarios();
     }

     
     @PostMapping("/upd")
     public String updateUsuario(HttpEntity<String> httpEntity){
        Usuario usu = new Usuario();
      String json = httpEntity.getBody();
      System.out.println("json: " +json);
      try{
      usu= obj.readValue(json,Usuario.class);
      System.out.println("usuario: " +usu.getNombre());
      }catch(Exception e){
          e.printStackTrace();
      }

     int nuevoID= dao.actualizar(usu);
     System.out.println("id nuevo: " +nuevoID);
      return getUsuarios();
  }
    
}
