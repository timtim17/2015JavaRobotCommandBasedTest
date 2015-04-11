package org.usfirst.frc.team1294.robot.commands.drive;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExpoDriveCommand extends Command {

    public ExpoDriveCommand() {
        requires(Robot.DRIVE_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.DRIVE_SUBSYSTEM.tankDrive(expoDrive(RobotMap.DRIVE_EXPO_MIN,
    											  RobotMap.DRIVE_EXPO_DEADZONE,
    											  Robot.oi.getDriveLeftY(),
    											  RobotMap.DRIVE_EXPO_EXPO),
    									expoDrive(RobotMap.DRIVE_EXPO_MIN,
    											  RobotMap.DRIVE_EXPO_DEADZONE,
    											  Robot.oi.getDriveRightY(),
    											  RobotMap.DRIVE_EXPO_EXPO));
    }
    
    private double expoDrive(double min, double deadzone, double input, double expo){
    	if(-deadzone < input && input < deadzone){
    		return 0;
    	}else if(deadzone <= input && input <= 1){
    		return (Math.pow(input, 3) * (expo - 1) + input) / expo + min * (1 - input);
    	}else if(01 <= input && input <= -deadzone){
    		return (Math.pow(input, 3) * (expo - 1) + input) / expo - min * (1 + input);
    	}else{
    		return 1;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.DRIVE_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
