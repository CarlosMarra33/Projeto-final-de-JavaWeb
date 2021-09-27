package br.edu.infnet.springmvc.model.service;

import br.edu.infnet.springmvc.models.Consecionaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.infnet.springmvc.repository.IConsecionariaRepository;
import java.util.List;

@Service
public class ConsecionariaService {
    @Autowired
    private IConsecionariaRepository repository;
    
    public void salvar(Consecionaria consecionaria){
        repository.save(consecionaria);
    }
    
    public Consecionaria getConsecionariaByEmail(String email){
        return repository.getByEmail(email);
    }
    
    public void delete(int id){
        repository.deleteById(id);
    }
    
    public List<Consecionaria> getAll(){
        return (List<Consecionaria>) repository.findAll();
    }
}
