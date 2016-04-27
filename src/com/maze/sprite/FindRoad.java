package com.maze.sprite;

import com.maze.dao.DirectionTest;
import com.maze.dao.OnFindExitListener;

/**
 * 寻路事务
 * 
 * @author Heiliuer
 * 
 */
public class FindRoad implements Runnable {

	/**
	 * 寻路精灵
	 */
	private Sprite sprite;
	/**
	 * 找到出口的回调
	 */
	private OnFindExitListener onFindExitListener;
	private int steps;
	/**
	 * 是否找到标志位
	 */
	private boolean isFinding;

	/**
	 * 构造寻路事务
	 * 
	 * @param directionTest
	 *            问路实例
	 * @param onFindExitListener
	 *            找到出口的回调
	 * @param start
	 *            起点
	 */
	public FindRoad(DirectionTest directionTest,
			OnFindExitListener onFindExitListener, Point start) {
		sprite = new Sprite(start, directionTest);
		this.onFindExitListener = onFindExitListener;
	}

	/**
	 * 
	 * @param directionTest
	 *            问路实例
	 * @param onFindExitListener
	 *            找到出口的回调
	 * @param startRow
	 *            起点列
	 * @param startLine
	 *            起点行
	 */
	public FindRoad(DirectionTest directionTest,
			OnFindExitListener onFindExitListener, int startRow, int startLine) {
		sprite = new Sprite(new Point(startRow, startLine), directionTest);
		this.onFindExitListener = onFindExitListener;
	}

	/**
	 * 开始寻路
	 */
	public void go() {
		if (!isFinding) {
			isFinding = true;
			new Thread(this).start();
		}
	}

	@Override
	public void run() {
		while (isFinding && sprite.nextStep() == false) {
			steps++;
		}
		System.out.println("\n*******************************\n\t已经成功找到出口("
				+ steps + "步)\n*******************************\n");
		if (onFindExitListener != null)
			onFindExitListener.onFind(sprite.getRoute());
	}
}
