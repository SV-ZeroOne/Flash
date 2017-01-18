package za.co.entelect.bootcamp.flash.persistence;

import za.co.entelect.bootcamp.flash.domain.Entity;

import java.util.List;

public interface Repository<TKey, TEntity extends Entity<TKey>> {

    void create(TEntity entity);

    TEntity getByID(TKey entityKey);

    List<TEntity> getAll();

    void update(TEntity entity) throws Exception;

    void delete(TEntity entity) throws Exception;
}
