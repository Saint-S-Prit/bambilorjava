package sn.saint.bambilorjava.validator;

import org.springframework.util.StringUtils;
import sn.saint.bambilorjava.dto.AppuserDto;

import java.util.ArrayList;
import java.util.List;

public class AppuserValidator {

    public static List<String> validate(AppuserDto appuserDto) {

        List<String> errors = new ArrayList<>();

        if (appuserDto == null)
        {

            errors.add("Veuillez renseigner le nom complet");
            errors.add("Veuillez renseigner le pseudo");
            errors.add("Veuillez renseigner le Numero Telephone");
            errors.add("Numero Telephone non valide");
            errors.add("Veuillez renseigner le mot de passe");
            return errors;

        }

        if (!StringUtils.hasLength(appuserDto.getFullname())) {
            errors.add("Veuillez renseigner le nom complet");
        }

        if (!StringUtils.hasLength(appuserDto.getUsername())) {
            errors.add("Veuillez renseigner le pseudo");
        }

        if (!StringUtils.hasLength(appuserDto.getPhoneNumber())) {
            errors.add("Veuillez renseigner le Numero Telephone");
        }

        if (!appuserDto.getPhoneNumber().matches("^(33|7[05-8])[0-9]{7}$")){
            errors.add("Numero Telephone non valide");
        }

        if (!StringUtils.hasLength(appuserDto.getPassword())) {
            errors.add("Veuillez renseigner le mot de passe");
        }

        return errors;
    }
}
