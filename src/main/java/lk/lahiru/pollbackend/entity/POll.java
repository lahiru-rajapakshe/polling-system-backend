package lk.lahiru.pollbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class POll implements SuperEntity{

    private int id;
    private String title;
    private String

}
