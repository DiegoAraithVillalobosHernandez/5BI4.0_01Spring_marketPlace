package mx.edu.utez.erielit.product.controller;

import mx.edu.utez.erielit.product.model.Product;
import mx.edu.utez.erielit.product.model.ProductImage;
import mx.edu.utez.erielit.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Se encarga de recibir los datos
// y de mapear las uris para el acceso a nuestro servicio
@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = {"*"})
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return productService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody ProductDTO productDTO){
        List<ProductImage> images = new ArrayList<>();

        productDTO.getImages().forEach(image -> images.add(new ProductImage(image.getName(), image.getFileBase64(), null)));

        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(),
                productDTO.getQuantity(), productDTO.getBrand(), productDTO.getStatus(), productDTO.getSubcategory(),
                images);

        return productService.save(product);
    }
}
