package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Score extends Behaviour {

  public Score(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.getBall(this.timestamp).octant() == 3 && abstract_robot.canKick(this.timestamp);
  };

  public void action() {
      abstract_robot.kick(this.timestamp);
  };
}
