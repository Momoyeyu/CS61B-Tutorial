
// Import statement
import java.lang.Math;

/** The targeted class Planet
 * @source
 */
public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, 
				double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}
	
	public double calcDistance(Planet other) {
		final double dx = this.xxPos - other.xxPos;
		final double dy = this.yyPos - other.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}
		
	public double calcForceExertedBy(Planet other) {
		final double r = this.calcDistance(other);		
		return (G * this.mass * other.mass) / (r * r);
	}

	public double calcForceExertedByX(Planet other) {
		return this.calcForceExertedBy(other) * (other.xxPos - this.xxPos) / this.calcDistance(other);
	}

	public double calcForceExertedByY(Planet other) {
		return this.calcForceExertedBy(other) * (other.yyPos - this.yyPos) / this.calcDistance(other);
	}

	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double netf = 0;
		for(Planet p : allPlanets) {
			netf += this.calcForceExertedByX(p);
		}
		return netf;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double netf = 0;
		for(Planet p : allPlanets) {
			netf += this.calcForceExertedByY(p);
		}
		return netf;
	}

	public void update(double dt, double fx, double fy) {
		double ax = fx / this.mass;
		double ay = fy / this.mass;
		xxVel = xxVel + dt * ax;
		yyVel = yyVel + dt * ay;
		this.xxPos = xxPos + dt * xxVel;
		this.yyPos = yyPos + dt * yyVel;
		return;
	}


}	

