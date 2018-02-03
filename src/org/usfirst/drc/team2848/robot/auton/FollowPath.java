package org.usfirst.drc.team2848.robot.auton;

import org.usfirst.frc.team2848.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class FollowPath extends Command {

	// Variables
	private double totalTime = .5; // Sample value 5 sec
	private double timeStep = .01; // 100 ms default 20: changed for time testing purposes.

	private double distanceTraveled = 5;

	private double robotTrackWidth = 1.97125; // 2 feet
	private double waypointPath[][] = new double[][] { { 0, 0 }, { 0, distanceTraveled } }; // Points measured in feet

	private double encTicksFoot = 276; // Sample number -- need testing
	private double maxVelocity = 12.5; // Sample
	private int totalSteps = 0;

	private double kP = 0;
	private double kA = 0;
	private double kV = 1 / maxVelocity;

	private int stepCount = 0;
	private double leftError;
	private double leftError2;
	private double rightError;
	private double rightError2;

	FalconPathPlanner path = new FalconPathPlanner(waypointPath);
	// Jared 254 Copied Implementation Code:
	/*
	 * // For each side of the drive... while (following) { //
	 * desired_position,desired_velocity, and desired_acceleration are all generated
	 * by your profile. position_error = desired_position[i] - actual_position;
	 * command[i] = Kv * desired_velocity[i] + Ka * desired_acceleration[i] + Kp *
	 * position_error;
	 */

	public FollowPath() {
		requires(Robot.lift);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		path.calculate(totalTime, timeStep, robotTrackWidth);
		stepCount = 0;
		totalSteps = path.leftPath.length;
		Robot.lift.enable();

		// for(int i = 0; i< path.smoothLeftVelocity.length; i++) {
		// System.out.println(path.smoothLeftVelocity[i][0]);
		// }
		// System.out.println("\n\n\n\n");
		// for(int i = 0; i< path.smoothLeftVelocity.length; i++) {
		// System.out.println(path.smoothLeftVelocity[i][1]);
		// }
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		// leftError =
		// path.leftPath[stepCount][0]-Robot.drivetrain.leftEncoder.get()*encTicksFoot;
		// leftError2 =
		// path.leftPath[stepCount][1]-Robot.drivetrain.leftEncoder.get()*encTicksFoot;
		// rightError =
		// path.rightPath[stepCount][0]-Robot.drivetrain.rightEncoder.get()*encTicksFoot;
		// rightError2 =
		// path.rightPath[stepCount][1]-Robot.drivetrain.rightEncoder.get()*encTicksFoot;

		// +path.rightPath[stepCount][1]

		// double leftMotorPower =
		// kV*path.smoothLeftVelocity[stepCount][1]+kA*((path.smoothLeftVelocity[stepCount][1]-path.smoothLeftVelocity[stepCount][1])/timeStep)+kP*leftError;
		// double rightMotorPower =
		// kV*path.smoothRightVelocity[stepCount][1]+kA*((path.smoothRightVelocity[stepCount][1]-path.smoothRightVelocity[stepCount][1])/timeStep)+kP*rightError;
		//

		// if(stepCount>0) {
		// leftMotorPower =
		// kV*path.smoothLeftVelocity[stepCount][1]+kA*((path.smoothLeftVelocity[stepCount][1]-path.smoothLeftVelocity[stepCount-1][1])/timeStep)+kP*leftError;
		// rightMotorPower =
		// kV*path.smoothRightVelocity[stepCount][1]+kA*((path.smoothRightVelocity[stepCount][1]-path.smoothRightVelocity[stepCount-1][1])/timeStep)+kP*rightError;
		// }

		// System.out.println(leftMotorPower);
		// Robot.lift.liftMotor.set(leftMotorPower);

		// PID code

		Robot.lift.setSetpoint(path.smoothLeftVelocity[stepCount][1]);

		stepCount++;

		// System.out.println("Total Steps: "+totalSteps);
		//
		// System.out.println("Step Count: "+stepCount);

	}

	protected boolean isFinished() {
		// Set up method that evaluates current step and total steps.
		if (totalSteps == stepCount) {
			return true;
		} else {
			return false;
		}
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.lift.liftMotor.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
