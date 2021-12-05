package bananas.premium.web.Data.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.Data.repository.SucursalRepository;
import bananas.premium.web.modelos.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
@Repository
@Component
@Primary
public class SucursalDAO  extends Conexion implements SucursalRepository{

    class mapSucursal implements RowMapper<Sucursal>{
        @Override
        public Sucursal mapRow(ResultSet rs, int rowNum)throws SQLException{
            Sucursal usu = new Sucursal();
            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("nombre"));
            usu.setUbicacion(rs.getString("ubicacion"));
            usu.setImagen(rs.getString("imagen"));
            usu.baja=rs.getBoolean("baja");
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
    public int getLast(){
        return jdbcTemplate.queryForObject("select max(id) id from sucursal", new intMap());
 }
    public List<Sucursal> getAll(){
        return jdbcTemplate.query("select * from Sucursal where baja=0", new mapSucursal());
    }

    public int delete(int id){
        return jdbcTemplate.update("delete from Sucursal where id=?", id);
    }
 
    public int insert(Sucursal Sucursal){
        return jdbcTemplate.update("insert into Sucursal(nombre,ubicacion,imagen)values(?,?,?)", Sucursal.getNombre(),Sucursal.getUbicacion(),Sucursal.getImagen());
    }
    public int actualizar(Sucursal Sucursal){
        return jdbcTemplate.update("update Sucursal set nombre=?,  ubicacion=?, imagen=?, baja=? where id LIKE ?", Sucursal.getNombre(),Sucursal.getUbicacion(),Sucursal.getImagen(),Sucursal.baja,Sucursal.getId());
    }
    public Sucursal getById(int id){
        return jdbcTemplate.queryForObject("select * from sucursal where id=?", new mapSucursal(), id);
    }
}
