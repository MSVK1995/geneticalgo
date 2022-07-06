package src.operators.selectors;

import src.population.Pairs;
import src.population.Population;

/**
 * @desc Selection interface is for selector that accepts a Pair and is used for parent selection. 
 */

public interface Selection {
  // accepts a pair and applies selection
  public Pairs selectParents(Population population);
}