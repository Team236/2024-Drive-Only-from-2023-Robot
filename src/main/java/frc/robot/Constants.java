// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.sendable.Sendable;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class ControllerConstants {

    public static final int USB_AUXCONTROLLER = 1;
    public static final int USB_DRIVECONTROLLER = 0;
    public static class Thrustmaster {
        public static final int TRIGGER = 1;
        public static final int BUTTON_MIDDLE = 2;
        public static final int BUTTON_LEFT = 3;
        public static final int BUTTON_RIGHT = 4;
        public static final int LEFT_BASE_1 = 11;
        public static final int LEFT_BASE_2 = 16;
        public static final int LEFT_BASE_3 = 13;
        public static final int LEFT_BASE_4 = 14;
        public static final int RIGHT_BASE_5 = 7;
        public static final int RIGHT_BASE_6 = 8;
        public static final int RIGHT_BASE_7 = 5;
        public static final int RIGHT_BASE_8 = 10;

        public static class AxesThrustmaster {
            public static final int X = 0;
            public static final int Y = 1;
            public static final int Z = 2;
            public static final int THROTTLE = 3;
        }       
    }
    public static class XboxController {
      public static final int A = 1;
      public static final int B = 2;
      public static final int X = 3;
      public static final int Y = 4;
      public static final int LB = 5;
      public static final int RB = 6;
      public static final int VIEW = 7;
      public static final int MENU = 8;
      public static final int LM = 9;
      public static final int RM = 10;

      public static class AxesXbox {
        public static final int LX = 0;
        public static final int LY = 1;
        public static final int LTrig = 2;
        public static final int RTrig = 3;
        public static final int RX = 4;
        public static final int RY = 5;
      }
      public class POVXbox {
        public static final int UP_ANGLE = 0;
        public static final int RIGHT_ANGLE = 90;
        public static final int DOWN_ANGLE = 180;
        public static final int LEFT_ANGLE = 270;
      }
    }
    public static class LogitechF310 {
        // ****when controller is in DirectInput mode (use slider on the back of the controller)
        public static final int A = 2;
        public static final int B = 3;
        public static final int X = 1;
        public static final int Y = 4;
        public static final int LB = 5;
        public static final int RB = 6;
        public static final int BACK = 9;
        public static final int START = 10;
        public static final int LEFT_PRESS = 7;
        public static final int RIGHT_PRESS = 8;
        public class AxesController {
            public static final int LEFT_X = 0;
            public static final int LEFT_Y = 1;
            public static final int LT = 2;
            public static final int RT = 3;
            public static final int RIGHT_X = 4;
            public static final int RIGHT_Y = 5;
        }

        public class POVController {
          public static final int UP_ANGLE = 0;
          public static final int RIGHT_ANGLE = 90;
          public static final int DOWN_ANGLE = 180;
          public static final int LEFT_ANGLE = 270;
        }
    }
}
  public static class MotorControllers {
    public static final int ID_LEFT_FRONT = 35; 
    public static final int ID_RIGHT_FRONT = 59; 
    public static final int ID_LEFT_REAR = 58;
    public static final int ID_RIGHT_REAR = 32;
    }


public static class DriveConstants {
  public static final double LEFT_DEADZONE = 0.17; //0.15???
  public static final double RIGHT_DEADZONE = 0.17;
  public static final double DEADBAND = 0.17;
  //public static final boolean IS_DEADZONE = true;
}

}

  