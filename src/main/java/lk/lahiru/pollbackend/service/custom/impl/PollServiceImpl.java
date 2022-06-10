package lk.lahiru.pollbackend.service.custom.impl;


import lk.lahiru.pollbackend.dto.PollDTO;
import lk.lahiru.pollbackend.service.custom.PollService;
import lk.lahiru.pollbackend.service.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PollServiceImpl implements PollService {

    @Override
    public List<PollDTO> listAllPolls() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        em.close();
        return null;
    }

    @Override
    public PollDTO getPoll(int id) {
        return null;
    }

    @Override
    public PollDTO savePoll(PollDTO dto) {
        return null;
    }

    @Override
    public void updatePoll(PollDTO dto) {

    }

    @Override
    public void deletePoll(int id) {

    }
}
