package com.varejonline.budget.Budget.controllers;

import com.varejonline.budget.Budget.config.SecurityConfig;
import com.varejonline.budget.Budget.exception.BudgetNotFoundException;
import com.varejonline.budget.Budget.models.budget.Budget;
import com.varejonline.budget.Budget.models.product.Product;
import com.varejonline.budget.Budget.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Set;

@Controller
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @Autowired
    private SecurityConfig securityConfig;

    @GetMapping("/auth/read")
    public String showBudgetsList(Model model) {

        List<Budget> budgetsList = budgetService.getAllBudgets();
        model.addAttribute("budgets", budgetsList);
        model.addAttribute("pageTitle", "View Budgets");
        if (securityConfig.isAdmin()) {
            return "admin-read";
        } else {

            return "read";
        }
    }

    @GetMapping("/auth/budgets/create")
    public String newBudget(Model model) {
        model.addAttribute("newBudget", new Budget());
        model.addAttribute("pageTitle", "Create Budget Page");
        model.addAttribute("saveButton", "Create");
        return "create";
    }

    @PostMapping("/auth/budgets/save")
    public String saveBudget(Budget budget, RedirectAttributes ra) {
        ra.addFlashAttribute("message", "The budget has been successfully saved!");
        budgetService.save(budget);
        return "redirect:/auth/read";
    }

    @GetMapping("/auth/budgets/edit/{id}")
    public String editBudget(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Budget newBudget = budgetService.get(id);
            model.addAttribute("newBudget", newBudget);
            model.addAttribute("products", newBudget.getProducts());
            model.addAttribute("pageTitle", "Edit Page");
            model.addAttribute("divTitle", "Edit Budget (ID: "+  id + ")");
            ra.addFlashAttribute("message", "The budget has been successfully edited!");
            model.addAttribute("saveButton", "Edit");
            return "edit";

        } catch (BudgetNotFoundException e) {
            e.printStackTrace();
            ra.addFlashAttribute("message", "Budget with ID: " + id + " Not Found!");
            return "redirect:/auth/read";
        }
    }

    @GetMapping("/auth/budgets/delete/{id}")
    public String deleteBudget(@PathVariable("id") Long id, RedirectAttributes ra) {
        try {
            budgetService.delete(id);
            ra.addFlashAttribute("message", "The budget with ID: " + id + " has been deleted!");
        } catch (BudgetNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/auth/read";
    }

    @GetMapping("/auth/products/read/{id}")
    public String showProductsList(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {

        try {
            List<Product> productsList = budgetService.getAllProducts(id);
            model.addAttribute("products", productsList);
            model.addAttribute("pageTitle", "View Products");
            ra.addFlashAttribute("message", "Budget ID:" + id + " Products");
            return "products_read";

        } catch (BudgetNotFoundException e) {
            ra.addFlashAttribute("message", "Budget Not Found!");
            return "read";
        }
    }

    @GetMapping("/auth/products/create/{id}")
    public String newProduct(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
        try {
            Budget budget = budgetService.get(id);
            model.addAttribute("budgetID", budget.getId());
            model.addAttribute("newProduct", new Product());
            model.addAttribute("pageTitle", "Create Product Page");
        } catch (BudgetNotFoundException e) {
            ra.addFlashAttribute("message", "Budget with ID: " + id + " Not Found!");
        }
        return "products_create";
    }

    @PostMapping("/auth/products/save/{id}")
    public String saveProduct(@PathVariable("id") Long id, Product product, RedirectAttributes ra) {
        try {
            Budget budget = budgetService.get(id);
            budgetService.saveProductToBudget(budget, product);
            ra.addFlashAttribute("message", "The product has been created!");
        } catch (BudgetNotFoundException e) {
            ra.addFlashAttribute("message", "Budget Not Found!");
        }
        return "redirect:/auth/read";
    }

}
