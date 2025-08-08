package com.blog.BloggingProject.controller;


import com.blog.BloggingProject.model.Post;
import com.blog.BloggingProject.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Autowired
    PostRepo repo;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listPosts", repo.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newpost(Model model) {
        model.addAttribute("post", new Post());
        return "new_post";
    }

    @PostMapping("/save")
    public String savepost(@ModelAttribute Post post) {
        repo.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable int id, Model model) {
        model.addAttribute("post", repo.findById(id));
        return "edit_post";
    }

    @PostMapping("/update")
    public String updatepost(@ModelAttribute Post post) {
        repo.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletepost(@PathVariable int id) {
     repo.deleteById(id);
        return "redirect:/";
    }
}
