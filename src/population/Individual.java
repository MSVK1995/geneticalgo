/**
 * @desc Individual is made of list of Chromosomes. A group of individuals make up a Population
 */
package src.population;

import java.util.*;

public class Individual implements Comparable<Individual> {

  Chromosome chromosome;
  final int chromosomeLength = 10;
  int fitness = 0;

  public Individual() {
    this.chromosome = new Chromosome(chromosomeLength);
  }

  /**
   * @return int the fitness of an individual
   */
  public int getFitness() {
    return fitness;
  }

  /**
   * @return int returns the number of chromosomes that make up an individual.
   */
  public int getChromosomeLength() {
    return chromosomeLength;
  }

  /**
   * @param geneIndex
   * @return Gene at the value geneIndex.
   */
  public Gene getGene(int geneIndex) {
    List<Gene> geneList = this.chromosome.getGenes();
    return geneList.get(geneIndex);
  }

  /**
   * @param geneIndex
   * @param incomingGene
   * @desc set incomingGene to geneIndex in chromosome of this individual.
   */
  public void setGene(int geneIndex, Gene incomingGene) {
    this.chromosome.addGene(geneIndex, incomingGene);
  }

  /**
   * @return List<Gene>
   */
  public List<Gene> getChromosome() {
    return this.chromosome.getGenes();
  }

  /**
   * This function calculates fitness of an individual based on his gene values.
   * It multiplies each geneValue with its index which makes fitness unique for every individual and then make it into percentage.
   * @return int
   */
  public int calculateFitness() {
    List<Gene> geneList = this.getChromosome();

    int maxFitnessSum = 0;

    for (int i = 1; i <= geneList.size(); i++) {
      this.fitness +=(geneList.get(i - 1).getEnumValue() * i);
      maxFitnessSum += i;
    }
    this.fitness =
      (int) Math.round((this.fitness / (double) maxFitnessSum) * 100);
    return this.fitness;
  }

  /**
   * Compare function for individuals. It compares individuals based on their fitness and returns int value
   * @param i
   * @return int
   * 
   */
  public int compareTo(Individual individual) {
    if ((this.fitness == individual.fitness)) return 0; // 0 => same
    else if (this.fitness > individual.fitness) return 1; // 1 => greater-than
    else return -1; // -1 => less-than
  }

  /**
   * @return String
   */
  public String toString() {
    return chromosome.toString() + " Fitness " + this.fitness;
  }
}
