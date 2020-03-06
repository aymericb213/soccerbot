package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Tag extends Behaviour implements Activable {

  public Tag(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.getOpponentsGoal(curr_time).r < 0.2;
  };

  public void action() {

  };
}
