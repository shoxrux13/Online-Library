package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.model.User;
import uz.pdp.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping()
    public String loginUser(User user, HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (user != null && user.getPassword() != null && user.getUserName() != null) {
            User userByUserName = userService.getUserByUserName(user.getUserName());
            if (userByUserName != null) {
                session.setAttribute("userId", userByUserName.getId());
                return "redirect:/books";
            }
        }
        return "index";
    }
    @GetMapping
    public String loginUser(){
        return "index";
    }

    @GetMapping("register")
    public String registerUser() {
        return "register";
    }

    @PostMapping("register")
    public String registerUser(User user) {
        userService.saveUser(user);
        return "redirect:/books";
    }

}
