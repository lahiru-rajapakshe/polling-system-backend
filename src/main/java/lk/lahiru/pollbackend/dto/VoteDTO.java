package lk.lahiru.pollbackend.dto;

import lk.ijse.dep8.polling.util.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteDTO implements Serializable {
    private Integer pollId;
    private String user;
    private VoteType voteType;
}
