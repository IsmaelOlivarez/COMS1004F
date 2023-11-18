package MidtermPractice1.ScratchPaper;

public class Cup {
    private double contents;

    public double getContent(){
        return contents;
    }

    public void add(double amount){
        contents += amount;
    }

    public void removed(double amount){
        contents -= amount;
        if(contents<0){
            contents = 0;
        }
    }

    public double measure() {
        return getContent();
    }



}
