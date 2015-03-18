package org.usfirst.frc.team1294.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1294.robot.Robot;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Command
 * @since 3/11/2015
 */
public class DriveSetBrakeModeCommand extends Command {
    private boolean brakeMode;

    /**
     * @param brakeMode Brake mode for drive CANTalons. Should be either <code>RobotMap.BRAKE</code> or <code>RobotMap.COAST</code>
     * @see org.usfirst.frc.team1294.robot.RobotMap
     */
    public DriveSetBrakeModeCommand(boolean brakeMode) {
        requires(Robot.driveSubsystem);
        this.brakeMode = brakeMode;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveSubsystem.setBrakeMode(this.brakeMode);
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
