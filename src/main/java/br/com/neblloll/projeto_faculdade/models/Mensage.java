package br.com.neblloll.projeto_faculdade.models;

import org.springframework.stereotype.Component;

@Component
public class Mensage {

    //Atributo
    private String mensage;

    //Método construtor
    public Mensage() {
        
    }

    public Mensage(String mensage) {
        this.mensage = mensage;
    }

    //Método Getter e Setter
    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
    
}
