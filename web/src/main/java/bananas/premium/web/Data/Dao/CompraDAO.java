package bananas.premium.web.Data.Dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.Data.repository.CompraRepository;
import bananas.premium.web.modelos.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
@Repository
@Component
@Primary
public class CompraDAO extends Conexion implements CompraRepository{

    class mapCompra implements RowMapper<Compra>{
        @Override
        public Compra mapRow(ResultSet rs, int rowNum) throws SQLException{
            Compra usu = new Compra();
            usu.setId(rs.getInt("id"));
            usu.setFecha(rs.getDate("fecha"));
            usu.setTotal(rs.getDouble("total"));
            return usu;
            
        }
    }

    public List<Compra> getAll(){
        return jdbcTemplate.query("select * from Compra", new mapCompra());
    }

    public int delete(int id){
        return jdbcTemplate.update("delete from Compra where id=?", id);
    }
 
    public int insert(Compra Compra){
        return jdbcTemplate.update("insert into Compra(fecha,total)values(?,?)", Compra.getFecha(),Compra.getTotal());
    }
    public int actualizar(Compra Compra){
        return jdbcTemplate.update("update Compra set fecha=?,  total=? where id LIKE ?", Compra.getFecha(),Compra.getTotal());
    }
}