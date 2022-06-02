// CSE 110     : <Class #15817> / <Fridays 9:05-9:55am>
// Assignment  : <assignment #03>
// Author      : <Carlos Corral-Williams> & <1222280826>
// Description : <This program determines whether the user should buy, sell, or hold their shares based on the input data.>

import java.util.Scanner;

public class Assignment03 {

	public static void main(String[] args) 
	{
		// declare and initialize the Scanner
		Scanner keyboard = new Scanner(System.in);
		// declare and initialize the variables
		final int TRANSACTIONFEE = 10;
		int purchasePrice;
		int availableFunds;
		int currentShares;
		int marketPrice;
		boolean profitable = true;
		// prompt for and collect the inputs
		System.out.print("Current Shares  :"+ " ");
		currentShares = keyboard.nextInt();
		System.out.print("Market Price    :" + " ");
		marketPrice = keyboard.nextInt();
		System.out.print("Purchase Price  :" + " ");
		purchasePrice = keyboard.nextInt();
		System.out.print("Available Funds :" + " ");
		availableFunds = keyboard.nextInt();
		// compute the required values
		int numberOfSharesToBuy = (int)Math.floor(availableFunds-TRANSACTIONFEE)/marketPrice;
		int totalBuyCost = TRANSACTIONFEE + marketPrice * numberOfSharesToBuy;
		int perShareBuyValue = purchasePrice - marketPrice;
		int totalBuyValue = perShareBuyValue * numberOfSharesToBuy;
		int perShareSellValue = marketPrice - purchasePrice;
		int totalSellValue = perShareSellValue * currentShares;
		
		// display the required outputs
		if (perShareBuyValue > 0 && totalBuyValue > TRANSACTIONFEE && numberOfSharesToBuy > 0)
		{
			System.out.println("Buy" + " " + numberOfSharesToBuy + " " + "shares");
			profitable = true;
		}
		
		else if (perShareSellValue > 0  && totalSellValue > TRANSACTIONFEE)
		{
			System.out.println("Sell" + " " + currentShares + " " + "shares");
			profitable = true;
		}
		
			else if (totalSellValue < TRANSACTIONFEE || totalBuyValue < TRANSACTIONFEE)
			{
			System.out.println("Hold" + " " + "shares");
			profitable = false;
			}
			
	}

}
