package com.vanshikaexpense.msbaexpensetracker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
    @Autowired
    private ExpenseTrackerController expenseController;

    @RequestMapping("/")
    public String home(Model model) {
        List<Expense> expenses = expenseController.getAll();
        model.addAttribute("expensedata", expenses);
        return "home";
    }

    @RequestMapping("/createExpense")
    public String createExpense(@ModelAttribute Expense expense) {
        expenseController.createExpense(expense);
        return "redirect:/";
    }

    @RequestMapping("/deleteExpenses/{id}")
    public String deleteExpense(@PathVariable("id") int id) {
        expenseController.deletebyId(id);
        return "redirect:/";
    }

    @RequestMapping("/editExpense/{id}")
    public String editExpensePage(Model model, @PathVariable("id") int id) {
        Expense ex = expenseController.findId(id);
        System.out.println("Data" + ex.toString());
        model.addAttribute("expense", ex);
        return "edit";
    }

    @RequestMapping("/getId")
    public String getExpense(Model model, @RequestParam("id") int id) {
        System.out.println(id);
        Expense expense = expenseController.findId(id);
        model.addAttribute("data", expense);
        return "edit";

    }

    @RequestMapping("/updateExpense/{id}")
    public String editExpense(@PathVariable("id") int id, @ModelAttribute Expense expense) {
        expenseController.updateExpense(expense, id);
        return "redirect:/";
    }
}
