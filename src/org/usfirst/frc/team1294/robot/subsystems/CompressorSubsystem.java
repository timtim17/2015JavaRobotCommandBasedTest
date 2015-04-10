package org.usfirst.frc.team1294.robot.subsystems;

import org.usfirst.frc.team1294.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CompressorSubsystem extends Subsystem {
	Compressor compressor = new Compressor(RobotMap.PCM);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setCompressor(boolean on){
		compressor.setClosedLoopControl(on);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

