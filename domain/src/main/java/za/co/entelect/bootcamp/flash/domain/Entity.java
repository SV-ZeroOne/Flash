package za.co.entelect.bootcamp.flash.domain;


public interface Entity<TKey> {
    TKey getID();
    void setID(TKey entityKey);
}
