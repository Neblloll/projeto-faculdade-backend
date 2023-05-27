package br.com.neblloll.projeto_faculdade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.neblloll.projeto_faculdade.models.TaskModel;
import br.com.neblloll.projeto_faculdade.services.TaskService;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    //Atributos
    @Autowired
    private TaskService taskService;

    //----------<CRUD PARA TAREFA>----------

    //Método para pegar todos as tarefas
    @GetMapping("/listar-tarefa")
    public ResponseEntity<?> getAllTask() {
        return taskService.select();
    }

    //Método para pegar a tarefa pelo ID
    @GetMapping("/listar-tarefa/{id}")
    public ResponseEntity<?> getPerIdTask(@PathVariable Long id) {
        return taskService.selectPerId(id);
    }

    //Método para criar uma nova tarefa
    @PostMapping("/criar-tarefa")
    public ResponseEntity<?> postTask(@RequestBody TaskModel obj) {
        return taskService.register(obj);
    }

    //Método para editar uma tarefa
    @PutMapping("/editar-tarefa")
    public ResponseEntity<?> putTask(@RequestBody TaskModel obj) {
        return taskService.edit(obj);
    }

    //Método para deletar uma tarefa
    @DeleteMapping("/deletar-tarefa/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        return taskService.delete(id);
    }
    
}
