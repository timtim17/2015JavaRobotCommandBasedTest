
package org.usfirst.frc.team1294.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1294.robot.commands.auto.AutoCommand;
import org.usfirst.frc.team1294.robot.commands.drive.DriveSetBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.drive.TankDriveCommand;
import org.usfirst.frc.team1294.robot.subsystems.drive.DriveSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    public static DriveSubsystem driveSubsystem;

    public static Command autoCommand;

	public static OI oi;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();

        driveSubsystem = new DriveSubsystem();

        // instantiate the command used for the autonomous period
        autoCommand = new AutoCommand();

        SmartDashboard.putData(Scheduler.getInstance());
        SmartDashboard.putData(driveSubsystem);
        SmartDashboard.putData(autoCommand);
        SmartDashboard.putData(new TankDriveCommand());
    }

    /**
     * This function is called when auton beings.
     */
    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autoCommand != null) autoCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called when teleop begins.
     */
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autoCommand != null) autoCommand.cancel();

        new DriveSetBrakeModeCommand(DriveSubsystem.COAST);
//        new Set2CANBrakeModeCommand(BRAKE);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){ }

    /**
     * This function is called periodically while disabled.
     */
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
