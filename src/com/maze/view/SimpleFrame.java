package com.maze.view;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame {
	private static final long serialVersionUID = 23L;

	public SimpleFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("迷宫");
		setLocation(200, 100);
		setResizable(false);
	}
}
