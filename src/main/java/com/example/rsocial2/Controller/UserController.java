package com.example.rsocial2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.rsocial2.Model.User;
import com.example.rsocial2.Service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "list";
    }

    @GetMapping("/users/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/users/new")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
}
