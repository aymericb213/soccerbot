package utils;

import EDU.gatech.cc.is.util.Vec2;
import EDU.gatech.cc.is.abstractrobot.*;

public class Util {

  protected SocSmall abstract_robot;
  protected long timestamp;

  /**
    * Constructeur de la classe.
    * @param abstract_robot
  */
  public Util(SocSmall abstract_robot) {
    this.abstract_robot = abstract_robot;
    this.timestamp = this.abstract_robot.getTime();
  }

  public Vec2 getKickspot(long timestamp) {
    Vec2 kickspot = new Vec2(0, 0);

    Vec2 ball = abstract_robot.getBall(timestamp);
    Vec2 goal = abstract_robot.getOpponentsGoal(timestamp);

    goal.sub(ball);
    kickspot.sub(goal);
    kickspot.setr(1);
    ball.add(kickspot);
    return ball;
  }

  // The closest teammate from the player
  public Vec2 closestTeammate() {
    Vec2[] teammates = abstract_robot.getTeammates(this.timestamp);
    Vec2 closestguy = new Vec2(teammates[0]);

    for (int i=1; i< teammates.length; i++){
      if (teammates[i].r < closestguy.r)
        closestguy = teammates[i];
    }

    return closestguy;
  }
}
