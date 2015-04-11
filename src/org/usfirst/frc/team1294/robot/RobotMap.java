package org.usfirst.frc.team1294.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;	
	
	public static final int MOTOR_DRIVE_LEFT = 1,
							MOTOR_DRIVE_RIGHT = 2,
							MOTOR_ARM_LEFT = 3,
							MOTOR_ARM_RIGHT = 4,
							MOTOR_2CAN_LEFT = 5,
							MOTOR_2CAN_RIGHT = 6;
	
	public static final int PCM = 50;
							
	public static final int SOLENOID_CLAW_OPEN = 0,
							SOLENOID_CLAW_EXTEND = 1;
	
	public static final int ENCODER_DRIVE_LEFT_A = 0,
							ENCODER_DRIVE_LEFT_B = 1,
							ENCODER_DRIVE_LEFT_NUMBER_SAMPLES_TO_AVERAGE = 1;
	public static final double ENCODER_DRIVE_LEFT_DISTANCE_PER_PULSE = 0.002635,
							   ENCODER_DRIVE_LEFT_MIN_RATE = 0.01;
	
	public static final int GYRO = 0;
	public static final double GYRO_SENSITIVITY = 0.012637;
	
	public static final int POT_ARM_LEFT = 0,
							POT_ARM_RIGHT = 0;
	
	public static final int LS_ARM_LEFT_TOP = 0,
							LS_ARM_LEFT_BTM = 0,
							LS_ARM_RIGHT_TOP = 0,
							LS_ARM_RIGHT_BTM = 0;
	
	public static final double PID_ARM_RIGHT_kP = 20,
							   PID_ARM_RIGHT_kI = 0,
							   PID_ARM_RIGHT_kD = 0;
	
	public static final double SOFTLIMIT_ARM_LEFT_TOP = 0,
							   SOFTLIMIT_ARM_LEFT_BTM = 0;
	
	public static final double AUTO_DRIVE_DISTANCE_1 = 0,
							   AUTO_DRIVE_DISTANCE_2 = 0,
							   AUTO_DRIVE_SPEED_1 = 0,
							   AUTO_DRIVE_SPEED_2 = 0,
							   AUTO_2CANS_SPEED = 0,
							   AUTO_2CANS_TIME = 0;
	
	public static final double DRIVE_EXPO_MIN = 0.2,
							   DRIVE_EXPO_DEADZONE = 0.03,
							   DRIVE_EXPO_EXPO = 1.75;
	
	public static enum Mechs {ARM, LEFT2CAN, RIGHT2CAN}
	
	public static enum BrakeMode{
		BRAKE(true), COAST(false);
		
		public final boolean mode;
		
		private BrakeMode(boolean mode) {
			this.mode = mode;
		}
	}
}
