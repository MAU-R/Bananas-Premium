package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Compra;

public interface CompraRepository {
    
    public List<Compra> getAll();
    public int delete(int id);
    public int insert(Compra Compra);
    public int actualizar(Compra Compra);
}
