package br.edu.infnet.springmvc.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carros")
public class Carro implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carro_id")
    private int carro_id;
    private String modelo;
    private String ano;
    @Column(unique=true)
    private int chassi;

    public Carro() {
    }

    public Carro(int carro_id, String modelo, String ano, int chassi, Consecionaria consecionaria) {
        this.carro_id = carro_id;
        this.modelo = modelo;
        this.ano = ano;
        this.chassi = chassi;
        this.consecionaria = consecionaria;
    }
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "consecionaria_id", nullable = false)
    private Consecionaria consecionaria;

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public int getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(int carro_id) {
        this.carro_id = carro_id;
    }

    public Consecionaria getConsecionaria() {
        return consecionaria;
    }

    public void setConsecionaria(Consecionaria consecionaria) {
        this.consecionaria = consecionaria;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
