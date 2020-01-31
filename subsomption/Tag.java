import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;

public class Tag implements Activable {

  SocSmall abstract_robot;

  public Tag(SocSmall abstract_robot) {
    this.abstract_robot = abstract_robot;
  }

  public boolean isActivated() {
    return false;
  };

  public void action() {

  };
}
