package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Defend extends Behaviour {

  public Defend(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.getPlayerNumber(this.timestamp) == 0 || abstract_robot.getOurGoal(this.timestamp).r < 0.2;
  }

  public void action() {
    abstract_robot.setSteerHeading(this.timestamp, abstract_robot.getOurGoal(this.timestamp).t);
    abstract_robot.setSpeed(this.timestamp, 1.0);
    if (abstract_robot.canKick(this.timestamp)) {
      abstract_robot.setSteerHeading(this.timestamp, abstract_robot.getOpponentsGoal(this.timestamp).t);
      abstract_robot.kick(this.timestamp);
    }
  }

  public String toString() {
    return "Defend";
  }
}
