/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunCentripetalShooter extends CommandBase {
  /**
   * Creates a new RunCentripetalShooter.
   */
  int oldPos = 0;
  int pos = 0;
  long time = 0;
  long oldTime = 0;

  public RunCentripetalShooter() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("wheel 1 speed", 0.5);
    SmartDashboard.putNumber("wheel 2 speed", 0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    oldTime = time;
    time = System.nanoTime();

    oldPos = pos;
    pos = Robot.getEncoderValue();
    SmartDashboard.putNumber("Raw Encoder", pos - oldPos);
    SmartDashboard.putNumber("Current RPM", (pos - oldPos) / 1024.0 * (time - oldTime) / 1_000_000_000.0 * 60.0);
    Robot.spinWheel1(SmartDashboard.getNumber("wheel 1 speed", 0.5) * -1);
    Robot.spinFeeder2(SmartDashboard.getNumber("wheel 2 speed", 0.5));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
