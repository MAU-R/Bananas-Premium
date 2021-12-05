package bananas.premium.web.controladores.admin;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bananas.premium.web.Data.repository.HeladoRepository;
import bananas.premium.web.Data.repository.SucursalRepository;
import bananas.premium.web.Data.repository.UsuarioRepository;
import bananas.premium.web.Data.repository.detalleSucursalRepository;
import bananas.premium.web.modelos.Detalle_Sucursal;
import bananas.premium.web.modelos.Helado;
import bananas.premium.web.modelos.Sucursal;
import bananas.premium.web.modelos.Usuario;
import bananas.premium.web.modelos.detalleManager;

@Controller
@RequestMapping("/owner")
public class ownerController {
    private boolean baneo=false;
    @Autowired
    HeladoRepository heladoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    SucursalRepository sucursalRepository;
    @Autowired
    detalleSucursalRepository detalleSucursalRepository;
    @GetMapping("/-1")
    public String getOwner1(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }

        if(baneo){
            return("redirect:/inicio/login");
        }

      List<Helado> helados=  heladoRepository.getAll();
        model.addAttribute("helados", helados);
        List<detalleManager> managers = usuarioRepository.getManagers();
        model.addAttribute("managers", managers);
        return "admin/owner/owner1";
    }
    @GetMapping("/-2")
    public String getOwner2(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }

        if(baneo){
            return("redirect:/inicio/login");
        }
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/owner2";
    }
    @GetMapping("/-3")
    public String getOwner3(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }
 

        List<Sucursal> sucursals= sucursalRepository.getAll();
        model.addAttribute("sucursales", sucursals);
        return "admin/owner/owner3";
    }
    @GetMapping("/edit/emplooye")
    public String geteditempo(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }

        if(baneo){
            return("redirect:/inicio/login");
        }
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/ownereditemp";
    }
    @GetMapping("/edit/manager/{id}")
    public String geteditAdmino(Model model, HttpServletRequest request,@PathVariable int id){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }

        if(baneo){
            return("redirect:/inicio/login");
        }
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/owner/ownereditadmin";
    }
    @GetMapping("/add/ice")
    public String addice(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }
       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }

       model.addAttribute("helado", new Helado());
        return "admin/owner/ownereditic2";
    }
    @PostMapping("/add/ice")
    public String addIce(Model model, HttpServletRequest request, Helado helado){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }
       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }
        heladoRepository.insert(helado);
       model.addAttribute("helado", new Helado());
        return "redirect:/owner/-1";
    }
    @GetMapping("/edit/ice/{id}")
    public String geteditempso(Model model, HttpServletRequest request, @PathVariable int id){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }

        Helado helado = heladoRepository.getbyId(id);
        model.addAttribute("helado", helado);
        return "admin/owner/ownereditic";
    }
    @GetMapping("/delete/ice/{id}")
    public String deleteICE(Model model, HttpServletRequest request, @PathVariable int id){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }
        
        Helado helado = heladoRepository.getbyId(id);
        helado.baja=true;
        heladoRepository.actualizar(helado);
        return "redirect:/owner/-1";
    }
    @PostMapping("/edit/ice/{id}")
    public String editUser(Model model, HttpServletRequest request, @PathVariable int id, Helado helado){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }
     Helado helado2 = heladoRepository.getbyId(id);
     helado.setNombre(helado2.getNombre());
     helado.setImagen(helado2.getImagen());
     helado.setId(id);
      heladoRepository.actualizar(helado);
        return "redirect:/owner/-1";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest req ,SessionStatus status){
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuarioLog", null);
        status.setComplete();
        return "redirect:/inicio/";

    }
    





    @GetMapping("/edit/sucursal/{id}")
    public String getediloc(Model model, HttpServletRequest request, @PathVariable int id){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }

       Sucursal sucursal = sucursalRepository.getById(id);
        model.addAttribute("sucursal", sucursal);
        return "admin/owner/ownereditloc";
    }

    @PostMapping("/edit/sucursal/{id}")
    public String editLoc(Model model, HttpServletRequest request, @PathVariable int id, @RequestParam("manager") int id_manager, Sucursal sucursal){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }
        sucursal.setId(id);
        sucursalRepository.actualizar(sucursal);
        return "redirect:/owner/-1";
    }
    @GetMapping("/add/sucursal")
    public String addLocG(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }
       
        model.addAttribute("sucursal", new Sucursal());
        return "admin/owner/editloc2";
    }
    @PostMapping("/add/sucursal")
    public String addLoc(Model model, HttpServletRequest request, @RequestParam("manager") int id_manager, Sucursal sucursal){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }
        sucursalRepository.insert(sucursal);
        int id_suc= sucursalRepository.getLast();
        Detalle_Sucursal detalle= new Detalle_Sucursal();
        detalle.setId_sucursal(id_suc); detalle.setId_usuario(id_manager);
       detalleSucursalRepository.insert(detalle);
        model.addAttribute("sucursal", sucursal);
        return "redirect:/owner/-3";
    }
    @GetMapping("/delete/sucursal/{id}")
    public String deleteLoc(Model model, HttpServletRequest request, @PathVariable int id){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
         model.addAttribute("usuario", usuario);
        if(usuario!=null){
            baneo=false;
        }else{
            baneo=true;
        }

       }catch(Exception e){
           System.out.print(e);
       }
        if(baneo){
            return("redirect:/inicio/login");
        }

       Sucursal sucursal = sucursalRepository.getById(id);
       sucursal.baja=true;
       sucursalRepository.actualizar(sucursal);
        return "redirect:/owner/-3";
    }
}
