package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Pass extends Behaviour {

  public Pass(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.canKick(this.timestamp);
  }

  public void action() {
    System.out.println("Behaviour of " + abstract_robot.getPlayerNumber(this.timestamp) + " at " + this.timestamp + " : Pass");
    abstract_robot.kick(this.timestamp);
  }

  public String toString() {
    return "Pass";
  }
}
