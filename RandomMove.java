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


public class RandomMove extends ControlSystemSS
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
    Random r = new Random();
    double x = r.nextDouble();
    double y = r.nextDouble();
    if (r.nextBoolean()) {
      x = -x;
    }
    if (r.nextBoolean()) {
      y = -y;
    }
    Vec2	vec = new Vec2(x,y);

    
		long	curr_time = abstract_robot.getTime();

		// set heading towards it
		abstract_robot.setSteerHeading(curr_time, vec.t);

		// set speed at maximum
		abstract_robot.setSpeed(curr_time, 1.0);

		// kick it if we can
		if (abstract_robot.canKick(curr_time))
			abstract_robot.kick(curr_time);

		// tell the parent we're OK
		return(CSSTAT_OK);
		}
	}
