package org.usfirst.frc.team2848.robot.subsystems;

import org.usfirst.frc.team2848.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	Spark leftDrive1 = new Spark(RobotMap.p_leftDrive1);
	Spark leftDrive2 = new Spark(RobotMap.p_leftDrive2);
	Spark leftDrive3 = new Spark(RobotMap.p_leftDrive3);
	Spark rightDrive1 = new Spark(RobotMap.p_rightDrive1);
	Spark rightDrive2 = new Spark(RobotMap.p_rightDrive2);
	Spark rightDrive3 = new Spark(RobotMap.p_rightDrive3);
	
	RobotDrive drive1 = new RobotDrive(leftDrive1, leftDrive2, rightDrive1, rightDrive2);
	RobotDrive drive2 = new RobotDrive(leftDrive3, rightDrive3);
	
	public Spark LEDs = new Spark(RobotMap.p_LEDs);

    public void initDefaultCommand() {
        
    }
    
    public void arcadeDrive(double left, double right){
    	drive1.arcadeDrive(-left, -right);
    }
}

