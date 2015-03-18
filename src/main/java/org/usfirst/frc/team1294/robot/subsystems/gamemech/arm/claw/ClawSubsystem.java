package org.usfirst.frc.team1294.robot.subsystems.gamemech.arm.claw;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1294.robot.RobotMap;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Subsystem
 * @since 3/17/2015
 */
public class ClawSubsystem extends Subsystem {
    Compressor compressor = new Compressor(RobotMap.PCM);
    Solenoid openSolenoid = new Solenoid(RobotMap.PCM, RobotMap.SOLENOID_OPEN),
                      extendSolenoid = new Solenoid(RobotMap.PCM, RobotMap.SOLENOID_EXTEND);

    public ClawSubsystem(){
        compressor.setClosedLoopControl(true);
    }

    public void setOpenSolenoid(boolean mode){
        openSolenoid.set(mode);
    }

    public void setExtendSolenoid(boolean mode){
        extendSolenoid.set(mode);
    }

    public void initDefaultCommand() {}
}

