package org.usfirst.frc.team1294.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    /* Sensors */
    public static final int LEFT_ARM_POT = 0,
                                            RIGHT_ARM_POT = 1,
                                            LIMIT_ARM_LEFT_FWD = 0,
                                            LIMIT_ARM_LEFT_REV = 1;

    /* Actuators */
    // Motors
    public static final int MOTOR_DRIVE_LEFT = 1,
                                            MOTOR_DRIVE_RIGHT = 2,
                                            MOTOR_ARM_LEFT = 3,
                                            MOTOR_ARM_RIGHT = 4,
                                            MOTOR_2CAN_LEFT = 5,
                                            MOTOR_2CAN_RIGHT = 6;

    // Air
    public static final int PCM = 50,
                                            SOLENOID_EXTEND = 0,
                                            SOLENOID_OPEN = 1;

    /* Constants */
    public static final double PID_ARM_RIGHT_kP = 20,
                                                    PID_ARM_RIGHT_kI = 0,
                                                    PID_ARM_RIGHT_kD = 0,
                                                    MECH_SPEED_MULTIPLIER = .75,
                                                    SOFT_LIMIT_ARM_LEFT_FWD = 0,
                                                    SOFT_LIMIT_ARM_LEFT_REV = 0;
    public static final boolean BRAKE = true,
                                                      COAST = false;
}
