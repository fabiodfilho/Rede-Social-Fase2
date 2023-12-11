package com.example.rsocial2.Controller;

import com.example.rsocial2.Model.Post;
import com.example.rsocial2.Model.User;
import com.example.rsocial2.Service.PostService;
import com.example.rsocial2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String redirectToPostList() {

        return "redirect:/posts";
    }

    @GetMapping("/users/{userId}/posts")
    public String listUserPosts(@PathVariable Long userId, Model model) {
        User User = userService.findUserById(Math.toIntExact(userId));

        if (User != null) {
            List<Post> userPosts = postService.findPostsByAuthorId(userId);
            model.addAttribute("user", User);
            model.addAttribute("posts", userPosts);
            return "user-posts";
        } else {

            return "redirect:/error";
        }
    }

    @GetMapping("/posts/recent")
    public String listRecentPosts(Model model) {
        List<Post> recentPosts = postService.findRecentPosts();
        return "post-list";
    }

    @GetMapping("/posts/new")
    public String showPostForm(Model model) {
        model.addAttribute("newPost", new Post());
        return "post-form";
    }

    @GetMapping("/posts")
    public String listAllPosts(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "post-list";
    }


    @PostMapping("/posts/new")
    public String addPost(@ModelAttribute("newPost") Post newPost, RedirectAttributes redirectAttributes) {

        if (newPost.getAuthor() != null) {
            postService.save(newPost);
            return "redirect:/posts";
        } else {


            redirectAttributes.addFlashAttribute("error", "Usuário não encontrado. Não foi possível adicionar o post.");
            return "redirect:/error";
        }
    }


    @GetMapping("/error")
    public String showErrorPage(Model model) {
        return "error";
    }

}
