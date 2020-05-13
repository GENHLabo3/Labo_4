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

    public String getCode() {
        return code;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getProductJson() {
        StringBuffer sb = new StringBuffer();
        sb.append(JsonTranslator.getJsonAttribute("code", getCode()));
        sb.append(", ");
        sb.append(JsonTranslator.getJsonAttribute("color",
                getColor() == null ? "no color" : getColor().toString()));
        sb.append(", ");

        if (getSize() != Size.undefined) {
            sb.append(JsonTranslator.getJsonAttribute("size",
                    getSize() == null ? "Invalid Size" : getSize().toString()));
            sb.append(", ");
        }

        sb.append(JsonTranslator.getJsonAttribute("price", getPrice()));
        sb.append(", ");
        sb.append(JsonTranslator.getJsonAttribute("currency", getCurrency()));

        return sb.toString();
    }
}