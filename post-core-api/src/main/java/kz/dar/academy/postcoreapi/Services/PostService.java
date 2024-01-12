package kz.dar.academy.postcoreapi.Services;

import kz.dar.academy.postcoreapi.models.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PostService {

    private HashMap<String, PostModel> database = new HashMap<>();

    public PostModel createPost(PostModel post){
        return database.put(post.getPostId(), post);
    }

    public ArrayList<PostModel> getAllPosts(){
        return new ArrayList(database.values());
    }

    public PostModel getPostById(String id){
        return database.get(id);
    }

    public PostModel updatePost(String id, PostModel post){
        if(!database.containsKey(id)){
            return null;
        }
        return database.put(id, post);
    }

    public PostModel deletePostById(String id){
        return database.remove(id);
    }

}
