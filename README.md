# GA

PROJECT MEMBERS: 
- Vikas Kumar
- Kevin Boylan
- Ripandeep Singh Khangura

HOW TO RUN PROJECT:
- Click on "Run" in Main.java or click on the Play button ("Run Java"). 
- These instructions are based on our use of VS Code. 


OUTPUT EXPLANATION: 
- Each individual has 10 genes and they have a value of either 0 or 1. 
EXAMPLE TARGET? 
- our target fitness is always all 1's. 
EXAMPLE INDIVIDUAL? 
- an example of the presentation of an individual would be "1011111111".  
HOW TO CALCULATE?
- We calculate the fitness positionally (from left to right). 
- We multiply each geneValue with its weight which makes fitness unique for every individual and then convert it into percentage.

- if a gene value at an index is "1", it has a weight but if it's "0" then it has no weight. 
- A weight applied at the first index would be 1, a weight at the second index would be 2, a weight at the third index would be 3, and so on.
- Max weight/score attainable is 55 ((10*11)/2 = 55). 
- We take the total weights and divide it by 55 to get the percentage (the actual fitness value).  

CALCULATION ON THE EXAMPLE INDIVIDUAL("1011111111"):
- (1 * 1) + (0 * 2) + (1 * 3) + (1 * 4) + (1 * 5) + (1 * 6) + (1 * 7) + (1 * 8) + (1 * 9) + (1 * 10) = 1 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 53
- 53/55 * 100 = 96.363636363 => 96 (rounded)
- Therefore, he has a fitness of 96.    

```
public int calculateFitness() {
    List<Gene> geneList = this.getChromosome();

    int maxFitnessSum = 0;

    for (int i = 1; i <= geneList.size(); i++) {
      this.fitness += (geneList.get(i - 1).getValue() * i);
      maxFitnessSum += i;
    }
    this.fitness =
      (int) Math.round((this.fitness / (double) maxFitnessSum) * 100);
    return this.fitness;
  }
``` 





SINGLETON PATTERN IS FOUND...
in Population.java

Population.java
- Population is our Singleton. 
- Both Population and the Population size are static. 
```
 private static Population cpop;
 private static int popSize;
````
- It can be instantiated just once to make the first generation. 
- Then, the replacements are made in the same population by passing generations.
- Either a default value of 10 can be used for population size or we can pass a size. 
```
 public static Population getPopulationInstance() {
    popSize = 10;
    if (cpop == null) cpop = new Population(popSize);

    return cpop;
  }

public static Population getPopulationInstance(int size) {
    if (cpop == null) cpop = new Population(size);
    return cpop;
  }
```
- This is a Lazy Singleton Initiliazation. 





ABSTRACT FACTORY PATTERN IS FOUND...
in GAComponentFactory.java, GA1factory.java, GA2factory.java, GA3factory.java


GAComponentFactory.java
- This interface adapts the Abstract Factory pattern. 
- It defines a family of operators which are used to create a new generation in a genetic algorithm cycle. 
- Every generation of the population undergoes selection, crossover, mutation (if necessary) and replacement. 
- The implementing factory (either GA1factory, GA2factory, or GA3factory) combines and creates a set of appropriate concrete instances that will be used in executing genetic algorithm process
```
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
```

GA1factory.java, GA2factory.java, GA3factory.java
- The selected component factory returns a selected selector, reproducer, mutator and replacer.
- e.g. GA1factory
```
  //returns roulettewheel selector instance
  @Override
  public Selection createSelector() {
    return new SelectionRoulette();
  }

  //returns single-point crossover instance
  @Override
  public Crossover createReproducer() {
    return new SinglePointCrossover();
  }

  //returns mutation instance
  @Override
  public Mutation createMutator() {
    return new Mutation();
  }

  //returns replacer instance
  @Override
  public Replace createReplacer() {
    return new ReplaceWeakest();
  }
}
```






STRATEGY PATTERN IS FOUND...
in GAProcess.java, GACoreProcess.java

GAProcess.java
- This can be considered as the Context. 
- The references to each of the operators that use a particular strategy from a factory are stored here in GAProcess.  
```
  Selection processSelector;
  Crossover processCrossover;
  Mutation processMutation;
  Replace processReplace;
```

GACoreProcess.java - runProcess(Population population) 
- The selected component factory (e.g. GA1factory) returns strategies for each of the operators (selector, reproducer, mutator and replacer).
```
    processSelector = componentFactory.createSelector();
    processCrossover = componentFactory.createReproducer();
    processMutation = componentFactory.createMutator();
    processReplace = componentFactory.createReplacer();
``` 
- GA1factory returns these strategies: SelectionRoulette, SinglePointCrossover, Mutation and ReplaceWeakest. 
- These strategies are stored in the reference and can be altered. 









TEMPLATE METHOD PATTERN (BONUS) IS FOUND...
in GAController.java, ControllerV1.java, ControllerV2.java and ControllerV3.java

- Template method design pattern defines an algorithm as a skeleton of operations (GAController.java) and leaves the details to be implemented by the subclasses (ControllerV1.java, ControllerV2.java and ControllerV3.java). 

GAController.java
- This is an abstract class that acts as an interface with the client to initiate the genetic algorithm process. 
- It defines the start() behavior. The singleton population is initialized with default size or size passed as parameter. 
``` 
    public void start() {
        p = Population.getPopulationInstance();
        int size = p.getPopulationSize();
        System.out.println("Starting with default settings:");
        System.out.println("Population size: " + size);
        createWorld(p);
    }
