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
import bananas.premium.web.modelos.detalleManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

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
    class mapManager implements RowMapper<detalleManager>{
        @Override
        public detalleManager mapRow(ResultSet rs, int rowNum)throws SQLException{
            detalleManager usu = new detalleManager();
            usu.id_manager= rs.getInt("id");
            usu.nombre= rs.getString("nombre");
            usu.location=rs.getString("ubicacion");
            return usu;
        }
    }
    class intMap implements RowMapper<Integer>{
        @Override
        public Integer mapRow(ResultSet rs, int rowNum)throws SQLException{
            int x= rs.getInt("id");
            return x;
        }
    }
    public List<Usuario> getAll(){
        return jdbcTemplate.query("select * from usuario", new mapUsuario());
    }
    public List<detalleManager> getManagers(){
        return jdbcTemplate.query("select empleador.nombre , sucursal.ubicacion, empleador.id id from usuario empleador inner join detalle_sucursal det on det.id_usuario = empleador.id inner join sucursal on sucursal.id=det.id_sucursal where empleador.rol = ?;", new mapManager(), "admin");
    }
    public int delete(int id){
        return jdbcTemplate.update("delete from usuario where id=?", id);
    }
 public int getLast(){
        return jdbcTemplate.queryForObject("select max(id) id from usuario", new intMap());
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
    public Usuario getById(int id){
        try{
            return jdbcTemplate.queryForObject("select * from usuario WHERE id=? ",new mapUsuario(), id);
        }catch(IncorrectResultSizeDataAccessException e){
            System.out.println(e);
            return null;
        }
    }
}
