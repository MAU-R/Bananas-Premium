package bananas.premium.web.Data.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.Data.repository.UsuarioRepository;
import bananas.premium.web.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
@Component
@Primary
public class UsuarioDao extends Conexion implements UsuarioRepository{

    class mapUsuario implements RowMapper<Usuario>{
        @Override
        public Usuario mapRow(ResultSet rs, int rowNum)throws SQLException{
            Usuario usu = new Usuario();
            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("nombre"));
            usu.setContraseña(rs.getString("contraseña"));
            usu.setRol(rs.getString("rol"));
            return usu;
        }
    }

    public List<Usuario> getAll(){
        return jdbcTemplate.query("select * from usuario", new mapUsuario());
    }

    public int delete(int id){
        return jdbcTemplate.update("delete from usuario where id=?", id);
    }

    public int insert(Usuario usuario){
        return jdbcTemplate.update("insert into usuario(nombre,contraseña,rol)values(?,?,?)", usuario.getNombre(),usuario.getContraseña(),usuario.getRol());
    }
    public int actualizar(Usuario usuario){
        return jdbcTemplate.update("update usuario set nombre=?,  contraseña=?,  rol = ? where id LIKE ?", usuario.getNombre(),usuario.getContraseña(),usuario.getRol(),usuario.getId());
    }
    public Usuario getByInicio(Usuario usuario){
        try{
            return jdbcTemplate.queryForObject("select * from usuario WHERE nombre=? AND contraseña=? ",new mapUsuario(), usuario.getNombre(), usuario.getContraseña());
        }catch(IncorrectResultSizeDataAccessException e){
            System.out.println(e);
            return null;
        }
    }
}
