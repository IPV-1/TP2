package utils;

import com.uqbar.vainilla.UnitVector2D;

public class Velocity {
	
	UnitVector2D uVector;
	double speed;
	
	public Velocity(UnitVector2D uVector, double speed) {
		super();
		this.uVector = uVector;
		this.speed = speed;
	}
	
//	public Velocity getFrom
	
	
	public UnitVector2D getuVector() {
		return uVector;
	}
	public void setuVector(UnitVector2D uVector) {
		this.uVector = uVector;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	

}
