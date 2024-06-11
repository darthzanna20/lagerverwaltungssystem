package ch.projektgruppe2.detailhandel.persistence;

public interface ProductDao {
    void saveProduct(long id, Object... product);
    Object[] findProduct(long id);
}

