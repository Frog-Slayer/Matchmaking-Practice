package server;

public class TestServiceDelegator implements ServiceDelegator {
    @Override
    public String process(String message) {
        return message.toUpperCase();
    }
}
