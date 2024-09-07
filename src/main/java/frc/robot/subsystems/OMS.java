package frc.robot.subsystems;

import com.studica.frc.Servo;
import com.studica.frc.TitanQuad;
import com.studica.frc.TitanQuadEncoder;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class OMS extends SubsystemBase
{
    /**
     * Motors
     */
    private TitanQuad elevator;
    private Servo claw;
    private Servo twist;
    private Servo extend;

    /**
     * Sensors
     */
    private TitanQuadEncoder elevatorEncoder;

    /**
     * Shuffleboard
     */
    private ShuffleboardTab tab = Shuffleboard.getTab("Training Robot"); 
    private NetworkTableEntry elevatorEncoderValue = tab.add("Elevator Angle", 0)
                                                    .getEntry();

    public OMS ()
    {
        /**
         * Motors
         */
        elevator = new TitanQuad(Constants.TITAN_ID, Constants.elevator_motor);
        claw = new Servo(Constants.grip_servo);
        twist = new Servo(Constants.twist_servo);
        extend = new Servo(Constants.extender_servo);

        /**
         * Sensors
         */
        elevatorEncoder = new TitanQuadEncoder(elevator, Constants.elevator_motor, Constants.ELEVATOR_DIST_TICK);
    }

    /**
     * Sets the speed of the motor
     * <p>
     * @param speed range -1 to 1 (0 stop)
     */
    /*public void setElevator(double degrees)
    {
        elevator.setAngle(degrees);
    }*/

    /**
     * Gets the encoder distance for the elevator motor
     * <p>
     * @return distance traveled in mm
     */

    public void setElevatorMotorSpeed(double speed)
    {
        elevator.set(speed);
    }
    
    public double getElevatorEncoderDistance()
    {
        return elevatorEncoder.getEncoderDistance();
    }

    /**
     * Sets the angle at which the servo is located
     * <p>
     * @param degrees valid input is 0 to 300
     */
    public void setServoPositionClaw(double degrees)
    {
        claw.setAngle(degrees);
    }
    public void setServoPositionTwist(double degrees)
    {
        twist.setAngle(degrees);
    }
    public void setServoPositionExtend(double degrees)
    {
        extend.setAngle(degrees);
    }

    /**
     * Reset the elevator encoder
     */
    public void resetEncoders()
    {
        elevatorEncoder.reset();
    }

    @Override
    public void periodic()
    {
        elevatorEncoderValue.setDouble(getElevatorEncoderDistance());
    }
}