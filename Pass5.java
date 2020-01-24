/*
 * GoToBall.java
 */
import  java.util.Random;
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


public class Pass5 extends ControlSystemSS
	{
	/**
	Configure the Avoid control system.  This method is
	called once at initialization time.  You can use it
	to do whatever you like.
	*/
	public void Configure()
		{
		}


	// The closest teammate from the player
	public Vec2 closestGuy(Vec2[] teammates){
		Vec2 closestguy = new Vec2(99999,0);

		for (int i=0; i< teammates.length; i++){
			if (teammates[i].r < closestguy.r)
				closestguy = teammates[i];
		}

		return closestguy;
	}

	public boolean iAmTheclosestGuyTo(Vec2 position){
		boolean closest = true;

		long	curr_time = abstract_robot.getTime();
		Vec2 mypos = abstract_robot.getPosition(curr_time);

		// Vec2 usfromball = abstract_robot.getBall(curr_time);
		Vec2[] teammates = abstract_robot.getTeammates(curr_time);

		System.out.println(" JE SUIS LENGTH");
		System.out.println(teammates.length);


		for (int i=0; i< teammates.length; i++){
			Vec2 teammatefromball = new Vec2(mypos);


			// calcul de vecteur du teammates par rapport a la balle
			teammatefromball.add(position);
			teammatefromball.add(teammates[i]);

			// System.out.println();
			System.out.println(" JE SUIS RAYON");
			System.out.println(teammatefromball.r);
			if (teammatefromball.r < mypos.r){
				return false;
			}
		}

		return true;
	}

	/**
	Called every timestep to allow the control system to
	run.
	*/
	public int TakeStep()
		{
		Vec2	result,ball;
		long	curr_time = abstract_robot.getTime();

		// get vector to the ball
		ball = abstract_robot.getBall(curr_time);

    Vec2 v = new Vec2();
		// get a list of the positions of our teammates
		Vec2[] teammates = abstract_robot.getTeammates(curr_time);

		if (teammates.length != 0){
			Vec2 usfromball = abstract_robot.getBall(curr_time);

			System.out.println(" JE SUIS LENGTH");
			System.out.println(teammates.length);

			boolean closest = iAmTheclosestGuyTo(ball);

			System.out.println(" SUIS-JE LE PLUS PROCHE ?");

			if (closest){
				abstract_robot.setSteerHeading(curr_time, ball.t);
				abstract_robot.setSpeed(curr_time, 0.5);

			}
			System.out.println();

		}

		// tell the parent we're OK
		return(CSSTAT_OK);
		}
	}
