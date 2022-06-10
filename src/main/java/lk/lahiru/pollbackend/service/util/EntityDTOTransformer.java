package lk.lahiru.pollbackend.service.util;


import lk.lahiru.pollbackend.dto.PollDTO;
import lk.lahiru.pollbackend.entity.Poll;
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

}
