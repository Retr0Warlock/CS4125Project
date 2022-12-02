package CollisionDetection;

import Cars.I_CarCollisionObserver;
import Road.*;

public interface I_CollisionDetectionSubject {
    void registerObserver(I_CarCollisionObserver o);
    void removeObserver(I_CarCollisionObserver o);
    void notifyObservers(int vehicle1ID, int vehicle2ID);
    int checkForCollisions(int vehicleID, int cellID, Lane track);
}
