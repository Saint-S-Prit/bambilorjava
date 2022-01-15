package sn.saint.bambilorjava.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sn.saint.bambilorjava.dto.PostDto;
import sn.saint.bambilorjava.exception.EntityNotFoundException;
import sn.saint.bambilorjava.exception.ErrorCodes;
import sn.saint.bambilorjava.exception.InvalidEntityException;
import sn.saint.bambilorjava.model.Appuser;
import sn.saint.bambilorjava.model.Post;
import sn.saint.bambilorjava.repository.AppuserRepository;
import sn.saint.bambilorjava.repository.PostRepository;
import sn.saint.bambilorjava.service.PostService;
import sn.saint.bambilorjava.validator.PostValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    AppuserRepository appuserRepository;

    @Override
    public PostDto save(PostDto postDto) {

        List<String> errors = PostValidator.validate(postDto);
        if (!errors.isEmpty()) {
            log.error("user is not valid {}", postDto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_VALID, errors);
        }


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Post post = new Post();
        Appuser appuser = appuserRepository.findByUsernameAndArchiveFalse(auth!=null?auth.getPrincipal().toString():"sidibe").get();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setAppuser(appuser);
        postDto.setAppuser(postDto.getAppuser());
        log.info(postDto.toString());
        postRepository.save(post);
        return PostDto.fromEntity(post);
    }

    @Override
    public PostDto findById(Long id)
    {
        if (id == null)
        {log.error("User ID is null");
            return null;
        }

        return postRepository.findById(id).map(PostDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune post avec l'identifiant = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.POST_NOT_FOUND)
        );

    }


    @Override
    public List<PostDto> findAll() {
        return postRepository.findAllByArchiveFalse().stream()
                .map(PostDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void detete(Long id) {
        postRepository.deleteById(id);
    }


}
