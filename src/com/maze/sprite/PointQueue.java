package com.maze.sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * 位置队列
 * 
 * @author Heiliuer
 * 
 */
public class PointQueue {
	private List<Point> list;

	public Point pop() {
		if (list.size() == 0) {
			return null;
		}
		return list.remove(list.size() - 1);
	}

	public Point getTop() {
		if (list.size() == 0) {
			return null;
		}
		return list.get(list.size() - 1);
	}

	public PointQueue push(Point p) {
		list.add(p);
		return this;
	}

	public PointQueue clear() {
		list.clear();
		return this;
	}

	public PointQueue() {
		list = new ArrayList<Point>();
	}

	public boolean contain(Point p) {
		return list.contains(p);
	}

	public Point get(Point p) {
		if (p == null)
			return null;
		for (Point pp : list) {
			if (pp.equals(p))
				return pp;
		}
		return null;
	}

	public void clearLoop() {
		Point pI;
		for (int i = 0; i < list.size(); i++) {
			pI = list.get(i);
			for (int j = i + 1; j < list.size(); i++) {
				if (pI.equals(list.get(j))) {
					for (int k = i + 1; k <= j; k++) {
						list.remove(k);
						System.out.println("remove:" + k);
					}
				}
			}
		}
	}

	public List<Point> getList() {
		return list;
	}
}
