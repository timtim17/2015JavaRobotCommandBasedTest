package org.usfirst.frc.team1294.robot.subsystems.gamemech.arm;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.RightArmFollowCommand;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.PIDSubsystem
 * @since 3/13/2015
 */
public class ArmRightSubsystem extends PIDSubsystem {
    Potentiometer leftPot = new AnalogPotentiometer(RobotMap.LEFT_ARM_POT),
                                rightPot = new AnalogPotentiometer(RobotMap.RIGHT_ARM_POT);

    CANTalon talon = new CANTalon(RobotMap.MOTOR_ARM_RIGHT);

    public ArmRightSubsystem() {
        super(RobotMap.PID_ARM_RIGHT_kP, RobotMap.PID_ARM_RIGHT_kI, RobotMap.PID_ARM_RIGHT_kD);
        setSetpoint(leftPot.get());
        setOutputRange(-1, 1);
        enable();
    }

    // Since we've enabled PID control, that runs as an automatic command, we don't need a default command.
    public void initDefaultCommand() {setDefaultCommand(new RightArmFollowCommand());}

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer
        return rightPot.get();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        talon.set(output);
    }

    public double getLeftPotValue(){
        return leftPot.get();
    }
}
