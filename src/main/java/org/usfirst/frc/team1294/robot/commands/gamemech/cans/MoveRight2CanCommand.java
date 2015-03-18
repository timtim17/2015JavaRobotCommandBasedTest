package org.usfirst.frc.team1294.robot.commands.gamemech.cans;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Command
 * @since 3/15/2015
 */
public class MoveRight2CanCommand extends Command {
    public MoveRight2CanCommand() {
        requires(Robot.right2CANSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(Robot.currentMech == Robot.Mech.RIGHT2CAN) Robot.left2CANSubsystem.move(Robot.oi.getMechY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.right2CANSubsystem.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
