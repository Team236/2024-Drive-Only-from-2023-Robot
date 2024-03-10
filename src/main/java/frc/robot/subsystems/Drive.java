// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;


public class Drive extends SubsystemBase {
  public CANSparkMax leftFront, leftRear, rightFront, rightRear;
  private XboxController xboxController;
  private boolean isDeadzone;
 

  /** Creates a new ExampleSubsystem. */
  public Drive() {
    leftFront = new CANSparkMax(Constants.MotorControllers.ID_LEFT_FRONT, MotorType.kBrushless);
    leftRear = new CANSparkMax(Constants.MotorControllers.ID_LEFT_REAR, MotorType.kBrushless);
    rightFront = new CANSparkMax(Constants.MotorControllers.ID_RIGHT_FRONT, MotorType.kBrushless);
    rightRear = new CANSparkMax(Constants.MotorControllers.ID_RIGHT_REAR, MotorType.kBrushless);

    leftFront.restoreFactoryDefaults();
    rightFront.restoreFactoryDefaults();

    leftFront.setInverted(true); //testbed = true, 
    rightFront.setInverted(false); // testbed = false, 

    leftRear.follow(leftFront);
    rightRear.follow(rightFront);

    leftFront.setSmartCurrentLimit(40);
    rightFront.setSmartCurrentLimit(40);
    leftRear.setSmartCurrentLimit(40);
    rightRear.setSmartCurrentLimit(40); 


   xboxController = new XboxController(Constants.ControllerConstants.USB_DRIVECONTROLLER);
 
  isDeadzone = Constants.DriveConstants.IS_DEADZONE;
  }
  


     public void closedRampRate() {
      leftFront.setClosedLoopRampRate(0.08);
      rightFront.setClosedLoopRampRate(0.08);
    }
  
    public void openRampRate() {
      leftFront.setOpenLoopRampRate(0.08);
      rightFront.setOpenLoopRampRate(0.08);
    }

  public void setLeftSpeed(double speed) {
    leftFront.set(speed);
  }

  public void setRightSpeed(double speed) {
    rightFront.set(speed);
  }

  public void setBothSpeeds(double speed) {
    rightFront.set(speed);
    leftFront.set(speed);
  }
  public void setTurnSpeeds(double speed) {
    leftFront.set(speed);
    rightFront.set(-speed);
  }
  public void setLeftSpeedWithDeadzone(double speed) {
    double leftSpeed = speed;
    if(leftSpeed < DriveConstants.LEFT_DEADZONE && leftSpeed > -DriveConstants.LEFT_DEADZONE) {
      leftSpeed = 0;
    } 
    setLeftSpeed(leftSpeed);
  }

  public void setRightSpeedWithDeadzone(double speed) {
    double rightSpeed = speed;
    if(rightSpeed < DriveConstants.RIGHT_DEADZONE && rightSpeed > -DriveConstants.RIGHT_DEADZONE) {
      rightSpeed = 0;
    } 
    setRightSpeed(rightSpeed);
  }

 
  public void stop() {
    leftFront.stopMotor();
    rightFront.stopMotor();
  }

  @Override
  public void periodic() {
  //SmartDashboard.getBoolean("In Low Gear?", inLowGear());
  // SmartDashboard.putNumber("left enc", getLeftEncoder());

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}