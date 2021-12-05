package bananas.premium.web.Data.Dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.Data.repository.detalleSucursalRepository;
import bananas.premium.web.modelos.Usuario;
import bananas.premium.web.modelos.detalleEmpleado;
@Repository
@Component
@Primary
public class detalleSucursalDAO extends Conexion implements detalleSucursalRepository {
    /*
      class mapEmp implements RowMapper<detalleEmpleado>{
        @Override
        public detalleEmpleado mapRow(ResultSet rs, int rowNum)throws SQLException{
            detalleEmpleado emp = new detalleEmpleado();
            
            
        }
    }
    public detalleEmpleado obtenerEmpleadoEmpleador(Usuario usuario){
        try{
            detalleEmpleado empEmp= jdbcTemplate.queryForObject("Select * from ", requiredType)
        }
        
    }
    */ 
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
    public List<Usuario> obtenerEmpleados(Usuario usuario){
        return jdbcTemplate.query("select emp.id, emp.nombre, emp.contraseña,emp.rol   from usuario emp inner join detalle_sucursal det on det.id_usuario = emp.id  inner join usuario empleador on emp.id = det.id_usuario where emp.rol = ? and empleador.id = ?", new mapUsuario(), "worker",usuario.getId());
    }
}
