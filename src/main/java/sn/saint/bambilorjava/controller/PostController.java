package sn.saint.bambilorjava.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.saint.bambilorjava.controller.api.PostApi;
import sn.saint.bambilorjava.dto.PostDto;
import sn.saint.bambilorjava.service.PostService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class PostController implements PostApi {

    @Autowired
    PostService postService;

    @Override
    public PostDto save(PostDto postDto) {
        return postService.save(postDto);
    }

    @Override
    public Optional<PostDto> findById(long id) {
        return Optional.ofNullable(postService.findById(id));
    }

    public List<PostDto> findAll() {
        return postService.findAll();
    }

    @Override
    public void detete(Long id) {
        postService.detete(id);
    }
}
