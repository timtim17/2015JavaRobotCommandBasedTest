package org.usfirst.frc.team1294.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Command
 * @since 3/11/2015
 */
public class AutoDriveCommand extends Command {
    private boolean isDone;

    public AutoDriveCommand() {
        requires(Robot.driveSubsystem);
        isDone = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveSubsystem.driveForwards(5, 75);
        Robot.driveSubsystem.driveForwards(3, 50);
        isDone = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
