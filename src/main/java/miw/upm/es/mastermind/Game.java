package miw.upm.es.mastermind;

import java.util.Scanner;

public class Game {
    int roundNum;
    int sinks;
    int hits;
    IO io = new IO();
    public final int NUMROUNDS = 10;
    public final int NUMCOLOURS = 4;
    
    public Game() {
    }
    
    public Game(int attempt, int sinks, int hits, Scanner scanner) {
        this.roundNum = 0;
        this.sinks = 0;
        this.hits = 0;
    }  
    
    public void play(Round round, Secret secret) {
        Round guessPegs = new Round();
        String guess;
        roundNum++;
        
        guess = io.nextGuess();

        while (guess.length() != NUMCOLOURS) {
            guess = io.nextGuess();
        }
        
        guessPegs = keepGuess(secret, guess); 
        
        sinks = round.countSinks(guessPegs);
        hits  = round.countHits(guessPegs);

        guessPegs = keepGuess(secret, guess);
        round = io.roundState(roundNum, guessPegs, round, sinks, hits);
        
    }
    
    public Round keepGuess(Secret secret, String guess) {
        return secret.stringToCode(guess); 
    }
    
    public int getNumAttempts() {
        return roundNum;
    }
    
    public int getNumSinks() {
        return sinks;
    }
    
    public boolean isEnded(int numAttempts, int numSinks) {
        if(numAttempts < NUMROUNDS && numSinks < NUMCOLOURS) {
            return false;
        }else {
            io.closeScanner();
            return true;
        }
    }
    
    public boolean end(int sinks, Round secretPegs) {
        System.out.println();
        if (sinks == NUMCOLOURS) {
            return io.winnerMessage();
        }else {
            return io.looserMessage(secretPegs);
        }        
    }
}
