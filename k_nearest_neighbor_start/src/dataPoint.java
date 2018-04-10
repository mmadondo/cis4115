
public class dataPoint {

	 public double x;				// holds the height
	 public double y;				// holds the circumf.
	 public String type;			// type of object, "Tree" or "Bush"
	 
	 public dataPoint(double newx, double newy, String newtype){
		 x = newx;
		 y = newy;
		 type = newtype;
	 }
	 
	 public dataPoint(double newx, double newy){
		 x = newx;
		 y = newy;
		 type = "unknown";
	 }
	 
	 public double distanceTo(dataPoint p2) {
		 double dist;
		 dist = Math.pow(x - p2.x,2);
		 dist += Math.pow(y - p2.y,2);
		 dist = Math.sqrt(dist);
		 return dist;
	 }
	 
	 public void display() {
		 System.out.println(type+" at x = "+x+" and y = "+y);
	 }
	 
}


