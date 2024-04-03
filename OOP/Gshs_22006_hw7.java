package con.gshs;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Gshs_22006_hw7 - a robot by (your name here)
 */
public class Gshs_22006_hw7 extends AdvancedRobot
{
	/**
	 * run: Gshs_22006_hw7's default behavior
	 */
	public void run() {
		setAdjustRadarForGunTurn(true);
		setTurnRadarRight(10000);
		execute();

		while (true) {
			if (getRadarTurnRemaining() == 0)
				setTurnRadarRight(1);
			
			execute();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {

		double gap = getGunHeading() - getHeading();
		gap = e.getBearing() - gap;

		setTurnRight(e.getBearing());
		setTurnGunRight(gap);
		setFire(5);
		setAhead(e.getDistance());
		setTurnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
	}	
}
