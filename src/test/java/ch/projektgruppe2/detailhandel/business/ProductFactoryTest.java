package ch.projektgruppe2.detailhandel.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductFactoryTest {

    private ProductFactory productFactory;

    @BeforeEach
    public void setUp() {
        productFactory = ProductFactory.getInstance();
    }

    @Test
    public void testCreateProduct() {
        Product product = productFactory.createProduct("Test Product", "Test Description", 10);
        assertNotNull(product);
        assertEquals("Test Product", product.getName());
        assertEquals("Test Description", product.getDescription());
        assertEquals(10, product.getInventory());
    }

    @Test
    public void testDisplayProduct() {
        Product product = productFactory.createProduct("Test Product", "Test Description", 10);
        productFactory.saveProduct(product);

        Product retrievedProduct = productFactory.displayProduct(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals(product.getId(), retrievedProduct.getId());
        assertEquals(product.getName(), retrievedProduct.getName());
        assertEquals(product.getDescription(), retrievedProduct.getDescription());
        assertEquals(product.getInventory(), retrievedProduct.getInventory());
    }

    @Test
    public void testSaveProduct() {
        Product product = productFactory.createProduct("Test Product", "Test Description", 10);
        productFactory.saveProduct(product);

        Product retrievedProduct = productFactory.displayProduct(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals(product.getId(), retrievedProduct.getId());
        assertEquals(product.getName(), retrievedProduct.getName());
        assertEquals(product.getDescription(), retrievedProduct.getDescription());
        assertEquals(product.getInventory(), retrievedProduct.getInventory());
    }
}
