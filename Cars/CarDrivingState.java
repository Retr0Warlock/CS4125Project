package Cars;

import Road.*;

public class CarDrivingState implements I_CarState{

    public void accelerate(int speedModifier, Car v, Lane l) {
        v.incrementCellID(speedModifier);
        v.updatePosition(l.getPosition(v.getCurrentCellID()));
        v.updateAngle(l.getCarAngle(v.getCurrentCellID()));
    }

    public CarStatesEnum getState() {
        return CarStatesEnum.DRIVING;
    }           
    
    public void changeLane(int laneID, Car v) {
    	v.getLane().removeFromCell(v.getCurrentCell());
		v.setLane(laneID);
		v.updatePosition(v.getLane().getPosition(v.getCurrentCell()));
		v.getLane().addToOccupiedCells(v.getCurrentCell(), v.getID());
	}
}
