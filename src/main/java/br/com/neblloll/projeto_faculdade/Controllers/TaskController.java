package br.com.neblloll.projeto_faculdade.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neblloll.projeto_faculdade.models.TaskModel;
import br.com.neblloll.projeto_faculdade.services.TaskService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tarefas")
public class TaskController {

    //Atributos
    @Autowired
    private TaskService taskService;

    //----------<CRUD PARA TAREFA>----------

    //Método para pegar todos os produtos
    @GetMapping
    public ResponseEntity<?> getAllTask() {
        return taskService.select();
    }

    //Método para pegar o produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPerIdTask(@PathVariable Long id) {
        return taskService.selectPerId(id);
    }

    //Método para criar um novo produto
    @PostMapping
    public ResponseEntity<?> postTask(@RequestBody TaskModel obj) {
        return taskService.register(obj);
    }

    //Método para editar um produto
    @PutMapping
    public ResponseEntity<?> putTask(@RequestBody TaskModel obj) {
        return taskService.edit(obj);
    }

    //Método para deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        return taskService.delete(id);
    }
    
}
