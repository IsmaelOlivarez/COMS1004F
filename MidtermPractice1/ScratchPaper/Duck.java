package MidtermPractice1.ScratchPaper;

public class Duck implements Mesurable{

    private String name;
    private double weight;

    public Duck(String n, double w){
        name = n;
        weight = w;
    }

    public String getName() {
        return name;
    }

    public void setWeight(double w){
        weight = w;
    }
    
    public double getWeight() {
        return weight;
    }

    public void quack(){
        System.out.println("Quack");
    }

    public double measure(){
        return getWeight();
    }
}
