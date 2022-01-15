package sn.saint.bambilorjava.service;

import sn.saint.bambilorjava.dto.PostDto;
import sn.saint.bambilorjava.model.Post;

import java.util.List;

public interface PostService {

    PostDto save(PostDto postDto);

    PostDto findById(Long id);

    List<PostDto> findAll();

    void detete(Long id);
}
