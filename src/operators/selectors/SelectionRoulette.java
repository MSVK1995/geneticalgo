package src.operators.selectors;

import java.util.List;

import src.population.Individual;
import src.population.Pairs;
import src.population.Population;


/**
 * @desc This class implements parent selection via the roulette wheel. 
 * The logic is written in reverse of how a roulette wheel works in real life as it's more practical.
 * We calculate a random position where a ball would drop first and then work out what individual it is.
 * The random position is randomly selected from a value between 0 to the total population fitness. 
 * The higher the fitness of an Individual, the higher the chance they will be selected. 
 * Individuals with a higher fitness value are essentially allocated more space on a metaphorical roulette wheel. 
 * A Pair of parents are returned. 
 */

public class SelectionRoulette implements Selection {

  
  /** 
   * @param population
   * @return Pairs
   */
  public Pairs selectParents(Population population) {
    
    // Two individuals
    Individual p1, p2;

    // Spin the roulette wheel twice and assign
    p1 = rouletteWheel(population);
    p2 = rouletteWheel(population);

    // Used so same parent isn't returned twice
    while (p1 == p2) {
      p2 = rouletteWheel(population);
    }

    return new Pairs(p1, p2);
  }

  
  /** 
   * @param population
   * @return Individual
   */
  private Individual rouletteWheel(Population population) {
    List<Individual> individuals = population.getIndividuals();
    double populationFitness = population.getPopulationFitness();
    // We select the random position first
    double rouletteWheelPosition = Math.random() * populationFitness;
    //System.out.println(rouletteWheelPosition);

    // Then we find the parent
    double spinWheel = 0;
    for (Individual individual : individuals) {
      spinWheel += individual.getFitness();

      if (spinWheel >= rouletteWheelPosition) {
        return individual;
      }
    }

    return individuals.get(individuals.size() - 1);
  }
}
