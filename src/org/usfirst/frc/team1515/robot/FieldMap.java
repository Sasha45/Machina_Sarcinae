package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.util.coordsystem.Point;

public class FieldMap {

	// start position
    public static final Point START_LEFT = new Point(62, 17);
    public static final Point START_RIGHT = new Point(298, 17);
    public static final Point START_CENTER = new Point(182, 17);
    
    // offsets for turning
    private static final int offsetDistance = 24;
    public static final Point CENTER_OFFSET = new Point(182, 41);
    
	// left
    public static final Point LEFT_BASELINE = new Point(62, 168);
    public static final Point LEFT_SWITCH = new Point(70, 168);
    public static final Point LEFT_SCALE = new Point(56, 324); 

	// right
    public static final Point RIGHT_BASELINE = new Point(298, 168);
    public static final Point RIGHT_SWITCH = new Point(290, 168);
    public static final Point RIGHT_SCALE = new Point(304, 324); 

	// center to left switch
    public static final Point CENTER_LEFT_MIDPOINT = new Point(131, 50);
    public static final Point CENTER_LEFT_SWITCH = new Point(131, 90);

	// center to right switch
    public static final Point CENTER_RIGHT_MIDPOINT = new Point(230, 50);
    public static final Point CENTER_RIGHT_SWITCH = new Point(230, 90);

}
