package br.edu.infnet.springmvc.repository;

import br.edu.infnet.springmvc.models.Consecionaria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IConsecionariaRepository extends CrudRepository<Consecionaria, Integer>{
    @Query(value="SELECT * FROM consecionaria WHERE email = :email", nativeQuery=true)
    public Consecionaria getByEmail(@Param("email") String email);
}
