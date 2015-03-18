package org.usfirst.frc.team1294.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1294.robot.commands.gamemech.SetGameMechCommand;

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

    private static Joystick leftStick = new Joystick(0),
                                               rightStick = new Joystick(1),
                                               armStick = new Joystick(2);

    private static Button left2CANButton = new JoystickButton(armStick, 3),
                                           armButton = new JoystickButton(armStick, 4),
                                           right2CANButton = new JoystickButton(armStick, 5);

    public OI() {
        left2CANButton.whenPressed(new SetGameMechCommand(Robot.Mech.LEFT2CAN));
        armButton.whenPressed(new SetGameMechCommand(Robot.Mech.ARM));
        right2CANButton.whenPressed(new SetGameMechCommand(Robot.Mech.RIGHT2CAN));
    }

    public double getDriveLeft(){
        return leftStick.getY();
    }

    public double getDriveRight(){
        return rightStick.getY();
    }

    public double getMechY(){
        return armStick.getY() * RobotMap.MECH_SPEED_MULTIPLIER;
    }
}

