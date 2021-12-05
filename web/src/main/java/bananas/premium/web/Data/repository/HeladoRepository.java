package bananas.premium.web.Data.repository;

import java.util.List;

import bananas.premium.web.modelos.Helado;

public interface HeladoRepository {
   public List<Helado> getAll();
    public int delete(int id);
    public int insert(Helado helado);
    public int actualizar(Helado helado);
    public Helado getbyId(int id);
}
