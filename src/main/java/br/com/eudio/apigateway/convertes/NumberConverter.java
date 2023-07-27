package br.com.eudio.apigateway.convertes;

public class NumberConverter {

    public static Double convertToDouble(String Strnumber) {
        if(Strnumber == null) return 0D;
        String number = Strnumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String Strnumber) {
        if(Strnumber == null) return false;
        String number = Strnumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
