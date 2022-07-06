/**
 * @desc Replace interface is for replacer that replaces individuals in current population with new offSpring. 
 */
package src.operators.replacers;

import src.population.Pairs;
import src.population.Population;

public interface Replace {
  public Population replace(Population currGen, Pairs offsprings);
}
