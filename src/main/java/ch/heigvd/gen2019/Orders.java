package ch.heigvd.gen2019;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<Order>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    public String getOrdersJson() {

        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            sb.append("{");
            sb.append(order.getOrderJson());
            sb.append("}" + (i >= orders.size() - 1 ? "" : ", "));
        }

        sb.append("]}");

        return sb.toString();
    }
}
