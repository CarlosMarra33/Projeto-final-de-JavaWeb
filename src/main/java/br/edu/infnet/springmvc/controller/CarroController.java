package br.edu.infnet.springmvc.controller;

import br.edu.infnet.springmvc.model.service.CarroService;
import br.edu.infnet.springmvc.model.service.ConsecionariaService;
import br.edu.infnet.springmvc.models.Carro;
import br.edu.infnet.springmvc.models.Consecionaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("consecionaria")
public class CarroController {
    @Autowired
    private CarroService carroService;
    @Autowired
    private ConsecionariaService consecionariaService;
    
    @RequestMapping("register-carro")
    public String criacaoCarro(){
        return "register-carro";
    }
    
    @RequestMapping("handleRegisterCarro")
    public String criarCarro(Carro carroView, Model model, ModelMap modelMap){
        Consecionaria consecionaria = (Consecionaria) model.getAttribute("consecionaria");
        
        carroView.setConsecionaria(consecionaria);
        try
        {
            carroService.salvar(carroView);
            consecionaria = consecionariaService.getConsecionariaByEmail(consecionaria.getEmail());
            modelMap.put("consecionaria", consecionaria);
            return "redirect:/home";
        } catch (Exception e)
        {
            model.addAttribute("erro", e);
            return "register-carro";
        }
    }
    
    @RequestMapping("update-carro")
    public String edicaoCarro(@RequestParam int id, Model model){
        try
        {
            Carro carro = carroService.consultaPorId(id);
            model.addAttribute("carro", carro);
        } catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return "update-carro";
    }
    
    @RequestMapping("handleUpdateCarro")
    public String editarCarro(Carro carroView, ModelMap model){
        Consecionaria consecionaria = (Consecionaria) model.getAttribute("consecionaria");
        
        carroView.setConsecionaria(consecionaria);
        try
        {
            carroService.salvar(carroView);
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return "redirect:/home";
    }
    
    @RequestMapping("excluir")
    public String excluirCarro(@RequestParam int id, ModelMap model){
        Consecionaria consecionariaNv = (Consecionaria) model.getAttribute("consecionaria");
        String email = consecionariaNv.getEmail();
        Carro carro = carroService.consultaPorId(id);
        
        for(Carro c : consecionariaNv.getCarros()){
            if (c.getCarro_id() == carro.getCarro_id())
            {
                consecionariaNv.getCarros().remove(c);
                consecionariaService.salvar(consecionariaNv);
                consecionariaNv = consecionariaService.getConsecionariaByEmail(email);
                model.put("consecionaria", consecionariaNv);
                return "redirect:/home";
            }
        }
        return "redirect:/home";
    }
}