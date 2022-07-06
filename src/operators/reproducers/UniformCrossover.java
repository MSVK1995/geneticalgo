package src.operators.reproducers;

import src.population.Individual;
import src.population.Pairs;

/**
 * @desc This class implements uniform crossover where each of the two offsprings are assigned half the genes
 * from both the parents. The resulting offsprings are then evaluated to get the fitness from the resulting
 * gene alignment(Chromosome)
 */

public class UniformCrossover implements Crossover {

  /**
   * @param parents instance of type Pair that contains an array of two individuals from the selector
   * @return Pairs containing offsprings resulting from crossover
   */
  public Pairs applyCrossover(Pairs parents) {
    // Initialize offsprings
    Individual offspring1 = new Individual();
    Individual offspring2 = new Individual();

    // Destructor (or) extract individual parents from Pairs class
    Individual parent1 = parents.getPair().get(0);
    Individual parent2 = parents.getPair().get(1);

    // Loop over genome
    for (
      int geneIndex = 0;
      geneIndex < parent1.getChromosomeLength();
      geneIndex++
    ) {
      // Use half of parent1's genes and half of parent2's genes
      if (0.5 > Math.random()) {
        // setGene used to copy genes from parent to the offspring at the specified position/index in Chromosome
        offspring1.setGene(geneIndex, parent1.getGene(geneIndex));
        offspring2.setGene(geneIndex, parent2.getGene(geneIndex));
      } else {
        // setGene used to copy genes from parent to the offspring at the specified position/index in Chromosome
        offspring1.setGene(geneIndex, parent2.getGene(geneIndex));
        offspring2.setGene(geneIndex, parent1.getGene(geneIndex));
      }
    }
    Pairs offsprings = new Pairs(offspring1, offspring2);
    return offsprings;
  }
}
