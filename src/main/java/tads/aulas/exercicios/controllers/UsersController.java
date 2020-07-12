package tads.aulas.exercicios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tads.aulas.exercicios.models.Users;

import java.util.List;

@Controller
public class UsersController {

    UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/")
    public String getHome(Model model){
        List<Users> usersList = usersService.findAll();
        model.addAttribute("userList", usersList);
        return "index";
    }

    @RequestMapping("/cadastrar")
    public String getPageCadastro(Model model){
        Users user = new Users();
        model.addAttribute("user", user);
        return "cadastrar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String addUser(@ModelAttribute Users user) {
        usersService.add(user);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public  ModelAndView editUser(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("editar");
        Users user = usersService.getOne(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/deletar/{id}")
    public String deleteAnime(@PathVariable(name = "id" ) Long id) {
        usersService.delete(id);
        return  "redirect:/";
    }
}
