package lk.lahiru.pollbackend.service.custom;

import lk.lahiru.pollbackend.dto.PollDTO;
import lk.lahiru.pollbackend.service.util.SuperService;

import java.util.List;

public interface PollService extends SuperService {

    List<PollDTO> listAllPolls();

    PollDTO savePoll(PollDTO dto);

    void updatePoll(PollDTO dto);

    void deletePoll(int id);


}
