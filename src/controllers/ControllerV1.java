package src.controllers;

import src.factories.GA1factory;
import src.factories.GAComponentFactory;
import src.population.Population;
import src.processes.GACoreProcess;
import src.processes.GAProcess;

/**
 * @desc This controller provides its own implementation for the abstract createWorld method. 
 * GA1factory is the component factory used.  
 * This factory is passed to GACoreProcess where all the basic processes are implemented by it in runProcess method. 
 */

public class ControllerV1 extends GAController {

  @Override
  protected void createWorld(Population cpop) {
    GAComponentFactory componentFactoryV1 = new GA1factory();

    GAProcess processV1 = new GACoreProcess(componentFactoryV1);
    processV1.runProcess(cpop);
  }
}
