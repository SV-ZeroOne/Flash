package za.co.entelect.bootcamp.flash.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by steve.velcev on 2017/01/19.
 */
public class CRUDRepoImpl<T, PK extends Serializable> implements CRUDRepo<T, PK> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public CRUDRepoImpl(){
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    public boolean create(T object) {
        try{
            this.entityManager.persist(object);
            return true;
        }catch(Exception e){
            System.out.println("Something went wrong while persisting to DB");
            return false;
        }

    }

    public T read(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    public List<T> readAll() {
        return this.entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
    }

    public boolean update(T object) {
        this.entityManager.merge(object);
        return true;
    }

    public boolean delete(T object) {
        object = this.entityManager.merge(object);
        this.entityManager.remove(object);
        return true;
    }
}
