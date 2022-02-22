package mx.edu.utez.marketplace.category.controller;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.category.model.CategoryRepository;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK",false,categoryRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if (categoryRepository.existsById(id)){
            return new ResponseEntity<>(new Message("OK",false,
                    categoryRepository.getById(id)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La categoría no existe",true,
                null),HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Category category){
        Optional<Category> existsCategory = categoryRepository.findByDescription(category.getDescription());
        if (existsCategory.isPresent()){
            return new ResponseEntity<>(new Message("La categoría ya existe",true,null),HttpStatus.BAD_REQUEST);
        }
        Category savedCategory = categoryRepository.saveAndFlush(category);
        return new ResponseEntity<>(new Message("Categoría registrada correctamente",false,savedCategory),HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Category category){
        if ( categoryRepository.existsById(category.getId()) ){
            return new ResponseEntity<>(new Message("ok",false,categoryRepository.saveAndFlush(category)),HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La categoría no existe",true,null),HttpStatus.BAD_REQUEST);
    }
}
