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
            throw new Exception("Nevernyi znak");
        }
        if (znak == '*' || znak == '/') {
            if (data[1].contains("\"")) throw new Exception("Stroka ymnozaetsya ili delitsya na chislo");
        }
        if (data[0].length() > 12 || data[1].length() > 12) {
            throw new Exception("Very big stroka");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        if (znak == '+') {
            pechat(data[0] + data[1]);
        } else if (znak == '*') {
            int multiplier = Integer.parseInt(data[1]);
            if(Integer.parseInt(data[1])>10) throw new Exception("chislo ne dolzhno bit bolshe 10");
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
            if (result.length() > 40) {
                result = result + "...";
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
            if(Integer.parseInt(data[1])>10) throw new Exception("chislo ne dolzhno bit bolshe 10");
            String result = data[0].substring(0, newLen);
            pechat(result);
        }
    }

    static void pechat(String text) {
        System.out.println("\"" + text + "\"");
    }
}



