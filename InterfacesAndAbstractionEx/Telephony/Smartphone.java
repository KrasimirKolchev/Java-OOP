package InterfacesAndAbstractionEx.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder(this.urls.size());

        for (String url : urls) {
            if (!url.matches(".*\\d.*")) {
                sb.append(String.format("Browsing: %s!", url));
            } else {
                sb.append("Invalid URL!");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
            if (number.matches("^([\\d]+)$")) {
                sb.append(String.format("Calling... %s", number));
            } else {
                sb.append("Invalid number!");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }
}
