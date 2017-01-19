package za.co.entelect.bootcamp.flash.persistence;

import za.co.entelect.bootcamp.flash.domain.Entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RepositoryBase<TKey, TEntity extends Entities<TKey>> implements Repository<TKey, TEntity> {

    private Map<TKey, TEntity> entityMap = new HashMap<TKey, TEntity>();

    public void create(TEntity entity) {
        entityMap.put(entity.getID(), entity);
    }

    public TEntity getByID(TKey entityKey) {
        return entityMap.get(entityKey);
    }

    public List<TEntity> getAll()
    {
        return (List<TEntity>) entityMap.values();
    }

    public void update(TEntity entity) throws Exception {
        TEntity existingEntity = this.getByID(entity.getID());
        if (existingEntity == null) {
            throw new Exception("Entities does not exist");
        }
        entityMap.put(entity.getID(), entity);
    }

    public void delete(TEntity entity) throws Exception {
        TEntity existingEntity = this.getByID(entity.getID());
        if (existingEntity == null) {
            throw new Exception("Entities does not exist");
        }
        entityMap.remove(entity.getID());
    }

}
