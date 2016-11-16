package ray.controller;

import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ray.models.Post;
import ray.repositories.PostRepository;

import java.util.List;

/**
 * Created by zr on 2016/11/15.
 */

@Controller
@RequestMapping("admin")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @RequestMapping(value = "post",method = RequestMethod.GET)
    public String post(){
        return "admin/post";
    }
    @RequestMapping(value = "post",method = RequestMethod.POST)
    public String post(Post post){
        postRepository.save(post);
        return "redirect:/postList";
    }


}
