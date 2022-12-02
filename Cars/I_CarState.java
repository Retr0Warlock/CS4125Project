package Cars;

import Road.Lane;

public interface I_CarState {
    void accelerate(int speedModifier, Car v, Lane l);
    CarStatesEnum getState();
    void changeLane(int laneID, Car v);
}
