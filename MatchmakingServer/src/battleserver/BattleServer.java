package battleserver;

import server.Server;

public class BattleServer extends Server {

    public BattleServer(int port) {
        super(port, new BattleServiceImpl(), BattleClientThread.class);
    }

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        new BattleServer(12121).run();
    }
}
