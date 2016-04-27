package com.maze.dao;

import java.util.List;

import com.maze.sprite.Point;

public interface OnFindExitListener {
	public void onFind(List<Point> route);
}
