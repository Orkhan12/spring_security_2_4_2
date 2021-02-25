package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;

import java.security.Principal;


@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/user")
    public String userData(Model model, Principal principal) {
        model.addAttribute("user", this.userDao.getUserByUsername(principal.getName()));

        return "user";

    }
}
