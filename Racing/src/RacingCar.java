public class RacingCar {

    private int speed;
    int fuel;
    String color;
    private int currentPosition;
    int maxSpeed;


    RacingCar(int speed, int fuel) {
        this.speed = speed;
        this.fuel = fuel;
    }

    RacingCar(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    int getSpeed () {
        return speed;
    }

}
