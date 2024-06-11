package ch.projektgruppe2.detailhandel.business;

import ch.projektgruppe2.detailhandel.persistence.ProductDao;
import ch.projektgruppe2.detailhandel.persistence.ProductDaoFactory;

public class ProductFactory {
    private static ProductFactory instance;
    private final ProductDao productDao;

    private ProductFactory() {
        this.productDao = ProductDaoFactory.getInstance().createProductDao();
    }

    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }

    public void createProduct(Product product) {
        String[] productData = new String[3];
        productData[0] = product.getName();
        productData[1] = product.getDescription();
        productData[2] = String.valueOf(product.getInventory());
        productDao.saveProduct(product.getId(), productData);
    }

    public Product displayProduct(long id) {
        String[] productData = productDao.findProduct(id);
        if (productData == null) {
            return null;
        }

        Product product = new BCProduct();
        product.setId(id);
        product.setName(productData[0]);
        product.setDescription(productData[1]);
        product.setInventory(Integer.parseInt(productData[2]));
        return product;
    }
}
