package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Message {
    private Map<String, String> map;

    public Message(String message) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println((message));
            map = mapper.readValue(message, new TypeReference<Map<String, String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return map.get(key);
    }
}
