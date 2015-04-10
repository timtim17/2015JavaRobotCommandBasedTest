package org.usfirst.frc.team1294.robot.commands.auto.gamemech.cans;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLiftCansCommand extends Command {

    public AutoLiftCansCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.LEFT2CAN_SUBSYSTEM);
    	requires(Robot.RIGHT2CAN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.LEFT2CAN_SUBSYSTEM.move(RobotMap.AUTO_2CANS_SPEED);
    	Robot.RIGHT2CAN_SUBSYSTEM.move(RobotMap.AUTO_2CANS_SPEED);
    	setTimeout(RobotMap.AUTO_2CANS_TIME);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.LEFT2CAN_SUBSYSTEM.stop();
    	Robot.RIGHT2CAN_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
