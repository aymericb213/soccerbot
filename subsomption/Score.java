package subsomption;

import utils.*;
import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Score extends Behaviour {

  public Score(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    Vec2 ball = abstract_robot.getBall(this.timestamp);
    return (ball.octant() == 3 || ball.octant() == 4) && ball.r < abstract_robot.RADIUS*4;
  }

  public void action() {
    Util utils = new Util(abstract_robot);
    Vec2 kickspot = utils.getKickspot(this.timestamp);

    abstract_robot.setSteerHeading(this.timestamp, kickspot.t);
    abstract_robot.setSpeed(this.timestamp, 1.0);
    if (abstract_robot.canKick(this.timestamp)) {
      abstract_robot.kick(this.timestamp);
    }
  }

  public String toString() {
    return "Score";
  }
}
