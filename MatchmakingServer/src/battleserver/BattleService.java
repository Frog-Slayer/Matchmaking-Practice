package battleserver;

import server.ServiceDelegator;

public interface BattleService extends ServiceDelegator {
    void makeSession();
    void joinSession();
    void quitSession();
}
