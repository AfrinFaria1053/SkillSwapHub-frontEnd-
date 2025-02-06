package com.frontend.front.controller;

import com.frontend.front.entity.User;
import com.frontend.front.repository.UserRepository;
import jakarta.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/signUpForm")
    public String signUpForm(Model model, HttpSession session) {
        model.addAttribute("user", new User());
        session.removeAttribute("message");
        return "signUpForm";
    }
    @GetMapping("/logInForm")
    public String logInForm() {
        return "logInForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, HttpSession session)
    {

        repo.save(user);
        session.setAttribute("message", "User Register Successful");

        return "redirect:/signUpForm";
    }
}
