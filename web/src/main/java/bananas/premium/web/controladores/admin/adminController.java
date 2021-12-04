package bananas.premium.web.controladores.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {
    @GetMapping("/-1")
    public String getAdmin1(){
        return "admin/usuario/admin1";
    }
    @GetMapping("/-2")
    public String getAdmin2(){
        return "admin/usuario/admin2";
    }
    @GetMapping("/edit/emplooye")
    public String geteditemp(){
        return "admin/usuario/admineditemp";
    }
    @GetMapping("/edit/ice")
    public String geteditemps(){
        return "admin/usuario/admineditic";
    }
    @GetMapping("/stats")
    public String getStats(){
        return "admin/stats";
    }
}
