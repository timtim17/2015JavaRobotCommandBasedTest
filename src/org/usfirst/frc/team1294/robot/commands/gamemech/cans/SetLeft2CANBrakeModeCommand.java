package org.usfirst.frc.team1294.robot.commands.gamemech.cans;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap.BrakeMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetLeft2CANBrakeModeCommand extends Command {

    public SetLeft2CANBrakeModeCommand(BrakeMode mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.LEFT2CAN_SUBSYSTEM);
    	Robot.LEFT2CAN_SUBSYSTEM.setBrakeMode(mode);
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
