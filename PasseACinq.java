/*
 * GoToBall.java
 */
import java.util.Random;
import	EDU.gatech.cc.is.util.Vec2;
import	EDU.gatech.cc.is.abstractrobot.*;
//Clay not used

/**
 * This is about the simplest possible soccer strategy, just go to the ball.
 * (c)1997 Georgia Tech Research Corporation
 *
 * @author Tucker Balch
 * @version $Revision: 1.1 $
 */


public class PasseACinq extends ControlSystemSS
	{
	/**
	Configure the Avoid control system.  This method is
	called once at initialization time.  You can use it
	to do whatever you like.
	*/
	public void Configure()
		{
		}


	/**
	Called every timestep to allow the control system to
	run.
	*/
	public int TakeStep()
		{
		Vec2	ball;
    long	curr_time = abstract_robot.getTime();

      // get vector to the ball
      ball = abstract_robot.getBall(curr_time);
      System.out.println(abstract_robot.getPosition(curr_time));
      randomMove();

        // get a list of the positions of our teammates
      Vec2[] teammates = abstract_robot.getTeammates(curr_time);
        // find the closest teammate
      Vec2 closestteammate = new Vec2(99999,0);
      for (int i=0; i< teammates.length; i++) {
        if (teammates[i].r < closestteammate.r)
          closestteammate = teammates[i];
        }

      // a direction away from the closest teammate.
      Vec2 toclosest = new Vec2(closestteammate.x,
          closestteammate.y);
      toclosest.sett(toclosest.t);

      // compute a point three robot radii
      // behind the ball.
      Vec2 backspot = new Vec2(ball.x, ball.y);
      backspot.sub(closestteammate);
      backspot.setr(abstract_robot.RADIUS);
      backspot.add(ball);

      if (abstract_robot.canKick(curr_time)) {
        // set heading towards it
        abstract_robot.setSteerHeading(curr_time, toclosest.t);
        abstract_robot.kick(curr_time);
      }
		// tell the parent we're OK
		return(CSSTAT_OK);
	}

    public void randomMove() {
      long	curr_time = abstract_robot.getTime();
      Random r = new Random();
      double x = 2*r.nextDouble()-1;
      double y = 2*r.nextDouble()-1;
      Vec2	vec = new Vec2(x,y);
      abstract_robot.setSteerHeading(curr_time, vec.t);
      abstract_robot.setSpeed(curr_time, 1.);
    }


	}
