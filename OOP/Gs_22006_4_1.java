package con.gshs;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
 
/**
 * Gs_22006_4_1 - a robot by (your name here)
 */
public class Gs_22006_4_1 extends AdvancedRobot
{
	/**
	 * run: Gs_22006_4_1's default behavior
	 */
	public void run() {
		double dX = 100 - getX(), dY = 100 - getY();
		double deg = Math.toDegrees(Math.atan2(dY, dX)) - 90;

		deg = 360 - deg;
		deg -= getHeading();

		while(deg > 180)
			deg -= 360;
		
		while(deg < -180)
			deg += 360;

		turnRight(deg);

		double dist = Math.hypot(100 - getX(), 100 - getY());
		ahead(dist);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {

	}	
}
