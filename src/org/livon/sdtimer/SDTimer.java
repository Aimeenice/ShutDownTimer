package org.livon.sdtimer;

import javax.swing.SwingUtilities;

import org.livon.sdtimer.gui.SDTimerFrame;

public class SDTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//TimerFrame fenetre = new TimerFrame();
				SDTimerFrame fenetre = new SDTimerFrame();
				fenetre.setVisible(true);
			}
		});
	}
}
