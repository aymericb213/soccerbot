package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Score extends Behaviour {

  public Score(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return (abstract_robot.getBall(this.timestamp).octant() == 3 || abstract_robot.getBall(this.timestamp).octant() == 4);
  }

  public void action() {
    abstract_robot.setSteerHeading(this.timestamp, abstract_robot.getBall(this.timestamp).t);
    abstract_robot.setSpeed(this.timestamp, 1.0);
    if (abstract_robot.canKick(this.timestamp)) {
      abstract_robot.kick(this.timestamp);
    }
  }

  public String toString() {
    return "Score";
  }
}
