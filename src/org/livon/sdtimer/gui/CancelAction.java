package org.livon.sdtimer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelAction implements ActionListener {
	
	private SDTimerFrame timer_frame;

	public CancelAction(SDTimerFrame sdTimerFrame) {
		setTimer_frame(sdTimerFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getTimer_frame().getTimer().setEnabled(false);
		getTimer_frame().getLaunch_button().setText("Launch");
		getTimer_frame().getCancel_button().setEnabled(false);
		getTimer_frame().getTxt_hours().setEnabled(true);
		getTimer_frame().getTxt_minutes().setEnabled(true);
		getTimer_frame().getTxt_seconds().setEnabled(true);
		getTimer_frame().getRdb_hibernate().setEnabled(true);
		getTimer_frame().getRdb_restart().setEnabled(true);
		getTimer_frame().getRdb_sd().setEnabled(true);
		getTimer_frame().getLaunch_button().removeActionListener(getTimer_frame().getLaunch_button().getActionListeners()[0]);
		getTimer_frame().getLaunch_button().addActionListener(new LaunchAction(getTimer_frame()));
	}

	public SDTimerFrame getTimer_frame() {
		return timer_frame;
	}

	public void setTimer_frame(SDTimerFrame sdTimerFrame) {
		this.timer_frame = sdTimerFrame;
	}

}
