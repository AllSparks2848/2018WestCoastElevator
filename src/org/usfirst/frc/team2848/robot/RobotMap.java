/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2848.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static int p_leftDrive1 = 0;
	public static int p_leftDrive2 = 1;
	public static int p_leftDrive3 = 2;
	public static int p_rightDrive1 = 3;
	public static int p_rightDrive2 = 4;
	public static int p_rightDrive3 = 5;

	public static int p_liftMotor = 6;
	
	public static int p_LEDs = 7;
	

	public static int p_liftEncoderA = 0;
	public static int p_liftEncoderB = 1;
	
	public static int p_stringPot = 0;

	public static int p_xbox1 = 0;
}
