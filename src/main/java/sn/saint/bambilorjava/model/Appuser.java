package sn.saint.bambilorjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Appuser extends AbstractEntity{

    private String fullname;
    private String username;
    private String password;
    private String phoneNumber;

    @OneToMany(mappedBy = "appuser")
    private  List<Post> posts;
}
