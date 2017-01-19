package za.co.entelect.bootcamp.flash.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Created by steve.velcev on 2017/01/19.
 */
public interface CRUDRepo <T, PK extends Serializable>{
    boolean create(T object);
    T read(PK id);
    List<T> readAll();
    boolean update(T object);
    boolean delete(T object);
}
