package sn.saint.bambilorjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.saint.bambilorjava.model.Appuser;
import sn.saint.bambilorjava.model.Post;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppuserDto {

    Long id;
    String fullname;
    String username;
    String password;
    String phoneNumber;
    @JsonIgnore
    List<PostDto> posts;


    public static AppuserDto fromEntity(Appuser appuser)
    {
        if (appuser == null)
        {
            return null;
        }
        return AppuserDto.builder()
                .fullname(appuser.getFullname())
                .username(appuser.getUsername())
                .phoneNumber(appuser.getPhoneNumber())
                .build();
    }

    public static Appuser toEntity(AppuserDto appuserDto)
    {
        if (appuserDto == null)
        {
            return null;
        }

        Appuser appuser = new Appuser();
        appuser.setFullname(appuserDto.getFullname());
        appuser.setUsername(appuserDto.getUsername());
        appuser.setPassword(appuserDto.getPassword());
        appuser.setPhoneNumber(appuserDto.getPhoneNumber());
        return appuser;
    }
}
