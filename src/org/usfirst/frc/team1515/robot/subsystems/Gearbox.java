package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.RobotMap;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.PIDController;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gearbox extends Subsystem {
	
	private MotorModule motorModule;
	
	public Gearbox(int[] talonPorts) {
		motorModule = new MotorModule(talonPorts);
		
	}

	public void setSpeed(double speed) {
		motorModule.setSpeed(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
