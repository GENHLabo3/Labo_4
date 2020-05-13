package ch.heigvd.gen2019;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class OrdersTest {
    Orders orders = new Orders();
    Order order111 = new Order(111);

    @BeforeEach
    public void SetupOneOrder() {
        orders.AddOrder(order111);
    }

    @Test
    public void NoOrder() {
        assertEquals("{\"orders\": []}", new Orders().getOrdersJson());
    }

    @Test
    public void OneOrder() {
        String order111 = "{\"id\": 111, \"products\": []}";
        assertEquals("{\"orders\": [" + order111 + "]}", orders.getOrdersJson());
    }

    @Test
    public void TwoOrders() {
        orders.AddOrder(new Order(222));

        String order111Json = JsonOrder111WithProduct("");
        String order222Json = "{\"id\": 222, \"products\": []}";
        assertEquals("{\"orders\": [" + order111Json + ", " + order222Json + "]}", orders.getOrdersJson());
    }

    @Test
    public void OneOrderWithOneProduct() {
        order111.AddProduct(new Product("Shirt", Color.blue, Size.M, 2.99, "TWD"));

        String order111Json = JsonOrder111WithProduct("{\"code\": \"Shirt\", \"color\": \"blue\", \"size\": \"M\", \"price\": 2.99, \"currency\": \"TWD\"}");
        assertEquals("{\"orders\": [" + order111Json + "]}", orders.getOrdersJson());
    }

    @Test
    public void OneOrderWithOneProductNoSize() {
        order111.AddProduct(new Product("Pot", Color.red, Size.undefined, 16.50, "SGD"));

        String order111Json = JsonOrder111WithProduct("{\"code\": \"Pot\", \"color\": \"red\", \"price\": 16.5, \"currency\": \"SGD\"}");
        assertEquals("{\"orders\": [" + order111Json + "]}", orders.getOrdersJson());
    }

    private String JsonOrder111WithProduct(String productJson) {
        return "{\"id\": 111, \"products\": [" + productJson + "]}";
    }
}
