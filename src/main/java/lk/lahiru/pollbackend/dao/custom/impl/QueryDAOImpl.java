package lk.lahiru.pollbackend.dao.custom.impl;

import lk.ijse.dep8.polling.dao.custom.QueryDAO;

import javax.persistence.EntityManager;

public class QueryDAOImpl implements QueryDAO {

    private EntityManager em;

    public QueryDAOImpl(EntityManager em) {
        this.em = em;
    }
}
