/**
 * @desc IndividualComparator implementing Comparator<Individual> and returning the comparison values.
 */
package src.utilities;

import java.util.Comparator;

import src.population.Individual;

public class IndividualComparator implements Comparator<Individual> {

  
  /** 
   * @param individualA
   * @param individualB
   * @return int
   */
  public int compare(Individual individualA, Individual individualB) {
    return individualA.compareTo(individualB);
  }
}