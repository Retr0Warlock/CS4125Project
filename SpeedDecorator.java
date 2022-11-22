package Speed;

public class SpeedDecorator extends Speed {
    Speed v;

    SpeedDecorator(Speed v) { 
        this.v = v; 
    }
    
    int kilometers(){ 
        return v.kilometers(); 
    }
}