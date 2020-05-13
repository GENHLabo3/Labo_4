package ch.heigvd.gen2019;

public class JsonTranslator {

    public static String getJsonAttribute(String attribute, String productValue) {
        return "\"" + attribute + "\": \"" + productValue + "\"";
    }

    public static String getJsonAttribute(String attribute, double productValue) {
        return "\"" + attribute + "\": " + productValue;
    }

    public static String getJsonAttribute(String attribute, int productValue) {
        return "\"" + attribute + "\": " + productValue;
    }

}
