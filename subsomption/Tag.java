package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Tag extends Behaviour {

  public Tag(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    for (Vec2 opp : abstract_robot.getOpponents(this.timestamp)) {
      if (utils.readyToTag(opp)) {
        return true;
      }
    }
    return false;
  }

  public void action() {
    for (Vec2 opp : abstract_robot.getOpponents(this.timestamp)) {
      if (utils.readyToTag(opp)) {
        abstract_robot.setSteerHeading(this.timestamp, opp.t);
        abstract_robot.setSpeed(this.timestamp, 1.0);
      }
    }
    System.out.println("Behaviour " + abstract_robot.getPlayerNumber(this.timestamp) + "at " + this.timestamp + " : Tag");
  }

  public String toString() {
    return "Tag";
  }

}
