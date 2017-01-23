package za.co.entelect.bootcamp.flash.domain;


public interface Entities<TKey> {
    TKey getID();
    void setID(TKey entityKey);
}
