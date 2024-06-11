package ch.projektgruppe2.detailhandel.business;

public interface Product {
    void setId(long id);
    long getId();
    void setName(String name);
    String getName();
    void setDescription(String description);
    String getDescription();
    void setInventory(int inventory);
    int getInventory();
}

