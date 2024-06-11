package ch.projektgruppe2.detailhandel.persistence;

import java.util.HashMap;
import java.util.Map;

public class ProductDaoMock implements ProductDao {
    private final Map<Long, Object[]> products = new HashMap<>();

    @Override
    public void saveProduct(long id, Object... product) {
        products.put(id, product);
    }

    @Override
    public Object[] findProduct(long id) {
        return products.get(id);
    }
}

