package exemplo.DTO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DTO.entitites.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}