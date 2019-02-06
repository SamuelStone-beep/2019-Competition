/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.input;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Outtake extends InstantCommand {
  /**
   * Calls oi.outtake()
   */
  public Outtake() {
    super();
  }
  
  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.oi.outtake();
  }
  
}
