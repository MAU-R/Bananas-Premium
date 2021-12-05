package bananas.premium.web.controladores.admin;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bananas.premium.web.Data.repository.UsuarioRepository;
import bananas.premium.web.Data.repository.detalleSucursalRepository;
import bananas.premium.web.modelos.Usuario;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    detalleSucursalRepository detalleRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    private Usuario admin;
private boolean baneo=false;
private boolean entrar = false;
   /* @ModelAttribute("usuario")
    public Usuario usuario(@ModelAttribute("usuarioLog") Usuario usuariolog){
        try{
            Usuario usuario = usuariolog;
            System.out.println(usuario.getNombre());
           if(usuario.getNombre()==null){
                baneo=true;
            }else{
                if(!entrar){
                    admin=usuario;
                    entrar = true;
                }
                baneo=false;
            }
            return usuario;
            
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }*/

    @GetMapping("/-1")
    public String getAdmin1(Model model, HttpServletRequest request){
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
        System.out.println(usuario.getId());
        List<Usuario> empleados = detalleRepository.obtenerEmpleados(usuario);
        model.addAttribute("admin", usuario);
        model.addAttribute("empleados", empleados);
        admin=usuario;
        return "admin/manager/admin1";
    }


    @GetMapping("/-2")
    public String getAdmin2(HttpServletRequest request, Model model){
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
        
        return "admin/manager/admin2";
    }
    @GetMapping("/edit/employee/{id}")
    public String geteditemp(Model model, @PathVariable int id, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
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
        model.addAttribute("usuario", usuario);
        model.addAttribute("admin", admin);
        Usuario empleado = usuarioRepository.getById(id);
       // System.out.println(empleado.getContraseña());
        model.addAttribute("employee", empleado);
        return "admin/manager/admineditemp";
    }
    @PostMapping("/edit/employee/{id}")
    public String editEmployee(Model model,Usuario employee, @PathVariable int id,SessionStatus status, HttpServletRequest request){
        HttpSession session = request.getSession();
        Usuario usuario=null;
       try{
         usuario= (Usuario)session.getAttribute("usuarioLog");
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
        model.addAttribute("usuario", usuario);
        System.out.print("practicamente obtener el nombre");
        status.setComplete();
        employee.setId(id);
        employee.setRol("worker");
        usuarioRepository.actualizar(employee);
        return "redirect:/admin/-1";
    }
    @GetMapping("/edit/ice")
    public String geteditemps(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/manager/admineditic";
    }
    @GetMapping("/stats")
    public String getStats(){
        if(baneo){
            return("redirect:/inicio/login");
        }
        return "admin/manager/stats";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest req ,SessionStatus status){
        HttpSession sesion = req.getSession();
        sesion.setAttribute("usuarioLog", null);
        status.setComplete();
        return "redirect:/inicio/";

    }
}
