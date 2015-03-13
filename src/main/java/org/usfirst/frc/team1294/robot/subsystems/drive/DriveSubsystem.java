package org.usfirst.frc.team1294.robot.subsystems.drive;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.drive.TankDriveCommand;

/**
 * Subsystem to control the drive motors.
 *
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Subsystem
 * @see edu.wpi.first.wpilibj.RobotDrive
 * @since 3/10/2015
 */

public class DriveSubsystem extends Subsystem {
    Encoder leftDriveEncoder = new Encoder(0, 1, false, CounterBase.EncodingType.k4X);

    CANTalon driveLeft = new CANTalon(RobotMap.MOTOR_DRIVE_LEFT),
                         driveRight =  new CANTalon(RobotMap.MOTOR_DRIVE_RIGHT);
    RobotDrive robotDrive = new RobotDrive(driveLeft, driveRight);

    public DriveSubsystem(){
        leftDriveEncoder.setDistancePerPulse(0.002635);
        leftDriveEncoder.setMinRate(0.01);
        leftDriveEncoder.setSamplesToAverage(1);
    }

    /**
     * Method to drive the RobotDrive with a tank drive.
     *
     * @param left Left side movement.
     * @param right Right side movement.
     */
    public void tankDrive(double left, double right){
        robotDrive.tankDrive(left, right);
    }

    /**
     * Method to drive the RobotDrive forwards for a specified distance and speed using the encoder.
     *
     * @param distance Distance to move forwards in feet. Can be off.
     * @param speedInPercent Speed to drive on a scale of 0 to 100. Typically should be negative on most drive systems, but should be noticed in testing.
     */
    public void driveForwards(double distance, int speedInPercent){
        leftDriveEncoder.reset();

        double speed = -(speedInPercent/100);

        while(leftDriveEncoder.getDistance() < distance){
            robotDrive.arcadeDrive(speed, 0);
        }

        stop();
    }

    /**
     * Method to stop the robot drive.
     */
    public void stop(){
        robotDrive.arcadeDrive(0, 0);
    }

    public static final boolean BRAKE = true;
    public static final boolean COAST = false;

    /**
     * Method to set the brake mode of the drive CANTalons.
     *
     * @param brakeMode Should be either <code>DriveSubsystem.BRAKE</code> or <code>DriveSubsystem.COAST</code>
     */
    public void setBrakeMode(boolean brakeMode){
        driveLeft.enableBrakeMode(brakeMode);
        driveRight.enableBrakeMode(brakeMode);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveCommand());
    }
}

