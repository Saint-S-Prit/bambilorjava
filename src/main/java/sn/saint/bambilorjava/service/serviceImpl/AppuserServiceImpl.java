package sn.saint.bambilorjava.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.saint.bambilorjava.dto.AppuserDto;
import sn.saint.bambilorjava.exception.EntityNotFoundException;
import sn.saint.bambilorjava.exception.ErrorCodes;
import sn.saint.bambilorjava.exception.InvalidEntityException;
import sn.saint.bambilorjava.repository.AppuserRepository;
import sn.saint.bambilorjava.service.AppuserService;
import sn.saint.bambilorjava.validator.AppuserValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AppuserServiceImpl implements AppuserService {

    @Autowired
    AppuserRepository appuserRepository;

    @Autowired
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public AppuserDto save(AppuserDto appuserDto) {

        List<String> errors = AppuserValidator.validate(appuserDto);
        if (!errors.isEmpty()) {
            log.error("user is not valid {}", appuserDto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_VALID, errors);
        }
        if (appuserRepository.findByUsername(appuserDto.getUsername()).isPresent())
        {
            throw new InvalidEntityException("Le pseudo n'existe déjà", ErrorCodes.USER_NOT_EXIST, errors);
        }

        appuserDto.setPassword(encoder.encode(appuserDto.getPassword()));
        return AppuserDto.fromEntity(appuserRepository.save(
                AppuserDto.toEntity(appuserDto)
        ));
    }

    @Override
    public AppuserDto findById(Long id)
    {
        if (id == null)
        {log.error("User ID is null");
            return null;
        }

        return appuserRepository.findById(id).map(AppuserDto::fromEntity).orElseThrow(() ->
            new EntityNotFoundException(
            "Aucun utilisateur avec l'identifiant = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.USER_NOT_FOUND)
        );

    }


    @Override
    public AppuserDto findByUsernameAndArchiveFalse(String username)
    {
        if (username == null)
        {
            log.error("userName is null");
            return null;
        }

        return appuserRepository.findByUsernameAndArchiveFalse(username).map(AppuserDto::fromEntity).orElseThrow(() ->
            new EntityNotFoundException(
            "Aucun utilisateur avec l'email = " + username + " n' ete trouve dans la BDD",
            ErrorCodes.USER_NOT_FOUND)
        );
    }

    @Override
    public List<AppuserDto> findAll() {
        return appuserRepository.findAllByArchiveFalse().stream()
                .map(AppuserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void detete(Long id) {
        appuserRepository.getById(id);
    }
}
