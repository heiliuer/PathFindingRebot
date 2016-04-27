package com.maze.sprite;

public class DirectionInfo {
	/**
	 * 此方向是否可行
	 */
	private boolean canGo;
	/**
	 * 此方向是否已经走过
	 */
	private boolean hasGo;

	/**
	 * 
	 * @return 此方向是否可行
	 */
	public boolean isCanGo() {
		return canGo;
	}

	public void setCanGo(boolean canGo) {
		this.canGo = canGo;
	}

	public DirectionInfo(boolean canGo) {
		this.canGo = canGo;
	}

	/**
	 * 
	 * @return 此方向是否已经走过
	 */
	public boolean isHasGo() {
		return hasGo;
	}

	public void setHasGo(boolean hasGo) {
		this.hasGo = hasGo;
	}

	@Override
	public String toString() {
		return canGo + "";
	}

}
