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
    Swarm swarm = new Swarm(abstract_robot);
    Vec2 direction = swarm.swarmDirection();
    abstract_robot.setSteerHeading(this.timestamp, direction.t);
    abstract_robot.setSpeed(this.timestamp, 1.0);

  }


  public String toString() {
    return "Move";
  }

}
