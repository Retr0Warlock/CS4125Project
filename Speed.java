package Speed;

public void main(String[] args) {
    int speed;

    //slow car
    Speed slowCarBadBrakes = new BadBrakes (new BadBrakes (new Slow()));
    speed = slowCarBadBrakes.kilometers();
    
    Speed slowCarGoodBrakes = new GoodBrakes (new GoodBrakes (new Slow()));
    speed = slowCarGoodBrakes.kilometers();

    //Average car
    Speed averageCarBadBrakes = new BadBrakes (new BadBrakes (new Average()));
    speed = averageCarBadBrakes.kilometers();

    Speed averageCarGoodBrakes = new GoodBrakes (new GoodBrakes (new Average()));
    speed = averageCarGoodBrakes.kilometers();

    //fast car
    Speed fastCarBadBrakes = new BadBrakes (new BadBrakes (new Fast()));
    speed = fastCarBadBrakes.kilometers();

    Speed fastCarGoodBrakes = new GoodBrakes (new GoodBrakes (new Fast()));
    speed = fastCarGoodBrakes.kilometers();

    //F1 car
    Speed f1CarGoodBrakes = new BadBrakes (new BadBrakes (new F1()));
    speed = f1CarGoodBrakes.kilometers();

    Speed f1CarGoodBrakes = new GoodBrakes (new GoodBrakes (new F1()));
    speed = f1CarGoodBrakes.kilometers();
}

public abstract class Speed {
    abstract int kilometers();
}  