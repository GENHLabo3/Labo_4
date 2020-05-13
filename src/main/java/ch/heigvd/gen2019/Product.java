package ch.heigvd.gen2019;

public class Product {

    private String code;
    private Color color;
    private Size size;
    private double price;
    private String currency;

    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getProductJson() {
        StringBuffer sb = new StringBuffer();
        sb.append(JsonTranslator.getJsonAttribute("code", code));
        sb.append(", ");
        sb.append(JsonTranslator.getJsonAttribute("color",
                color == null ? "no color" : color.toString()));
        sb.append(", ");

        if (size != Size.undefined) {
            sb.append(JsonTranslator.getJsonAttribute("size",
                    size == null ? "Invalid Size" : size.toString()));
            sb.append(", ");
        }

        sb.append(JsonTranslator.getJsonAttribute("price", price));
        sb.append(", ");
        sb.append(JsonTranslator.getJsonAttribute("currency", currency));

        return sb.toString();
    }
}