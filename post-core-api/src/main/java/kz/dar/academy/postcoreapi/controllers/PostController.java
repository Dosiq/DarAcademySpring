package kz.dar.academy.postcoreapi.controllers;

import kz.dar.academy.postcoreapi.DTO.PostDTO;
import kz.dar.academy.postcoreapi.Services.PostService;
import kz.dar.academy.postcoreapi.models.PostModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {


    private final PostService service = new PostService();

    private static int postId = 0;

    @GetMapping("/check")
    public String healthCheck(){
        return "OK, is working";
    }

    @PostMapping("/create")
    public PostModel createPost(@RequestBody PostDTO post){
        return service.createPost(convertToPost(post));
    }

    @GetMapping("/getAll")
    public List<PostModel> getAllPosts(){
        return service.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostModel getPostById(@PathVariable String id){
        return service.getPostById(id);
    }

    @PutMapping("/update/{id}")
    public PostModel updatePost(@PathVariable String id, @RequestBody PostDTO post){
        return service.updatePost(id, convertToPost(post));
    }

    @DeleteMapping("/delete/{id}")
    public PostModel deletePostById(@PathVariable String id){
        return  service.deletePostById(id);
    }

    public PostModel convertToPost(PostDTO postDTO){
        PostModel post = new PostModel();
        post.setPostId(String.valueOf(++postId));
        post.setClientId(postDTO.getClientId());
        post.setPostRecipientId(postDTO.getPostRecipientId());
        post.setPostItem(postDTO.getPostItem());
        post.setStatus(postDTO.getStatus());

        return post;
    }
}
