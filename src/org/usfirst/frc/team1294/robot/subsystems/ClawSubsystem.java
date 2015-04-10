package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawSubsystem extends Subsystem {
    Solenoid openSolenoid = new Solenoid(RobotMap.SOLENOID_CLAW_OPEN),
    		 extendSolenoid = new Solenoid(RobotMap.SOLENOID_CLAW_EXTEND);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void setOpenClawSolenoid(boolean open){
    	openSolenoid.set(open);
    }
    
    public void setExtendClawSolenoid(boolean extend){
    	extendSolenoid.set(extend);
    }

    public void initDefaultCommand() {}
}

