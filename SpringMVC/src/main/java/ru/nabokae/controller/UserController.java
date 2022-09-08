package ru.nabokae.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nabokae.persist.User;
import ru.nabokae.persist.UserRepository;


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
    public String NewUserForm (Model model) {
        logger.info("Запрошена страница создания нового пользователя");
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/all")
    public String UpdateUser (User user) {
        logger.info("Запрошен обновленный список пользователей посде добавления нового");
       userRepository.insert(user);
        return "redirect:/users/all";
    }

    @GetMapping("{id}")
    public String EditUserForm (@PathVariable("id") long id, Model model) {
        logger.info("Запрошена страница редактирования пользователя");
        User user =  userRepository.findById(id);
        model.addAttribute("user", user);
        return "user";
    }


}
