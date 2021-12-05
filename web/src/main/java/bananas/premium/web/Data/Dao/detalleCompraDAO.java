package bananas.premium.web.Data.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import bananas.premium.web.Data.db.Conexion;
import bananas.premium.web.Data.repository.detalleCompraRepository;
import bananas.premium.web.modelos.Detalle_Compra;
import bananas.premium.web.modelos.detalleCompraTotal;
@Repository
@Component
@Primary
public class detalleCompraDAO extends Conexion implements detalleCompraRepository{
    class mapdetalle implements RowMapper<detalleCompraTotal>{
        @Override
        public detalleCompraTotal mapRow(ResultSet rs, int rowNum)throws SQLException{
            detalleCompraTotal usu = new detalleCompraTotal();
           usu.sabor= rs.getString("sabor");
           usu.fecha= rs.getString("fecha");
           usu.total= rs.getString("monto_total");
            return usu;
        }
    }
    public  List<detalleCompraTotal> obtenerCompras(int id){
        return jdbcTemplate.query("select helado.sabor ,compra.fecha, compra.monto_total from detalle_compra detalle inner join helado on helado.id=detalle.id_helado inner join compra on compra.id = detalle.id_compra where detalle.id_sucursal=?;", new mapdetalle(),id);
    }
    public int insert(Detalle_Compra detalle){
        return jdbcTemplate.update("insert into detalle_compra(id_sucursal,id_compra,id_helado,cantidad)values(?,?,?,?) ", detalle.getId_sucursal(),detalle.getId_compra(), detalle.getId_helado(), detalle.getCanridad());
    }
}
