package ch.projektgruppe2.detailhandel.persistence;

public interface ProductDao {
    void saveProduct(long id, String[] product);
    String[] findProduct(long id);
}

