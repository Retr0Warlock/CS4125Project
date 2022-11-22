package Speed;

public class GoodBrakes extends SpeedDecorator {
    GoodBrakes(Speed v) { 
        super(v); 
    }

    int kilometers() { 
        return super.kilometers() - 3; 
    }
}  
