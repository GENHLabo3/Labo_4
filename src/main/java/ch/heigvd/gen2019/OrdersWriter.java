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
            sb.append(getJsonAttribute("code", product.getCode()));
            sb.append(", ");
            sb.append(getJsonAttribute("color", getColorFor(product)));
            sb.append(", ");

            if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
                if(product.getSize() < 0 || product.getSize() > Size.values().length) {
                    sb.append(getJsonAttribute("size", "Invalid Size"));
                } else {
                    sb.append(getJsonAttribute("size", Size.values()[product.getSize() - 1].toString()));
                }
                sb.append(", ");
            }

            sb.append(getJsonAttribute("price", product.getPrice()));
            sb.append(", ");
            sb.append(getJsonAttribute("currency", product.getCurrency()));
            sb.append("}" + (j >= order.getProductsCount() - 1 ? "" : ", "));
        }
    }

    private String getColorFor(Product product) {
        if(product.getColor() < 0 || product.getColor() > Color.values().length)
            return "no color";

        return Color.values()[product.getColor() - 1].toString();
    }

    private String getJsonAttribute(String attribute, String productValue) {
        return "\"" + attribute + "\": \"" + productValue + "\"";
    }

    private String getJsonAttribute(String attribute, double productValue) {
        return "\"" + attribute + "\": " + productValue;
    }
}