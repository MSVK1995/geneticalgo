package src.controllers;

import src.factories.GAComponentFactory;
import src.population.Population;

/**
 * @desc TEMPLATE METHOD PATTERN implemented here. 
 * Template method design pattern defines an algorithm as a skeleton of operations (GAController.java) 
 * and leaves the details to be implemented by the subclasses (ControllerV1.java, ControllerV2.java and ControllerV3.java). 
 * 
 * GAController acts as an interface (not the keyword interface) with the client to initiate the genetic algorithm process.
 * It defines start behavior that initializes the singleton population with default size or size passed
 * as parameter. 
 */

public abstract class GAController {

  Population p;
  GAComponentFactory componentFactory;

  // method that acts as an interface between the createWorld function and the client. 
  // Population is initialized with default size of 10
  public void start() {
    //Population is a singleton class and calls getPopulationInstance() to get one instance of population for the entire GA process
    p = Population.getPopulationInstance();
    int size = p.getPopulationSize();
    System.out.println("Starting with default settings:");
    System.out.println("Population size: " + size);
    //createWorld is defined by concrete classes extending GAController class
    createWorld(p);
  }

  /**
   * @param popuSize
   * @desc  method that acts as an interface between the createWorld function and the client. 
   * Population is initialized with size passed as parameter
   */
  public void start(int popuSize) {
    int size = popuSize;
    System.out.println("Starting with custom settings:");
    System.out.println("Population size: " + size);
    //Population is a singleton class and calls getPopulationInstance() to get one instance of population for the entire GA process
    p = Population.getPopulationInstance(popuSize);
    createWorld(p);
  }

  //abstract method that initializes specified factory instance and starts the core process
  protected abstract void createWorld(Population cpop);
}
