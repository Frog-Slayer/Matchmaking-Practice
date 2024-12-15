package utils;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private final Map<String, String> map = new HashMap<>();

    //TODO : 파싱 실패 예외 처리 필요
    public Message(String message) {
        String[] messageParts = message.split(" ");
        for (int i = 0; i < messageParts.length; i+= 2) {
            String key = messageParts[i];
            String value = messageParts[i+1];
            map.put(key, value);
        }
    }

    public String get(String key) {
        return map.get(key);
    }
}
