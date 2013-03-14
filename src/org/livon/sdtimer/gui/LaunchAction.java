package org.livon.sdtimer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.livon.sdtimer.clock.Clock;
import org.livon.sdtimer.clock.EmptyClockException;
import org.livon.sdtimer.tools.Timer;

public class LaunchAction implements ActionListener {
	
	private boolean launch_action;
	
	private boolean resume;

	private SDTimerFrame timer_frame;
	
	public LaunchAction(SDTimerFrame sdTimerFrame) {
		setTimer_frame(sdTimerFrame);
		launch_action = true;
		resume = false;
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		if(launch_action){
			if(resume){
				synchronized (getTimer_frame().getTimer()) {
					getTimer_frame().getLaunch_button().setText("Pause");
					getTimer_frame().getTimer().setPause(false);
					getTimer_frame().getTimer().notify();
				}
			}
			else{
				int hours = (int)getTimer_frame().getTxt_hours().getValue();
				int minutes = (int)getTimer_frame().getTxt_minutes().getValue();
				int seconds = (int)getTimer_frame().getTxt_seconds().getValue();
				if(hours == 0 && minutes == 0 && seconds == 0) return;
				getTimer_frame().getLaunch_button().setText("Pause");
				getTimer_frame().getCancel_button().setEnabled(true);
				getTimer_frame().getTxt_hours().setEnabled(false);
				getTimer_frame().getTxt_minutes().setEnabled(false);
				getTimer_frame().getTxt_seconds().setEnabled(false);
				getTimer_frame().getRdb_hibernate().setEnabled(false);
				getTimer_frame().getRdb_restart().setEnabled(false);
				getTimer_frame().getRdb_sd().setEnabled(false);
	
				try {
					Clock c = new Clock(hours, minutes, seconds);
					Timer t = new Timer(c, getTimer_frame());
					getTimer_frame().setTimer(t);
					t.start();
				} catch (EmptyClockException e1) {
					e1.printStackTrace();
				}
			}
			this.launch_action = false;
		}
		else{
			this.launch_action = true;
			this.resume = true;
			getTimer_frame().getTimer().setPause(true);
			getTimer_frame().getLaunch_button().setText("Launch");
		}
	}

	public SDTimerFrame getTimer_frame() {
		return timer_frame;
	}

	public void setTimer_frame(SDTimerFrame sdTimerFrame) {
		this.timer_frame = sdTimerFrame;
	}

}
