package con.gshs;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Gshs22006_2 - a robot by (your name here)
 */
public class Gshs22006_2 extends Robot
{
	/**
	 * run: Gshs22006_2's default behavior
	 */
	public void run() {
        int cou = 0;

		while(1 > 0)
		{
			for(int i = 0 ; i < 4 ; i++)
			{
				ahead(150);
				turnRight(90);
			}

			cou++;
			out.println(cou);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	}	
}
