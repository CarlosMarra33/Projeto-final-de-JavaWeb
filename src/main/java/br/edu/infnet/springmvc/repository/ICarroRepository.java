
package br.edu.infnet.springmvc.repository;

import br.edu.infnet.springmvc.models.Carro;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroRepository extends CrudRepository<Carro, Integer> {
@Query(value="SELECT * FROM carros WHERE modelo = :modelo", nativeQuery=true)
    public List<Carro> getByAllModelo(@Param("modelo") String modelo);
    
@Query(value="SELECT * FROM carros WHERE consecionaria_id = :consecionaria_id", nativeQuery=true)
    public List<Carro> getAllCarros(@Param("consecionaria_id") int consecionaria_id);
    
@Query(value="SELECT * FROM carros WHERE consecionaria_id = :consecionaria_id", nativeQuery=true)
    public Set<Carro> getAllCarrosPorConsecionaria(@Param("consecionaria_id") int consecionaria_id);
}