/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DataGrabber extends CommandBase {
  /**
   * Creates a new DataGrabber.
   */

  File dataFile = new File("data.txt");

  public DataGrabber() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    try {
      if (dataFile.createNewFile()) {
        System.out.println("Created data file");
      }
      else {
        System.out.println("Now appending to data file");
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
