package org.usfirst.frc.team1294.robot.commands.gamemech.cans;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap.Mechs;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Left2CANJoystickCommand extends Command {

    public Left2CANJoystickCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.LEFT2CAN_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.selectedMech == Mechs.LEFT2CAN){
    		Robot.LEFT2CAN_SUBSYSTEM.move(Robot.oi.getArmY());
    	}else{
    		Robot.LEFT2CAN_SUBSYSTEM.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.LEFT2CAN_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
