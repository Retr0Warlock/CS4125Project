package Cars;

public interface I_CarCollisionObserver {
    // all vehicles implement this interface and must provide a collisionNotification() method
    void collisionNotification(int id1, int id2);
}
