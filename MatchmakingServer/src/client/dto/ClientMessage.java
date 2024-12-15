package client.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class ClientMessage {
    private Map<String, String> map = new HashMap<>();

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(String key, String value) {
        map.put(key, value);
    }
}
