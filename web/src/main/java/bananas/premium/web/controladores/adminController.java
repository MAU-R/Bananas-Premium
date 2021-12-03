package bananas.premium.web.controladores;

import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bananas.premium.web.datos.UsuarioRepository;
import bananas.premium.web.modelos.Usuario;

@Controller
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private UsuarioRepository repoUsuario;

    @GetMapping("/usuario")
    public String getUsers(){
        Usuario usu = new Usuario() ;
        System.out.println("AAAAAAAAAHHHHHHHHH");
        for(Usuario us: repoUsuario.findAll()){
            System.out.println(us.getNombre());
        }
       return "admin/usuarios";
    }

}
