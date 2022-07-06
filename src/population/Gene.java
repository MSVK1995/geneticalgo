/**
 * @desc Gene is a unit of genetics transferred from parent to offSpring. 
 * List of Genes -> Chromosome
 * List of Chromosome -> Individual
 * List of Individuals -> Population
 */
package src.population;

public class Gene {
  //Enum to store gene code. 
  public enum Value{
    ONE(1),
    ZERO(0);

    private int code;
    private Value(int code){
      this.code = code;
    }
    public int returnCode(){
      return this.code;
    }
  }
  Value geneValue;

  //Empty Constructor that assign random value to a Gene
  Gene() {
    geneValue = Math.random() > 0.5 ? Value.ZERO : Value.ONE;
  }

  Gene(Value i) {
    geneValue = i;
  }

  
  /** 
   * @return Value
   */
  public Value getValue() {
    return this.geneValue;
  }
  
  /** 
   * @return int
   */
  public int getEnumValue() {
    return this.geneValue.returnCode();
  }

  
  /** 
   * @param newCode
   */
  public void setValue(Value newCode) {
    this.geneValue = newCode;
  }
}
