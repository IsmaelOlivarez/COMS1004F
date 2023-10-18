package MidtermPractice1;

public class Car {
    
    //instance variables
    private String make;
    private String model;
    private int year;
    private String color;

    //Unnessecary declaration, would default to 0
    private double speed = 0.0;


    //constructor
    public Car(String make, String model, int year, String color){

        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;

    }

    //overridden constructor
    public Car(String make, String model, int year){
        
        this.make = make;
        this.model = model;
        this.year = year;

        color = "blue";
    }


    //Accessor Methods
    public double getSpeed(){
        return speed;
    }

    //Mutator Method

    public void speedUp(double delta){
        speed += delta;
        if(speed > 150){
            speed = 150;
        }
    }

    public void speedDown(double delta){
        speed -= delta;
        //cars dont typically go faster than 30mph backwards
        if(speed < -30.0){
            speed = -30.0;
        }
    }


    //toString

    public String toString(){
        return color + " " + year + " " + make + " " + model + " - " + speed;
    }
}
