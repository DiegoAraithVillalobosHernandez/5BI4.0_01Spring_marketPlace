package mx.edu.utez.erielit.product.controller;

import mx.edu.utez.erielit.product.model.Product;
import mx.edu.utez.erielit.product.model.ProductImage;
import mx.edu.utez.erielit.product.model.ProductRepository;
import mx.edu.utez.erielit.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//Las clases de Servicio nos sirven para llevar la lógica del negocio
// Es decir los datos recibidos son tratados aquí
@Service
@Transactional//Debe ser de Spring
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, productRepository.findAll()),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if (productRepository.existsById(id)) {
            return  new ResponseEntity<>(new Message("ok", false, productRepository.findById(id)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El producto no existe", true, null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Product product){
        //No sabemos el id porque es automatico, por ende solo podemos buscar por nombre
        Optional<Product> exists = productRepository.findByName(product.getName());

        if (exists.isPresent()){
            return new ResponseEntity<>(new Message("Producto existente", true, null),
                    HttpStatus.BAD_REQUEST);
        }

/*
        Esto nos lo evita fetch = FetchType.EAGER, cascade = CascadeType.PERSIST
        es decir hacer el registro en ambos sitios
        List<ProductImage> images = product.getImages();
        //Obtenemos el id del producto temporal
        Product idProduct = productRepository.saveAndFlush(product);
        //Seteamos a cada imagen el id del producto
        images.forEach(image -> image.setProduct(idProduct));

        idProduct.setImages(images);
        Product savedProduct = productRepository.saveAndFlush(idProduct);
*/
        return new ResponseEntity<>(new Message("ok", false, productRepository.saveAndFlush(product)),
                HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> update(Product product){
        //Necesitamos verificar que exista dicho producto a modificar
        if (productRepository.existsById(product.getId())){
            return new ResponseEntity<>(new Message("ok", false, productRepository.saveAndFlush(product)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Este producto na existe", true, null),
                HttpStatus.BAD_REQUEST);
    }
}
