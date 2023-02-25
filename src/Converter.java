import java.util.HashMap;

class Converter {
    HashMap<String, Integer> map = new HashMap<>();

    int getIntFromStringRomanArabic(String string) {
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        return map.get(string);
    }

    boolean checkMap(String str) {
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        return map.containsKey(str);
    }

    String getRomanFromArabic(int x) {
        String str1 = null;
        String str2 = null;

        if (x / 10 == 1) {
            str1 = "X";
        }
        if (x / 10 == 2) {
            str1 = "XX";
        }
        if (x / 10 == 3) {
            str1 = "XXX";
        }
        if (x / 10 == 4) {
            str1 = "XL";
        }
        if (x / 10 == 5) {
            str1 = "L";
        }
        if (x / 10 == 6) {
            str1 = "LX";
        }
        if (x / 10 == 7) {
            str1 = "LXX";
        }
        if (x / 10 == 8) {
            str1 = "LXXX";
        }
        if (x / 10 == 9) {
            str1 = "XC";
        }
        if (x / 10 == 10) {
            str1 = "C";
        }
        if (x % 10 == 1) {
            str2 = "I";
        }
        if (x % 10 == 2) {
            str2 = "II";
        }
        if (x % 10 == 3) {
            str2 = "III";
        }
        if (x % 10 == 4) {
            str2 = "IV";
        }
        if (x % 10 == 5) {
            str2 = "V";
        }
        if (x % 10 == 6) {
            str2 = "VI";
        }
        if (x % 10 == 7) {
            str2 = "VII";
        }
        if (x % 10 == 8) {
            str2 = "VIII";
        }
        if (x % 10 == 9) {
            str2 = "IX";
        }
        if (str1 != null & str2 != null) {
            return str1 + str2;
        } else if (str1 == null) {
            return str2;
        } else return str1;
    }
}
