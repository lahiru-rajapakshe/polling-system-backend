package lk.lahiru.pollbackend.service.custom.impl;

import lk.ijse.dep8.polling.dao.DAOFactory;
import lk.ijse.dep8.polling.dao.custom.PollDAO;
import lk.ijse.dep8.polling.dao.custom.VoteDAO;
import lk.ijse.dep8.polling.dto.PollDTO;
import lk.ijse.dep8.polling.dto.VoteDTO;
import lk.ijse.dep8.polling.entity.VotePK;
import lk.ijse.dep8.polling.service.custom.PollService;
import lk.ijse.dep8.polling.service.exception.NotFoundException;
import lk.ijse.dep8.polling.service.util.EntityDTOTransformer;
import lk.ijse.dep8.polling.service.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PollServiceImpl implements PollService {

    @Override
    public List<PollDTO> listAllPolls() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        PollDAO pollDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.POLL);
        try {
            List<PollDTO> pollDTOList = pollDAO.findAll().stream().map(EntityDTOTransformer::getPollDTO)
                    .collect(Collectors.toList());
            Collections.sort(pollDTOList);
            return pollDTOList;
        } finally {
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
        } finally {
            em.close();
        }
    }

    @Override
    public PollDTO savePoll(PollDTO dto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        PollDAO pollDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.POLL);
        try {
            em.getTransaction().begin();
            PollDTO pollDTO = EntityDTOTransformer.getPollDTO(pollDAO.save(EntityDTOTransformer.getPoll(dto)));
            em.getTransaction().commit();
            return pollDTO;
        } catch (Throwable t) {
            if (em != null && em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to save the poll", t);
        } finally {
            em.close();
        }
    }

    @Override
    public void updatePoll(PollDTO dto) throws NotFoundException {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        PollDAO pollDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.POLL);
        if (!pollDAO.existsById(dto.getId())) throw new NotFoundException("Invalid poll id");
        try {
            em.getTransaction().begin();
            pollDAO.save(EntityDTOTransformer.getPoll(dto));
            em.getTransaction().commit();
        } catch (Throwable t) {
            if (em != null && em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to update the poll", t);
        } finally {
            em.close();
        }
    }

    @Override
    public void deletePoll(int id) throws NotFoundException {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        PollDAO pollDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.POLL);
        if (!pollDAO.existsById(id)) throw new NotFoundException("Invalid poll id");
        try {
            em.getTransaction().begin();
            pollDAO.deleteById(id);
            em.getTransaction().commit();
        } catch (Throwable t) {
            if (em != null && em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to delete the poll", t);
        } finally {
            em.close();
        }
    }

    @Override
    public VoteDTO getVote(int pollId, String user) throws NotFoundException {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            VoteDAO voteDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.VOTE);
            return voteDAO.findById(new VotePK(pollId, user)).map(EntityDTOTransformer::getVoteDTO)
                    .orElseThrow(() -> new NotFoundException("No record found for this user and poll id combination"));
        } finally {
            em.close();
        }
    }

    @Override
    public boolean saveVote(VoteDTO dto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            VoteDAO voteDAO = DAOFactory.getInstance().getDAO(em, DAOFactory.DAOType.VOTE);
            if (!voteDAO.existsById(new VotePK(dto.getPollId(), dto.getUser()))){
                voteDAO.save(EntityDTOTransformer.getVote(dto));
               return true;
            }
            voteDAO.save(EntityDTOTransformer.getVote(dto));
            em.getTransaction().commit();
            return false;
        } catch (Throwable t) {
            if (em != null && em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to save the vote", t);
        } finally {
            em.close();
        }
    }
}
