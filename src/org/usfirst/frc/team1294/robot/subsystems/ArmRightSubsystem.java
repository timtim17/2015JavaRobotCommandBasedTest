package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.Robot;
import org.usfirst.frc.team1294.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class ArmRightSubsystem extends PIDSubsystem {
	Potentiometer leftPot = new AnalogPotentiometer(RobotMap.POT_ARM_LEFT),
				  rightPot = new AnalogPotentiometer(RobotMap.POT_ARM_RIGHT);
	DigitalInput topLS = new DigitalInput(RobotMap.LS_ARM_RIGHT_TOP),
				 btmLS = new DigitalInput(RobotMap.LS_ARM_RIGHT_BTM);
	
	CANTalon armRight = new CANTalon(RobotMap.MOTOR_ARM_RIGHT);
	
    // Initialize your subsystem here
    public ArmRightSubsystem() {
    	super(RobotMap.PID_ARM_RIGHT_kP, RobotMap.PID_ARM_RIGHT_kI, RobotMap.PID_ARM_RIGHT_kD);
        setOutputRange(-1, 1);
    	enable();
    }
    
    public double getLeftPot(){
    	return leftPot.get();
    }
    
    public double getRightPot(){
    	return rightPot.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return rightPot.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	if(output < 0){
    		if(btmLS.get()) return;
    	}else{
    		if(topLS.get()) return;
    	}
    	armRight.set(output);
    }
}
