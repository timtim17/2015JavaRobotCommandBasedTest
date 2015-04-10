package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.ArmLeftJoystickCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmLeftSubsystem extends Subsystem {
	DigitalInput topLS = new DigitalInput(RobotMap.LS_ARM_LEFT_TOP),
				 btmLS = new DigitalInput(RobotMap.LS_ARM_LEFT_BTM);
	
	CANTalon talon = new CANTalon(RobotMap.MOTOR_ARM_LEFT);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void move(double movement){
		if(movement < 0){
			if(RobotMap.SOFTLIMIT_ARM_LEFT_BTM >= Robot.ARM_RIGHT_SUBSYSTEM.getLeftPot() || btmLS.get()) return;
		}else{
			if(RobotMap.SOFTLIMIT_ARM_LEFT_TOP <= Robot.ARM_RIGHT_SUBSYSTEM.getLeftPot() || topLS.get()) return;
		}
		talon.set(movement);
	}
	
	public void stop(){
		talon.set(0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ArmLeftJoystickCommand());
    }
}

