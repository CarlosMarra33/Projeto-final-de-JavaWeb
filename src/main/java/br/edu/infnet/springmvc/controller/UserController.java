package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.service.UserService;
import br.edu.infnet.springmvc.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(method = {RequestMethod.GET}, value = "/handleGetAllUser")
    public List<User> consultaUser(){
        try
        {
            List<User> users = userService.consultarTodoUser();
            return users;
        } catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    
    @RequestMapping(method = {RequestMethod.POST}, value = "/handleRegisterUser")
    public void handleRegisterUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String cpf){
        User user = new User();
        user.setCpf(cpf);
        user.setEmail(email);
        user.setName(name);
        try
        {
            userService.SalvarUser(user);

        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
