public class Calculator {

    private char znak;
    private String[] data;

    public void calc(String virajenie) throws Exception {
        if (virajenie.contains(" + ")) {
            data = virajenie.split(" \\+ ");
            znak = '+';
        } else if (virajenie.contains(" - ")) {
            data = virajenie.split(" - ");
            znak = '-';
        } else if (virajenie.contains(" * ")) {
            data = virajenie.split(" \\* ");
            znak = '*';
        } else if (virajenie.contains(" / ")) {
            data = virajenie.split(" / ");
            znak = '/';
        } else {
            throw new Exception("Неверный знак");
        }
        if (znak == '*' || znak == '/') {
            if (data[1].contains("\"")) throw new Exception("Строка умножается или делится только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        if (znak == '+') {
            pechat(data[0] + data[1]);
        } else if (znak == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            pechat(result);
        } else if (znak == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                pechat(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                pechat(result);
            }
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLen);
            pechat(result);
        }
    }

    static void pechat(String text) {
        System.out.println("\"" + text + "\"");
    }
}



