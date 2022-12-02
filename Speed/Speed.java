package Speed;

public class Speed {

    static double speed;
    public static double SlowSpeed(int i) {
        //slow car
        if(i == 0) {
        Speed slowCarBadBrakes = new BadBrakes (new BadBrakes (new Slow()));
        speed = slowCarBadBrakes.kilometers();
        } else if(i == 1) {
        Speed slowCarGoodBrakes = new GoodBrakes (new GoodBrakes (new Slow()));
        speed = slowCarGoodBrakes.kilometers();
        }
        return speed;
    }

    public static double AverageSpeed(int i) {
        //Average car
        if(i == 0) {
        Speed averageCarBadBrakes = new BadBrakes (new BadBrakes (new Average()));
        speed = averageCarBadBrakes.kilometers();
        } else if(i == 1) {
        Speed averageCarGoodBrakes = new GoodBrakes (new GoodBrakes (new Average()));
        speed = averageCarGoodBrakes.kilometers();
        }
        return speed;
    }

    public static double FastSpeed(int i) {
        //fast car
        if(i == 0) {
        Speed fastCarBadBrakes = new BadBrakes (new BadBrakes (new Fast()));
        speed = fastCarBadBrakes.kilometers();
        } else if(i == 1) {
        Speed fastCarGoodBrakes = new GoodBrakes (new GoodBrakes (new Fast()));
        speed = fastCarGoodBrakes.kilometers();
        }
        return speed;
    }

    public static double F1Speed(int i) {
        //F1 car
        if(i == 0) {
        Speed f1CarBadBrakes = new BadBrakes (new BadBrakes (new F1()));
        speed = f1CarBadBrakes.kilometers();
        } else if(i == 1) {
        Speed f1CarGoodBrakes = new GoodBrakes (new GoodBrakes (new F1()));
        speed = f1CarGoodBrakes.kilometers();
        }
        return speed;
        
    }

    protected double kilometers() {
        return speed;
    }

}