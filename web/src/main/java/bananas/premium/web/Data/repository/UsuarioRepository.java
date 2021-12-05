package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Usuario;
import bananas.premium.web.modelos.detalleManager;

public interface UsuarioRepository {
    public List<Usuario> getAll();
    public int delete(int id);
    public int insert(Usuario usuario);
    public int actualizar(Usuario usuario);
    public Usuario getByInicio(Usuario usuario);
    public Usuario getById(int id);
    public int getLast();
    public List<detalleManager> getManagers();
}
