package org.usfirst.frc.team2848.robot.commands;

import org.usfirst.frc.team2848.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class goToHeight extends Command {
double height = 0;
    public goToHeight(double h) {
    	height = h;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.liftEncoder.reset();
    	Robot.lift.enable();
    	Robot.lift.setOutputRange(-.4, .6);
    	Robot.lift.setSetpoint(height);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Encoder Reading: " + Robot.lift.liftEncoder.get());
    
    	
        if(Math.abs((height - Robot.lift.liftEncoder.get())) <= 1) {
        	return true;
        }
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.liftMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
