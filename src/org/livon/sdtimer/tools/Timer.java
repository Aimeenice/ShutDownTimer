package org.livon.sdtimer.tools;

import java.io.IOException;

import org.livon.sdtimer.clock.Clock;
import org.livon.sdtimer.gui.SDTimerFrame;

public class Timer extends Thread {

	private Clock target_time;
	
	private SDTimerFrame timer_frame;
	
	private boolean timer_enabled;

	private boolean timer_paused;
	
	public Timer(Clock targ_time, SDTimerFrame sdTimerFrame){
		this.target_time = targ_time;
		this.setTimer_frame(sdTimerFrame);
		this.timer_enabled = true;
	}
	
	public void run(){
		while(target_time.getTimeLeft() != 0){
			synchronized (this) {
				if(getPause()){
					try {
						this.wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				getTimer_frame().getTxt_hours().setValue(target_time.getHour());
				getTimer_frame().getTxt_minutes().setValue(target_time.getMinute());
				getTimer_frame().getTxt_seconds().setValue(target_time.getSecond());
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				target_time.retrieveSeconde();
				if(!this.isEnabled()) break;
			}
		}
		if(this.isEnabled()){
			String exec_command = "";
			if(getTimer_frame().getRdb_sd().isSelected()){
				exec_command = "shutdown -s -t 0";
			}
			else if(getTimer_frame().getRdb_restart().isSelected()){
				exec_command = "shutdown -r -t 0";
			}
			else{
				exec_command = "shutdown -h";
			}
			try {
				Runtime.getRuntime().exec(exec_command);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

	public SDTimerFrame getTimer_frame() {
		return timer_frame;
	}

	public void setTimer_frame(SDTimerFrame sdTimerFrame) {
		this.timer_frame = sdTimerFrame;
	}
	
	public Clock getTarget_Time(){
		return this.target_time;
	}
	
	public void setTarget_Time(Clock c){
		this.target_time = c;
	}
	
	public boolean isEnabled() {
		return timer_enabled;
	}

	public void setEnabled(boolean timer_enabled) {
		this.timer_enabled = timer_enabled;
	}

	public void setPause(boolean b) {
		this.timer_paused = b;
	}
	
	public boolean getPause(){
		return this.timer_paused;
	}
}
