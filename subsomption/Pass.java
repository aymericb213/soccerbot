package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Pass extends Behaviour {

  public Pass(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return utils.closestTeammate().x < abstract_robot.getPosition(this.timestamp).x;
  }

  public void action() {
    if (abstract_robot.canKick(this.timestamp)) {
      Vec2 kickspot = utils.getKickspot(utils.closestTeammate());//passe au plus proche
      abstract_robot.kick(this.timestamp);
    } else {
      Vec2 ball = abstract_robot.getBall(this.timestamp);//aller chercher la balle
      abstract_robot.setSteerHeading(this.timestamp, ball.t);
      abstract_robot.setSpeed(this.timestamp, 1.0);
    }
  }

  public String toString() {
    return "Pass";
  }
}
