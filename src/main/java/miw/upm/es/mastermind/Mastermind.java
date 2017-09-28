package miw.upm.es.mastermind;

class MasterMind {

    public static void main (String [] args) {
        Secret secret = new Secret();
        Round playerGuess = new Round();
        Game game = new Game();
        IO io = new IO();

        io.showInstructions();
        
        playerGuess = secret.generateSecretCode();
        System.out.println("Código secreto: " + playerGuess);
        do {
            game.play(playerGuess, secret);
        } while (!game.isEnded(game.getNumAttempts(), game.getNumSinks()));

        game.end(game.getNumSinks(), playerGuess);
        
    }

}