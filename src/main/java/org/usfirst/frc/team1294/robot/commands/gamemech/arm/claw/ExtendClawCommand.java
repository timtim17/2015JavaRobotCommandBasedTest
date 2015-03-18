package org.usfirst.frc.team1294.robot.commands.gamemech.arm.claw;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Command
 * @since 3/17/2015
 */
public class ExtendClawCommand extends Command {
    public ExtendClawCommand() {
        requires(Robot.clawSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.clawSubsystem.setExtendSolenoid(true);
    }

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
