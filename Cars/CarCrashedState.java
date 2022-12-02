package Cars;

import Road.Lane;

public class CarCrashedState implements I_CarState {

    public void accelerate(int speedModifier, Car v, Lane l) {
        //Will not accelerate when Crashed
    }

    public CarStatesEnum getState() {
        return CarStatesEnum.CRASHED;
    }
    
    public void changeLane(int laneID, Car v) {
        //Will not change lane when Crashed
	}
}
