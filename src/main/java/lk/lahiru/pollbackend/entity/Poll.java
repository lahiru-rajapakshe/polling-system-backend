package lk.lahiru.pollbackend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Poll implements SuperEntity {
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

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "poll", cascade = {CascadeType.REMOVE})
    private List<Vote> votes = new ArrayList<>();

    public Poll(String title, int upVotes, int downVotes, String createdBy) {
        this.title = title;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.createdBy = createdBy;
    }
}
