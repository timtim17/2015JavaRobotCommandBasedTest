package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.RobotMap.BrakeMode;
import org.usfirst.frc.team1294.robot.commands.drive.ExpoDriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	Encoder leftDriveEncoder = new Encoder(RobotMap.ENCODER_DRIVE_LEFT_A, RobotMap.ENCODER_DRIVE_LEFT_B, false, Encoder.EncodingType.k4X);
	
    CANTalon leftDrive = new CANTalon(RobotMap.MOTOR_DRIVE_LEFT),
    		 rightDrive = new CANTalon(RobotMap.MOTOR_DRIVE_RIGHT);
    RobotDrive robotDrive = new RobotDrive(leftDrive, rightDrive);
    
    public DriveSubsystem(){
    	leftDriveEncoder.setDistancePerPulse(RobotMap.ENCODER_DRIVE_LEFT_DISTANCE_PER_PULSE);
    	leftDriveEncoder.setMinRate(RobotMap.ENCODER_DRIVE_LEFT_MIN_RATE);
    	leftDriveEncoder.setSamplesToAverage(RobotMap.ENCODER_DRIVE_LEFT_NUMBER_SAMPLES_TO_AVERAGE);
    	
    	robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
    	robotDrive.setSafetyEnabled(false);	// Safety? We don't need safety!: Auto sets the motor speed and then sleeps for a bit, if safety was on the motor would stop once it times out.
    }
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void drive(double forwards, double rotation){
    	robotDrive.drive(forwards, rotation);
    }
    
    public void tankDrive(double left, double right){
    	robotDrive.tankDrive(left, right);
    }
    
    public void setBrakeMode(BrakeMode brakeMode){
    	leftDrive.enableBrakeMode(brakeMode.mode); 
    }
    
    public void stop(){
    	robotDrive.drive(0, 0);
    }
    
    public void resetEncoder(){
    	leftDriveEncoder.reset();
    }
    
    public double getEncoder(){
    	return leftDriveEncoder.getDistance();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ExpoDriveCommand());
    }
}

