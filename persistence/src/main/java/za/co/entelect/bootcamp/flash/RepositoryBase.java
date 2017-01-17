package za.co.entelect.bootcamp.flash;

import java.util.HashMap;

public abstract class RepositoryBase<TKey, TEntity extends Entity<TKey>> implements Repository<TKey, TEntity> {

    private HashMap<TKey, TEntity> entityHashMap = new HashMap<TKey, TEntity>();

    public void add(TEntity entity) {
        entityHashMap.put(entity.getID(), entity);
    }

    public void update(TEntity entity) {
        entityHashMap.remove(entity.getID());
        entityHashMap.put(entity.getID(), entity);
    }

    public void remove(TEntity entity) {
        entityHashMap.remove(entity.getID());
    }

    public TEntity getById(TKey entityKey) {
        return entityHashMap.get(entityKey);
    }

    public HashMap<TKey, TEntity> getAll()
    {
        return entityHashMap;
    }

}
