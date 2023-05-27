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

import br.com.neblloll.projeto_faculdade.models.ProductModel;
import br.com.neblloll.projeto_faculdade.services.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/produtos")
public class ProductController {
    
    //Atributos
    @Autowired
    private ProductService productService;

    //----------<CRUD PARA PRODTUTOS>----------

    //Método para pegar todos os produtos
    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        return productService.select();
    }

    //Método para pegar o produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPerIdProduct(@PathVariable Long id) {
        return productService.selectPerId(id);
    }

    //Método para criar um novo produto
    @PostMapping
    public ResponseEntity<?> postProduct(@RequestBody ProductModel obj) {
        return productService.register(obj);
    }

    //Método para editar um produto
    @PutMapping
    public ResponseEntity<?> putProduct(@RequestBody ProductModel obj) {
        return productService.edit(obj);
    }


    //Método para deletar um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

}
