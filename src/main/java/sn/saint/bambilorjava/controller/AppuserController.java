package sn.saint.bambilorjava.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sn.saint.bambilorjava.controller.api.AppuserApi;
import sn.saint.bambilorjava.dto.AppuserDto;
import sn.saint.bambilorjava.service.AppuserService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class AppuserController implements AppuserApi {
    @Autowired
    AppuserService appuserService;
    @Override
    public AppuserDto save(AppuserDto appuserDto) {
        return appuserService.save(appuserDto);
    }

    @Override
    public Optional<AppuserDto> findById(long id) {
        return Optional.ofNullable(appuserService.findById(id));
    }

    @Override
    public List<AppuserDto> findAll() {
        return appuserService.findAll();
    }

    @Override
    public void detete(Long id) {
        appuserService.detete(id);
    }
}
