package sn.saint.bambilorjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.saint.bambilorjava.model.Appuser;
import sn.saint.bambilorjava.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByIdAndArchiveFalse(Long id);
    List<Post> findAllByArchiveFalse();
}
