package con.gshs;
import robocode.*;

public class Gshs_22006_hw15 extends AdvancedRobot {
    private EnemyBot enemy = new EnemyBot();
    private EnemyBot[] enemylist = new EnemyBot[10];

    public void run() {
        setAdjustRadarForGunTurn(true);
        setAdjustGunForRobotTurn(true);
        enemy.reset();
        for (int i = 0; i < enemylist.length; i++) {
            enemylist[i] = new EnemyBot();
        }
        for (EnemyBot e : enemylist) {
            e.reset();
        }
        while (true) {
            doScanner();
            doMovement();
            doGun();
            execute();
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        if (enemy.none() || e.getDistance() < enemy.getDistance() - 70 || e.getName().equals(enemy.getName())) {
            enemy.update(e);
            // Calculate gun turn toward enemy and normalize it
            double turn = getHeading() - getGunHeading() + e.getBearing();
            setTurnGunRight(normalizeBearing(turn));
        }
        for (int i = 0; i < 10; i++) {
            if (enemylist[i].none() || enemylist[i].getName().equals(e.getName())) {
                enemylist[i].update(e);
            }
        }
    }

    public void onRobotDeath(RobotDeathEvent e) {
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
        if (enemy.getDistance() < 100) {
            setBack(enemy.getDistance());
        }
        if (getTime() % 20 == 0) {
            setTurnRight(Math.random() * 100 - 50);
            setAhead((Math.random() * 200 - 100));
        }
    }

    void doGun() {
        if (enemy.none() || getGunHeat() > 0 || (this.getEnergy() < 20 && enemy.getEnergy() > 20)) {
            return;
        }

		double firePower = Math.min(400 / enemy.getDistance(), Rules.MAX_BULLET_POWER);
		
		if (this.getEnergy() < 10) {
			firePower = Math.min(firePower, 0.5);
		}

		else if (this.getEnergy() > 30 && enemy.getDistance() < 200) {
			firePower = Math.min(firePower, 3);
		}

		if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10) {
			setFire(firePower);
    	}
    }

    // Normalizes a bearing to between +180 and -180
    double normalizeBearing(double angle) {
        while (angle > 180) angle -= 360;
        while (angle < -180) angle += 360;
        return angle;
    }
}
