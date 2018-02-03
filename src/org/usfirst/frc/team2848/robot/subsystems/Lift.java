package org.usfirst.frc.team2848.robot.subsystems;

import org.usfirst.frc.team2848.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *14.5 Off ground
 *293
 *652
 *78.5
 *
 *
 *65 - 600
 *
 *652-293
 *
 *78.5-14.5
 *
 *
 *each tick is approx .1783
 *
 *
 *.12
 *
 *
 *
 *
 *
 *
 * 
 */
public class Lift extends PIDSubsystem {
	private static double p = .05;
	private static double i = .01;
	private static double d = .025;
	
	private static double maxOutputChange = .1;
	private double previousOutput = 0;
	
	
	public Spark liftMotor = new Spark(RobotMap.p_liftMotor);

	public Encoder liftEncoder = new Encoder(RobotMap.p_liftEncoderA, RobotMap.p_liftEncoderB, false, EncodingType.k4X);

	
	public AnalogInput ai = new AnalogInput(1);
	public Potentiometer pot = new AnalogPotentiometer(ai, 360, 30);

	
	public Lift() {
		super(p, i, d);
		liftEncoder.setMaxPeriod(.1);
		liftEncoder.setMinRate(10);
		liftEncoder.setDistancePerPulse(5);
		liftEncoder.setReverseDirection(false);
		
		
		

		// TODO Auto-generated constructor stub
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		
		
		
		return (liftEncoder.get());
	}

	@Override
	protected void usePIDOutput(double output) {
		
//		if (output - previousOutput > maxOutputChange){
//			liftMotor.pidWrite(output + maxOutputChange);
//			previousOutput = output + maxOutputChange;
//			}
//		else {
//			liftMotor.pidWrite(output);
//			previousOutput = output;
//			}
//			
		
		liftMotor.pidWrite(-output);
//	
		// TODO Auto-generated method stub

	}

	public void raiseElevator(double power) {
		liftMotor.set(-power);

	}

	public void lowerElevator(double power) {
		liftMotor.set(power);

	}

}
