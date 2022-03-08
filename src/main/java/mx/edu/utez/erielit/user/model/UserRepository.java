package mx.edu.utez.erielit.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsById(long id);
    boolean existsByUsername(String username);
    boolean existsByPersonCurp(String curp);
}
