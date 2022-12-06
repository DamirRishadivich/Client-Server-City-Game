public class CheckChar {
    String firstCity;
    String lastCity;
    public CheckChar(String firstCity, String lastCity) {
        this.firstCity = firstCity; // Москва
        this.lastCity = lastCity; // Актау
    }

    public boolean check() {
        String firstChar = String.valueOf(firstCity.charAt(firstCity.length() - 1)); // последнее слово сохраненное в деке
        String lastChar = String.valueOf(lastCity.charAt(0)); // полученное слово от клиента
        if (firstChar.equalsIgnoreCase(lastChar)) {
            return true;
        } else {
            return false;
        }
    }
}
