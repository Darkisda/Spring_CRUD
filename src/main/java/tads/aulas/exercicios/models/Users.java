package tads.aulas.exercicios.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    String email;
    String senha;
    Integer anoNascimento;
}
