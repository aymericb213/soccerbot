package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Defend extends Behaviour {

  public Defend(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    Vec2 ball = abstract_robot.getBall(this.timestamp);
    return abstract_robot.getPlayerNumber(this.timestamp) == 0 || utils.opponentHasBall();
  }

  public void action() {
    abstract_robot.setSteerHeading(this.timestamp, utils.interceptBall().t);
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
