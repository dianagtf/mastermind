package miw.upm.es.mastermind;
class Peg {
  
   private char colour;

   public Peg() {
      this('R');
   }

   public Peg(Peg p) {
      this(p.getColour());
   }

   public Peg(char c) {
      setColour(c);
   }
   
   public void setColour (char c) {
       colour = c;
   }

   public char getColour () {
       return colour;
   }

   public String toString () {
       return "" + getColour(); 
   }

}