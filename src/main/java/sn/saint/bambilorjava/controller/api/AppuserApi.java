package sn.saint.bambilorjava.controller.api;


import org.springframework.web.bind.annotation.*;
import sn.saint.bambilorjava.dto.AppuserDto;

import java.util.List;
import java.util.Optional;

public interface AppuserApi {

    @PostMapping(value = "/utilisateurs/registration")
    AppuserDto save(
            @RequestBody AppuserDto appuserDto
    );

    @GetMapping(value =  "/utilisateurs/{id}")
    Optional<AppuserDto> findById(@PathVariable long id);

    @GetMapping(value ="/utilisateurs")
    List<AppuserDto> findAll();

    @DeleteMapping(value = "/utilisateurs/{id}")
    void detete(@PathVariable Long id);
}