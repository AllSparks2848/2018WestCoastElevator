package org.usfirst.frc.team2848.robot.commands;

import org.usfirst.frc.team2848.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class lowerElevator extends Command {
	public double power = 0;
    public lowerElevator(double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.power = power;
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.lowerElevator(power);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.liftMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.liftMotor.set(0);
    }
}
