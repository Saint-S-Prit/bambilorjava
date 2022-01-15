package sn.saint.bambilorjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post  extends AbstractEntity{

    private String title;
    private String description;
    @ManyToOne
    private Appuser appuser;
}
