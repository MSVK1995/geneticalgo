/**
 * @desc ReplaceConditional is an implementation of Replace interface.
 * It compares the fittest offSpring with the weakest and keep the fitter individual in the population.
 */
package src.operators.replacers;

import src.population.Individual;
import src.population.Pairs;
import src.population.Population;

public class ReplaceConditional implements Replace {

  /**
   * @param currGen The current generation of population
   * @param offsprings Pair of individuals produced after crossing over and mutation.
   * @desc Replace function compares the fittest offSpring with the weakest and keep the fitter individual in the population.
   * @return Population New updated generation of population returned after replacing with offSprings
   */
  public Population replace(Population currGen, Pairs offsprings) {
    Individual offspring1 = offsprings.getPair().get(0);
    Individual offspring2 = offsprings.getPair().get(1);
    Individual strongerOffspring = offspring1.compareTo(offspring2) > 0 ? offspring1 : offspring2;
    Individual weakestIndividual = currGen.getWeakest();
    if (strongerOffspring.getFitness() > weakestIndividual.getFitness()) {
      currGen.replaceIndividual(weakestIndividual, strongerOffspring);
    }

    return currGen;
  }
}
