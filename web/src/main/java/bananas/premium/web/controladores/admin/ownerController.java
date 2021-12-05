package bananas.premium.web.controladores.admin;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bananas.premium.web.modelos.Usuario;

@Controller
@RequestMapping("/owner")
@SessionAttributes("usuarioLog")
public class ownerController {
    private boolean baneo=false;
    @ModelAttribute("usuario")
    public Usuario usuario(@ModelAttribute("usuarioLog") Usuario usuariolog){
        try{
            Usuario usuario = usuariolog;
            System.out.println(usuario.getNombre());
            if(usuario.getNombre()==null){
                baneo=true;
            }else{
                baneo=false;
            }
            return usuario;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/-1")
    public String getOwner1(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/owner1";
    }
    @GetMapping("/-2")
    public String getOwner2(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/owner2";
    }
    @GetMapping("/-3")
    public String getOwner3(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/owner3";
    }
    @GetMapping("/edit/emplooye")
    public String geteditempo(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/ownereditemp";
    }
    @GetMapping("/edit/admin")
    public String geteditAdmino(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/ownereditadmin";
    }
    @GetMapping("/edit/ice")
    public String geteditempso(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/ownereditloc";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest req ,SessionStatus status){
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuarioLog", null);
        status.setComplete();
        return "redirect:/inicio/";

    }
    
}
