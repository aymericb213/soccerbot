package subsomption;

import swarm.*;
import EDU.gatech.cc.is.util.Vec2;
import EDU.gatech.cc.is.abstractrobot.*;

public class Move extends Behaviour {

  public Move(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return true;
  }

  public void action() {
    if (abstract_robot.getPlayerNumber(this.timestamp) != 0) {

    Swarm swarm = new Swarm(abstract_robot);
    Vec2 direction = swarm.swarmDirection();
    if (abstract_robot.canKick(this.timestamp)) {
      direction.add(abstract_robot.getOpponentsGoal(this.timestamp));//attraction vers le but adverse
    } else {
      direction.add(abstract_robot.getBall(this.timestamp));//attraction vers la balle
    }
    for (Vec2 opp : abstract_robot.getOpponents(this.timestamp)) {
      direction.sub(opp);//répulsion envers les adversaires
    }
    abstract_robot.setSteerHeading(this.timestamp, direction.t);
    abstract_robot.setSpeed(this.timestamp, 1.0);
  }
}

  public String toString() {
    return "Move";
  }

}
