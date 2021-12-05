package bananas.premium.web.Data.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.Data.repository.HeladoRepository;
import bananas.premium.web.modelos.Helado;
@Repository
@Component
@Primary
public class HeladoDAO  extends Conexion implements HeladoRepository{

    
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
            usu.baja=rs.getBoolean("baja");
            return usu;
            
        }
    }
    @Override
    public List<Helado> getAll(){
        return jdbcTemplate.query("select * from Helado where baja=0", new mapHelado());
    }
    @Override
    public Helado getbyId(int id){
        return jdbcTemplate.queryForObject("select * from Helado where id= ?", new mapHelado(),id);
    }
    @Override
    public int delete(int id){
        return jdbcTemplate.update("delete from Helado where id=?", id);
    }
    @Override
    public int insert(Helado Helado){
        return jdbcTemplate.update("insert into Helado(nombre,sabor,imagen,precio,existencia)values(?,?,?,?,?)", Helado.getNombre(),Helado.getSabor(),Helado.getImagen(),Helado.getPrecio(),Helado.getExistencia());
    }
    @Override
    public int actualizar(Helado Helado){
        return jdbcTemplate.update("update Helado set nombre=?,  sabor=?,  imagen = ?, precio=?, existencia=?, baja=? where id LIKE ?", Helado.getNombre(),Helado.getSabor(),Helado.getImagen(),Helado.getPrecio(),Helado.getExistencia(),Helado.baja,Helado.getId());
    }
}