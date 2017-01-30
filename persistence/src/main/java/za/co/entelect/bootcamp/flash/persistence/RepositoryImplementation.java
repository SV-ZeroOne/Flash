package za.co.entelect.bootcamp.flash.persistence;

import za.co.entelect.bootcamp.flash.domain.EntityInterface;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by steve.velcev on 2017/01/19.
 */
public abstract class RepositoryImplementation<TKey, TEntity extends EntityInterface<TKey>> implements RepositoryInterface<TKey, TEntity> {

    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUnit");
    protected EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Class<TEntity> entityClass;

    public RepositoryImplementation(){
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<TEntity>) genericSuperClass.getActualTypeArguments()[1];
    }

    public boolean create(TEntity object) {
        try{
            entityManager.getTransaction().begin();
            this.entityManager.persist(object);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public TEntity read(TKey id) {
        return this.entityManager.find(entityClass, id);
    }

    public List<TEntity> readAll() {
        return this.entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
    }

    public boolean update(TEntity object) {
        entityManager.getTransaction().begin();
        this.entityManager.merge(object);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean delete(TEntity object) {
        entityManager.getTransaction().begin();
        object = this.entityManager.merge(object);
        this.entityManager.remove(object);
        entityManager.getTransaction().commit();
        return true;
    }
}
