package subsomption;

import utils.*;
import	EDU.gatech.cc.is.abstractrobot.*;
/**
	* Classe abstraite représentant un comportement possible des agents.
*/
public abstract class Behaviour implements Activable {

  protected SocSmall abstract_robot;
  protected long timestamp;
  protected Util utils;

	/**
		* Constructeur de la classe.
		* @param abstract_robot l'agent qui va évaluer le comportement
    * @param timestamp date dans le match
    * @param utils classe contenant des fonctions de calcul vectoriel
	*/
  public Behaviour(SocSmall abstract_robot) {
    this.abstract_robot = abstract_robot;
    this.timestamp = this.abstract_robot.getTime();
    this.utils = new Util(this.abstract_robot);
  }

  public abstract String toString();
}
