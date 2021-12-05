package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Detalle_Compra;
import bananas.premium.web.modelos.detalleCompraTotal;

public interface detalleCompraRepository {
    public  List<detalleCompraTotal> obtenerCompras(int id);
    public int insert(Detalle_Compra detalle);
}
