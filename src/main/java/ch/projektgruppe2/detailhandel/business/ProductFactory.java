package ch.projektgruppe2.detailhandel.business;

import ch.projektgruppe2.detailhandel.persistence.ProductDao;
import ch.projektgruppe2.detailhandel.persistence.ProductDaoFactory;

public class ProductFactory {
    private static ProductFactory instance;
    private final ProductDao productDao;
    private long productId = 0;

    private ProductFactory() {
        this.productDao = ProductDaoFactory.getInstance().createProductDao();
    }

    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }

    public Product createProduct(String name, String description, int inventory) {
        Product product = new BCProduct();
        product.setId(productId++);
        product.setName(name);
        product.setDescription(description);
        product.setInventory(inventory);
        return product;
    }

    public Product displayProduct(long id) {
        Object[] productData = productDao.findProduct(id);
        if (productData != null) {
            Product product = new BCProduct();
            product.setId(id);
            product.setName((String) productData[0]);
            product.setDescription((String) productData[1]);
            product.setInventory((int) productData[2]);
            return product;
        } 
        return null;
    }

    public void saveProduct(Product product) {
        productDao.saveProduct(product.getId(), product.getName(), product.getDescription(), product.getInventory());
    }
}
