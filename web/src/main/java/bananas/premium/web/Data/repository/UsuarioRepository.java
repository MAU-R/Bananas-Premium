package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Usuario;

public interface UsuarioRepository {
    public List<Usuario> getAll();
    public int delete(int id);
    public int insert(Usuario usuario);
    public int actualizar(Usuario usuario);
    public Usuario getByInicio(Usuario usuario);
}
