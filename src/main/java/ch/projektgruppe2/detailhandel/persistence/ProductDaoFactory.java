package ch.projektgruppe2.detailhandel.persistence;

public class ProductDaoFactory {
    private static ProductDaoFactory instance;

    private ProductDaoFactory() {
    }

    public static ProductDaoFactory getInstance() {
        if (instance == null) {
            instance = new ProductDaoFactory();
        }
        return instance;
    }

    public ProductDao createProductDao() {
        return new ProductDaoMock();
    }
}
