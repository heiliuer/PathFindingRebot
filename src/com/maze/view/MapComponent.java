package com.maze.view;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.maze.dao.DirectionTest;
import com.maze.dao.OnFindExitListener;
import com.maze.sprite.Direction;
import com.maze.sprite.DirectionInfo;
import com.maze.sprite.FindRoad;
import com.maze.sprite.Map;
import com.maze.sprite.Point;

public class MapComponent extends Map implements KeyListener, DirectionTest,
		OnFindExitListener {
	private static final long serialVersionUID = 34L;
	private int pline = 6;
	private int prow = 6;

	public MapComponent(JFrame jFrame) {
		this.jFrame = jFrame;
		int margin = LAYOUT_MARGIN * 2;
		jFrame.setSize(FONT_SIZE * (ROW + 1) + margin, FONT_SIZE * (LINE + 1)
				+ margin + LAYOUT_MARGIN);
	}

	private JFrame jFrame;

	public int getPline() {
		return pline;
	}

	public int getProw() {
		return prow;
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (int ia = 0; ia <= LINE; ia++) {
			for (int ja = 0; ja <= ROW; ja++) {
				g.drawString(MAP[ia][ja], ja * FONT_SIZE + LAYOUT_MARGIN, ia
						* FONT_SIZE + LAYOUT_MARGIN);
			}
		}
	}

	private static final int FONT_SIZE = 20;
	private static final int LAYOUT_MARGIN = 60;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_LEFT) {
			if (!MAP[pline][prow - 1].equals(W)) {
				prow = prow - 1;
				MAP[pline][prow + 1] = S;
				MAP[pline][prow] = P;
			}
		} else if (c == KeyEvent.VK_RIGHT) {
			if (pline == LINE || prow == ROW) {
				JOptionPane.showMessageDialog(null, "过关了");
			} else if (!MAP[pline][prow + 1].equals(W)) {
				prow = prow + 1;
				MAP[pline][prow - 1] = S;
				MAP[pline][prow] = P;
			}
		} else if (c == KeyEvent.VK_UP) {
			if (!MAP[pline - 1][prow].equals(W)) {
				pline = pline - 1;
				MAP[pline + 1][prow] = S;
				MAP[pline][prow] = P;
			}
		} else if (c == KeyEvent.VK_DOWN) {
			if (!MAP[pline + 1][prow].equals(W)) {
				pline = pline + 1;
				MAP[pline - 1][prow] = S;
				MAP[pline][prow] = P;
			}
		} else if (c == KeyEvent.VK_ENTER) {
			new FindRoad(this, this, prow, pline).go();
			return;
		}
		for (int j = 0; j < ROW; j++) {
			for (int k = 0; k < LINE; k++) {
				if (MAP[k][j].equals(R)) {
					MAP[k][j] = S;
				}
			}
		}
		jFrame.setTitle("(" + prow + "," + pline + ")");
		this.repaint();
	}

	@Override
	public void testDirection(Point p) {
		if (p.getLine() >= LINE || p.getRow() >= ROW) {
			p.setExitPoint(true);
			return;
		}
		p.setDirectionInfo(Direction.Left, new DirectionInfo(
				!MAP[p.getLine()][p.getRow() - 1].equals(W)));
		p.setDirectionInfo(Direction.Right, new DirectionInfo(
				!MAP[p.getLine()][p.getRow() + 1].equals(W)));
		p.setDirectionInfo(Direction.Up, new DirectionInfo(
				!MAP[p.getLine() - 1][p.getRow()].equals(W)));
		p.setDirectionInfo(Direction.Down, new DirectionInfo(
				!MAP[p.getLine() + 1][p.getRow()].equals(W)));
	}

	// 画出路线

	public void onFind2(List<Point> route) {
		for (int j = 0; j < ROW; j++) {
			for (int k = 0; k < LINE; k++) {
				if (MAP[k][j].equals(R)) {
					MAP[k][j] = S;
				}
			}
		}
		Point p;
		for (int i = 1; i < route.size(); i++) {
			p = route.get(i);
			MAP[p.getLine()][p.getRow()] = R;
		}
		jFrame.setTitle(route.size() + "步");
		this.repaint();

	}

	private static final long DELAY_SHOW_STEP = 60;

	// 寻路演示
	@Override
	public void onFind(List<Point> route) {
		for (int j = 0; j < ROW; j++) {
			for (int k = 0; k < LINE; k++) {
				if (MAP[k][j].equals(R)) {
					MAP[k][j] = S;
				}
			}
		}
		Point p = route.get(0);
		for (int i = 1; i < route.size(); i++) {
			if (i != 1)
				MAP[p.getLine()][p.getRow()] = S;
			p = route.get(i);
			MAP[p.getLine()][p.getRow()] = P;
			this.repaint();
			try {
				Thread.sleep(DELAY_SHOW_STEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		jFrame.setTitle(route.size() + "步");
	}
}
