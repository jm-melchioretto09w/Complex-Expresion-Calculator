import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write the problem: ");
        String problem = scan.nextLine();
        System.out.println("Problem: " + problem);
        ArrayList<String> instructionList = Calculator.getInstructions(problem);

        System.out.println(Calculator.calculate(instructionList));
    }
}