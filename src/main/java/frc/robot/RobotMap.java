/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
  
  // names of constants should be subsystem_specificPart
  
  public static final int DRIVETRAIN_LEFTMASTER_ID = 11;
  public static final int DRIVETRAIN_LEFT1_ID = 12;
  public static final int DRIVETRAIN_LEFT2_ID = 13;
  public static final int DRIVETRAIN_RIGHTMASTER_ID = 32;
  public static final int DRIVETRAIN_RIGHT1_ID = 33;
  public static final int DRIVETRAIN_RIGHT2_ID = 34;
  
  // joysticks
  public static final int OI_LEFT_ID = 1;
  public static final int OI_RIGHT_ID = 2;
  public static final int OI_OPERATOR_1_ID = 0;
  public static final int OI_OPERATOR_2_ID = 3;
  
  // driver buttons
  public static final int OI_INTAKE_ID = 0;
  public static final int OI_OUTTAKE_ID = 0;
  
  // operator buttons
  public static final int OI_CLIMB_ID = 0;
  public static final int OI_CLIMB_OVERRIDE_ID = 0;
  public static final int OI_MANUAL_OVERRIDE_ID = 0;
  
  // positional buttons
  public static final int OI_CARGO_SHIP_ID = 0;
  public static final int OI_ROCKET_LEVEL_1_ID = 0;
  public static final int OI_ROCKET_LEVEL_2_ID = 0;
  public static final int OI_ROCKET_LEVEL_3_ID = 0;
  public static final int OI_HUMAN_PLAYER_STATION_ID = 0;
  
  // cargo/panel buttons
  public static final int OI_PANEL_SELECTOR = 0;
  public static final int OI_CARGO_SELECTOR = 0;
}
