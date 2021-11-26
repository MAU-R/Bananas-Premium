package bananas.premium.web.Data.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.modelos.Helado;

public class HeladoDAO extends Conexion{

    class mapHelado implements RowMapper<Helado>{
        @Override
        public Helado mapRow(ResultSet rs, int rowNum)throws SQLException{
            Helado usu = new Helado();
            usu.setId(rs.getInt("id"));
            usu.setNombre(rs.getString("nombre"));
            usu.setSabor(rs.getString("sabor"));
            usu.setImagen(rs.getString("imagen"));
            usu.setPrecio(rs.getDouble("precio"));
            usu.setExistencia(rs.getInt("existencia"));
            return usu;
        }
    }

    public List<Helado> getAll(){
        return jdbcTemplate.query("select * from Helado", new mapHelado());
    }

    public int delete(int id){
        return jdbcTemplate.update("delete from Helado where id=?", id);
    }
 
    public int insert(Helado Helado){
        return jdbcTemplate.update("insert into Helado(nombre,sabor,imagen,precio,existencia)values(?,?,?,?,?)", Helado.getNombre(),Helado.getSabor(),Helado.getImagen(),Helado.getPrecio(),Helado.getExistencia());
    }
    public int actualizar(Helado Helado){
        return jdbcTemplate.update("update Helado set nombre=?,  sabor=?,  imagen = ?, precio=?, existencia=? where id LIKE ?", Helado.getNombre(),Helado.getSabor(),Helado.getImagen(),Helado.getPrecio(),Helado.getExistencia(),Helado.getId());
    }
}