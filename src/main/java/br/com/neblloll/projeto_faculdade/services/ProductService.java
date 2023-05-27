package br.com.neblloll.projeto_faculdade.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.neblloll.projeto_faculdade.models.Mensage;
import br.com.neblloll.projeto_faculdade.models.ProductModel;
import br.com.neblloll.projeto_faculdade.repositories.ProductRepository;

@Service
public class ProductService {

    //Atributo
    @Autowired
    private Mensage mensage;
    
    @Autowired
    private ProductRepository productAction;

    //Método para cadastrar produto
    public ResponseEntity<?> register(ProductModel obj) {

        if(obj.getName().equals("")) {
            mensage.setMensage("O nome precisa ser preechido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getPrice() < 0) {
            mensage.setMensage("Informe um preço válido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getQuantity() < 0) {
            mensage.setMensage("Informe um preço válido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(productAction.save(obj), HttpStatus.CREATED);
        }
    }

    //Método para selecionar produto
    public ResponseEntity<?> select() {
        return new ResponseEntity<>(productAction.findAll(), HttpStatus.OK);
    }

    //Método para selecionar produto pelo ID
    public ResponseEntity<?> selectPerId(Long id) {

        if(productAction.countById(id) == 0) {
            mensage.setMensage("Nenhum produto foi encontrado!");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(productAction.findByid(id), HttpStatus.FOUND);
        }
    }

    //Método para editar os dados do produto
    public ResponseEntity<?> edit(ProductModel obj) {

        if(productAction.countById(obj.getId()) == 0) {
            mensage.setMensage("Nenhum produto foi encontrado!");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        } else if(obj.getName().equals("")) {
            mensage.setMensage("O nome precisa ser preechido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getPrice() < 0) {
            mensage.setMensage("Informe um preço válido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if(obj.getQuantity() < 0) {
            mensage.setMensage("Informe um preço válido!");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(productAction.save(obj), HttpStatus.OK);
        }
    }

    //Método para deletar um produto
    public ResponseEntity<?> delete(Long id) {

        if(productAction.countById(id) == 0) {
            mensage.setMensage("Código informado não existe");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        } else {
            ProductModel obj = productAction.findByid(id);
            productAction.delete(obj);
            mensage.setMensage("Produto removido com sucesso!");
            return new ResponseEntity<>(mensage, HttpStatus.OK);
        }
    }
    
}
