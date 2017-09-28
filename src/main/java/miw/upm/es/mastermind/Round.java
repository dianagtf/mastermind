package miw.upm.es.mastermind;

class Round {
    
    private Peg peg1, peg2, peg3, peg4;

    public Round() {
       this(new Peg('R'), new Peg('R'), new Peg('R'), new Peg('R'));
    }

    public Round(Round pegs) {
       this(new Peg(pegs.peg1), 
            new Peg(pegs.peg2),
            new Peg(pegs.peg3),
            new Peg(pegs.peg4));
    }

    public Round(Peg p1, Peg p2, Peg p3, Peg p4) {
       peg1 = p1;
       peg2 = p2;
       peg3 = p3;
       peg4 = p4;
    }
  
    public void setColour(int whichPeg, char c) {
       switch (whichPeg) {
          case 1: 
              peg1.setColour(c); 
              break;
          case 2: 
              peg2.setColour(c); 
              break;
          case 3: 
              peg3.setColour(c); 
              break;
          case 4: 
              peg4.setColour(c); 
              break;
          default: 
              System.err.println("No existe este pin!!");
              System.exit(1);
       }
    }

    public char getColour(int whichPeg) {
       char c = ' ';
       switch (whichPeg) {
          case 1: 
              c = peg1.getColour(); 
              break;
          case 2: 
              c = peg2.getColour(); 
              break;
          case 3: 
              c = peg3.getColour(); 
              break;
          case 4: 
              c = peg4.getColour(); 
              break;
          default: 
              System.err.println("No existe este pin!!");
              System.exit(2);
       }
       return c;
    }

    public String toString() {
       return peg1.toString() + " " +
              peg2.toString() + " " +
              peg3.toString() + " " +
              peg4.toString();
    }

    public int countSinks(Round guessPegs) {
       int sinks = 0;

       for (int i=1; i<=4; i++) 
          if (getColour(i) == guessPegs.getColour(i)) {
             sinks++;
             guessPegs.setColour(i, 'Z');
          }

       return sinks;
    }

    public int countHits(Round guessPegs) {
       int hits = 0;
       char guessPeg;

       for (int i=1; i<=4; i++) {

          guessPeg = guessPegs.getColour(i);
          for (int j=1; j<=4; j++) {
             if (i==j) continue;

             if (guessPeg == this.getColour(j)) {
                hits++;
                guessPegs.setColour(i, 'Z');
                break;
             }
          }
       }

       return hits;
    }

 }
