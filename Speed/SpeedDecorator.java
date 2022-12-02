package Speed;

public class SpeedDecorator extends Speed {
    Speed v;

    SpeedDecorator(Speed v) { 
        this.v = v; 
    }
    
    public double kilometers(){ 
        return v.kilometers(); 
    }
}