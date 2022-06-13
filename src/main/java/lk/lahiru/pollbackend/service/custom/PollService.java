package lk.lahiru.pollbackend.service.custom;

import lk.ijse.dep8.polling.dto.PollDTO;
import lk.ijse.dep8.polling.dto.VoteDTO;
import lk.ijse.dep8.polling.service.SuperService;
import lk.ijse.dep8.polling.service.exception.NotFoundException;

import java.util.List;

public interface PollService extends SuperService {

    List<PollDTO> listAllPolls();

    PollDTO getPoll(int id) throws NotFoundException;

    PollDTO savePoll(PollDTO dto);

    void updatePoll(PollDTO dto) throws NotFoundException;

    void deletePoll(int id) throws NotFoundException;

    VoteDTO getVote(int pollId, String user) throws NotFoundException;

    /**
     * Save or update a vote
     *
     * @param dto
     * @return if false it means the vote has been updated, otherwise it has been created
     */
    boolean saveVote(VoteDTO dto);

}
