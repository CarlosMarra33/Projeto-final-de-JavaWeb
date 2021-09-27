package br.edu.infnet.springmvc.model.service;

import br.edu.infnet.springmvc.models.Carro;
import br.edu.infnet.springmvc.repository.ICarroRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    @Autowired
    private ICarroRepository repository;
    
   public void salvar(Carro carro){
        repository.save(carro);
    }
   
   public List<Carro> consultarTodos(int consecionaria_id){
       return repository.getAllCarros(consecionaria_id);
   }
   
   public List<Carro> consultarTodosPorModelo(String modelo){
       return repository.getByAllModelo(modelo);
   }
   
   public Carro consultaPorId(int id){
       return repository.findById(id).get();
   }
   
   public void deletarCarro(Integer id){
       System.out.println("pre-delete");
       repository.deleteById(id);
       System.out.println("pos-delete");
   }
   
   public Set<Carro> carrosDeConsecionaria(int id_consecionaria){
       return repository.getAllCarrosPorConsecionaria(id_consecionaria);
   }
}
