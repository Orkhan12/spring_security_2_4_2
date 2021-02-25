package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUser());
        model.addAttribute("listRole", this.userService.listRole());
        return "admin";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addUsers(@ModelAttribute("admin") User user, @RequestParam("select_role") Long role) {
        Set<Role> set = new HashSet<>();
        set.add(this.userService.getRoleById(role));
        user.setRoles(set);
        if (user.getId() == null) {
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/admin";
    }

    @RequestMapping("remove/{id}")
    public String removeUser(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        this.userService.removeUser(id);

        return "redirect:/admin";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUser());
        model.addAttribute("listRole", this.userService.listRole());

        return "admin";

    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));

        return "userdata";

    }

}
