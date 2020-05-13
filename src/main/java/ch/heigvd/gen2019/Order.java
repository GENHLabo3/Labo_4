package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    private String getProductsJson() {

        StringBuffer sb = new StringBuffer();

        for (int j = 0; j < products.size(); j++) {
            Product product = products.get(j);
            sb.append("{");
            sb.append(product.getProductJson());
            sb.append("}" + (j >= products.size() - 1 ? "" : ", "));
        }

        return sb.toString();
    }

    public String getOrderJson() {
        StringBuffer sb = new StringBuffer();

        sb.append(JsonTranslator.getJsonAttribute("id", id));
        sb.append(", ");
        sb.append("\"products\": [");
        sb.append(getProductsJson());
        sb.append("]");

        return sb.toString();
    }

}
