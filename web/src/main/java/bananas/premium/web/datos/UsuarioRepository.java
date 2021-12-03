package bananas.premium.web.datos;
import org.springframework.data.repository.CrudRepository;

import bananas.premium.web.modelos.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    
}
