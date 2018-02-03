/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2848.robot;

import org.usfirst.drc.team2848.robot.auton.FollowPath;
import org.usfirst.frc.team2848.robot.commands.goToHeight;
import org.usfirst.frc.team2848.robot.commands.lowerElevator;
import org.usfirst.frc.team2848.robot.commands.raiseElevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick xbox1 = new Joystick(RobotMap.p_xbox1);
	Button a1 = new JoystickButton(xbox1,1);
	Button b1 = new JoystickButton(xbox1,2);
	Button x1 = new JoystickButton(xbox1,3);
	public OI() {
		a1.whileHeld(new raiseElevator(.8));
		b1.whileHeld(new lowerElevator(.5));
		x1.whenPressed(new goToHeight(800));
	}
	
	public double getLeftJoystick() {
		return xbox1.getRawAxis(1);
	}
	
	public double getRightJoystick() {
		return xbox1.getRawAxis (4);
}
}
