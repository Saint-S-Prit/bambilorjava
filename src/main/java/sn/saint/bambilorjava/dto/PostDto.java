package sn.saint.bambilorjava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.saint.bambilorjava.model.Post;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    Long id;
    String title;
    String description;
    AppuserDto appuser;


    public static PostDto fromEntity(Post post)
    {
        if (post == null)
        {
            return null;
        }

        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .appuser(AppuserDto.fromEntity(post.getAppuser()))
                .build();
    }

    public static Post toEntity(PostDto postDto)
    {
        if (postDto == null)
        {
            return null;
        }

        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setAppuser(AppuserDto.toEntity(postDto.getAppuser()));
        return post;
    }
}
