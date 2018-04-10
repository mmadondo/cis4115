
public class dataPoint {

	 final int num_parameters=2;		// number of parameters or characteristics for each data point
	 //public double[] x = new double[num_parameters];	// the parameters for this data point
	 public double x;				// holds the height
	 public double y;				// holds the circumf.
	 public int type;				// the classification or type of this data point
	 public String label;			// label for this data point

	 public dataPoint(double newx, double newy, String newlabel){
		 x = newx;
		 y = newy;
		 label = newlabel;
	 }
	 
/*	 
 	public dataPoint(double[] newx){
		 for (int i=0; i<newx.length; i++) {
			 x[i] = newx[i];
		 }
	 }
*/
	 
	 public void setRandom() {
		 x = Math.random()*70;
		 y = Math.random()*30;
		 System.out.print("Set new random mean "+type+" to :");
		 display();
/*		 
		 for (int i=0; i<x.length; i++) {
			 x[i] = Math.random()*100;
		 }
		 
*/	 }
	 
	 public double distanceTo(dataPoint p2) {
		 double dist=0;
		 dist = Math.sqrt( Math.pow(x - p2.x,2) + Math.pow(y - p2.y,2));
/*		 
		 for (int i=0; i<x.length; i++) {
			 dist += Math.pow(x[i] - p2.x[i],2);
		 }
		 dist = Math.sqrt(dist);
		 
*/		 return dist;
	 }
	 
	 public void display() {
		 System.out.println(label+" at x = "+x+" and y = "+y);
		 //System.out.println(type+" at x = "+x[0]+" and y = "+x[1]);
	 }
	 
	 public dataPoint copy() {
		 return(new dataPoint(x,y,label));
	 }
	 
}


