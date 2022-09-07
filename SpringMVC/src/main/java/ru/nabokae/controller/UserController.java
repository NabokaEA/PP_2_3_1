package ru.nabokae.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nabokae.persist.UserRepository;


@Controller
@RequestMapping("/")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
@GetMapping
    public String ListPage(Model model) {
        logger.info("Запрошен список пользьзовантелей");
        model.addAttribute("users", userRepository.findAll());
        return null;
    }


}