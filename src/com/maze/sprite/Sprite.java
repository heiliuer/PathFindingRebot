package com.maze.sprite;

import java.util.List;

import com.maze.dao.DirectionTest;

/**
 * 寻路精灵
 * 
 * @author Heiliuer
 * 
 */
public class Sprite {

	/**
	 * 当前的位置
	 */
	private Point current;

	/**
	 * 路径（可行位置和不可行位置的队列）
	 */
	private PointQueue activePoints, deadPoints;

	/**
	 * 问路实例
	 */
	private DirectionTest directionTest;

	/**
	 * 得到此时的可行路线
	 * 
	 * @return
	 */
	public List<Point> getRoute() {
		activePoints.clearLoop();
		return activePoints.getList();
	}

	/**
	 * 寻路精灵
	 * 
	 * @param startPoint
	 *            起点
	 * @param directionTest
	 *            撞墙测试
	 */
	public Sprite(Point startPoint, DirectionTest directionTest) {
		this(startPoint, directionTest, STRATEGY_D_L_R_U);
	}

	/**
	 * 寻路精灵
	 * 
	 * @param startPoint
	 *            起点
	 * @param directionTest
	 *            撞墙测试
	 * @param strategy
	 *            策略 (默认STRATEGY_D_L_R_U)
	 */
	public Sprite(Point startPoint, DirectionTest directionTest,
			Direction[] strategy) {
		activePoints = new PointQueue();
		deadPoints = new PointQueue();
		current = startPoint;
		activePoints.push(current);
		this.directionTest = directionTest;
		directionTest.testDirection(current);
		this.strategy = strategy;
	}

	private static final Direction STRATEGY_D_L_R_U[] = { Direction.Down,
			Direction.Left, Direction.Right, Direction.Up };

	private Direction strategy[];

	/**
	 * 下一步
	 * 
	 * @return 是否找到出口了
	 */
	public boolean nextStep() {
		Point nextPoint;
		nextPoint = go(strategy[0]);
		if (nextPoint == null) {
			nextPoint = go(strategy[1]);
			if (nextPoint == null) {
				nextPoint = go(strategy[2]);
				if (nextPoint == null)
					nextPoint = go(strategy[3]);
			}
		}
		// 确定nextPoint是死点
		if (nextPoint == null) {
			deadPoints.push(activePoints.pop());
			// System.out.println("add dead point " + current);
			current = activePoints.getTop();
			return false;
		} else if (nextPoint.isExitPoint()) {
			return true;
		}
		return nextPoint.getRow() == 11 && nextPoint.getLine() == 13;
	}

	/**
	 * 朝指定方向走一步
	 * 
	 * @param direction
	 * @return
	 */
	private Point go(Direction direction) {
		Point newPoint;
		DirectionInfo info = current.getDirectionInfo(direction);
		if (info == null)
			return current.setExitPoint(true);
		if (info.isCanGo() && !info.isHasGo()) {
			info.setHasGo(true);
			newPoint = current.getPointSurround(direction);
			directionTest.testDirection(newPoint);
			if (newPoint.isExitPoint()) {
				return newPoint;
			}
			if (deadPoints.contain(newPoint)
					|| !newPoint.canGoExcept(direction.getReverse())) {
				return null;
			}
			System.out.print(direction.toString());
			System.out.println("  " + current);
			current = newPoint;
			current.getDirectionInfo(direction.getReverse()).setHasGo(true);
			Point temp;
			if ((temp = activePoints.get(current)) != null) {
				current = temp;
				current.getDirectionInfo(direction.getReverse()).setHasGo(true);
			}
			activePoints.push(current);
			return current;
		}
		return null;
	}
}
