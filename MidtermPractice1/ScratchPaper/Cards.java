package MidtermPractice1.ScratchPaper;
import java.util.ArrayList;
import java.util.Character;

public class Cards {
    private static String spade = "\u2660";
    private static String heart = "\u2665";
    private static String diamond = "\u2666";
    private static String club = "\u2663";

    public static void main(String[] args) {
        //Spade 2660
        //Heart 2665
        //Diamond 2666
        //Club 2663
        ArrayList<String> hand = new ArrayList<>();
        hand.add(cardVisual(6,'s'));
        //hand.add(cardVisual(10, 'd'));


        System.out.print(hand);
        /*System.out.println(" ___\n|\u2660  |\n| A |\n|  \u2660|\n ---");
        System.out.println(" ___\n|   |\n| 2 |\n|   |\n ---");
        System.out.println(" ___\n|   |\n| 3 |\n|   |\n ---");*/
    }

    public static String cardVisual(int r, char s){
        String visual = " ___\n|";
        switch (s) {
            case 's':
                visual = visual + spade + "  |\n|";
                break;
            case 'd':
                visual = visual + diamond + "  |\n|";
                break;
            case 'h':
                visual = visual + heart + "  |\n|";
                break;
            case 'c':
                visual = visual + club + "  |\n|";
                break;
            default:
                break;
        }

        if(r == 1){
            visual = visual + " A |\n|  ";
        }else if(r>1&&r<11&&r!=10){
            visual = visual + " " + r + " |\n|  ";
        }else if(r==10){
            visual = visual + " " + r + "|\n|  ";
        }else if(r==11){
            visual = visual + " " + "J" + " |\n|  ";
        }else if(r==12){
            visual = visual + " " + "Q" + " |\n|  ";
        }else if(r==13){
            visual = visual + " " + "K" + " |\n|  ";
        }
        switch (s) {
            case 's':
                visual = visual + spade + "|\n ---";
                break;
            case 'd':
                visual = visual + diamond + "|\n ---";
                break;
            case 'h':
                visual = visual + heart + "|\n ---";
                break;
            case 'c':
                visual = visual + club + "|\n ---";
                break;
            default:
                break;
        }
        return visual;
    }
}
