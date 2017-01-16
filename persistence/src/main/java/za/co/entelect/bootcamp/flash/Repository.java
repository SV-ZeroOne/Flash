package za.co.entelect.bootcamp.flash;

import java.util.Map;

public interface Repository<TEntity extends Entity<TKey>, TKey> {

    void add(TEntity entity, TKey entityId);

    void update(TEntity entity, TKey entityId);

    void remove(TKey entityId);

    TEntity getById(TKey id);

    Map<TKey, TEntity> getAll();
}
