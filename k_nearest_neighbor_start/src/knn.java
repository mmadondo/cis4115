
public class knn {

	public static void main(String[] args) {
		dataPoint[] data = new dataPoint[6];
		
		data[0] = new dataPoint(40.0,14.0,"Tree");
		data[1] = new dataPoint(35.0,23.0,"Tree");
		data[2] = new dataPoint(29.0,19.0,"Tree");
		data[3] = new dataPoint(19.0,9.0,"Bush");
		data[4] = new dataPoint(9.0,12.0,"Bush");
		data[5] = new dataPoint(10.0,5.0,"Bush");
		
		dataPoint new_point = new dataPoint(17,20);
		int smallIndex = 0;
                double smallDist = data[smallIndex].distanceTo(new_point);
		for (int i=0;i<data.length;i++){
                    if(data[i].distanceTo(new_point) < smallDist){
                        
                        smallIndex = i;
                        smallDist = data[i].distanceTo(new_point);
                    }
			System.out.println("distance to point "+ i +" is "+data[i].distanceTo(new_point));
		}
		System.out.println("I think it is a "+ data[smallIndex].type);
		
	}
	
	
}
