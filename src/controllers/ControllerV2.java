package src.controllers;

import src.factories.GA2factory;
import src.factories.GAComponentFactory;
import src.population.Population;
import src.processes.GACoreProcess;
import src.processes.GAProcess;

/**
 * @desc This controller provides its own implementation for the abstract createWorld method. 
 * GA2factory is the component factory used.  
 * This factory is passed to GACoreProcess where all the basic processes are implemented by it in runProcess method. 
 */

public class ControllerV2 extends GAController {

  @Override
  protected void createWorld(Population cpop) {
    GAComponentFactory componentFactoryV2 = new GA2factory();

    GAProcess processV2 = new GACoreProcess(componentFactoryV2);
    processV2.runProcess(cpop);
  }
}
