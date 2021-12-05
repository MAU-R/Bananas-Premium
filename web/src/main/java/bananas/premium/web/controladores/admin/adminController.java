package bananas.premium.web.controladores.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bananas.premium.web.modelos.Usuario;

@Controller
@RequestMapping("/admin")
@SessionAttributes("usuarioLog")
public class adminController {


    @ModelAttribute("usuario")
    public Usuario usuario(@ModelAttribute("usuarioLog") Usuario usuariolog){
        try{
            Usuario usuario = usuariolog;
           // System.out.println(usuario.getNombre());
            return usuario;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/-1")
    public String getAdmin1(){
        
        return "admin/manager/admin1";
    }
    @GetMapping("/-2")
    public String getAdmin2(){
        return "admin/manager/admin2";
    }
    @GetMapping("/edit/emplooye")
    public String geteditemp(){
        return "admin/manager/admineditemp";
    }
    @GetMapping("/edit/ice")
    public String geteditemps(){
        return "admin/manager/admineditic";
    }
    @GetMapping("/stats")
    public String getStats(){
        return "admin/manager/stats";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest req ,SessionStatus status){
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuarioLog", null);
        status.setComplete();
        return "compras/index";

    }
}
