package br.com.neblloll.projeto_faculdade.model;

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

    private LocalDate date;

    //Método Construtor
    public TaskModel() {

    }

    public TaskModel(Long id, String name, Double price, String text, LocalDate date) {
        super(id, name, price);
        this.text = text;
        this.date = date;
    }

    //Método Getter e Setter
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
