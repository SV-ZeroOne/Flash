package za.co.entelect.bootcamp.flash;

import java.util.HashMap;

import java.util.Map;

public abstract class RepositoryBase<TEntity extends Entity<TKey>, TKey> implements Repository<TEntity, TKey> {

    private HashMap<TKey, TEntity> items = new HashMap<TKey, TEntity>();

    public void add(TEntity entity, TKey entityId)
    {
        items.put(entityId, entity);
    }

    public void update(TEntity entity, TKey entityId) {
        TEntity objectToUpdate = items.get(entityId);
        objectToUpdate = entity;
        items.put(entityId, objectToUpdate);
    }

    public void remove(TKey entityId)
    {
        items.remove(entityId);
    }

    public TEntity getById(TKey id)
    {
        return items.get(id);
    }

    public Map<TKey, TEntity> getAll()
    {
        return items;
    }

}
