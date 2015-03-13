package org.usfirst.frc.team1294.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1294.robot.Robot;

/**
 * Command to drive tank drive with two joysticks.
 *
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Command
 * @since 3/10/2015
 */
public class TankDriveCommand extends Command {
    public TankDriveCommand() {
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveSubsystem.tankDrive(Robot.oi.leftStick.getY(), Robot.oi.rightStick.getY());
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
