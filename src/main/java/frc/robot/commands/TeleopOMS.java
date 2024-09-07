package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.OMS;
import frc.robot.gamepad.OI;

public class TeleopOMS extends CommandBase 
{

    /**
     * Bring in DriveTrain and OI
     */
    private static final OMS oms = RobotContainer.oms;
    private static final OI oi = RobotContainer.oi;

    /**
     * Joystick inputs
     */
    boolean up;
    boolean down;
    boolean open;
    boolean close;
    boolean forward;
    boolean backward;
    float deg = 0; 
    float deg1 = 0;

    /**
     * Constructor
     */
    public TeleopOMS ()
    {
        addRequirements(oms);
    }

    /**
     * Code here will run once when the command is called for the first time
     */
    @Override
    public void initialize()
    {
        oms.resetEncoders();
    }

    /**
     * Code here will run continously every robot loop until the command is stopped
     */
    @Override
    public void execute()
    {
        /**
         * Get Joystick data
         */
        up = oi.getDriveRightBumper();
        down = oi.getDriveRightTrigger();
        close = oi.getDriveLeftTrigger();
        open = oi.getDriveLeftBumper();
        forward = oi.getDriveYButton();
        backward = oi.getDriveXButton();

        if (up)
        {
            oms.setElevatorMotorSpeed(-0.5);
        }
        else if (down)
        {
            oms.setElevatorMotorSpeed(0.5);
        }
        else 
        {
            oms.setElevatorMotorSpeed(0.0);
        }
        if (open)
        {
            deg = (deg<300)?deg+5:300;
            oms.setServoPositionClaw(deg);
        }
        if (close)
        {
            deg = (deg>=0)?deg-5:0;
            oms.setServoPositionClaw(deg);
        }
        if (forward)
        {
            deg1 = (deg1<300)?deg1+5:300;
            oms.setServoPositionExtend(deg1);
        }
        if (backward)
        {
            deg1 = (deg1<0)?0:deg1-5;
            oms.setServoPositionExtend(deg1);
        }
    }

    /**
     * When the comamnd is stopped or interrupted this code is run
     * <p>
     * Good place to stop motors in case of an error
     */
    @Override
    public void end(boolean interrupted)
    {
        oms.setElevatorMotorSpeed(0.0);
    }

    /**
     * Check to see if command is finished
     */
    @Override
    public boolean isFinished()
    {
        return false;
    } 
}