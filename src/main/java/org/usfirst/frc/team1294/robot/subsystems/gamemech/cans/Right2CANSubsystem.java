package org.usfirst.frc.team1294.robot.subsystems.gamemech.cans;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.MoveRight2CanCommand;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Subsystem
 * @since 3/13/2015
 */
public class Right2CANSubsystem extends Subsystem {
    CANTalon talon = new CANTalon(RobotMap.MOTOR_2CAN_RIGHT);

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
        setDefaultCommand(new MoveRight2CanCommand());
    }
}

