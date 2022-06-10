package lk.lahiru.pollbackend.dao;

import lk.lahiru.pollbackend.entity.SuperEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class CrudDAOImpl<T extends SuperEntity, ID extends Serializable> implements CrudDAO<T, ID> {

    protected EntityManager em;
    private Class<T> entityClzObj;

    public CrudDAOImpl() {
        entityClzObj = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    @Override
    public T save(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public void deleteById(ID pk) {
        em.remove(em.getReference(entityClzObj, pk));
    }

    @Override
    public Optional<T> findById(ID pk) {
        T entity = em.find(entityClzObj, pk);
        return entity == null ? Optional.empty() : Optional.of(entity);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("SELECT e FROM " + entityClzObj.getName() + " e", entityClzObj).getResultList();
    }

    @Override
    public long count() {
        return em.createQuery("SELECT COUNT(e) FROM " + entityClzObj.getName() + " e", Long.class).getSingleResult();
    }

    @Override
    public boolean existsById(ID pk) {
        return findById(pk).isPresent();
    }
}