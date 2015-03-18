package org.usfirst.frc.team1294.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1294.robot.RobotMap;
import org.usfirst.frc.team1294.robot.commands.drive.DriveSetBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.SetLeft2CANBrakeModeCommand;
import org.usfirst.frc.team1294.robot.commands.gamemech.cans.SetRight2CANBrakeModeCommand;

/**
 * @author Austin
 * @see edu.wpi.first.wpilibj.command.CommandGroup
 * @since 3/11/2015
 */
public class AutoCommand extends CommandGroup {
    public AutoCommand() {
        addSequential(new Raise2CANCommand());
        addSequential(new DriveSetBrakeModeCommand(RobotMap.BRAKE));
        addSequential(new AutoDriveCommand());
        addSequential(new SetLeft2CANBrakeModeCommand(RobotMap.COAST));
        addSequential(new SetRight2CANBrakeModeCommand(RobotMap.COAST));
    }
}
