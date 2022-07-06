package src.controllers;

import src.factories.GA3factory;
import src.factories.GAComponentFactory;
import src.population.Population;
import src.processes.GACoreProcess;
import src.processes.GAProcess;

/**
 * @desc This controller provides its own implementation for the abstract createWorld method. 
 * GA3factory is the component factory used.  
 * This factory is passed to GACoreProcess where all the basic processes are implemented by it in runProcess method.
 */

public class ControllerV3 extends GAController {

  @Override
  protected void createWorld(Population cpop) {
    GAComponentFactory componentFactoryV3 = new GA3factory();

    GAProcess processV3 = new GACoreProcess(componentFactoryV3);
    processV3.runProcess(cpop);
  }
}
