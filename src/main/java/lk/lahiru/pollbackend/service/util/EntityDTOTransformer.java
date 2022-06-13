package lk.lahiru.pollbackend.service.util;

import lk.ijse.dep8.polling.dto.PollDTO;
import lk.ijse.dep8.polling.dto.VoteDTO;
import lk.ijse.dep8.polling.entity.Poll;
import lk.ijse.dep8.polling.entity.Vote;
import org.modelmapper.ModelMapper;

public class EntityDTOTransformer {

    public static PollDTO getPollDTO(Poll pollEntity){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(pollEntity, PollDTO.class);
    }

    public static Poll getPoll(PollDTO pollDTO){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(pollDTO, Poll.class);
    }

    public static VoteDTO getVoteDTO(Vote voteEntity){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(voteEntity, VoteDTO.class);
    }

    public static Vote getVote(VoteDTO voteDTO){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(voteDTO, Vote.class);
    }

}
