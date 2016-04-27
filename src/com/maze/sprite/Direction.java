package com.maze.sprite;

public enum Direction {
	Left, Right, Down, Up;
	/**
	 * @return 相反方向
	 */
	public Direction getReverse() {
		switch (this) {
		case Left:
			return Right;
		case Right:
			return Left;
		case Down:
			return Up;
		case Up:
			return Down;
		}
		return null;
	}

	@Override
	public String toString() {
		switch (this) {
		case Left:
			return "←";
		case Right:
			return "→";
		case Down:
			return "↓";
		case Up:
			return "↑";
		}
		return super.toString();
	}
}
