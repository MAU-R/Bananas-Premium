package bananas.premium.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class indexController {
    
    @GetMapping({"/", "/index", "/inicio", "home"})
    public String index(Model model){
       // model.addAttribute("texto", "asldkfjakld");
        return "/compras/index";
    }

    @GetMapping("/login")
    public String login(Model model){
       // model.addAttribute("texto", "asldkfjakld");
        return "/compras/login";
    }
    @GetMapping("/map")
    public String map(Model model){
       // model.addAttribute("texto", "asldkfjakld");
        return "/compras/map";
    }
    @GetMapping("/fragments")
    public String fragments(Model model){
       // model.addAttribute("texto", "asldkfjakld");
        return "/compras/fragments";
    }
    @GetMapping("/shop")
    public String shop(Model model){
       // model.addAttribute("texto", "asldkfjakld");
        return "/compras/shop";
    }
    @GetMapping("/cart")
    public String cart(Model model){
       // model.addAttribute("texto", "asldkfjakld");
        return "/compras/cart";
    }
}
