package con.gshs;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Gshs_22006_Bot - a robot by (your name here)
 */
public class Gshs_22006_Bot extends Robot
{
	/**
	 * run: Gshs_22006_Bot's default behavior
	 */
	public void run() {
		while (true) {
            setAdjustGunForRobotTurn(true);
            setAdjustRadarForGunTurn(true);
            turnRadarRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {

		double gap = getGunHeading() - getHeading();
		gap = e.getBearing() - gap;

		turnRight(e.getBearing());
		turnGunRight(gap);

		ahead(-1);
		ahead(1);
		ahead(-1);
		ahead(1);
		fire(5);
		ahead(e.getDistance());
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
		back(20);
	}	
}
