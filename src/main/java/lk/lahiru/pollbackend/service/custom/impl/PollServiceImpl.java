package lk.lahiru.pollbackend.service.custom.impl;


import lk.lahiru.pollbackend.dao.DAOFactory;
import lk.lahiru.pollbackend.dao.custom.PollDAO;
import lk.lahiru.pollbackend.dto.PollDTO;
import lk.lahiru.pollbackend.service.custom.PollService;
import lk.lahiru.pollbackend.service.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class PollServiceImpl implements PollService {

    @Override
    public List<PollDTO> listAllPolls() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        PollDAO pollDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.POLL);
        try {
            return pollDAO.findAll().stream().map(EntityDTOTransformer::getPollDTO)
                    .collect(Collectors.toList());
        }finally{
            em.close();
        }
    }

    @Override
    public PollDTO getPoll(int id) throws NotFoundException {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        PollDAO pollDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.POLL);
        try {
            return pollDAO.findById(id)
                    .map(EntityDTOTransformer::getPollDTO)
                    .orElseThrow(() -> new NotFoundException("Invalid Poll ID"));
        }finally{
            em.close();
        }
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
