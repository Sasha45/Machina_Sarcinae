package org.usfirst.frc.team1515.robot.util.coordsystem;
public class Point {
    final double inchesX;
    final double inchesY;
    
    public Point(int inchesX, double inchesY) {
        this.inchesX = inchesX;
        this.inchesY = inchesY;
    }
    
    public Point(double feetX, double feetY) {
        this((int) (12 * feetX), (int) (12 * feetY));
    }
    
    public double getX() {
        return this.inchesX;
    }
    
    public double getY() {
        return this.inchesY;
    }

    @Override
    public String toString() {
        return "(" + Double.toString(inchesX) + ", " + Double.toString(inchesY) + ")";
    }
}
