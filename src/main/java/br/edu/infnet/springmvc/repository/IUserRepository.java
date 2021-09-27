package br.edu.infnet.springmvc.repository;

import br.edu.infnet.springmvc.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer>  {
}
