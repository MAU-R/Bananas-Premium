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
import org.springframework.web.bind.annotation.SessionAttributes;

import bananas.premium.web.Data.repository.HeladoRepository;
import bananas.premium.web.Data.repository.UsuarioRepository;
import bananas.premium.web.modelos.Helado;
import bananas.premium.web.modelos.Usuario;
import bananas.premium.web.modelos.cantidad;

@Controller
@RequestMapping("/inicio")

public class indexController {
    
    @Autowired
    HeladoRepository heladoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @GetMapping({"/", "/index", "/inicio", "home"})
    public String index(Model model){
       // model.addAttribute("texto", "asldkfjakld");
        return "/compras/index";
    }

    @GetMapping("/login")
    public String login(Model model, HttpServletRequest req){
        HttpSession session= req.getSession();
        Usuario usuarioSesion = null;
        try{
             usuarioSesion = (Usuario)session.getAttribute("usuarioLog");
            session.setAttribute("usuarioLog", usuarioSesion);
        }catch(Exception e){
            System.out.println(e);
            session.setAttribute("usuarioLog", new Usuario());
          //  System.out.println("guardar arraylist");
        }
        try{ if(usuarioSesion!=null){
            if(usuarioSesion.getRol().equals("admin"))
            return "redirect:/admin/-1";
            if(usuarioSesion.getRol().equals("owner")){
                return "redirect:/owner/-1";
            }
            else{
                return "redirect:/admin/-1";
            }
        }
       }catch(Exception e){

       }
       
        model.addAttribute("usuario", new Usuario());
        return "/compras/login";
    }
    @PostMapping("/login")
    public String loginIn(Usuario usuario, Model model , HttpServletRequest req){
        HttpSession session= req.getSession();
        Usuario usuarioSesion = usuario;
        System.out.println("usuario ingreso");
        
       Usuario usuarioBase = usuarioRepository.getByInicio(usuario);
        try{
            if(!usuarioBase.getNombre().equals(null)){
                System.out.println(usuario.getNombre());
                session.setAttribute("usuarioLog", usuarioBase);
            }
        }catch(Exception e){
            return login(model, req);
        }
        
        model.addAttribute("usuario", usuario);
        return login(model, req);
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
            List<cantidad> heladosSesion = (List<cantidad>)session.getAttribute("helados");
            session.setAttribute("helados", heladosSesion);
        }catch(Exception e){
            System.out.println(e);
            session.setAttribute("helados", new ArrayList<>());
          //  System.out.println("guardar arraylist");
        }
        
        List<Helado> helados = heladoRepository.getAll();
        model.addAttribute("helados", helados);
        return "/compras/shop";
    }
    @GetMapping("/shop/add/{id}")
    public String shopAdd(Model model, @PathVariable int id, HttpServletRequest req){
        HttpSession sesion= req.getSession();
        try{
            List<cantidad> heladosSesion = (List<cantidad>)sesion.getAttribute("helados");
         //   System.out.println("Obtener helados");
            
            for (cantidad helado : heladosSesion) {
                if(helado.helado.getId()==id){
                  //  System.out.println("Helado Aumentado");
                    helado.cantidad++;
                    sesion.setAttribute("helados", heladosSesion);
                    return shop(model, req);
                }
            }
            heladosSesion.add(new cantidad(1, heladoRepository.getbyId(id)));
            
         //   System.out.println("Heladoguardado");
           sesion.setAttribute("helados", heladosSesion);
        }catch(Exception e){
            System.out.println(e);
            sesion.setAttribute("helados", new ArrayList<>());
          //  System.out.println("guardar arraylist");
        }
       
        return shop(model, req);
    }
    public void addAttribute(){

    }
    @GetMapping("/cart")
    public String cart(Model model ,HttpServletRequest req){
        HttpSession sesion= req.getSession();
        try{
            List<cantidad> heladosSesion = (List<cantidad>)sesion.getAttribute("helados");
          //  System.out.println("Obtener helados");
            model.addAttribute("helados", heladosSesion);
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Sin helados al parecer");
        }
        return "/compras/cart";
    }
}
