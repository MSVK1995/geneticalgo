package src.operators.reproducers;

import java.util.Random;

import src.population.Individual;
import src.population.Pairs;

/**
 * @desc This class implements single point crossover where a single point is chosen from the parent's chromosome
 * and genes from one parent are copied to the offspring until the cross point. The rest are filled by the
 * other parent's genes until the end of the chromosome.
 */

public class SinglePointCrossover implements Crossover {

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

    // Creating a random point from a parent's chromosome and then distribute the genes to the offsprings until the point
    Random rnd = new Random();
    int crossPoint = rnd.nextInt(parent1.getChromosomeLength()) + 1;
    // Loop over genome
    for (
      int geneIndex = 0;
      geneIndex < parent1.getChromosomeLength();
      geneIndex++
    ) {
      // Use genes of parent1 until crossPoint and rest of parent2's genes
      if (geneIndex < crossPoint) {
        offspring1.setGene(geneIndex, parent1.getGene(geneIndex));
        offspring2.setGene(geneIndex, parent2.getGene(geneIndex));
      } else {
        offspring1.setGene(geneIndex, parent2.getGene(geneIndex));
        offspring2.setGene(geneIndex, parent1.getGene(geneIndex));
      }
    }
    Pairs offsprings = new Pairs(offspring1, offspring2);
    return offsprings;
  }
}
