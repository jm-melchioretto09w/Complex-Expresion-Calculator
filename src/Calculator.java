import java.util.ArrayList;

public class Calculator {

    public static ArrayList<String> getInstructions(String expression){
        ArrayList<String> instructionList = new ArrayList<>();
        String instruction = "" + expression.charAt(0);
        int lastCharacterType = Character.getType(expression.charAt(0));

        for(int character = 1; character < expression.length(); character++){
            char thisCharacter = expression.charAt(character);
            int thisCharacterType = Character.getType(thisCharacter);

            if(thisCharacterType == 1 || thisCharacterType == 2){
                thisCharacterType = 9;
            }

            System.out.println("Character " + character + ": " + thisCharacter);

            if (thisCharacter == ' '){
                continue;
            }

            if(thisCharacterType == lastCharacterType){
                instruction += thisCharacter;
                System.out.println("Inscrution incremented: " + instruction);
            }else{
                System.out.println("Instruction added: " + instruction);
                instructionList.add(instruction);
                instruction = "" + thisCharacter;
            }

            lastCharacterType = thisCharacterType;
        }

        instructionList.add(instruction);

        return instructionList;
    }

    public static ComplexNumber calculate(ArrayList<String> instructionList){
        ComplexNumber result = new ComplexNumber(0, 0);
        for(int i = 0; i < instructionList.size(); i++){
            String instruction = instructionList.get(i);
            result.added(1);
        }
        return result;
    }
}
