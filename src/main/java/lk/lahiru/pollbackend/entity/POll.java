package lk.lahiru.pollbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data @AllArgsConstructor @NoArgsConstructor @Entity
public class POll implements SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String upVotes;
    private String downVotes;
    private String createdBy;

}
