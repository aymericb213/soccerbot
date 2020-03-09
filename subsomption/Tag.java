package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Tag extends Behaviour {

  public Tag(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.getOpponentsGoal(this.timestamp).r < 0.2;
  }

  public void action() {
    System.out.println("Behaviour " + abstract_robot.getPlayerNumber(this.timestamp) + "at " + this.timestamp + " : Tag");
  }

  public String toString() {
    return "Tag";
  }

}
