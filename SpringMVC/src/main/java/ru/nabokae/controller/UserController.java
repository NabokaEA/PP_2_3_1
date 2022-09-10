package ru.nabokae.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.nabokae.persist.NotFoundException;
import ru.nabokae.persist.User;
import ru.nabokae.persist.UserRepository;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public String ListPage(Model model) {
        logger.info("Запрошен список пользьзовантелей");
        model.addAttribute("usersAll", userRepository.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String NewUserForm(Model model) {
        logger.info("Запрошена страница создания нового пользователя");
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/all")
    public String UpdateUser(@Valid User user, BindingResult bindingResult) {
        logger.info("Запрошен обновленный список пользователей ");
        if(bindingResult.hasErrors()){
            return "user";
        }
        userRepository.update(user);
        return "redirect:/users/all";
    }

    @GetMapping("/{id}")
    public String EditUserForm(@PathVariable("id") Long id, Model model) {
        logger.info("Запрошена страница редактирования пользователя");
      /*  Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
        }*/
        model.addAttribute("user", userRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found")));
        return "user";
    }

    @GetMapping("/{id}/delete")
    public String EditUserForm(@PathVariable("id") Long id) {
        logger.info("Запрошена страница удаления пользователя");
        userRepository.delete(id);
        return "redirect:/users/all";
    }

    @ExceptionHandler
    public ModelAndView notFoundExceptionHandler(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("message",ex.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
}
