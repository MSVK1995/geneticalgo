package src.factories;

import src.operators.mutators.Mutation;
import src.operators.replacers.Replace;
import src.operators.reproducers.Crossover;
import src.operators.selectors.Selection;

/**
 * @desc ABSTRACT FACTORY PATTERN is implemented here and in its factories (GA1factory, GA2factory, or GA3factory)
 * 
 * It defines a family of operators which are used to create a new generation in a genetic algorithm cycle. 
 * Every generation of the population undergoes selection, crossover, mutation (if necessary) and replacement. 
 * The implementing factory (either GA1factory, GA2factory, or GA3factory) combines and creates a set of appropriate concrete instances that will be used in executing genetic algorithm process
 */


public interface GAComponentFactory {
    //createSelector() returns an instance of a particular selector
    public Selection createSelector();
    //createReproducer() returns an instance of a particular crossover
    public Crossover createReproducer();
    //createMutator() returns an instance of a particular mutator
    public Mutation createMutator();
    //createReplacer() returns an instance of a particular replacer
    public Replace createReplacer();
}
