package src.operators.reproducers;

import src.population.Pairs;

/**
 * @desc Crossover interface is for reproducer that accepts a Pair of parents and generates a Pair of offsprings
 */

public interface Crossover {
  //accepts a pair and applies crossover algorithm
  public Pairs applyCrossover(Pairs parents);
}
