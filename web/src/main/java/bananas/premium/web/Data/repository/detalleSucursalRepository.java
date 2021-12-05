package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Detalle_Sucursal;
import bananas.premium.web.modelos.Usuario;
import bananas.premium.web.modelos.detalleEmpleado;

public interface detalleSucursalRepository {
    
  //  public detalleEmpleado obtenerEmpleadoEmpleador(Detalle_Sucursal sucursal);
      public List<Usuario> obtenerEmpleados(Usuario usuario);
}
