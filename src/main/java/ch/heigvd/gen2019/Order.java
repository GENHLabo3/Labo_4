package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    private String getProductsJson() {

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < getProductsCount(); j++) {
            Product product = getProduct(j);
            sb.append("{");
            sb.append(product.getProductJson());
            sb.append("}" + (j >= getProductsCount() - 1 ? "" : ", "));
        }

        return sb.toString();
    }

    public String getOrderJson() {
        StringBuilder sb = new StringBuilder();

        sb.append(JsonTranslator.getJsonAttribute("id", getOrderId()));
        sb.append(", ");
        sb.append("\"products\": [");
        sb.append(getProductsJson());
        sb.append("]");

        return sb.toString();
    }

}
