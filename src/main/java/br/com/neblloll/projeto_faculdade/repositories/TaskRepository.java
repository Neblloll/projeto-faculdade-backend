package br.com.neblloll.projeto_faculdade.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.neblloll.projeto_faculdade.models.TaskModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

    //Encontrar todos os produtos cadastrados
    @Transactional(readOnly = true)
    List<TaskModel> findAll();

    //Contar o produto que tem o ID
    @Transactional(readOnly = true)
    Long countById(Long id);

    //Encontrar produto pelo ID
    @Transactional(readOnly = true)
    TaskModel findByid(Long id);
}
