package swarm;

import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;
/**
	* Classe abstraite représentant .
*/
public class Swarm {

  protected SocSmall abstract_robot;
  protected long timestamp;

	/**
		* Constructeur de la classe.
		* @param abstract_robot
	*/
  public Swarm(SocSmall abstract_robot) {
    this.abstract_robot = abstract_robot;
    this.timestamp = this.abstract_robot.getTime();
  }

  public Vec2 cohesion(double elasticity) {
    Vec2 base = abstract_robot.getPosition(this.timestamp);
    Vec2 bary = new Vec2();
    for (Vec2 mate : abstract_robot.getTeammates(this.timestamp)) {
      bary.add(mate);
    }
    bary.x = elasticity*(bary.x/5);
    bary.y = elasticity*(bary.y/5);
    base.sub(bary);
    return base;
  }

  public Vec2 separation(double elasticity) {
    Vec2 sep = new Vec2(0,0);
    for (Vec2 mate : abstract_robot.getTeammates(this.timestamp)) {
      mate.sub(abstract_robot.getPosition(this.timestamp));
      sep.add(mate);
    }
    sep.x *= elasticity;
    sep.y *= elasticity;
    return sep;
  }

  public Vec2 alignment(double elasticity) {
    Vec2 base = abstract_robot.getPosition(this.timestamp);
    Vec2 bary = new Vec2();
    for (Vec2 mate : abstract_robot.getTeammates(this.timestamp)) {
      bary.t += mate.t;
    }
    bary.t = bary.t/5;
    bary.x *= elasticity;
    bary.y *= elasticity;
    base.t -= bary.t;
    return base;
  }

  public Vec2 swarmDirection() {
    Vec2 base_vec = abstract_robot.getPosition(this.timestamp);
    base_vec.add(cohesion(0.5));
    base_vec.add(separation(0.5));
    base_vec.add(alignment(0.5));
    return base_vec;
  }

}
