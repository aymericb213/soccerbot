package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Defend extends Behaviour implements Activable {

  public Defend(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.getOpponentsGoal(this.timestamp).r < 0.2;
  };

  public void action() {

  };
}
