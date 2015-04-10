package org.usfirst.frc.team1294.robot.commands.gamemech.cans;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap.MECH;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Right2CANJoystickCommand extends Command {

    public Right2CANJoystickCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.RIGHT2CAN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.selectedMech == MECH.RIGHT2CAN){
    		Robot.RIGHT2CAN_SUBSYSTEM.move(Robot.oi.getArmY());
    	}else{
    		Robot.RIGHT2CAN_SUBSYSTEM.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.RIGHT2CAN_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
