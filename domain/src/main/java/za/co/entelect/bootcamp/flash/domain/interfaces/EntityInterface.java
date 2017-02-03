package za.co.entelect.bootcamp.flash.domain.interfaces;

/**
 * @author kevin.gouws - Created on 2017/01/30.
 */
public interface EntityInterface<TKey> {
    TKey getID();
    void setID(TKey entityKey);
}
