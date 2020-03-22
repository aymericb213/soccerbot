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

  public Vec2 getKickspot(Vec2 goal) {
    Vec2 kickspot = new Vec2(0, 0);
    Vec2 ball = abstract_robot.getBall(this.timestamp);

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

  public boolean opponentHasBall() {
    for (Vec2 opp : abstract_robot.getOpponents(this.timestamp)) {
      Vec2 vec = new Vec2(0,0);
      vec.sub(opp);
      vec.add(abstract_robot.getBall(this.timestamp));
      if (vec.r < abstract_robot.RADIUS*2) {
        return true;
      }
    }
    return false;
  }

  public Vec2 interceptBall() {
    Vec2 vec = new Vec2(0,0);
    vec.sub(abstract_robot.getOurGoal(this.timestamp));
    vec.add(abstract_robot.getBall(this.timestamp));
    vec.setr(vec.r/2);
    return vec;
  }

  public boolean readyToTag(Vec2 opponent) {
    if (opponent.r > abstract_robot.RADIUS*3) {
      return false;
    }
    for (Vec2 ally : abstract_robot.getTeammates(this.timestamp)) {
      Vec2 vec = new Vec2(0,0);
      vec.sub(opponent);
      vec.add(ally);
      if (vec.r < opponent.r) {
        return false;
      }
    }
    return true;
  }
}
