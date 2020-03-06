package subsomption;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Pass extends Behaviour implements Activable {

  public Pass(SocSmall abstract_robot) {
    super(abstract_robot);
  }

  public boolean isActivated() {
    return abstract_robot.canKick();
  };

  public void action() {
    abstract_robot.kick();
  };
}
