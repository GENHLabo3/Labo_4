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
            sb.append("\"id\": ");
            sb.append(order.getOrderId());
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
            sb.append("\"code\": \"");
            sb.append(product.getCode());
            sb.append("\", ");
            sb.append("\"color\": \"");
            sb.append(getColorFor(product));
            sb.append("\", ");

            if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
                sb.append("\"size\": \"");
                sb.append(getSizeFor(product));
                sb.append("\", ");
            }

            sb.append("\"price\": ");
            sb.append(product.getPrice());
            sb.append(", ");
            sb.append("\"currency\": \"");
            sb.append(product.getCurrency());
            sb.append("\"}" + (j >= order.getProductsCount() - 1 ? "" : ", "));
        }
    }

    private String getSizeFor(Product product) {
        switch (product.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    private String getColorFor(Product product) {
        switch (product.getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }
}