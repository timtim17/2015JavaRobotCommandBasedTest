package org.usfirst.frc.team1294.robot.commands.drive;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap.BrakeMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetDriveBrakeModeCommand extends Command {

    public SetDriveBrakeModeCommand(BrakeMode mode) {
        requires(Robot.DRIVE_SUBSYSTEM);
    	Robot.DRIVE_SUBSYSTEM.setBrakeMode(mode);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
