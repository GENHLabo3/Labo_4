package ch.heigvd.gen2019;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        return getOrderJson().toString();
    }

    private StringBuffer getOrderJson() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            sb.append("{");
            sb.append(JsonTranslator.getJsonAttribute("id", order.getOrderId()));
            sb.append(", ");

            sb.append("\"products\": [");
            getProductsJsonInformation(sb, order);
            sb.append("]");

            sb.append("}" + (i >= orders.getOrdersCount() - 1 ? "" : ", "));
        }

        return sb.append("]}");
    }
    private void getProductsJsonInformation(StringBuffer sb, Order order) {
        for (int j = 0; j < order.getProductsCount(); j++) {
            Product product = order.getProduct(j);
            sb.append("{");
            sb.append(product.getProductJson());
            sb.append("}" + (j >= order.getProductsCount() - 1 ? "" : ", "));
        }
    }

}