```


ControllerV1.java, ControllerV2.java and ControllerV3.java
- These are the child classes. 
- They have their own implementation of the abstract createWorld function. 
- In these controllers, the component factories used are either GA1factory, GA2factory or GA3factory.
- The selected component factory is passed to GACoreProcess where all the basic processes are implemented. 
- example, createWorld function from ControllerV1.java. 
```
protected void createWorld(Population cpop) {
    GAComponentFactory componentFactoryV1 = new GA1factory();

    GAProcess processV1 = new GACoreProcess(componentFactoryV1);
    processV1.runProcess(cpop);
  }
```






SOME EXTRA DETAILS (no longer talking about the design patterns) ...


ENUMS:
- Enum is used to limit the type with predefined values 
- In our case, gene is binary so it can only have ZERO(0) or ONE(1) as seen below. 
- 
```
public enum Value{
    ONE(1),
    ZERO(0);

    private int code;
    private Value(int code){
      this.code = code;
    }
    public int returnCode(){
      return this.code;
    }
  }
  Value geneValue;
```




STARTING POINT...
is in Main.java
- The controller is selected and its start() method is invoked.
``` 
    GAController controller = new ControllerV1();
    controller.start();
```




HIGH LEVEL OVERVIEW OF PATH THROUGH CODE:
Main, main()->
GAController, start()->
ControllerV1, createWorld(Population population)->
GACoreProcess, runProcess(Population population)->
assign operators->while loop where we use operators


OPERATOR EXAMPLE... 
selectors

Selection
- Selection is an interface for selectors that accept a Pair and are used for parent selection. 
- There are two available selectors: SelectionRoulette and SelectionTournament. 
```
public interface Selection {
  public Pairs selectParents(Population population);
}
```

SelectionRoulette
- This class implements parent selection via the roulette wheel. 
- selectParents (Population population) is called. 
- Two empty Individuals are created, we "spin" the roulette wheel twice using rouletteWheel (Population population) and assign them, we ensure that the same parents isn't assigned twice and selectParents finally returns a Pair of parents. 
```
public Pairs selectParents(Population population) {
    
    // Two individuals
    Individual p1, p2;

    // Spin the roulette wheel twice and assign
    p1 = rouletteWheel(population);
    p2 = rouletteWheel(population);

    // Used so same parent isn't returned twice
    while (p1 == p2) {
      p2 = rouletteWheel(population);
    }

    return new Pairs(p1, p2);
  }
```
- The logic of rouletteWheel(Population population) is written in reverse of how a roulette wheel works in real life as it's more practical.
- We calculate a random position where a ball would drop first and then work out what individual it is.
- The random position is randomly selected from a value between 0 to the total population fitness. 
- The higher the fitness of an Individual, the higher the chance they will be selected. 
- Individuals with a higher fitness value are essentially allocated more space on a metaphorical roulette wheel. 
```
private Individual rouletteWheel(Population population) {
    List<Individual> individuals = population.getIndividuals();
    double populationFitness = population.getPopulationFitness();
    // We select the random position first
    double rouletteWheelPosition = Math.random() * populationFitness;
    //System.out.println(rouletteWheelPosition);

    // Then we find the parent
    double spinWheel = 0;
    for (Individual individual : individuals) {
      spinWheel += individual.getFitness();

      if (spinWheel >= rouletteWheelPosition) {
        return individual;
      }
    }

    return individuals.get(individuals.size() - 1);
  }
```


SelectionTournament
- This class implements parent selection via tournaments. 
- selectParents (Population population) is called just like for SelectionRoulette and the implementation is the same except for two key differences: tournament(Population population) is used instead of roulette(Population population), and we assign the size of the protected tournamentSize integer and we make it one third of the population size.
- A high tournament size can cause a loss of genetic diversity.  
- However, a low size will allow for more low fitness parents and slow the progress of the algorithm. 
```
tournamentSize = population.getPopulationSize() / 3;
```
- In tournament(Population population), individuals are randomly selected from the population for each tournament. 
- The fittest individual of each tournament is returned from the tournament method.  
- A Pair of parents are returned.  
```
 private Individual tournament(Population population) {
    // Create tournament
    Individual[] tournament = new Individual[ this.tournamentSize ];
    // Add random individuals to the tournament
    List< Individual > tempPopulation = population.shuffle();
    for (int i = 0; i < this.tournamentSize; i++) {
      Individual tournamentIndividual = tempPopulation.get(i);
      tournament[ i ] = tournamentIndividual;
    }
    Arrays.sort(tournament, new IndividualComparator());
    // Return the best
    return tournament[tournament.length - 1];
  }
```