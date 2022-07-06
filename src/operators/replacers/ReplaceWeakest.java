/**
 * @desc ReplaceWeakest is an implementation of Replace interface.
 * It replaces the weakest individual in population with fitter offSpring
 */
package src.operators.replacers;

import src.population.Individual;
import src.population.Pairs;
import src.population.Population;

public class ReplaceWeakest implements Replace {

  /**
   * @param currGen The current generation of population
   * @param offsprings Pair of individuals produced after crossing over and mutation.
   * @desc Replace function replaces the weakest individual in population with fitter offSpring
   * @return Population New updated generation of population returned after replacing with offSprings
   */
  public Population replace(Population currGen, Pairs offsprings) {
    Individual offspring1 = offsprings.getPair().get(0);
    Individual offspring2 = offsprings.getPair().get(1);
    Individual strongerOffspring = offspring1.compareTo(offspring2) > 0 ? offspring1 : offspring2;
    Individual weakestIndividual = currGen.getWeakest();
    currGen.replaceIndividual(weakestIndividual, strongerOffspring);

    return currGen;
  }
}
