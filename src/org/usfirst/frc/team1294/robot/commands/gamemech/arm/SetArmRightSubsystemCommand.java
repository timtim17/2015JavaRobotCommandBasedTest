package org.usfirst.frc.team1294.robot.commands.gamemech.arm;

import org.usfirst.frc.team1294.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmRightSubsystemCommand extends Command {

    public SetArmRightSubsystemCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.ARM_RIGHT_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ARM_RIGHT_SUBSYSTEM.setSetpoint(Robot.ARM_RIGHT_SUBSYSTEM.getLeftPot());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
