import java.util.Random;
import EDU.gatech.cc.is.util.Vec2;
import EDU.gatech.cc.is.abstractrobot.*;

public class Move implements Activable {

  SocSmall abstract_robot;

  public Move(SocSmall abstract_robot) {
    this.abstract_robot = abstract_robot;
  }

  public boolean isActivated() {
    return true;
  };

  public void action() {
    Vec2	vec = new Vec2((new Random().nextDouble()*2)-1,(new Random().nextDouble()*2)-1);
    long	curr_time = abstract_robot.getTime();

    abstract_robot.setSteerHeading(curr_time, vec.t);
    abstract_robot.setSpeed(curr_time, 1.0);
  };
}