package miw.upm.es.mastermind;

import java.util.Random;

public class Secret {
    
    private static char intToColour(int i) {
        char c = ' ';

        switch (i) {
            case 0: 
                c = 'R'; 
                break;
            case 1: 
                c = 'G'; 
                break;
            case 2: 
                c = 'B'; 
                break;
            case 3: 
                c = 'Y'; 
                break;
            case 4: 
                c = 'P';
                break;
            case 5: 
                c = 'O'; 
                break;
            default: 
                System.err.println("Error: no such colour!");
                System.exit(1);
        }
        return c;
    }
    
    public Round generateSecretCode() {
        Round code = new Round();
        Random random = new Random();
 
        code.setColour(1, intToColour(random.nextInt(6)));
        code.setColour(2, intToColour(random.nextInt(6)));
        code.setColour(3, intToColour(random.nextInt(6)));
        code.setColour(4, intToColour(random.nextInt(6)));
       
        return code;
    }
    
    public Round stringToCode(String str) {
        Round code = new Round();
       
        code.setColour(1, str.charAt(0));
        code.setColour(2, str.charAt(1));
        code.setColour(3, str.charAt(2));
        code.setColour(4, str.charAt(3));

        return code;
    }
}
