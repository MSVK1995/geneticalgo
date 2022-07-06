/**
 * @desc 
 * This can be considered as the Context for the STRATEGY PATTERN
 * The references to each of the operators that use a particular strategy from a factory are stored here in GAProcess.  
 * GAProcess is abstract class that helps us define all the operators.
 */
package src.processes;

import src.factories.GAComponentFactory;
import src.operators.mutators.Mutation;
import src.operators.replacers.Replace;
import src.operators.reproducers.Crossover;
import src.operators.selectors.Selection;
import src.population.Pairs;
import src.population.Population;

public abstract class GAProcess {

  GAComponentFactory componentFactory;

  // operator references
  Selection processSelector;
  Crossover processCrossover;
  Mutation processMutation;
  Replace processReplace;

  Pairs parents;
  Pairs offsprings;
  int generation = 1;
  int targetFitness = 100;

  // abstract method
  public abstract void runProcess(Population population);
}
