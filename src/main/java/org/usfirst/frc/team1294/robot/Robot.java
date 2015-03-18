
package org.usfirst.frc.team1294.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1294.robot.commands.auto.AutoCommand;
import org.usfirst.frc.team1294.robot.commands.drive.DriveSetBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.drive.TankDriveCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.SetLeft2CANBrakeModeCommand;
import org.usfirst.frc.team1294.robot.subsystems.drive.DriveSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.gamemech.arm.ArmLeftSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.gamemech.arm.ArmRightSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.gamemech.arm.claw.ClawSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.gamemech.cans.Left2CANSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.gamemech.cans.Right2CANSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    public static DriveSubsystem driveSubsystem;
    public static Left2CANSubsystem left2CANSubsystem;
    public static Right2CANSubsystem right2CANSubsystem;
    public static ArmLeftSubsystem armLeftSubsystem;
    public static ArmRightSubsystem armRightSubsystem;
    public static ClawSubsystem clawSubsystem;

    public static Command autoCommand;

	public static OI oi;

    public static enum Mech  {ARM, LEFT2CAN, RIGHT2CAN};
    public static Mech currentMech = Mech.ARM;

    private CameraServer camServer;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveSubsystem = new DriveSubsystem();
        left2CANSubsystem = new Left2CANSubsystem();
        right2CANSubsystem = new Right2CANSubsystem();
        armLeftSubsystem = new ArmLeftSubsystem();
        armRightSubsystem = new ArmRightSubsystem();
        clawSubsystem = new ClawSubsystem();

        oi = new OI();

        // instantiate the command used for the autonomous period
        autoCommand = new AutoCommand();

        SmartDashboard.putData(Scheduler.getInstance());
        SmartDashboard.putData(driveSubsystem);
        SmartDashboard.putData(autoCommand);
        SmartDashboard.putData(new TankDriveCommand());

        camServer = CameraServer.getInstance();
        camServer.setQuality(50);
        camServer.setSize(2);
        camServer.startAutomaticCapture("cam0");
    }

    /**
     * This function is called when auto beings.
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

        new DriveSetBrakeModeCommand(RobotMap.COAST);
        new SetLeft2CANBrakeModeCommand(RobotMap.BRAKE);
        new SetLeft2CANBrakeModeCommand(RobotMap.BRAKE);
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
