package mx.edu.utez.marketplace.subcategory.controller;

import mx.edu.utez.marketplace.subcategory.model.Subcategory;
import mx.edu.utez.marketplace.subcategory.model.SubcategoryRepository;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class SubcategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("OK", false, subcategoryRepository.findAll()),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id) {
        if (subcategoryRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("OK", false, subcategoryRepository.findById(id)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La subcategoría no existe", true, null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findSubcategoriesByCategory(long id) {
        if (subcategoryRepository.existsSubcategoriesByCategory_Id(id)) {
            return new ResponseEntity<>(new Message("OK", false,
                    subcategoryRepository.findAllByCategoryId(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La categoría no tiene subcategorías", true, null),
                HttpStatus.BAD_REQUEST);
    }


    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> insert(Subcategory subcategory) {
        Optional<Subcategory> existsSubcategory = subcategoryRepository.findByDescription(subcategory.getDescription());
        if (existsSubcategory.isPresent()) {
            return new ResponseEntity<>(new Message("La subcategoría ya existe", true, null),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Subcategoría registrada correctamente", false,
                subcategoryRepository.saveAndFlush(subcategory)), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Subcategory subcategory) {
        if (!subcategoryRepository.existsById(subcategory.getId())) {
            return new ResponseEntity<>(new Message("La subcategoría no existe", true, null),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Subcategoría actualizada correctamente", false,
                subcategoryRepository.saveAndFlush(subcategory)), HttpStatus.OK);
    }


}
