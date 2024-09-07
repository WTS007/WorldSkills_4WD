/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public final class Constants
{

    /**
     * CAN ID's
     */
    public static final int TITAN_ID                    = 42;

    /**
     * Drive Base Constants
     */
        /**
         * Motors
         */
        public static final int M0                      = 0; //Right Motor
        public static final int M1                      = 3; //Left Motor
        public static final int M3                      = 1; //Back Motor
        public static final int elevator_motor          = 2;
        /**
         * Encoders
         */
        
        // Omni wheel radius
        public static final double wheelRadius          = 51; //mm

        // Encoder pulse per revolution
        public static final double pulsePerRevolution   = 1440;

        // Gear Ratio between encoder and wheel 
        public static final double gearRatio            = 1/1;

        // Pulse per revolution of wheel
        public static final double wheelPulseRatio      = pulsePerRevolution * gearRatio;

        // Distance per tick
        public static final double WHEEL_DIST_PER_TICK  = (Math.PI * 2 * wheelRadius) / wheelPulseRatio;

    /**
     * Elevator Constants
     */
        /**
         * Motors
         */
        public static final int extender_servo          = 0;
        public static final int twist_servo             = 1;
        public static final int grip_servo              = 2;

        /**
         * Encoder
         */

        // Radius of the belt pully
        public static final double pulleyRadius         = 7.85; //mm

        // Encoder pulses per revolution
        public static final double pulsePerRevElevator  = 1440;

        // Gear ratio between encoder and pulley
        public static final double elevatorGearRatio    = 2/1;

        // Pulse per revolution of pulley
        public static final double pulleyPulseRatio     = pulsePerRevElevator * elevatorGearRatio;

        // Distance per tick
        public static final double ELEVATOR_DIST_TICK   = (Math.PI * 2 * pulleyRadius) / pulleyPulseRatio;
}