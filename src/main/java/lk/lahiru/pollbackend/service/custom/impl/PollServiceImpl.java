package lk.lahiru.pollbackend.service.custom.impl;

import lk.ijse.dep8.polling.dao.DAOFactory;
import lk.ijse.dep8.polling.dao.custom.PollDAO;
import lk.ijse.dep8.polling.dto.PollDTO;
import lk.ijse.dep8.polling.service.custom.PollService;
import lk.ijse.dep8.polling.service.exception.NotFoundException;
import lk.ijse.dep8.polling.service.util.EntityDTOTransformer;
import lk.ijse.dep8.polling.service.util.JPAUtil;
import lk.lahiru.pollbackend.dao.DAOFactory;
import lk.lahiru.pollbackend.dao.custom.PollDAO;
import lk.lahiru.pollbackend.dto.PollDTO;
import lk.lahiru.pollbackend.service.exception.NotFoundException;
import lk.lahiru.pollbackend.service.util.EntityDTOTransformer;
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
        }catch (Throwable t){
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
        }catch (Throwable t){
            if (em != null && em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to delete the poll", t);
        } finally {
            em.close();
        }
    }
}
