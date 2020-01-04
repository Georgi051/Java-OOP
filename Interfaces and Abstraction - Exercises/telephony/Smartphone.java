package interfacesandabstraction.telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;
    private static final String NUM_PATTERN = "^[0-9]+$";
    private static final String URL_PATTERN = "^\\D+$";

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls) {
            if (this.isMatch(url, URL_PATTERN)) {
                sb.append(String.format("Browsing: %s!%n", url));
            } else {
                sb.append(String.format("Invalid URL!%n"));
            }
        }
        return sb.toString();
    }


    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            if (this.isMatch(number, NUM_PATTERN)) {
                sb.append(String.format("Calling... %s%n", number));
            } else {
                sb.append(String.format("Invalid number!%n"));
            }
        }
        return sb.toString();
    }

    private boolean isMatch(String urlOrNumber, String currentPattern) {
        Pattern pattern = Pattern.compile(currentPattern);
        Matcher matcher = pattern.matcher(urlOrNumber);
        return matcher.matches();
    }
}

