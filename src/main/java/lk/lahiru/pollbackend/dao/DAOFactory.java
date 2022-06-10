package lk.lahiru.pollbackend.dao;


import lk.lahiru.pollbackend.dao.custom.impl.PollDAOImpl;

import javax.persistence.EntityManager;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory == null) ? (daoFactory = new DAOFactory()) : daoFactory;
    }

    public <T extends  SuperDAO> T getDAO(EntityManager em, DAOType daoType){
        switch (daoType) {
            case POLL:
                return (T) new PollDAOImpl(em);
            default:
                return null;
        }
    }

    public enum DAOType{
        POLL
    }
}
