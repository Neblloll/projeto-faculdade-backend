package br.com.neblloll.projeto_faculdade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.neblloll.projeto_faculdade.models.Mensage;
import br.com.neblloll.projeto_faculdade.models.TaskModel;
import br.com.neblloll.projeto_faculdade.repositories.TaskRepository;

@Service
public class TaskService {

    //Atributo
    @Autowired
    private Mensage mensage;
    
    @Autowired
    private TaskRepository taskAction;
    
    //Método para cadastrar tarefa
    public ResponseEntity<?> register(TaskModel obj) {

        if(obj.getName().equals("")) {
            mensage.setMensage("O nome precisa ser preechido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getPrice() < 0) {
            mensage.setMensage("Informe um preço válido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getText().equals("")) {
            mensage.setMensage("A descrição precisa ser preenchido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getInitialDate().equals(null)) {
            mensage.setMensage("Informe uma data inicial válida!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getFinalDate().equals(null)) {
            mensage.setMensage("Informe uma data final válida!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(taskAction.save(obj), HttpStatus.CREATED);
        }
    } 

    //Método para selecionar tarefa
    public ResponseEntity<?> select() {
        return new ResponseEntity<>(taskAction.findAll(), HttpStatus.OK);
    }

    //Método para selecionar tafera pelo ID
    public ResponseEntity<?> selectPerId(Long id) {
     
        if(taskAction.countById(id) == 0) {
            mensage.setMensage("Nenhuma tarefa foi encontrada!");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(taskAction.findByid(id), HttpStatus.OK);
        }
    }

    //Método para editar os dados da tarefa
    public ResponseEntity<?> edit(TaskModel obj) {

        if(taskAction.countById(obj.getId()) == 0) {
            mensage.setMensage("Nenhuma tarefa foi encontrada!");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        } else if(obj.getName().equals("")) {
            mensage.setMensage("O nome precisa ser preechido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getPrice() < 0) {
            mensage.setMensage("Informe um preço válido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getText().equals("")) {
            mensage.setMensage("A descrição precisa ser preenchido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getInitialDate().equals(null)) {
            mensage.setMensage("Informe uma data inicial válida!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getFinalDate().equals(null)) {
            mensage.setMensage("Informe uma data final válida!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(taskAction.save(obj), HttpStatus.OK);
        }
    }

    //Método para deletar uma tarefa
    public ResponseEntity<?> delete(Long id) {

        if(taskAction.countById(id) == 0) {
            mensage.setMensage("Nenhuma tarefa foi encontrada!");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        } else {
            TaskModel obj = taskAction.findByid(id);
            taskAction.delete(obj);
            mensage.setMensage("Tarefa removida com sucesso!");
            return new ResponseEntity<>(mensage, HttpStatus.OK);
        }
    }
    
}
