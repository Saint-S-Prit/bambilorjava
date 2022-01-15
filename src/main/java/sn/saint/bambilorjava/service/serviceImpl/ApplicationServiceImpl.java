package sn.saint.bambilorjava.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.saint.bambilorjava.model.Appuser;
import sn.saint.bambilorjava.repository.AppuserRepository;
import sn.saint.bambilorjava.service.ApplicationService;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    AppuserRepository appuserRepository;

    @Override
    public Appuser findByUsername(String username) {
        if (appuserRepository.findByUsernameAndArchiveFalse(username).isPresent()){

            return appuserRepository.findByUsernameAndArchiveFalse(username).get();
        }
        return null;
    }
}
