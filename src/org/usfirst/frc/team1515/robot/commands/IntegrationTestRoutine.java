package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntegrationTestRoutine extends CommandGroup {

    public IntegrationTestRoutine() {
    	addSequential(new DriveForward(36, 0.5));
        addSequential(new DriveForward(36, -0.5));
        addSequential(new Delay(0.5));
       
        addSequential(new OpenIntake());
        addSequential(new Delay(0.5));
        addSequential(new CloseIntake());
        addSequential(new Delay(0.5));
  
        addSequential(new PurgeExchange(0.5));
        addSequential(new IntakeCube(0.5));
        addSequential(new Delay(0.5));
       
        addSequential(new RaiseElevator(1.5));
        addSequential(new LowerElevator(1.5));
    }
}
