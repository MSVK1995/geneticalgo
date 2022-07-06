package src.factories;

import src.operators.mutators.Mutation;
import src.operators.replacers.Replace;
import src.operators.replacers.ReplaceWeakest;
import src.operators.reproducers.Crossover;
import src.operators.reproducers.UniformCrossover;
import src.operators.selectors.Selection;
import src.operators.selectors.SelectionRoulette;

/**
 * @desc Implementation of component factory that returns Roulettewheel selector, uniform crossover, mutator
 * and replace-the-weakest objects
 */

public class GA3factory implements GAComponentFactory {

  //overridden method that returns roulettewheel selector instance
  @Override
  public Selection createSelector() {
    return new SelectionRoulette();
  }

  //overridden method that returns uniform selector instance
  @Override
  public Crossover createReproducer() {
    return new UniformCrossover();
  }

  //overridden method that returns mutator instance
  @Override
  public Mutation createMutator() {
    return new Mutation();
  }

  //overridden method that returns replacer instance
  @Override
  public Replace createReplacer() {
    return new ReplaceWeakest();
  }
}
