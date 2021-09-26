package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.Dto.SessionUser;
import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.web.dto.PostResponseDto;
import com.jojoldu.book.springboot.web.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
        //SessionUser user=(SessionUser) httpSession.getAttribute("user");

        if (user !=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id,Model model){
        PostResponseDto dto=postsService.findByid(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}
