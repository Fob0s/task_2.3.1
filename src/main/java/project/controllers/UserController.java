package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.dao.UserService;
import project.entity.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/allUsers";
    }
    @GetMapping("/")
    public String getUserById(@RequestParam(name = "id", required = false) Integer id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/user";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "/createUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("newUser") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/(id)/edit")
    public String updateUser(@RequestParam(name = "id") Integer id, Model model ) {
        model.addAttribute("updateUser", userService.getUser(id));
        User userDebug = (User) model.getAttribute("updateUser");
        return "/updateUser";
    }

    @PostMapping("/{id}")
    public String updating(@ModelAttribute("updateUser") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/(id)/delete")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        User user = userService.getUser(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }

}
