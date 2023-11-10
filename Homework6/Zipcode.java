public class Zipcode {
    private int code;
    private int checkDigits;
    private String bar = "";
    private String tempCode = "";
    private boolean valid = true;

    //Class Constructors
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
            code %= (int)Math.pow(10, i);     
        }
        addCheckDigit(checkDigits);
        bar = bar + "|";

        return bar;
    }

    public int getZIPcode(){
        //Checking for proper start--expecting '|'
        if(!bar.substring(0,1).equals("|") || 
        !bar.substring(bar.length()-1,bar.length()).equals("|")){
            System.out.println("Improper start/End to Zipcode Bar!--Reformat" + 
            " your Barcode!");
            return -1;
        }

        bar = bar.substring(1, bar.length()-1);

        while(tempCode.length() != 5 && valid){
            addDigits(bar.substring(0, 5));
            bar = cutString(bar);
        }
        if(!valid){
            return -1;
        }else{
            return Integer.parseInt(tempCode);
        }
    }

    public void addDigits(String barSection){
        switch(barSection){
            case "||:::":
                tempCode = tempCode + "0";
                break;
            case ":::||":
                tempCode = tempCode + "1";
                break;
            case "::|:|":
                tempCode = tempCode + "2";
                break;
            case "::||:":
                tempCode = tempCode + "3";
                break;
            case ":|::|":
                tempCode = tempCode + "4";
                break;
            case ":|:|:":
                tempCode = tempCode + "5";
                break;
            case ":||::":
                tempCode = tempCode + "6";
                break;
            case "|:::|":
                tempCode = tempCode + "7";
                break;
            case "|::|:":
                tempCode = tempCode + "8";
                break;
            case "|:|::":
                tempCode = tempCode + "9";
                break;
            default:
                System.out.println("Error--invalid code entered!");
                valid = false;
                break;
        }
    }

    public String cutString (String newBar){
        return bar.substring(5,bar.length());
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
