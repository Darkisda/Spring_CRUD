package tads.aulas.exercicios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.aulas.exercicios.models.UserRepository;
import tads.aulas.exercicios.models.Users;

import java.util.List;

@Service
public class UsersService {

    UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }

    public void add(Users user) {
        userRepository.save(user);
    }

    public Users getOne(Long id) {
        return userRepository.getOne(id);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
