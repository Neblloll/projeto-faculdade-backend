package br.com.neblloll.projeto_faculdade.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.neblloll.projeto_faculdade.models.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    //Encontrar todos os produtos cadastrados
    @Transactional(readOnly = true)
    List<ProductModel> findAll();

    //Contar o produto que tem o ID
    @Transactional(readOnly = true)
    Long countById(Long id);

    //Encontrar produto pelo ID
    @Transactional(readOnly = true)
    ProductModel findByid(Long id);
    
}
