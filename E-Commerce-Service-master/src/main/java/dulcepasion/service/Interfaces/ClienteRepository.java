package dulcepasion.service.Interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dulcepasion.service.modelo.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    @Query(value = "(SELECT EXISTS(SELECT id FROM cliente WHERE num_doc=:dni))", nativeQuery = true)
    int existByDoc(String dni);
    @Query(value = "SELECT EXISTS(SELECT C.* FROM cliente C WHERE C.num_doc=:dni AND NOT (C.id=:id))", nativeQuery = true)
    int existByDocForUpdate(String dni, int id);
}
