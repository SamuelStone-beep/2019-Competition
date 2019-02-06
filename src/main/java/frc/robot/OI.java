/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Climb;
import frc.robot.commands.CollectHatchPanel;
import frc.robot.commands.IntakeCargo;
import frc.robot.commands.PlaceCargo;
import frc.robot.commands.PlaceHatch;
import frc.robot.commands.ScoreCargo;
import frc.robot.commands.ScoreHatch;
import frc.robot.commands.SetElevator;
import frc.robot.commands.input.CargoMode;
import frc.robot.commands.input.Intake;
import frc.robot.commands.input.ManualMode;
import frc.robot.commands.input.Outtake;
import frc.robot.commands.input.SetPosition;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Elevator.Position;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private Joystick left = new Joystick(RobotMap.OI_LEFT_ID);
  private Joystick right = new Joystick(RobotMap.OI_RIGHT_ID);
  private Joystick operator1 = new Joystick(RobotMap.OI_OPERATOR_1_ID);
  private Joystick operator2 = new Joystick(RobotMap.OI_OPERATOR_2_ID);
  
  /**
   * Gets the left joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public double getLeftJoystick() {
    return -left.getY();
  }
  
  /**
   * Gets the right joystick's position, as a percent of fully pushed
   * 
   * @return the position, in the range of [-1, 1]
   */
  public double getRightJoystick() {
    return -right.getY();
  }
  
  // Auto Routines - need to review button mappings since there are two different
  // intake commands - hatch, cargo.
  private JoystickButton intake = new JoystickButton(left, RobotMap.OI_INTAKE_ID);
  private JoystickButton outtake = new JoystickButton(right, RobotMap.OI_OUTTAKE_ID);
  public JoystickButton rocketLevel1 = new JoystickButton(left, RobotMap.OI_ROCKET_LEVEL_1_ID);
  public JoystickButton rocketLevel2 = new JoystickButton(left, RobotMap.OI_ROCKET_LEVEL_2_ID);
  public JoystickButton rocketLevel3 = new JoystickButton(left, RobotMap.OI_ROCKET_LEVEL_3_ID);
  public JoystickButton cargoShip = new JoystickButton(left, RobotMap.OI_CARGO_SHIP_ID);
  public JoystickButton humanPlayerStation = new JoystickButton(left, RobotMap.OI_HUMAN_PLAYER_STATION_ID);
  
  public JoystickButton cargoMode = new JoystickButton(left, RobotMap.OI_CARGO_SELECTOR_ID);
  public JoystickButton panelMode = new JoystickButton(left, RobotMap.OI_PANEL_SELECTOR_ID);
  
  public JoystickButton climb = new JoystickButton(left, RobotMap.OI_CLIMB_ID);
  
  // Manual Routines
  private JoystickButton manualOverride = new JoystickButton(left, RobotMap.OI_MANUAL_OVERRIDE_ID);
  
  // state variables
  private boolean inManualMode = false;
  private boolean inCargoMode = false;
  private Elevator.Position cargoPos = Position.CargoIntakeHeight;
  private Elevator.Position panelPos = Position.HumanPlayerStation;
  
  // Buttons and their associated commands
  public OI() {
    // intakeCargo.whenPressed(new IntakeCargo());
    // outtakeCargo.whenPressed(new OuttakeCargo()); // placeholder, need a command
    
    // The rocket, cargoship, and climb buttons are overridden by these commands.
    // When the switch is turned off, the commands revert to the above.
    // climbOverride.whenPressed(new ClimbOverrideOn());
    // climbOverride.whenReleased(new ClimbOverrideOff());
    
    // binds inManualMode to change when manualOverrride is flipped
    manualOverride.whenPressed(new ManualMode(true));
    manualOverride.whenReleased(new ManualMode(false));
    
    // binds inCargoMode to change when mode buttons hit
    cargoMode.whenPressed(new CargoMode(true));
    panelMode.whenPressed(new CargoMode(false));
    
    // binds positions to change when the position buttons hit
    rocketLevel1.whenPressed(new SetPosition(Position.RocketLevel1Cargo, Position.RocketLevel1Hatch));
    rocketLevel2.whenPressed(new SetPosition(Position.RocketLevel2Cargo, Position.RocketLevel2Hatch));
    rocketLevel3.whenPressed(new SetPosition(Position.RocketLevel3Cargo, Position.RocketLevel3Hatch));
    cargoShip.whenPressed(new SetPosition(Position.CargoShipCargo, Position.CargoShipHatch));
    humanPlayerStation.whenPressed(new SetPosition(Position.CargoIntakeHeight, Position.HumanPlayerStation));
    
    // binds driver buttons
    intake.whenPressed(new Intake());
    outtake.whenPressed(new Outtake());
    
    // climb button
    climb.whileActive(new Climb());
  }
  
  public void setManualMode(boolean manual) {
    inManualMode = manual;
  }
  
  public void setCargoMode(boolean cargo) {
    inCargoMode = cargo;
  }
  
  public void setPosition(Elevator.Position cargo, Elevator.Position panel) {
    cargoPos = cargo;
    panelPos = panel;
    
    // move the elevator to position when in manual mode
    if (inManualMode) {
      if (inCargoMode) {
        new SetElevator(cargoPos).start();
      } else {
        new SetElevator(panelPos).start();
      }
    }
  }
  
  public void intake() {
    if (inManualMode) {
      if (inCargoMode) {
        new IntakeCargo().start();
      } else {
        new CollectHatchPanel().start();
      }
    } else {
      if (inCargoMode) {
        new IntakeCargo().start();
      } else {
        // TODO switch out for an auto command
        new CollectHatchPanel().start();
      }
    }
  }
  
  public void outtake() {
    if (inManualMode) {
      if (inCargoMode) {
        new PlaceCargo().start();
      } else {
        new PlaceHatch().start();
      }
    } else {
      if (inCargoMode) {
        new ScoreCargo(cargoPos).start();
      } else {
        new ScoreHatch(panelPos).start();
      }
    }
  }
  
  // public void bindCargoShip(boolean isCargoShipManual) {
  // if (isCargoShipManual == true) {
  // // command should just be executed instead of bound to the button
  // new SetElevator(Elevator.Position.CargoShipCargo).start();
  // } else {
  // // new StoreCargoParam().start(); // placeholder, need a command
  // }
  // }
  
  // public void bindCargoRocket(boolean isRocketCargoManual) {
  // if (isRocketCargoManual == true) {
  // new SetElevator(Elevator.Position.RocketLevel1Cargo).start();
  // new SetElevator(Elevator.Position.RocketLevel2Cargo).start();
  // new SetElevator(Elevator.Position.RocketLevel3Cargo).start();
  // } else {
  // rocketLevel1.whenPressed(new AutoRocketLevel1()); // placeholder, need a
  // command
  // rocketLevel2.whenPressed(new AutoRocketLevel2());
  // rocketLevel3.whenPressed(new AutoRocketLevel3());
  // }
  // }
  
  // public void bindClimb(boolean isClimbManual) {
  // if (isClimbManual == true) {
  // climb.whenPressed(new ManualClimb()); // placeholder command
  // } else {
  // climb.whenPressed(new AutoClimb());
  // }
  // }
}
