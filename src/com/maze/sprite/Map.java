package com.maze.sprite;

import javax.swing.JComponent;

public class Map extends JComponent {
	private static final long serialVersionUID = 1L;
	protected static final String P = "囍";
	protected static final String W = "■";
	protected static final String S = " ";
	protected static final String R = "▒";
	protected static final int ROW = 11;
	protected static final int LINE = 14;
	protected static final String[][] MAP_A = {
			{ W, W, W, W, W, W, W, W, W, W, W, W },
			{ W, S, S, S, W, S, S, S, W, S, S, W },
			{ W, S, S, S, W, S, S, S, S, S, S, W },
			{ W, W, S, W, W, W, W, W, W, S, S, W },
			{ W, S, S, S, S, S, S, S, S, S, S, W },
			{ W, S, W, S, W, W, W, W, W, S, S, W },
			{ W, S, W, S, S, S, P, S, W, S, S, W },
			{ W, W, W, S, W, S, S, S, W, S, S, W },
			{ W, S, S, S, W, S, W, S, W, S, S, W },
			{ W, W, W, S, W, S, W, S, W, S, S, W },
			{ W, S, S, S, W, S, W, W, W, S, S, W },
			{ W, S, W, W, W, S, S, S, S, S, S, W },
			{ W, S, S, S, S, S, S, S, S, W, W, W },
			{ W, S, S, S, W, W, W, S, S, S, S, S },
			{ W, W, W, W, W, S, W, W, W, W, W, W } };
	protected static final String[][] MAP_B = {
			{ W, W, W, W, W, W, W, W, W, W, W, W },
			{ W, S, S, W, S, W, W, W, S, W, W, W },
			{ W, W, S, W, S, W, W, W, S, W, W, W },
			{ W, S, S, W, S, S, S, S, S, S, W, W },
			{ W, S, W, W, S, W, W, W, W, S, W, W },
			{ W, S, S, S, S, W, W, W, W, S, W, W },
			{ W, W, S, W, S, S, P, W, W, W, W, W },
			{ W, W, S, S, W, W, S, S, W, W, S, S },
			{ W, S, W, W, W, W, W, S, W, W, S, W },
			{ W, S, W, W, W, W, W, S, W, W, S, W },
			{ W, S, W, W, S, S, S, S, S, S, S, W },
			{ W, S, S, S, S, W, W, S, W, S, W, W },
			{ W, W, W, W, S, W, W, S, S, S, W, W },
			{ W, W, W, W, W, W, W, W, W, W, W, W },
			{ W, W, W, W, W, S, W, W, W, W, W, W } };
	protected static final String[][] MAP = MAP_A;

}
