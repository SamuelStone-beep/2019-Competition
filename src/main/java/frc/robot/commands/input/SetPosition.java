/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.input;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

/**
 * Add your docs here.
 */
public class SetPosition extends InstantCommand {
  private Elevator.Position cargo;
  private Elevator.Position panel;
  
  /**
   * Calls oi.setPosistion(cargo, panel)
   */
  public SetPosition(Elevator.Position cargo, Elevator.Position panel) {
    super();
    this.cargo = cargo;
    this.panel = panel;
  }
  
  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.oi.setPosition(cargo, panel);
  }
  
}
