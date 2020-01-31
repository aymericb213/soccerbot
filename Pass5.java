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
	public Vec2 closestTeammate(){
		long	curr_time = abstract_robot.getTime();
		Vec2 mypos = abstract_robot.getPosition(curr_time);

		// Vec2 usfromball = abstract_robot.getBall(curr_time);
		Vec2[] teammates = abstract_robot.getTeammates(curr_time);

		Vec2 closestguy = new Vec2(teammates[0]);

		for (int i=1; i< teammates.length; i++){
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
		int mynum = abstract_robot.getPlayerNumber(curr_time);

		// System.out.println(mynum + " : " + position.r);


		for (int i=0; i< teammates.length; i++){
			Vec2 teammatefromball = new Vec2(teammates[i]);

			// calcul de vecteur du teammates par rapport a la balle
			teammatefromball.add(position);
			teammatefromball.sub(teammates[i]);

			// System.out.println(mynum + " : " + teammatefromball.r + " " + i);


			if (teammatefromball.r < position.r){
				return false;
			}
		}

		return true;
	}


	public void passBall(){
		Vec2 teammate = closestTeammate();
		shoot(teammate);
	}

	public void shoot(Vec2 position){
		long	curr_time = abstract_robot.getTime();

		abstract_robot.setSteerHeading(curr_time, position.t);
		abstract_robot.setSpeed(curr_time, 0.2);

		if (abstract_robot.canKick(curr_time)){
			abstract_robot.kick(curr_time);
		}
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

			// System.out.println(" JE SUIS LENGTH");
			// System.out.println(teammates.length);

			boolean closest = iAmTheclosestGuyTo(ball);
			// System.out.println(closest);
			// System.out.println(" SUIS-JE LE PLUS PROCHE ?");

			if (closest){
				System.out.println("UI");
				abstract_robot.setSteerHeading(curr_time, ball.t);
				abstract_robot.setSpeed(curr_time, 0.01);

			}else{
				// abstract_robot.setSpeed(curr_time, 0.0);
			}
			// System.out.println("CA PASSE BIEN");
			// System.out.println();

			if (usfromball.r < 0.2){
				passBall();
			}
		}


		// tell the parent we're OK
		return(CSSTAT_OK);
		}
	}
