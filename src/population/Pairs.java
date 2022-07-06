/**
 * @desc Pairs is list of two individuals which can be parent or offSpring
 */
package src.population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pairs {

  Individual ind1;
  Individual ind2;

  public Pairs(Individual p1, Individual p2) {
    ind1 = p1;
    ind2 = p2;
  }

  
  /** 
   * Return the list of individuals that make a pair
   * @return List<Individual>
   */
  public List<Individual> getPair() {
    List<Individual> pair = new ArrayList<>();
    Collections.addAll(pair, ind1, ind2);
    return pair;
  }
}
