package lk.lahiru.pollbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollDTO implements Serializable {
    private Integer id;
    private String title;
    private String createdBy;
    private int upVotes;
    private int downVotes;

    public PollDTO(String title, String createdBy, int upVotes, int downVotes) {
        this.title = title;
        this.createdBy = createdBy;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
    }
}
