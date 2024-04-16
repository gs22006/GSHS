package con.gshs;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * AdvancedEnemyBot - a robot by (your name here)
 */
public class AdvancedEnemyBot extends EnemyBot
{
	private double x;
	private double y;

	public AdvancedEnemyBot() {
		super();
		reset();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	@Override
	public void reset() {
		super.reset();
		this.x = 0;
		this.y = 0;
	}

	public void update(ScannedRobotEvent e, Robot robot) {
		super.update(e);

		double absBearingDeg = (robot.getHeading() + e.getBearing());
		if (absBearingDeg < 0) absBearingDeg += 360;
		//위 식은 적의 각도를 북쪽에서부터 잰 각도를 뜻한다. 0보다 작을 경우에는 360을 더해 양수 각도로 만들어 주었다.

		x = robot.getX() + Math.sin(Math.toRadians(absBearingDeg)) * e.getDistance(); //이 식은 자신의 위치에다 (적과의 거리) * (sin(북쪽에서부터의 각도))를 더한 값으로, 적의 x좌표를 나타낸다.
		y = robot.getY() + Math.cos(Math.toRadians(absBearingDeg)) * e.getDistance(); //이 식은 자신의 위치에다 (적과의 거리) * (cos(북쪽에서부터의 각도))를 더한 값으로, 적의 y좌표를 나타낸다.
		//보다 자세히 설명하면, 북쪽을 기준으로 시계 방향으로 각도를 재기 때문에, sin을 곱한 값이 delta x가 되고, cos을 곱한 값이 delta y가 된다.
	}

	public double getFutureX(long when) {
		return x + Math.sin(Math.toRadians(getHeading())) * getVelocity() * when;
		//우선, 적이 when의 시간동안 움직인 거리를 계산한다. (getVelocity() * when)
		//그리고, 앞서 설명한 것처럼 sin값을 곱해야 x의 변화량이 나오기 때문에 sin을 곱한 값을 현재 적의 위치에 더해주는 것이다.
		//최종적으로 이 계산을 통해서 when 시간 후 적의 위치를 알 수 있다.
	}

	public double getFutureY(long when) {
		return y + Math.cos(Math.toRadians(getHeading())) * getVelocity() * when;
		//우선, 적이 when의 시간동안 움직인 거리를 계산한다. (getVelocity() * when)
		//그리고, 앞서 설명한 것처럼 cos값을 곱해야 y의 변화량이 나오기 때문에 cos을 곱한 값을 현재 적의 위치에 더해주는 것이다.
		//최종적으로 이 계산을 통해서 when 시간 후 적의 위치를 알 수 있다.
	}
}
