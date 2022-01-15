package sn.saint.bambilorjava.validator;

import org.springframework.util.StringUtils;
import sn.saint.bambilorjava.dto.AppuserDto;
import sn.saint.bambilorjava.dto.PostDto;

import java.util.ArrayList;
import java.util.List;

public class PostValidator {

    public static List<String> validate(PostDto postDto) {

        List<String> errors = new ArrayList<>();

        if (postDto == null)
        {

            errors.add("Veuillez renseigner le titre");
            errors.add("Veuillez renseigner le description");
            return errors;

        }

        if (!StringUtils.hasLength(postDto.getTitle())) {
            errors.add("Veuillez renseigner le titre");
        }

        if (!StringUtils.hasLength(postDto.getDescription())) {
            errors.add("Veuillez renseigner le description");
        }



        return errors;
    }
}
