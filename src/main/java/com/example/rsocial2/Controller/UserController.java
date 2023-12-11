package com.example.rsocial2.Controller;

import com.example.rsocial2.Model.User;
import com.example.rsocial2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user-list";
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

    @GetMapping("/users/{userId}")
    public String showUserPosts(@PathVariable Long userId, Model model) {
        User user = userService.findUserById(Math.toIntExact(userId));

        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/users/" + userId + "/posts";
        } else {

            return "redirect:/error";
        }
    }
}

