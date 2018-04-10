
import java.util.Scanner;

public class Kmeans {

    dataPoint[] data;
    int k = 2;									// number of clusters
    dataPoint[] cluster;			// the means for each cluster

    // initialize all the data points 
    public Kmeans(int k) {
        this.k = k;
        data = new dataPoint[15];
        cluster = new dataPoint[k];
        data[0] = new dataPoint(68.0, 29.0, "White Pine Tree");			// White Pine Tree
        data[1] = new dataPoint(58.0, 19.0, "White Pine Tree");			// White Pine Tree
        data[2] = new dataPoint(66.0, 24.0, "White Pine Tree");			// White Pine Tree
        data[3] = new dataPoint(35.0, 13.0, "Maple Tree");				// Maple Tree
        data[4] = new dataPoint(32.0, 15.0, "Maple Tree");				// Maple Tree
        data[5] = new dataPoint(29.0, 19.0, "Maple Tree");				// Maple Tree
        data[6] = new dataPoint(25.0, 22.0, "Maple Tree");				// Maple Tree
        data[7] = new dataPoint(12.0, 9.0, "Bush");						// Bush
        data[8] = new dataPoint(9.0, 4.0, "Bush");						// Bush
        data[9] = new dataPoint(10.0, 5.0, "Bush");						// Bush
        data[10] = new dataPoint(7.0, 7.0, "Bush");						// Bush
        data[11] = new dataPoint(3.0, 2.0, "Shrub");						// Shrub
        data[12] = new dataPoint(3.0, 4.0, "Shrub");						// Shrub
        data[13] = new dataPoint(2.0, 5.0, "Shrub");						// Shrub
        data[14] = new dataPoint(1.0, 2.0, "Shrub");						// Shrub

    }

    // create k means and set each to a random value
    public void initMeans() {
        for (int m = 0; m < cluster.length; m++) {
            cluster[m] = new dataPoint(0, 0, "cluster mean");
            cluster[m].type = m;
            cluster[m].setRandom();
        }
    }

    // Assign each data point to the cluster represented by the nearest cluster mean
    // return true is some point is assigned to a new cluster
    public boolean findNearestMean() {
        double dist;
        int closest;
        boolean newCluster = false;
        for (int d = 0; d < data.length; d++) {
            // for each data point, assume it is closest to cluster[0] to start with. 
            dist = cluster[0].distanceTo(data[d]);			// record the distance to cluster[0]'s mean
            closest = 0;									// store the cluster number
            for (int m = 1; m < cluster.length; m++) {
                // for all the other cluster means starting with cluster[1], check if this data point is closer to it.
                double new_dist = cluster[m].distanceTo(data[d]);
                if (dist > new_dist) {
                    dist = new_dist;
                    closest = m;
                }
            }
            if (data[d].type != closest) {
                // found a data point that must move.  Reset its cluster to the closest one
                data[d].type = closest;				// store the current classification or nearest mean for this data point
                newCluster = true;					// remember that we moved at least on point to a new cluster
            }
        }
        return (newCluster);
    }

    // recalculate the cluster means for cluster m
    public void updateClusterCenter(int m) {
        // find the average x and y values for all data points in this cluster, that is those data points whose type is m
        // Here m is the cluster number of the cluster type.  All data points in this cluster will have a type equal to m
        //---------
        // this method must set cluster[m].x = average of all the data[i].x values for 
        //    the data points in this cluster, i.e. when data[i].type == m
        // this method must do the same for cluster[m].y
        // Warning: if there are not data points in cluster m, that is non of the data[i].type equal m
        //          then you can not calculate the averages and must assign the cluster a new random location
        //          by calling:  cluster[m].setRandom();
        System.out.println("Calculating new location for cluster " + m);
        System.out.println("   This cluster is now at x=" + cluster[m].x + " and y= " + cluster[m].y);
        
        //finding the average
        double totalX = 0.0, totalY = 0.0;
        int count = 0;
        
        for (int d = 0; d < data.length; d++) {
            // check if this data point is in cluster m
            if (data[d].type == m) {
                totalX += data[d].x;
                totalY += data[d].y;
                count ++;
                System.out.println("   Found data point in this cluster at x= " + data[d].x + " and y= " + data[d].y);
            }
        }
        double aveX = totalX/count;
        double aveY = totalY/count;
        
        //UPDATE the clusters
        cluster[m].x = aveX;
        cluster[m].y = aveY;
    }
    // check for empty cluster with no nodes nearby
    public boolean checkEmptyCluster(int m) {
        int count = 0;			// used to store the count of the data points in the cluster
        for (int d = 0; d < data.length; d++) {
            // if this data point is in cluster m, then count it
            if (data[d].type == m) {
                count++;
            }
        }
        if (count == 0) {
            // empty cluster, set to a random location
            cluster[m].setRandom();
            return true;
        }
        return false;
    }

    // print out a cluster and all the data points in it.
    public void displayClusters() {
        System.out.println("============== Clusters ==============");
        for (int m = 0; m < cluster.length; m++) {
            System.out.print("Cluster " + m + " mean : ");
            cluster[m].display();
            for (int d = 0; d < data.length; d++) {
                if (data[d].type == m) {
                    System.out.print("data point " + d + " : ");
                    data[d].display();
                }
            }
        }

    }

    // main routine that runs the k-means algorithm
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);    // needed to read input from the keyboard
        System.out.println("This program will automatically cluster the data points");
        System.out.println("How many clusters do you want to use?");
        int k = scnr.nextInt();

        Kmeans kMeans = new Kmeans(k);
        kMeans.initMeans();

        // repeat the following until the data points stay in the same clusters
        // findNearestMean() will return true if it moves any data points to different clusters
        while (kMeans.findNearestMean()) {
            // for each cluster do the following
            for (int m = 0; m < kMeans.cluster.length; m++) {
                if (!kMeans.checkEmptyCluster(m)) {             // check for empty cluster
                    kMeans.updateClusterCenter(m);		// move the cluster center to correspond to the data points in that cluster
                }
            }
            kMeans.displayClusters();					// display clusters
        }

    }

}
