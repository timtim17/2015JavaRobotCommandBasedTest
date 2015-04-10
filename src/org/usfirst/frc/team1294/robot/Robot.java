
package org.usfirst.frc.team1294.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.StartCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1294.robot.RobotMap.BrakeMode;
import org.usfirst.frc.team1294.robot.RobotMap.MECH;
import org.usfirst.frc.team1294.robot.commands.StartCompressorCommand;
import org.usfirst.frc.team1294.robot.commands.auto.AutoCommand;
import org.usfirst.frc.team1294.robot.commands.drive.SetDriveBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.SetArmRightSubsystemCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.SetLeft2CANBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.SetRight2CANBrakeModeCommand;
import org.usfirst.frc.team1294.robot.subsystems.ArmLeftSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.ArmRightSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.ClawSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.CompressorSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.GyroSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.Left2CANSubsystem;
import org.usfirst.frc.team1294.robot.subsystems.Right2CANSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static final DriveSubsystem DRIVE_SUBSYSTEM = new DriveSubsystem();
	public static final ArmLeftSubsystem ARM_LEFT_SUBSYSTEM = new ArmLeftSubsystem();
	public static final ArmRightSubsystem ARM_RIGHT_SUBSYSTEM = new ArmRightSubsystem();
	public static final ClawSubsystem CLAW_SUBSYSTEM = new ClawSubsystem();
	public static final Left2CANSubsystem LEFT2CAN_SUBSYSTEM = new Left2CANSubsystem();
	public static final Right2CANSubsystem RIGHT2CAN_SUBSYSTEM = new Right2CANSubsystem();
	public static final CompressorSubsystem COMPRESSOR_SUBSYSTEM = new CompressorSubsystem();
	public static final GyroSubsystem GYRO_SUBSYSTEM = new GyroSubsystem();
	
	public static OI oi;

    private static Command autonomousCommand;
    
    public static MECH selectedMech = MECH.ARM;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutoCommand();
        new StartCompressorCommand().start();
    }
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){}
	
    @Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}	
	
	@Override
    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    @Override
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        new SetDriveBrakeModeCommand(BrakeMode.COAST).start();
        new SetLeft2CANBrakeModeCommand(BrakeMode.BRAKE).start();
        new SetRight2CANBrakeModeCommand(BrakeMode.BRAKE).start();
        
        new SetArmRightSubsystemCommand().start();
    }    

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
        log();
    }
    
    public void log(){
    	SmartDashboard.putData(Scheduler.getInstance());
    	SmartDashboard.putData(DRIVE_SUBSYSTEM);
    	SmartDashboard.putData(ARM_LEFT_SUBSYSTEM);
    	SmartDashboard.putData(ARM_RIGHT_SUBSYSTEM);
    	SmartDashboard.putData(CLAW_SUBSYSTEM);
    	SmartDashboard.putData(LEFT2CAN_SUBSYSTEM);
    	SmartDashboard.putData(RIGHT2CAN_SUBSYSTEM);
    	SmartDashboard.putData(COMPRESSOR_SUBSYSTEM);
    	SmartDashboard.putData(GYRO_SUBSYSTEM);
    	SmartDashboard.putNumber("Gyro Angle", GYRO_SUBSYSTEM.getAngle());
    }
}
