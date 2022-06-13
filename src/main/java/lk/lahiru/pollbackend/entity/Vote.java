package lk.lahiru.pollbackend.entity;

import lk.ijse.dep8.polling.util.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote implements SuperEntity {
    @EmbeddedId
    private VotePK pk;
    @Enumerated(EnumType.STRING)
    @Column(name = "vote_type", nullable = false)
    private VoteType voteType;

    @JoinColumn(name = "poll_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne
    private Poll poll;

    public Vote(int pollId, String user, VoteType voteType) {
        this.pk = new VotePK(pollId, user);
        this.voteType = voteType;
    }
}
