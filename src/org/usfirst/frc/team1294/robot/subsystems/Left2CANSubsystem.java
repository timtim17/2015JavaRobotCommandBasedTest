package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.RobotMap.BrakeMode;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.Left2CANJoystickCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Left2CANSubsystem extends Subsystem {
	public CANTalon talon = new CANTalon(RobotMap.MOTOR_2CAN_LEFT);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void move(double movement){
		talon.set(movement);
	}
	
	public void stop(){
		talon.set(0);
	}
	
	public void setBrakeMode(BrakeMode brakeMode) {
		talon.enableBrakeMode(brakeMode.mode);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new Left2CANJoystickCommand());
    }	
}

