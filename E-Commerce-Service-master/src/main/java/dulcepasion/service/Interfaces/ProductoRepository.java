package dulcepasion.service.Interfaces;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dulcepasion.service.modelo.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {
	
	@Query("SELECT P FROM Producto P ")
    Iterable<Producto> listarproducto();
	
    @Query("SELECT P FROM Producto P WHERE P.recomendado IS 1")
    Iterable<Producto> listarproductoRecomendados();

    @Query("SELECT P FROM Producto P WHERE P.categoria.id=:idC")
    Iterable<Producto> listarprodcutoPorCategoria(int idC);

    @Modifying
    @Query("UPDATE Producto P SET P.stock=stock-:cant WHERE P.id=:id")
    void descontarStock(int cant, int id);

    @Modifying
    @Query("UPDATE Producto P SET P.stock=stock+:cant WHERE P.id=:id")
    void aumentarStock(int cant, int id);
}
