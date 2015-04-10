package org.usfirst.frc.team1294.robot.commands.auto.drive;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveOneCommand extends Command {

    public AutoDriveOneCommand() {
        requires(Robot.DRIVE_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.DRIVE_SUBSYSTEM.resetEncoder();
		Robot.DRIVE_SUBSYSTEM.drive(RobotMap.AUTO_DRIVE_SPEED_1, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.DRIVE_SUBSYSTEM.getEncoder() >= RobotMap.AUTO_DRIVE_DISTANCE_1;
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
