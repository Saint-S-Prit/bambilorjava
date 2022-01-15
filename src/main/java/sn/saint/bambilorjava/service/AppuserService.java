package sn.saint.bambilorjava.service;

import sn.saint.bambilorjava.dto.AppuserDto;
import sn.saint.bambilorjava.model.Appuser;

import java.util.List;

public interface AppuserService {

    AppuserDto save(AppuserDto appuserDto);

    AppuserDto findById(Long id);

    AppuserDto findByUsernameAndArchiveFalse(String username);

    List<AppuserDto> findAll();

    void detete(Long id);
}
