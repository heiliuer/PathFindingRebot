package com.maze.view;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import com.maze.sprite.FindRoad;

public class MainMaze {
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				final SimpleFrame frame = new SimpleFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				final MapComponent mapcomponent = new MapComponent(frame);
				frame.getContentPane().add(mapcomponent);
				frame.addKeyListener(mapcomponent);
				frame.addWindowStateListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						super.windowClosed(e);
						frame.removeKeyListener(mapcomponent);
					}
				});
				// 菜单
				JMenuBar menuBar = new JMenuBar();
				frame.setJMenuBar(menuBar);
				JMenu roadMenu = new JMenu("寻路");
				menuBar.add(roadMenu);
				JMenuItem roadItem = new JMenuItem("自动寻路(enter)");
				roadMenu.add(roadItem);
				roadItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						new FindRoad(mapcomponent, mapcomponent, mapcomponent
								.getProw(), mapcomponent.getPline()).go();
					}
				});

			}
		});

	}
}
