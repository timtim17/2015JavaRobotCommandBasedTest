package org.usfirst.frc.team1294.robot.subsystems.gamemech.arm;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.MoveArmWithJoystickCommand;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.Subsystem
 * @since 3/13/2015
 */
public class ArmLeftSubsystem extends Subsystem {
    AnalogPotentiometer pot = new AnalogPotentiometer(RobotMap.RIGHT_ARM_POT);
    DigitalInput fwdLS = new DigitalInput(RobotMap.LIMIT_ARM_LEFT_FWD),
                            revLS = new DigitalInput(RobotMap.LIMIT_ARM_LEFT_REV);

    CANTalon talon = new CANTalon(RobotMap.MOTOR_ARM_LEFT);

    double fwdSoftLimit = RobotMap.SOFT_LIMIT_ARM_LEFT_FWD,
                  revSoftLimit = RobotMap.SOFT_LIMIT_ARM_LEFT_REV;

    public void move(double movement){
        double potValue = pot.get();
        if(movement < 0){
            if(!(potValue <= revSoftLimit || revLS.get())) talon.set(movement);
        }else{
            if(!(potValue >= fwdSoftLimit || fwdLS.get())) talon.set(movement);
        }
    }

    public void initDefaultCommand() {
        setDefaultCommand(new MoveArmWithJoystickCommand());
    }
}

