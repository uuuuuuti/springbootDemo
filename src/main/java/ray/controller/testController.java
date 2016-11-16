package ray.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import ray.models.Post;
import ray.models.User;
import ray.repositories.PostRepository;
import ray.repositories.UserRepository;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zr on 2016/11/9.
 */
@Controller
public class testController {
    @Autowired
    PostRepository postRepository;
    @RequestMapping(value = {"","index"})
    public String home(){
        return "index";
    }

    @RequestMapping("/result/{previousPage}/{status}")
    public String showResultPage(Model model, @PathVariable String previousPage, @PathVariable String status){
        model.addAttribute("previousPage",previousPage);
        model.addAttribute("status",status);
        return "result";
    }
    @RequestMapping(value = "postList",method = RequestMethod.GET)
    public String getpost(Model model){
        List<Post> post = postRepository.findAll();
        model.addAttribute("posts",post);
        return "/postList";
    }

}
