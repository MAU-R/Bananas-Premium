package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Detalle_Sucursal;
import bananas.premium.web.modelos.Usuario;
import bananas.premium.web.modelos.detalleManager;

public interface detalleSucursalRepository {
    
  //  public detalleEmpleado obtenerEmpleadoEmpleador(Detalle_Sucursal sucursal);
      public List<Usuario> obtenerEmpleados(Usuario usuario);
      public int deleteByUserID(int id);
      public int deleteBySUCID(int id);
      public int insert(Detalle_Sucursal usuario);
      public int getIdSucursalUsuario(int id);
}
