package org.usfirst.frc.team1294.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1294.robot.commands.drive.DriveSetBrakeModeCommand;
import org.usfirst.frc.team1294.robot.subsystems.drive.DriveSubsystem;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.CommandGroup
 * @since 3/11/2015
 */
public class AutoCommand extends CommandGroup {
    public AutoCommand() {
//        addSequential(new Raise2CANCommand());
        addSequential(new DriveSetBrakeModeCommand(DriveSubsystem.BRAKE));
        addSequential(new AutoDriveCommand());
//        addSequential(new Set2CANBrakeModeCommand(COAST));
    }
}
