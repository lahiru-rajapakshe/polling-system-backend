package lk.lahiru.pollbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class POll implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(name = "up_votes", nullable = false)
    private int upVotes;
    @Column(name = "down_votes", nullable = false)
    private int downVotes;
    @Column(name = "created_by", nullable = false)
    private String createdBy;
}