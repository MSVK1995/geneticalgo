/**
 * @desc Population is group of individuals.
 */

package src.population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import src.utilities.IndividualComparator;

public class Population {

  List<Individual> population = new ArrayList<>();
  private int populationFitness = 0;
  private static int popSize;
  private static Population cpop;

  private Population(int size) {
    for (int i = 0; i < size; i++) {
      Individual individual = new Individual();
      populationFitness += individual.calculateFitness();
      population.add(individual);
    }
  }

  /**
   * Population is Singleton. It can be initialized once to make first generation.
   * Then, replacements are made in same populations with passing generations.
   * @return Population
   */
  public static Population getPopulationInstance() {
    popSize = 10;
    if (cpop == null) cpop = new Population(popSize);

    return cpop;
  }

  /**
   * Generates a new Population instance with different size than default
   * @param size
   * @return Population
   */
  public static Population getPopulationInstance(int size) {
    if (cpop == null) cpop = new Population(size);
    return cpop;
  }

  /**
   * @return List<Individual>
   */
  public List<Individual> getIndividuals() {
    return population;
  }

  /**
   * @return double
   */
  public double getPopulationFitness() {
    return populationFitness;
  }

  /**
   * @return List<Individual> create a shuffles list of of current generation and return it to do tournament selection.
   */
  public List<Individual> shuffle() {
    List<Individual> tempList = new ArrayList<>(this.getIndividuals());
    Random rnd = new Random();
    for (int i = tempList.size() - 1; i > 0; i--) {
      int index = rnd.nextInt(i + 1);
      Individual a = tempList.get(index);
      tempList.set(index, tempList.get(i));
      tempList.set(i, a);
    }
    return tempList;
  }

  /**
   * Return the individual at index offset
   * @param offset
   * @return Individual
   */
  public Individual getIndividual(int offset) {
    return population.get(offset);
  }

  /**
   * @param weakest
   * @param stronger
   */
  public void replaceIndividual(Individual weakest, Individual stronger) {
    this.populationFitness =
      this.populationFitness - weakest.getFitness() + stronger.getFitness();
    int offset = this.getIndividuals().indexOf(weakest);
    this.population.set(offset, stronger);
  }

  /**
   * @return Individual
   */
  public Individual getFittest() {
    return this.getSortedPopulation().get(population.size() - 1);
  }

  /**
   * @return Individual
   */
  public Individual getWeakest() {
    return this.getSortedPopulation().get(0);
  }

  /**
   * @return List<Individual>
   */
  private List<Individual> getSortedPopulation() {
    List<Individual> tempList = new ArrayList<>(population);
    Collections.sort(tempList, new IndividualComparator());
    return tempList;
  }

  /**
   * @return int
   */
  public int getPopulationSize() {
    return this.population.size();
  }

  /**
   * @return String
   */
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Individual i : population) {
      stringBuilder.append(i + "\n");
    }

    return stringBuilder.toString();
  }
}
