public class Zipcode {
    private int code;
    private int checkDigits;
    private String bar = "";

    public Zipcode(int code){
        this.code = code;
    }

    public Zipcode(String bar){
        this.bar = bar;
    }

    public String getBarcode(){
        bar = bar + "|";
        for(int i = 4; i >= 0; i--){
            addBars(code / (int)Math.pow(10,i));
            checkDigits += code / (int)Math.pow(10,i);
            System.out.println(code / (int)Math.pow(10,i));
            System.out.println(checkDigits);
            code %= (int)Math.pow(10, i);
            
        }
        addCheckDigit(checkDigits);
        bar = bar + "|";

        return bar;
    }

    public int getZIPcode(){
        return -1;
    }

    public void addBars(int digit){
        switch(digit){
            case 0:
                bar = bar + "||:::";
                break;
            case 1:
                bar = bar + ":::||";
                break;
            case 2:
                bar = bar + "::|:|";
                break;
            case 3:
                bar = bar + "::||:";
                break;
            case 4:
                bar = bar + ":|::|";
                break;
            case 5:
                bar = bar + ":|:|:";
                break;
            case 6:
                bar = bar + ":||::";
                break;
            case 7:
                bar = bar + "|:::|";
                break;
            case 8:
                bar = bar + "|::|:";
                break;
            case 9:
                bar = bar + "|:|::";
                break;
        }
    }

    public void addCheckDigit(int checkDigits){
        if(checkDigits % 10 == 0){
            addBars(0);
        }else{
            addBars(10-(checkDigits%10));
        }
    }
}
