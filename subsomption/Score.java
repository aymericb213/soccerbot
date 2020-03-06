package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Score extends Behaviour implements Activable {

  public Score(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.getOpponentsGoal(this.timestamp).r < 0.2 && abstract_robot.canKick();
  };

  public void action() {
      abstract
      abstract_robot.kick();
  };
}
