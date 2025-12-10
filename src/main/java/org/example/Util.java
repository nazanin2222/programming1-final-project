package org.example;

public class Util {
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) return str;

        String result = "";
        boolean newWord = true;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == ' ') {
                result += c;
                newWord = true;
            } else {
                if (newWord) {
                    result += Character.toUpperCase(c);
                    newWord = false;
                } else {
                    result += Character.toLowerCase(c);
                }
            }
        }

        return result;
    }
}
