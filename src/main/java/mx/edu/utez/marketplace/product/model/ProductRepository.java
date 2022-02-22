package mx.edu.utez.marketplace.product.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Es la encargada de manejar los métodos SQL
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    boolean existsById(long id);

}
