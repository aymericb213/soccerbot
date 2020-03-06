package swarm;

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
}
