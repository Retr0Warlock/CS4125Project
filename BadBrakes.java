package Speed;

public class BadBrakes extends SpeedDecorator {
    BadBrakes(Speed v) { 
        super(v);
    }
    
    int kilometers() { 
        return super.kilometers() - 1; 
    }
}