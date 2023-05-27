package br.com.neblloll.projeto_faculdade.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductModel extends DistributionModel {
    
    //Atributos
    private Integer quantity;

    //Método construtor
    public ProductModel() {

    }

    public ProductModel(Long id, String name, Double price, Integer quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }

    //Método Getter e Setter
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
}
