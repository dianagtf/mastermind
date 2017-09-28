package miw.upm.es.mastermind;

import java.text.DecimalFormat;
import java.util.Scanner;

public class IO {
    Scanner scanner = new Scanner(System.in);

    public void showInstructions() {
        System.out.println("Juega a Mastermind");
        System.out.println("Introduce 4 letras en formato XXXX, eligiendo entre los colores:");
        System.out.println("R (Red), B (Blue), G (Green), Y (Yellow), O (Orange) o P (Pink).");   
    }
    public String nextGuess(){
        System.out.print("Juega! Elige cuatro colores: ");
        return scanner.nextLine();
    }
    
    public void closeScanner() {
        scanner.close();
    }
    
    public Round roundState(int round, Round guessPegs, Round game, int sinks, int hits) {
        Round secretPegs = new Round(game);
        DecimalFormat df = new DecimalFormat("00");
        System.out.print("\t\t\t  Ronda #" + df.format(round)+ ": " + guessPegs);

        System.out.println("\t  Muertos = " + sinks + "; Heridos = " + hits);
        
        return new Round(secretPegs);
    }
    
    public boolean winnerMessage() {
        System.out.println("Enhorabuena!!! Has ganado!");
        return true;
    }
    
    public boolean looserMessage(Round secretPegs) {
        System.out.println("Lo siento, has perdido! El código era: "+ secretPegs + ".");
        return false;
    }
}
