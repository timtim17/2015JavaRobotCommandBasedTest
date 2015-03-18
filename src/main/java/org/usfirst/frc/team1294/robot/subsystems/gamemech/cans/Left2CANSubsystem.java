package org.usfirst.frc.team1294.robot.subsystems.gamemech.cans;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.MoveLeft2CanCommand;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Subsystem
 * @since 3/13/2015
 */
public class Left2CANSubsystem extends Subsystem {
    CANTalon talon = new CANTalon(RobotMap.MOTOR_2CAN_LEFT);

    public Left2CANSubsystem(){
        // Reverse the output of the Talon so that it doesn't go backwards
        talon.reverseOutput(true);
    }

    public void move(double movement){
        talon.set(movement);
    }

    /**
     * Method to set the brake mode of the  CANTalon.
     *
     * @param brakeMode Should be either <code>RobotMap.BRAKE</code> or <code>RobotMap.COAST</code>
     * @see org.usfirst.frc.team1294.robot.RobotMap
     */
    public void setBrakeMode(boolean brakeMode){
        talon.enableBrakeMode(brakeMode);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new MoveLeft2CanCommand());
    }
}

