package org.usfirst.frc.team1294.robot.commands.auto;

import org.usfirst.frc.team1294.robot.RobotMap.BrakeMode;
import org.usfirst.frc.team1294.robot.commands.auto.drive.AutoDriveOneCommand;
import org.usfirst.frc.team1294.robot.commands.auto.drive.AutoDriveTwoCommand;
import org.usfirst.frc.team1294.robot.commands.auto.gamemech.cans.AutoLiftCansCommand;
import org.usfirst.frc.team1294.robot.commands.drive.SetDriveBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.SetLeft2CANBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.SetRight2CANBrakeModeCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommand extends CommandGroup {
    
    public AutoCommand() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new AutoLiftCansCommand());
    	addSequential(new SetDriveBrakeModeCommand(BrakeMode.BRAKE));
    	addSequential(new AutoDriveOneCommand());
    	addSequential(new AutoDriveTwoCommand());
    	addParallel(new SetLeft2CANBrakeModeCommand(BrakeMode.COAST));
    	addSequential(new SetRight2CANBrakeModeCommand(BrakeMode.COAST));
    	
    }
}
