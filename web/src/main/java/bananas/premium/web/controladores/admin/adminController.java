package bananas.premium.web.controladores.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {
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
    public String logout(HttpServletRequest req){
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuarioLog", null);
        return "compras/index";

    }
}
