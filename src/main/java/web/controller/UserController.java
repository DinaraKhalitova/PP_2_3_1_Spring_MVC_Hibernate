package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("allUsers", userService.findAll()) ;
        return "index";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user );
        return "adduser";
    }
    @PostMapping("/saveUser")
    public String saveUser (@ModelAttribute ("user") User user){
        userService.saveUser(user);
        return  "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteById (@RequestParam ("id") int id){
        userService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping ("/updateUser")
    public String  update(@RequestParam ("id") int id,Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "updateuser";
    }
    @PostMapping("/user")
    public String save ( @ModelAttribute("user") User user) {

        userService.saveUser(user);
        return "redirect:/users";
    }

//    @GetMapping("/")
//    public String usersPage(Model model) {
//        model.addAttribute("users", userService.findAll());
//        return "users";
//    }
//
//    //@GetMapping("/showAddNewUserForm")
//    //public String showAddNewUserForm(Model model) {
//      //  model.addAttribute("addUser", new User());
//       // return "add-user";
//    //}
//
//    @PostMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        // userService.saveUser(user);
//        return "new";
//    }
//
//    @PostMapping("/create")
//    public String create(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/deleteUser")
//    public String deleteUser(@RequestParam("id") int id) {
//        userService.deleteById(id);
//        return "redirect:/";
//    }
//
//
//    @PostMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") long id) {
//        model.addAttribute("user", userService.getUser(id));
//        return "edit";
//    }
//
//    @PostMapping("/updateUser")
//    public String updateUser(@ModelAttribute("user") User user, Model model) {
//        // Логика обновления пользователя
//        return "redirect:/"; // Перенаправление на страницу пользователей после обновления
//    }
}