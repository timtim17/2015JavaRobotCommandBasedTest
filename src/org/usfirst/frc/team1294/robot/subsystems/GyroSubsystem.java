package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GyroSubsystem extends Subsystem {
	Gyro gyro = new Gyro(RobotMap.GYRO);
	
	public GyroSubsystem(){
		gyro.setSensitivity(RobotMap.GYRO_SENSITIVITY);
		gyro.initGyro();
		gyro.reset();
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public double getAngle(){
		return gyro.getAngle();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

