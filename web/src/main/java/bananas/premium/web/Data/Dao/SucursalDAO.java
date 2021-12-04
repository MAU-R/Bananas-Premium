package bananas.premium.web.Data.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.Data.repository.SucursalRepository;
import bananas.premium.web.modelos.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SucursalDAO  extends Conexion implements SucursalRepository{

    class mapSucursal implements RowMapper<Sucursal>{
        @Override
        public Sucursal mapRow(ResultSet rs, int rowNum)throws SQLException{
            Sucursal usu = new Sucursal();
            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("nombre"));
            usu.setUbicacion(rs.getString("ubicacion"));
            usu.setImagen(rs.getString("imagen"));
            return usu;
            
        }
    }

    public List<Sucursal> getAll(){
        return jdbcTemplate.query("select * from Sucursal", new mapSucursal());
    }

    public int delete(int id){
        return jdbcTemplate.update("delete from Sucursal where id=?", id);
    }
 
    public int insert(Sucursal Sucursal){
        return jdbcTemplate.update("insert into Sucursal(nombre,ubicacion,imagen)values(?,?,?)", Sucursal.getNombre(),Sucursal.getUbicacion(),Sucursal.getImagen());
    }
    public int actualizar(Sucursal Sucursal){
        return jdbcTemplate.update("update Sucursal set nombre=?,  ubicacion=? where id LIKE ?", Sucursal.getNombre(),Sucursal.getUbicacion(),Sucursal.getImagen(),Sucursal.getId());
    }
}
