package za.co.entelect.bootcamp.flash.persistence;

import za.co.entelect.bootcamp.flash.domain.Entities;

import java.io.Serializable;
import java.util.List;

/**
 * Created by steve.velcev on 2017/01/19.
 */
public interface RepositoryInterface<TKey, TEntity extends Entities>{
    boolean create(TEntity object);
    TEntity read(TKey id);
    List<TEntity> readAll();
    boolean update(TEntity object);
    boolean delete(TEntity object);
}
