package bananas.premium.web.controladores;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import bananas.premium.web.Data.repository.HeladoRepository;
import bananas.premium.web.modelos.Helado;

@Controller
@RequestMapping("/inicio")
public class indexController {
    
    @Autowired
    HeladoRepository heladoRepository;

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
    public String shop(Model model, HttpServletRequest req){
        HttpSession session= req.getSession();
        try{
            List<Helado> heladosSesion = (List<Helado>)session.getAttribute("helados");
            session.setAttribute("helados", heladosSesion);
            System.out.println("guardar helados");
            for (Helado helado : heladosSesion) {
                System.out.println(helado.getNombre());
            }
        }catch(Exception e){
            System.out.println(e);
            session.setAttribute("helados", new ArrayList<>());
            System.out.println("guardar arraylist");
        }
        
        List<Helado> helados = heladoRepository.getAll();
        model.addAttribute("helados", helados);
        return "/compras/shop";
    }
    @GetMapping("/shop/add/{id}")
    public String shopAdd(Model model, @PathVariable int id, HttpServletRequest req){
        HttpSession sesion= req.getSession();
        try{
            List<Helado> heladosSesion = (List<Helado>)sesion.getAttribute("helados");
            sesion.setAttribute("helados", heladosSesion);
            System.out.println("Obtener helados");
            for (Helado helado : heladosSesion) {
                System.out.println(helado.getNombre());
            }
            heladosSesion.add(heladoRepository.getbyId(id));
            System.out.println("wuauuaua aheladoso");
            System.out.println("Heladoguardado");
           
           sesion.setAttribute("helados", heladosSesion);
        }catch(Exception e){
            System.out.println(e);
            sesion.setAttribute("helados", new ArrayList<>());
            System.out.println("guardar arraylist");
        }
       
        return shop(model, req);
    }
    public void addAttribute(){

    }
    @GetMapping("/cart")
    public String cart(Model model ,@SessionAttribute(name = "helados") List<Helado> heladosSesion){
       System.out.println("wuauuaua aheladoso");
      for (Helado helado : heladosSesion) {
        System.out.println(helado.getNombre());
      }
        return "/compras/cart";
    }
}
