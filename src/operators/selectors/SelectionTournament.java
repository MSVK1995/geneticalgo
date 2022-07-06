package src.operators.selectors;

import java.util.Arrays;
import java.util.List;

import src.population.Individual;
import src.population.Pairs;
import src.population.Population;
import src.utilities.IndividualComparator;

/**
 * @desc This class implements parent selection via tournaments. 
 * Individuals are randomly selected from the population for each tournament. 
 * The tournament size in this implementation is one third of the population. 
 * The fittest individual of each tournament is returned from the tournament method.  
 * A Pair of parents are returned.  
 * A high tournament size can cause a loss of genetic diversity 
 * However, a low size will allow for more low fitness parents and slow the progress of the algorithm. 
 */

public class SelectionTournament implements Selection {

  protected int tournamentSize = 0;

  
  /** 
   * @param population
   * @return Pairs
   */
  // 
  public Pairs selectParents(Population population) {
    tournamentSize = population.getPopulationSize() / 3;

    Individual p1;
    Individual p2;

    p1 = tournament(population);
    p2 = tournament(population);

    while (p1 == p2) {
      p2 = tournament(population);
    }

    return new Pairs(p1, p2);
  }

  
  /** 
   * @param population
   * @return Individual
   */
  private Individual tournament(Population population) {
    // Create tournament
    Individual[] tournament = new Individual[this.tournamentSize];
    // Add random individuals to the tournament
    List<Individual> tempPopulation = population.shuffle();
    for (int i = 0; i < this.tournamentSize; i++) {
      Individual tournamentIndividual = tempPopulation.get(i);
      tournament[i] = tournamentIndividual;
    }
    Arrays.sort(tournament, new IndividualComparator());
    // Return the best
    return tournament[tournament.length - 1];
  }
}
