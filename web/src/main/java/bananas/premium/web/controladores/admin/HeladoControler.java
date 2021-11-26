package bananas.premium.web.controladores.admin;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import bananas.premium.web.Data.Dao.HeladoDAO;
import bananas.premium.web.modelos.Helado;

@Controller
@RequestMapping("/helados")
public class HeladoControler {
    HeladoDAO dao = new HeladoDAO();
    ObjectMapper obj = new ObjectMapper();

    @GetMapping("/")
    public String getHelados(){
        
        List<Helado> Helados = dao.getAll();
        for(Helado s:Helados){
            System.out.println(s.getNombre());
        }
        return "admin/Helados";
    }


    @PostMapping(value="/crear")
    public String insertarHelado(HttpEntity<String> httpEntity){
        Helado usu = new Helado();
        String json = httpEntity.getBody();
        System.out.println("json: " +json);
        try{
        usu= obj.readValue(json,Helado.class);
        System.out.println("Helado: " +usu.getNombre());
        }catch(Exception e){
            e.printStackTrace();
        }

       int nuevoID= dao.insert(usu);
       System.out.println("id nuevo: " +nuevoID);
        return getHelados();
    }


    @PostMapping(value="/elim")
    public String eliminarHelado(@RequestAttribute int id) {
        int elim= dao.delete(id);
        System.out.println("AAAAHHHH \n\n Eliminado: "+elim+"   ***\n****");
         return getHelados();
     }

     
     @PostMapping("/upd")
     public String updateHelado(HttpEntity<String> httpEntity){
        Helado usu = new Helado();
      String json = httpEntity.getBody();
      System.out.println("json: " +json);
      try{
      usu= obj.readValue(json,Helado.class);
      System.out.println("Helado: " +usu.getNombre());
      }catch(Exception e){
          e.printStackTrace();
      }

     int nuevoID= dao.actualizar(usu);
     System.out.println("id nuevo: " +nuevoID);
      return getHelados();
  }
    
}