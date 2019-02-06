/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.CargoIntake;
import frc.robot.subsystems.CargoScorer;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.HatchClaw;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.NavX;
import frc.robot.subsystems.Sensors;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static CargoIntake cargoIntake = new CargoIntake();
  public static CargoScorer cargoScorer = new CargoScorer();
  public static Drivetrain drivetrain = new Drivetrain();
  public static Elevator elevator = new Elevator();
  public static HatchClaw hatchClaw = new HatchClaw();
  public static Climber climber = new Climber();
  public static Limelight limelight = new Limelight();
  public static NavX navX = new NavX();
  public static Sensors sensors = new Sensors();
  public static OI oi;
  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    oi = new OI();
  }
  
  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }
  
  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
    clear();
  }
  
  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }
  
  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    clear();
    // Start autonomous commands
  }
  
  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }
  
  @Override
  public void teleopInit() {
    clear();
    // start teleop commands
  }
  
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }
  
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
  
  /**
   * Clears and resets the robot. Should be run every time the robot inits any
   * mode.
   */
  public void clear() {
    Scheduler.getInstance().removeAll();
    cargoIntake.zero();
    cargoIntake.stop();
    cargoScorer.zero();
    cargoScorer.stop();
    drivetrain.zero();
    drivetrain.stop();
    elevator.zero();
    elevator.stop();
    hatchClaw.zero();
    hatchClaw.stop();
    limelight.zero();
    limelight.stop();
    navX.zero();
    navX.stop();
    sensors.zero();
    sensors.stop();
  }
}
