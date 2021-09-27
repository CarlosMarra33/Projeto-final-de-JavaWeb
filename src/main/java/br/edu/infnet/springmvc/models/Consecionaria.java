package br.edu.infnet.springmvc.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="consecionaria")
public class Consecionaria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consecionaria_id")
    private int consecionaria_id;
    private String name;
    @Column(unique=true)
    private String email;
    private String password;
    
    public Consecionaria() {
    }

    public Consecionaria(int consecionaria_id, String name, String email, String password) {
        this.consecionaria_id = consecionaria_id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    @OneToMany(mappedBy = "consecionaria", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Carro> carros = new HashSet<>();

    public int getConsecionaria_id() {
        return consecionaria_id;
    }

    public void setConsecionaria_id(int consecionaria_id) {
        this.consecionaria_id = consecionaria_id;
    }

    public Set<Carro> getCarros() {
        return carros;
    }

    public void setCarros(Set<Carro> carros) {
        this.carros = carros;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
