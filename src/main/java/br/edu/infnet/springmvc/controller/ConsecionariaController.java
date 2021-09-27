package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.service.CarroService;
import br.edu.infnet.springmvc.model.service.ConsecionariaService;
import br.edu.infnet.springmvc.models.Carro;
import br.edu.infnet.springmvc.models.Consecionaria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("consecionaria")
public class ConsecionariaController {
    @Autowired
    private ConsecionariaService consecionariaService;
    @Autowired
    private CarroService carroService;
    
    @RequestMapping("handleLogin")
    public String fazerLogin(@RequestParam("email")String email, @RequestParam("password")String password, ModelMap model) {
        String errorMessage;
        
        try
        {
            Consecionaria consecionaria = consecionariaService.getConsecionariaByEmail(email);
            if ((consecionaria != null) && (password.equals(consecionaria.getPassword()))) {
                model.put("consecionaria", consecionaria);
                return "redirect:/home";
            } else {
                errorMessage = "Credenciais inválidas";
                model.addAttribute("errorMessage", errorMessage);
                return "login";
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
            return "login";
        }
    }
    
    @RequestMapping("handleSignUp")
    public String fazerSignUp(
            @RequestParam("name") String name,
            @RequestParam("email")String email,
            @RequestParam("password") String password,
            ModelMap model) {
        
        Consecionaria consecionaria = new Consecionaria();
        consecionaria.setEmail(email);
        consecionaria.setName(name);
        consecionaria.setPassword(password);
        String errorMessage;
        
        try
        {
           if (consecionariaService.getConsecionariaByEmail(email) == null) {
                consecionariaService.salvar(consecionaria);
                return "login";
            } else {
                errorMessage = "Email já existe";
                model.addAttribute("errorMessage", errorMessage);
                return "signup";
            }
        } catch (Exception e)
        {
            System.out.println(e.toString());
            return "signup";
        }
    }
    
    @RequestMapping("home")
    public String formHome(Model model){
        Consecionaria consecionaria = (Consecionaria) model.getAttribute("consecionaria");
        
        try
        {
           List<Carro> carros = carroService.consultarTodos(consecionaria.getConsecionaria_id());
           model.addAttribute("carros", carros);
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return "home";
    }
    
    @RequestMapping("ExcluirConsecionaria")
    public String ExcluirConta(ModelMap model){
        Consecionaria consecionaria = (Consecionaria) model.getAttribute("consecionaria");
        try
        {
            consecionariaService.delete(consecionaria.getConsecionaria_id());
            model.clear();
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return "landing";
    }
    
    @RequestMapping("handleSearch")
    public String pesquisar(@RequestParam String modelo, Model model, ModelMap modelMap){
        List<Carro> carros;
        Consecionaria consecionaria = (Consecionaria) modelMap.getAttribute("consecionaria");
        
        if (modelo.equals(""))
        {
            carros = carroService.consultarTodos(consecionaria.getConsecionaria_id());
        }else{
            carros = carroService.consultarTodosPorModelo(modelo);
        }
        model.addAttribute("carros", carros);
        return "home";
    }
    
    @RequestMapping("update-consecionaria")
    public String edicaoConsecionaria(Model model){
        Consecionaria consecionaria = (Consecionaria) model.getAttribute("consecionaria");
        
        model.addAttribute("consecionaria",consecionaria);
        return "update-consecionaria";
    }
    
    @RequestMapping("handleUpdateConsecionaria")
    public String editarConsecionaria(Consecionaria consecionariaView, ModelMap modelMap){
        try
        {
            consecionariaService.salvar(consecionariaView);
            modelMap.put("consecionaria", consecionariaView);
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return "redirect:/update-consecionaria";
    }
}
