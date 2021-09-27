package br.edu.infnet.springmvc.model.service;

import br.edu.infnet.springmvc.models.User;
import br.edu.infnet.springmvc.repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    
    public void SalvarUser(User user){
        userRepository.save(user);
    }
    
    public List<User> consultarTodoUser(){
        return (List<User>) userRepository.findAll();
    }
}
