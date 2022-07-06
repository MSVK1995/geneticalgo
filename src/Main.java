package src;
import src.controllers.ControllerV1;
import src.controllers.GAController;

class Main {
  /** 
   * @desc run project here from the start point. 
   * @param args
   */
  public static void main(String[] args) {
    GAController controller = new ControllerV1();
    controller.start();
  }
}
