package lk.lahiru.pollbackend.dao.custom.impl;

import lk.ijse.dep8.polling.dao.CrudDAOImpl;
import lk.ijse.dep8.polling.dao.custom.VoteDAO;
import lk.ijse.dep8.polling.entity.Vote;
import lk.ijse.dep8.polling.entity.VotePK;

import javax.persistence.EntityManager;

public class VoteDAOImpl extends CrudDAOImpl<Vote, VotePK> implements VoteDAO {

    public VoteDAOImpl(EntityManager em) {
        this.em = em;
    }
}
