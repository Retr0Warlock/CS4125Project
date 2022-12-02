package Speed;

public class BadBrakes extends SpeedDecorator {
    public BadBrakes(Speed v) { 
        super(v);
    }
    
    public double kilometers() { 
        return super.kilometers() - 1; 
    }
}