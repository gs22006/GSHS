package con.gshs;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Gshs_22006 - a robot by (your name here)
 */
public class Gshs_22006 extends AdvancedRobot
{ 
	private EnemyBot enemy = new EnemyBot();
	private EnemyBot[] enemylist = new EnemyBot[10];

	public void run() {
		setAdjustRadarForGunTurn(true);
		enemy.reset();
		for (int i = 0; i < enemylist.length; i++) {
			enemylist[i] = new EnemyBot(); // 배열의 각 요소를 새 EnemyBot 객체로 초기화
		}
		for (EnemyBot e : enemylist) {
			e.reset();
		}
		while (true) {
			doScanner();
			doMovement();
			doGun();
			execute(); // you must call this!!!
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if (
		// we have no enemy, or...
		enemy.none() ||
		// the one we just spotted is closer, or...
				e.getDistance() < enemy.getDistance() - 70 ||
				// we found the one we've been tracking
				e.getName().equals(enemy.getName())) {
			// track him
			enemy.update(e);
			// turn toward the enemy, a la BearingBot
			setTurnRight(e.getBearing());
		}
		for (int i = 0; i < 10; i++) {
			if (enemylist[i].none() || enemylist[i].getName().equals(e.getName())) {
				enemylist[i].update(e);
			}
		}
	}

	public void onRobotDeath(RobotDeathEvent e) {
		// check if the enemy we were tracking died
		if (e.getName().equals(enemy.getName())) {
			enemy.reset();
		}
		for (int i = 0; i < 10; i++) {
			if (enemylist[i].getName().equals(e.getName())) {
				enemylist[i].reset();
			}
		}
	}

	void doScanner() {
		setTurnRadarRight(360);
	}

	void doMovement() {
		if (enemy.getDistance() > 200) {
			setAhead(enemy.getDistance() / 2);
		}
		// but not too close
		if (enemy.getDistance() < 100) {
			setBack(enemy.getDistance());
		}

		if (getTime() % 20 == 0) {
			setTurnRight(Math.random() * 100 - 50);
			setAhead((Math.random() * 200 - 100));
		}
	}

	void doGun() {
		if (enemy.none() || (this.getEnergy() < 20 && enemy.getEnergy() > 20)) {
			return;
		}

		double firePower = Math.min(500 / enemy.getDistance(), 3);
		if (enemy.getEnergy() < 20 && this.getEnergy() > 40) { 
			firePower += 0.5;
		}

		if (Math.abs(getGunTurnRemaining()) < 10) {
			setFire(firePower);
		}
	}
}
