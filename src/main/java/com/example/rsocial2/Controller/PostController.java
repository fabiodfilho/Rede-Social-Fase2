package com.example.rsocial2.Controller;

import com.example.rsocial2.Model.Post;
import com.example.rsocial2.Service.PostService;
import com.example.rsocial2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/posts/new")
    public String showPostForm(Model model) {
        model.addAttribute("newPost", new Post());
        return "post-form";
    }

    @GetMapping("/posts")
    public String listAllPosts(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "post-list"; // Substitua "post-list" pelo nome do seu arquivo HTML de lista de posts
    }


    @PostMapping("/posts/new")
    public String addPost(@ModelAttribute("newPost") Post newPost, RedirectAttributes redirectAttributes) {
        // Certifique-se de que o autor não é nulo antes de atribuir à postagem
        if (newPost.getAuthor() != null) {
            postService.save(newPost);
            return "redirect:/posts";
        } else {
            // Lógica para lidar com o usuário não encontrado
            // Adicione uma mensagem de erro e redirecione para uma página de erro
            redirectAttributes.addFlashAttribute("error", "Usuário não encontrado. Não foi possível adicionar o post.");
            return "redirect:/error"; // Substitua "/error" pelo caminho da sua página de erro
        }
    }


    @GetMapping("/error")
    public String showErrorPage(Model model) {
        return "error"; // Isso assume que o nome do arquivo HTML é "error.html"
    }

}
