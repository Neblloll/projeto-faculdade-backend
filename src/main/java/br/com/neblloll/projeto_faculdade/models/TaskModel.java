package br.com.neblloll.projeto_faculdade.models;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class TaskModel extends DistributionModel {

    //Atributos
    @Column(columnDefinition = "TEXT")
    private String text;

    private LocalDate initialDate;
    private LocalDate finalDate;

    
    //Método Construtor
    public TaskModel() {

    }

    public TaskModel(Long id, String name, Double price, String text, LocalDate initialDate, LocalDate finalDate) {
        super(id, name, price);
        this.text = text;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    //Método Getter e Setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

}
