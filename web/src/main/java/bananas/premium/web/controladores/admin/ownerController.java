package bananas.premium.web.controladores.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class ownerController {
    @GetMapping("/-1")
    public String getOwner1(){
        return "admin/owner/owner1";
    }
    @GetMapping("/-2")
    public String getOwner2(){
        return "admin/owner/owner2";
    }
    @GetMapping("/-3")
    public String getOwner3(){
        return "admin/owner/owner3";
    }
    @GetMapping("/edit/emplooye")
    public String geteditempo(){
        return "admin/owner/ownereditemp";
    }
    @GetMapping("/edit/admin")
    public String geteditAdmino(){
        return "admin/owner/ownereditadmin";
    }
    @GetMapping("/edit/ice")
    public String geteditempso(){
        return "admin/owner/ownereditloc";
    }
    
}
