package con.gshs;

import robocode.*;
import robocode.util.Utils;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html
// AdvancedRobot documentation: https://robocode.sourceforge.io/docs/robocode/robocode/AdvancedRobot.html

/**
 * EnemyBot - a robot by (your name here)
 */
public class EnemyBot extends AdvancedRobot {
    private double bearing;
    private double distance;
    private double energy;
    private double heading;
    private String name;
    private double velocity;

    public EnemyBot() {
        reset();
    }

    public void run() {
        while (true) {
            turnRadarRight(360);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        update(e);
        fire(1);
    }

    public final void update(ScannedRobotEvent e) {
        this.bearing = e.getBearing();
        this.distance = e.getDistance();
        this.energy = e.getEnergy();
        this.heading = e.getHeading();
        this.name = e.getName();
        this.velocity = e.getVelocity();
    }

	public boolean shouldTrack(ScannedRobotEvent event, long time) {
		return true;
	}


    public void reset() {
        this.bearing = 0.0;
        this.distance = 0.0;
        this.energy = 0.0;
        this.heading = 0.0;
        this.name = "";
        this.velocity = 0.0;
    }

    public boolean none() {
        return this.name.equals("");
    }

    public double getBearing() {
        return this.bearing;
    }

    public double getDistance() {
        return this.distance;
    }

    public double getEnergy() {
        return this.energy;
    }

    public double getHeading() {
        return this.heading;
    }

    public String getName() {
        return this.name;
    }

    public double getVelocity() {
        return this.velocity;
    }
}
