// CSE 110     : <Class #15817> / <Fridays 9:05-9:55am>
// Assignment  : <Assignment #02>
// Author      : <Carlos Corral-Williams> & studentID: <1222280826>
// Description : <Assignment02 program, takes user input to output the associated costs and materials required for a given road construction project>

import java.util.Scanner; // Imports Scanner class  
import java.lang.Math; // Needed to use math.round()

/* this program computes the total materials and cost required for a road construction project */
public class Assignment02 {

	public static void main(String[] args) {
		// initializes input variables and constants
		Scanner scan = new Scanner (System.in);
		
		final int ASPHALTWEIGHTPERCUBICFOOT = 160;
		final int ASPHALTCOSTPERTON = 230;
		final int ASPHALTCOSTPERTRUCKLOAD = ASPHALTCOSTPERTON * 5; // A way for me to fix the rounding error that I've continually encountered with my asphalt cost calculations on this assignment was to find the cost per truck load of asphalt.
		final int LANEWIDTH = 12;
		final int MAXIMUMHAULINGCAPACITY = 10000;
		final int CONDUITPIPELENGTH = 20;
		final int INDIVIDUALSTOPLIGHTCOST = 27000;
		final int WORKDAYLENGTH = 8;
		final int WORKERHOURLYPAYRATE= 28;
		final int INDIVIDUALCONDUITPIPECOST = 600; 
	
		double milesOfRoad;
		int numberOfLanes;
		int depthOfAsphalt;
		int daysToComplete;
		
		// prompts user for input
		System.out.print("Length of road project (miles) :");
		milesOfRoad = scan.nextDouble();
		
		System.out.print("Number of lanes :");
		numberOfLanes = scan.nextInt();
		
		System.out.print("Depth of asphalt (inches) :");
		depthOfAsphalt = scan.nextInt();
		
		System.out.print("Days to complete project :");
		daysToComplete = scan.nextInt();
		
		// computes various sums through the formulas provided
		double totalFeetOfRoad = milesOfRoad * 5280;
		int totalIntersections = (int) milesOfRoad / 1;
		double totalLaneWidth = numberOfLanes * LANEWIDTH;
		double totalAsphaltDepth = (double)depthOfAsphalt / 12;
		double totalArea = totalFeetOfRoad * totalLaneWidth * totalAsphaltDepth;
		double totalAsphaltWeight = totalArea * ASPHALTWEIGHTPERCUBICFOOT;
		double totalTruckloads = Math.ceil(totalAsphaltWeight / MAXIMUMHAULINGCAPACITY);
		double totalNumberOfConduitPipes = Math.ceil(totalFeetOfRoad / CONDUITPIPELENGTH);
		double requiredCrewmates = Math.ceil(50 * milesOfRoad * numberOfLanes) / daysToComplete;
		int totalStoplights = 0;
		
		
			if (numberOfLanes == 1 && milesOfRoad > 0)
			{
				totalStoplights = (int) (totalIntersections * 2 + (numberOfLanes));
			}
		
			else if (numberOfLanes == 2 && milesOfRoad > 0)
			{
			totalStoplights = (int) (totalIntersections * 2) + (numberOfLanes * totalIntersections);
			}
		
			else if (numberOfLanes == 3 && milesOfRoad >0)
			{
				totalStoplights = (int) (totalIntersections * 2) + (numberOfLanes * totalIntersections);;
			}
			
			double totalAsphaltCost = (double)(totalTruckloads* ASPHALTCOSTPERTRUCKLOAD);
			double totalStoplightCost = (totalStoplights * INDIVIDUALSTOPLIGHTCOST);
			double totalConduitPipeCost = (totalNumberOfConduitPipes * INDIVIDUALCONDUITPIPECOST);
			double totalLaborCost = (double)(WORKERHOURLYPAYRATE * WORKDAYLENGTH * daysToComplete) * (Math.ceil(requiredCrewmates));
			
			// outputs necessary values
			System.out.println("=== Amount of materials needed ===");
			System.out.printf("Truckloads of Asphalt : " + ((int)totalTruckloads));
			System.out.printf("\nStoplights : " + (int)totalStoplights);
			System.out.printf("\nConduit pipes : " + ((int)totalNumberOfConduitPipes));
			System.out.printf("\nCrew members needed : " + ((int)requiredCrewmates));
			System.out.println("\n=== Cost of Materials ============");
			System.out.printf("Cost of Asphalt : $%.2f ", totalAsphaltCost);
			System.out.printf("\nCost of Stoplights : $%.2f ", totalStoplightCost);
			System.out.printf("\nCost of Conduit pipes : $%.2f ",  totalConduitPipeCost);
			System.out.printf("\nCost of Labor : $%.2f" , totalLaborCost);
			System.out.println("\n=== Total Cost of Project ========");
			System.out.printf("Total cost of project : $%.2f ", (totalAsphaltCost + totalStoplightCost + totalConduitPipeCost + totalLaborCost));
		
		
		
	}

}
