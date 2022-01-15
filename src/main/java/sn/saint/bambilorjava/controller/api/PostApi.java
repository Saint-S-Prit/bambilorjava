package sn.saint.bambilorjava.controller.api;

import org.springframework.web.bind.annotation.*;
import sn.saint.bambilorjava.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostApi {

    @PostMapping(value = "/posts")
    PostDto save(
            @RequestBody PostDto postDto
    );

    @GetMapping(value =  "/posts/{id}")
    Optional<PostDto> findById(@PathVariable long id);

    @GetMapping(value ="/posts/list")
    List<PostDto> findAll();

    @DeleteMapping(value = "/posts/{id}")
    void detete(@PathVariable Long id);
}
