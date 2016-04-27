package com.maze.sprite;

public class Point {
	/**
	 * 行列 x,y坐标
	 */
	private int row, line;
	/**
	 * 是否为出口
	 */
	private boolean isExitPoint;

	public boolean isExitPoint() {
		return isExitPoint;
	}

	public Point setExitPoint(boolean isExitPoint) {
		this.isExitPoint = isExitPoint;
		return this;
	}

	public Point(int row, int line) {
		this.row = row;
		this.line = line;
	}

	public DirectionInfo getUp() {
		return up;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * 得到周围四个方位的方向信息
	 * 
	 * @param direction
	 *            上下左右（枚举类型）
	 * @return
	 */
	public Point getPointSurround(Direction direction) {
		int pRow = row, pLine = line;
		switch (direction) {
		case Down:
			pLine++;
			break;
		case Left:
			pRow--;
			break;
		case Right:
			pRow++;
			break;
		case Up:
			pLine--;
		}
		return new Point(pRow, pLine);
	}

	public DirectionInfo getDirectionInfo(Direction direction) {
		switch (direction) {
		case Down:
			return down;
		case Left:
			return left;
		case Right:
			return right;
		case Up:
			return up;
		}
		return null;
	}

	/**
	 * 提供方向信息
	 * 
	 * @param direction
	 * @param directionInfo
	 * @return
	 */
	public Point setDirectionInfo(Direction direction,
			DirectionInfo directionInfo) {
		switch (direction) {
		case Down:
			down = directionInfo;
			break;
		case Left:
			left = directionInfo;
			break;
		case Right:
			right = directionInfo;
			break;
		case Up:
			up = directionInfo;
		}
		return this;
	}

	/**
	 * 
	 * @param directions
	 *            除了这些方向的其他方向是否有可以不碰壁的
	 * @return
	 */
	public boolean canGoExcept(Direction... directions) {
		for1: for (Direction direction : Direction.values()) {
			for (Direction direction2 : directions) {
				if (direction.equals(direction2)) {
					continue for1;
				}
			}
			if (getDirectionInfo(direction).isCanGo()) {
				return true;
			}
		}
		// not can go except the directions
		return false;
	}

	private DirectionInfo up, down, left, right;

	@Override
	public String toString() {
		return "(" + row + "," + line + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Point)) {
			return false;
		}
		Point target = (Point) obj;
		return row == target.getRow() && line == target.getLine();
	}
}
