package za.co.entelect.bootcamp.flash;

import java.util.HashMap;

public interface Repository<TKey, TEntity extends Entity<TKey>> {

    void add(TEntity entity);

    void update(TEntity entity);

    void remove(TEntity entity);

    TEntity getById(TKey entityKey);

    HashMap<TKey, TEntity> getAll();
}
