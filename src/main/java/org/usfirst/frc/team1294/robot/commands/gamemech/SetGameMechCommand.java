package org.usfirst.frc.team1294.robot.commands.gamemech;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Command
 * @since 3/17/2015
 */
public class SetGameMechCommand extends Command {
    Robot.Mech mech;

    private boolean isDone = false;

    public SetGameMechCommand(Robot.Mech mech) {
        this.mech = mech;
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.currentMech = this.mech;
        isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {}
}
