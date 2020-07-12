package tads.aulas.exercicios.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByNome(String nome);
    List<Users> findByAnoNascimento(Integer ano);
}
