import java.util.Random;

public class Drunkard{

    //Instance Variables
    int avenue;
    int street;
    int sAvenue;
    int sStreet; 
    Random gen = new Random();

    //Class Constructor
    public Drunkard(int avenue, int street) {
        this.avenue = avenue;
        this.street = street;
        sAvenue = avenue;
        sStreet = street;
    }

    //Methods
    public void fastForward(int steps) {
        for(int i = 0; i<steps;i++) {
            step();
        }
    }

    public void step(){
        int a = gen.nextInt(4);
        //int a = ((int)(Math.random() * ((3) + 1)));
            
        switch(a){
            case 0:
                avenue += 1;
                break;
            case 1:
                street -= 1;
                break;
            case 2:
                street += 1;
                break;
            case 3:
                avenue -= 1;
                break;
            }
    }

    public int howFar(){
        int distance = Math.abs(sStreet - street) + Math.abs(sAvenue - avenue);
        return distance;
    }

    public String getLocation() {
        String location = avenue + " Avenue, " + street + " Street";
        return location;
    }

}