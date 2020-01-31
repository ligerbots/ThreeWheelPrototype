/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public static TalonSRX wheel1;
  public static TalonSRX wheel2;
  public static TalonSRX wheel3;

  public static TalonSRX feeder1;
  public static TalonSRX feeder2;
  public static TalonSRX feeder3;

  public static RunCentripetalShooter shooterCommand;



  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    wheel1 = new TalonSRX(10);
    //wheel2 = new TalonSRX(14);
    wheel2 = new TalonSRX(2);
    wheel3 = new TalonSRX(4);

    feeder1 = new TalonSRX(11);
    feeder2 = new TalonSRX(6);
    //feeder3 = new TalonSRX(6);

    feeder1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
    shooterCommand = new RunCentripetalShooter();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  public static void spinWheel1 (double speed) {
    wheel1.set(ControlMode.PercentOutput, speed);
  }

  public static void spinWheel2 (double speed) {
    wheel2.set(ControlMode.PercentOutput, speed);
  }

  public static void spinWheel3 (double speed) {
    wheel3.set(ControlMode.PercentOutput, speed);
  }

  public static void spinFeeder1 (double speed) {
    feeder1.set(ControlMode.PercentOutput, speed);
  }

  public static void spinFeeder2 (double speed) {
    feeder2.set(ControlMode.PercentOutput, speed);
  }

  public static void spinFeeder3 (double speed) {
    feeder3.set(ControlMode.PercentOutput, speed);
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  @Override
  public void teleopInit() {
    // TODO Auto-generated method stub
    super.teleopInit();
    wheel1.setSelectedSensorPosition(0);
    shooterCommand.schedule();
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public static int getEncoderValue () {
    //return wheel1.getSelectedSensorPosition();
    return feeder1.getSelectedSensorPosition();
  }
}
