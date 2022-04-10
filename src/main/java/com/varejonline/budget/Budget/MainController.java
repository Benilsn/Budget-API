package com.varejonline.budget.Budget;

import com.varejonline.budget.Budget.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    @Autowired
    private SecurityConfig securityConfig;

    @GetMapping("/auth/home")
    public String homePage(RedirectAttributes ra, Model model) {
        model.addAttribute("userName", SecurityContextHolder.getContext().getAuthentication().getName().toUpperCase());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
