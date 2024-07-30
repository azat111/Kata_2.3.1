package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserService;
import web.models.User;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getCars(Model model) {
        model.addAttribute("users", userService.index());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        return "deleteUser";
    }

    @PostMapping("/deleteUser")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUser() {
        return "editUser";
    }

    @PostMapping("/editUser")
    public String edit(@RequestParam("id") int id, String model, int age) {
        User user = userService.findById(id);
        user.setAge(age);
        user.setName(model);
        userService.update(user);
        return "redirect:/users";
    }
}
