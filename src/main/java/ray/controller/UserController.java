package ray.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ray.models.User;
import ray.service.UserService;

import javax.annotation.Resource;

/**
 * Created by zr on 2016/11/15.
 */
@Controller
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login() {
        return "/login";
    }
    @RequestMapping(value="register" ,method = RequestMethod.GET)
    public String register(){ return "/register";}
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(User user){
        userService.save(user);
        return "redirect:/login";
    }
    @RequestMapping(value = "admin",method = RequestMethod.GET)
    public String admin() {
        return "/admin";
    }
}
