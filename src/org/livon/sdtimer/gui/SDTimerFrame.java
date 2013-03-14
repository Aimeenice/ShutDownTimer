package org.livon.sdtimer.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

import org.livon.sdtimer.tools.Timer;
import javax.swing.JSpinner;

public class SDTimerFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int FRAME_WITDH = 500;
	
	private static final int FRAME_HEIGHT = 150;

	private JPanel contentPane;
	
	private JSpinner txt_hours;
	
	private JSpinner txt_minutes;
	
	private JSpinner txt_seconds;
	
	private JRadioButton rdb_sd;
	
	private JRadioButton rdb_restart;
	
	private JRadioButton rdb_hibernate;
	
	private ButtonGroup rdb_group;

	public JSpinner getTxt_hours() {
		return txt_hours;
	}

	public void setTxt_hours(JSpinner txt_hours) {
		this.txt_hours = txt_hours;
	}

	public JSpinner getTxt_minutes() {
		return txt_minutes;
	}

	public void setTxt_minutes(JSpinner txt_minutes) {
		this.txt_minutes = txt_minutes;
	}

	public JSpinner getTxt_seconds() {
		return txt_seconds;
	}

	public void setTxt_seconds(JSpinner txt_seconds) {
		this.txt_seconds = txt_seconds;
	}

	private JButton launch_button;
	
	private JButton cancel_button;
	
	private Timer timer;
	
	/**
	 * Create the frame.
	 */
	public SDTimerFrame() {
		setResizable(false);
		setSize(FRAME_WITDH, FRAME_HEIGHT);
		setTitle("ShutDow Timer");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		build_content();
	}
	
	public void build_content(){

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdb_sd = new JRadioButton("ShutDown");
		rdb_sd.setBounds(6, 23, 89, 23);
		rdb_sd.setSelected(true);
		contentPane.add(rdb_sd);
		
		rdb_restart = new JRadioButton("Restart");
		rdb_restart.setBounds(97, 23, 68, 23);
		contentPane.add(rdb_restart);
		
		rdb_hibernate = new JRadioButton("Hibernate");
		rdb_hibernate.setBounds(167, 23, 87, 23);
		contentPane.add(rdb_hibernate);
		
		rdb_group = new ButtonGroup();
		rdb_group.add(rdb_sd);
		rdb_group.add(rdb_restart);
		rdb_group.add(rdb_hibernate);
		
		JButton launch_b = new JButton("Launch");
		launch_b.setBounds(206, 79, 89, 23);
		launch_b.addActionListener(new LaunchAction(this));
		setLaunch_button(launch_b);
		contentPane.add(getLaunch_button());
		
		JButton cancel_b = new JButton("Cancel");
		cancel_b.setBounds(313, 79, 89, 23);
		cancel_b.setEnabled(false);
		cancel_b.addActionListener(new CancelAction(this));
		setCancel_button(cancel_b);
		contentPane.add(getCancel_button());
		
		JLabel lblIn = new JLabel("in");
		lblIn.setBounds(260, 27, 14, 14);
		contentPane.add(lblIn);
		
		SpinnerNumberModel hour_spinner_model = new SpinnerNumberModel(
                new Integer(0), // value
                new Integer(0), // min
                new Integer(9), // max
                new Integer(1) // step
                );
		txt_hours = new JSpinner(hour_spinner_model);
		txt_hours.setBounds(284, 24, 39, 20);
		contentPane.add(txt_hours);
		
		SpinnerNumberModel minute_spinner_model = new SpinnerNumberModel(
                new Integer(0), // value
                new Integer(0), // min
                new Integer(59), // max
                new Integer(1) // step
                );
		txt_minutes = new JSpinner(minute_spinner_model);
		txt_minutes.setBounds(349, 24, 39, 20);
		contentPane.add(txt_minutes);
		
		SpinnerNumberModel second_spinner_model = new SpinnerNumberModel(
                new Integer(0), // value
                new Integer(0), // min
                new Integer(59), // max
                new Integer(1) // step
                );
		txt_seconds = new JSpinner(second_spinner_model);
		txt_seconds.setBounds(424, 23, 39, 20);
		contentPane.add(txt_seconds);
		
		JLabel lblHh = new JLabel("HH");
		lblHh.setBounds(327, 27, 21, 14);
		contentPane.add(lblHh);
		
		JLabel lblMm = new JLabel("MM");
		lblMm.setBounds(398, 27, 21, 14);
		contentPane.add(lblMm);
		
		JLabel lblSs = new JLabel("SS");
		lblSs.setBounds(467, 27, 21, 14);
		contentPane.add(lblSs);

	}

	public JRadioButton getRdb_sd() {
		return rdb_sd;
	}

	public void setRdb_sd(JRadioButton rdb_sd) {
		this.rdb_sd = rdb_sd;
	}

	public JRadioButton getRdb_restart() {
		return rdb_restart;
	}

	public void setRdb_restart(JRadioButton rdb_restart) {
		this.rdb_restart = rdb_restart;
	}

	public JRadioButton getRdb_hibernate() {
		return rdb_hibernate;
	}

	public void setRdb_hibernate(JRadioButton rdb_hibernate) {
		this.rdb_hibernate = rdb_hibernate;
	}

	public ButtonGroup getRdb_group() {
		return rdb_group;
	}

	public void setRdb_group(ButtonGroup rdb_group) {
		this.rdb_group = rdb_group;
	}

	public JButton getLaunch_button() {
		return launch_button;
	}

	public void setLaunch_button(JButton launch_button) {
		this.launch_button = launch_button;
	}

	public JButton getCancel_button() {
		return cancel_button;
	}

	public void setCancel_button(JButton cancel_button) {
		this.cancel_button = cancel_button;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}
}
