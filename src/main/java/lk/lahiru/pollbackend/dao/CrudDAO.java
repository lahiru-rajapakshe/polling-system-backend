package lk.lahiru.pollbackend.dao;

import lk.lahiru.pollbackend.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> extends SuperDAO {
        ID save(T entity);

        void deleteById(ID pk);

        T findById(ID pk);

        List<T> findAll();

        long count();

        boolean existById();

}
