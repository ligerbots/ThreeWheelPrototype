/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.revrobotics.CANSparkMax;

public class RunPIDShooter extends CommandBase {
/**
   * Creates a new RunCentripetalShooter.
   */
  int oldPos = 0;
  int pos = 0;
  long time = 0;
  long oldTime = 0;

  boolean sameHood = false;
  double old = 0;

  public static CANSparkMax wheel1;
  public static CANSparkMax wheel2;
  public static CANSparkMax wheel3;

  public RunPIDShooter() {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("wheel 1 speed", 0.5);
    SmartDashboard.putNumber("servo angle", 45);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*oldTime = time;
    time = System.nanoTime();
    

    oldPos = pos;
    pos = Robot.getEncoderValue();
    SmartDashboard.putNumber("Raw Encoder", pos - oldPos);
    SmartDashboard.putNumber("Current RPM", (pos - oldPos) / 1024.0 * (time - oldTime) / 1_000_000_000.0 * 60.0); */

    wheel2.follow(wheel1);
    wheel3.follow(wheel1);

    if (SmartDashboard.getNumber("servo angle", 45) == old) {
      sameHood = true;
    }
    else {
      sameHood = false;
    }
    old = SmartDashboard.getNumber("servo angle", 45);


}
a