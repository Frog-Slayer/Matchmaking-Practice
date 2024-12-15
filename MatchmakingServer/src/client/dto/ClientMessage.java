package client.dto;

import java.util.HashMap;
import java.util.Map;

public class ClientMessage {
    private Map<String, String> map = new HashMap<>();

    @Override
    public String toString() {
        return map.toString();
    }

    public void put(String key, String value) {
        map.put(key, value);
    }
}
