


/**
 * @desc STRATEGY PATTERN IS FOUND...
in GACoreProcess.java and in GAProcess.java

 * GACoreProcess is class where all the basic processes are implemented the strategies are selected by the Component Factory
 */
package src.processes;

import src.factories.GAComponentFactory;
import src.population.Population;

public class GACoreProcess extends GAProcess {

  public GACoreProcess(GAComponentFactory coreComponentFactory) {
    this.componentFactory = coreComponentFactory;
  }

  
  /** 
   * Runs all operation and return a new generation of population 
   * Population -> Selector (Selects two parents) -> Crossover two parents to make two offSprings
   * -> OffSprings are then mutated -> Replacement occurs in the population accordingly.
   * @param population
   */
  @Override
  public void runProcess(Population population) {
    // The selected component factory (e.g. GA1factory) returns strategies for each of the operators (selector, reproducer, mutator and replacer).
    // These strategies are stored in the reference that can be altered. 
    processSelector = componentFactory.createSelector();
    processCrossover = componentFactory.createReproducer();
    processMutation = componentFactory.createMutator();
    processReplace = componentFactory.createReplacer();

    while (true) {
      parents = processSelector.selectParents(population);
      offsprings = processCrossover.applyCrossover(parents);
      offsprings = processMutation.mutatePopulation(offsprings);
      population = processReplace.replace(population, offsprings);
      generation++;
      System.out.println("Generation: " + generation);
      System.out.println("Individual: " + population.getFittest());      

      if (population.getFittest().getFitness() >= targetFitness) {
        System.out.println("Target reached. Fitness value: " + population.getFittest().getFitness());
        break;
      }
    }
  }
}
