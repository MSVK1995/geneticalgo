/**
 * @desc Mutation is usually used to maintain a genetic diversity to a population.
 * In this process a random bit of chromosome is changed or flipped.
 * It helps the population to avoid local minima and preventing the population to be too similar.
 */
package src.operators.mutators;

import java.util.List;

import src.population.Gene;
import src.population.Individual;
import src.population.Pairs;
import src.population.Gene.Value;

public class Mutation {
  public Pairs mutatePopulation(Pairs offsprings) {
    // 10 out of 1k
    int mutationRate = 10; 
    for (Individual individual : offsprings.getPair()) {
      List<Gene> genes = individual.getChromosome();
      for (Gene gene : genes) {
        if ((Math.random() * 1000) > mutationRate) {
          if (gene.getEnumValue() == 1) {
            gene.setValue(Value.ZERO);
          } else {
            gene.setValue(Value.ONE);
          }
        }
      }
      individual.calculateFitness();
    }
    return offsprings;
  }
}
