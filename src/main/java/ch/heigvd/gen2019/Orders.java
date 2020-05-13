package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<Order>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    public int getOrdersCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }

    public String getOrdersJson() {

        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < getOrdersCount(); i++) {
            Order order = getOrder(i);
            sb.append("{");
            sb.append(order.getOrderJson());
            sb.append("}" + (i >= getOrdersCount() - 1 ? "" : ", "));
        }

        sb.append("]}");

        return sb.toString();
    }
}
