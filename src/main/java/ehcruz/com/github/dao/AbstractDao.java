package ehcruz.com.github.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T, PK> {

    @SuppressWarnings("unchecked")
    private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void save(T entity) {
        this.entityManager.persist(entity);
    }

    public void update(T entity) {
        this.entityManager.merge(entity);
    }

    public void delete(PK id) {
        T object = this.entityManager.getReference(this.entityClass, id);
        this.entityManager.remove(object);
    }

    public T findById(PK id) {
        return this.entityManager.find(this.entityClass, id);
    }

    public List<T> findAll() {
        return this.entityManager.createQuery("FROM " + this.entityClass.getSimpleName(), this.entityClass).
                getResultList();
    }

    protected List<T> createQuery(String jpql, Object... params) {
        TypedQuery<T> query = this.entityManager.createQuery(jpql, this.entityClass);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }
}
