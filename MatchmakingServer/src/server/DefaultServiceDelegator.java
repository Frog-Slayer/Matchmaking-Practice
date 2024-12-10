package server;

public class DefaultServiceDelegator implements ServiceDelegator {
    private static final DefaultServiceDelegator instance = new DefaultServiceDelegator();

    private DefaultServiceDelegator() {}

    public static DefaultServiceDelegator getInstance() {
        return instance;
    }

    @Override
    public String process(String message) {
        return message;
    }
}
