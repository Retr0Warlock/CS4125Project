package Speed;

public class GoodBrakes extends SpeedDecorator {
    GoodBrakes(Speed v) { 
        super(v); 
    }

    public double kilometers() { 
        return super.kilometers() - 0.2; 
    }
}  
