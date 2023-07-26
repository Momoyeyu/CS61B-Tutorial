
// -*- coding:utf-8 -*-
// Use UTF-8 for coding

/** The targeted class NBody
 * @source
 */
public class NBody {
	
	public static void main(String[] args) {
		// Check args
		if (args.length < 3) {
			System.out.println("[Error}: Missing parameter!");
			return;
		}
		
		// Enable double buffering
		StdDraw.enableDoubleBuffering();

		// Collect All Needed Input
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		final String filePath = args[2];
		double r = readRadius(filePath);
		Planet[] planets = readPlanets(filePath);
		
		// Draw the Background
		final String bgimg = "images/starfield.jpg";
		StdDraw.setScale(-r, r);
		StdDraw.clear();
		StdDraw.picture(0, 0, bgimg);

		// Play the BGM
		StdAudio.play("audio/2001.mid");
		
		// Draw All the Planets
		for (Planet p : planets) 
			p.draw();
		StdDraw.show();

		// Creating an Animation
		int N = planets.length;
		double time = 0;
		while (time <= T) {
			double[] xForces = new double[N];
			double[] yForces = new double[N];
			for (int i = 0; i < N; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for (int i = 0; i < N; i++)
				planets[i].update(dt, xForces[i], yForces[i]);

			StdDraw.clear();
			StdDraw.picture(0, 0, bgimg);
			for (Planet p : planets)
				p.draw();
			StdDraw.show();
			StdDraw.pause(10);

			time += dt;
		}

		return;
	}
	

	public static double readRadius(String filePath) {
		In in = new In(filePath);
		int N = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	
	public static Planet[] readPlanets(String filePath) {
		In in = new In(filePath);
		int N = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[N];

		for(int i = 0; i < N; i++) {
			double xp = in.readDouble();
			double yp = in.readDouble();
			double xv = in.readDouble();
			double yv = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xp, yp, xv, yv, m, img);
		}
		return planets;
	}

}


