// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class ArcadeDrive extends Command {
  private Drive drive;
  //private Boolean isDeadzone = Constants.DriveConstants.IS_DEADZONE;
  //private double max, L, R, sensitivityX,sensitivityY;
  private double leftSpeed, rightRotation;
  private XboxController driveController;
  private DifferentialDrive diffDrive;

  /** Creates a new DoubleArcadeDrive. */
  public ArcadeDrive(Drive drive1, XboxController driveController, DifferentialDrive diffDrive) {
    this.drive = drive1;
    this.driveController = driveController;
    this.diffDrive = diffDrive; 
    addRequirements(drive);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //this.isDeadzone = true;
    drive.openRampRate();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftSpeed = -driveController.getLeftY();
    rightRotation = -driveController.getRightX();
    diffDrive.arcadeDrive(leftSpeed, rightRotation);

    //OLD CODE
    // Adjust the Y speed so the robot drives straight (no angle change) when X
    // (turn) input is low
    // change all signs before getLeftX for 2022 robot (and also before gyro error correction factor?)

   // SmartDashboard.putNumber("Controller Left Stick X Value:", driveController.getLeftX());
    //SmartDashboard.putNumber( "Controller Right Stick Y Value:", driveController.getRightY());
   // getRightY is negative when driving forward.  getLeftX and navX.getRate are positive Clockwise.
    //change 0.05 /  0.05 to refer to Constants - Deadzone
  
   /*  if (drive.inLowGear()) {
      sensitivityX = 1;
      sensitivityY = 1;
     } else if (!drive.inLowGear()) {
       sensitivityX = 0.9;
       sensitivityY = 0.9; //0.75
     }
*/
   /*     sensitivityX = 0.9;
       sensitivityY = 0.9; //0.75  

    if ((Math.abs(driveController.getLeftX()) > 0.05) && (Math.abs(driveController.getRightY()) <= 0.05)) {
      L = driveController.getLeftX()*sensitivityX;
      R = -driveController.getLeftX()*sensitivityX;
    } else if ((Math.abs(driveController.getLeftX()) <= 0.05) && (Math.abs(driveController.getRightY()) <= 0.05)) {
      L = (0);
      R = (0);
    } else if ((Math.abs(driveController.getLeftX()) > 0.05) && (Math.abs(driveController.getRightY()) > 0.05)) {
      L = -driveController.getRightY()*sensitivityY + driveController.getLeftX()*sensitivityX;
      R = -driveController.getRightY()*sensitivityY - driveController.getLeftX()*sensitivityX;
    } else {
      L = (-driveController.getRightY()*sensitivityY);
      R = (-driveController.getRightY()*sensitivityY); 
    }
  
    
    max = Math.abs(L);
    if (max < Math.abs(R)) {
      max = Math.abs(R);
    }

    if (max > 1) {
      L /= max;
      R /= max;
    }
    // SmartDashboard.putNumber("left arcade speed", L);
    // SmartDashboard.putNumber("right Arcade speed", R);

    drive.setLeftSpeed(L);
    drive.setRightSpeed(R);
   // SmartDashboard.putNumber("Arcade Drive Left Encoder", drive.getLeftDistance());
    //SmartDashboard.putNumber("Roll in Arcade Drive", drive.getRoll());
   //gripper.autoGrab(); */
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.stop();
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}