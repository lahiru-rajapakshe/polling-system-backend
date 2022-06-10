package lk.lahiru.pollbackend.dao.custom.impl;

import lk.lahiru.pollbackend.dao.CrudDAOImpl;
import lk.lahiru.pollbackend.dao.custom.PollDAO;
import lk.lahiru.pollbackend.entity.Poll;

import javax.persistence.EntityManager;

public class PollDAOImpl extends CrudDAOImpl<Poll, Integer> implements PollDAO {
    public PollDAOImpl(EntityManager em) {
        this.em = em;
    }

}
