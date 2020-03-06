import subsomption.*;
import swarm.*;
import EDU.gatech.cc.is.util.Vec2;
import EDU.gatech.cc.is.abstractrobot.*;

/**
 * Example of a simple strategy for a robot
 * soccer team.
 * It illustrates how to use many of the sensor and
 * all of the motor methods of a SocSmall robot.
 * (c)1997 Georgia Tech Research Corporation
 *
 * @author Tucker Balch
 * @version $Revision: 1.1 $
 */

public class TeamBeauchampMori extends ControlSystemSS {
	/**
	Configure the control system. This method is
	called once at initialization time. You can use it
	to do whatever you like.
	*/

	public void Configure()
		{
		// not used in this example.
		}

  public Activable chooseBehaviour() {
    Behaviour score = new Score(abstract_robot);
    if (score.isActivated()) {
      return score;
    } else {
      Behaviour pass = new Pass(abstract_robot);
      if (pass.isActivated()) {
        return pass;
      } else {
        Behaviour tag = new Tag(abstract_robot);
        if (tag.isActivated()) {
          return tag;
        } else {
          Behaviour defend = new Defend(abstract_robot);
          if (defend.isActivated()) {
            return defend;
          } else {
            return new Move(abstract_robot);
          }
        }
      }
    }
  }

	/**
	Called every timestep to allow the control system to
	run.
	*/
	public int TakeStep() {
      Activable behaviour_to_adopt = chooseBehaviour();
      behaviour_to_adopt.action();

		  // tell the parent we're OK
		  return(CSSTAT_OK);
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
}
