package src.factories;

import src.operators.mutators.Mutation;
import src.operators.replacers.Replace;
import src.operators.replacers.ReplaceConditional;
import src.operators.reproducers.Crossover;
import src.operators.reproducers.UniformCrossover;
import src.operators.selectors.Selection;
import src.operators.selectors.SelectionTournament;

/**
 * @desc Implementation of component factory that returns Tournament selector, uniform crossover, mutator
 * and replace-the-weakest-conditionally objects
 */

public class GA2factory implements GAComponentFactory {

  //overridden method that returns tournament selector instance
  @Override
  public Selection createSelector() {
    return new SelectionTournament();
  }

  //overridden method that returns uniform crossover instance
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
    return new ReplaceConditional();
  }
}
