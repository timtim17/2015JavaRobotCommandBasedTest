package org.usfirst.frc.team1294.robot;

import org.usfirst.frc.team1294.robot.RobotMap.Mechs;
import org.usfirst.frc.team1294.robot.commands.gamemech.SetMechCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.claw.CloseClawCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.claw.ExtendClawCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.claw.OpenClawCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.arm.claw.RetractClawCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	Joystick leftJoystick = new Joystick(0),
			 rightJoystick = new Joystick(1),
			 armJoystick = new Joystick(2);
	
	Button openClawButton = new JoystickButton(armJoystick, 7),
		   closeClawButton = new JoystickButton(armJoystick, 6),
		   extendClawButton = new JoystickButton(armJoystick, 10),
		   retractClawButton = new JoystickButton(armJoystick, 11),
		   armButton = new JoystickButton(armJoystick, 3),
		   left2CanButton = new JoystickButton(armJoystick, 4),
		   right2CanButton = new JoystickButton(armJoystick, 5);
	
	public OI(){
		openClawButton.whenPressed(new OpenClawCommand());
		closeClawButton.whenPressed(new CloseClawCommand());
		extendClawButton.whenPressed(new ExtendClawCommand());
		retractClawButton.whenPressed(new RetractClawCommand());
		armButton.whenPressed(new SetMechCommand(Mechs.ARM));
		left2CanButton.whenPressed(new SetMechCommand(Mechs.LEFT2CAN));
		right2CanButton.whenPressed(new SetMechCommand(Mechs.RIGHT2CAN));
	}
	
	public double getDriveLeftY(){
		return leftJoystick.getY();
	}
	
	public double getDriveRightY(){
		return rightJoystick.getY();
	}
	
	public double getArmY(){
		return armJoystick.getY();
	}
}

