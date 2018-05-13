package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.RobotMap;
import org.usfirst.frc.team1515.robot.Controls;
import org.usfirst.frc.team1515.robot.commands.JoystickDrive;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class KitDrive extends Subsystem {
	
	public Gearbox leftGearbox;
	public Gearbox rightGearbox;
	
	private static final double ROTATE_SIDE = 1.0;
	private static final double ROTATE_CORNER = 0.25;

	private static final double DEADBAND_FORWARD = 0.15;
	private static final double DEADBAND_TWIST = 0.05;
	
	private static double trim = 0.825;

	// change sign to change direction
	private int factor = -1; 
	
	public KitDrive(int[] leftTalonPorts, int[] rightTalonPorts 
	) {
		leftGearbox = new Gearbox(leftTalonPorts);
		rightGearbox = new Gearbox(rightTalonPorts);
		
	}
	
	public void setSpeed(double speed) {
		leftGearbox.setSpeed(speed * factor);
		rightGearbox.setSpeed(-speed * factor * trim);
	}
	
	public void setSpeeds(double leftSpeed, double rightSpeed) {
		leftGearbox.setSpeed(leftSpeed * factor);
		rightGearbox.setSpeed(-rightSpeed * factor * trim);
	}

	public void stop() {
		setSpeed(0);
	}
	
	public void reverse() {
		factor *= -1;
	}
	
	public void drive() {
		double forward = Robot.driveStick.getRawAxis(Controls.Y_AXIS);
		double twist = Robot.driveStick.getRawAxis(Controls.TWIST);
		double throttle = Robot.driveStick.getRawAxis(Controls.THROTTLE);
		double turnSpeed = Robot.driveStick.getRawAxis(Controls.TURN_SPEED);
		
		forward = Math.abs(forward) > DEADBAND_FORWARD ? forward : 0;
		twist = Math.abs(twist) > DEADBAND_TWIST ? twist : 0;
		
		turnSpeed = (1 + turnSpeed)/2;
		throttle = (throttle - 1)/2;
		forward *= throttle;
		twist *= -turnSpeed;
		
		double y = Math.abs(forward);
		double x = Math.abs(twist);
		double a = ROTATE_SIDE;
		double b = ROTATE_CORNER;
		
		double left = a * x + y * (1 - a * x);
		double right = y * (1 + (a + b - 1) * x) - a * x;
		if (forward < 0) {
			left *= -1;
			right *= -1;
			twist *= -1;
		}
		if (twist > 0) {
			double temp = left;
			left = right;
			right = temp;
		}
		setSpeeds(left, right);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}

}
