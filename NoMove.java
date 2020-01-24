/*
 * GoToBall.java
 */

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


public class NoMove extends ControlSystemSS
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
		// tell the parent we're OK
		return(CSSTAT_OK);
		}
	}
