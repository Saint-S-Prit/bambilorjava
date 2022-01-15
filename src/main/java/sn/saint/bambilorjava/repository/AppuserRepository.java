package sn.saint.bambilorjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.saint.bambilorjava.dto.AppuserDto;
import sn.saint.bambilorjava.model.Appuser;

import java.util.List;
import java.util.Optional;

public interface AppuserRepository extends JpaRepository<Appuser, Long> {

    Optional<Appuser> findByIdAndArchiveFalse(Long id);
    Optional<Appuser> findByUsernameAndArchiveFalse(String username);
    Optional<Appuser> findByUsername(String username);
    List<Appuser> findAllByArchiveFalse();

}
