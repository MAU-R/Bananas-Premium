package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Sucursal;

public interface SucursalRepository {
    public List<Sucursal> getAll();
    public int delete(int id);
    public int insert(Sucursal Sucursal);
    public int actualizar(Sucursal Sucursal);
    public Sucursal getById(int id);
    public int getLast();
}
