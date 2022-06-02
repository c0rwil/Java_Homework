import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
// CSE 110     : <Class #> / <Fridays 9:05-9:55 am>
// Assignment  : <assignment #08>
// Author      : <Carlos Corral-Williams> & <studentID:1222280826>
// Description : <Roster Class >
public class Roster
        {
        private ArrayList<Player> players;

            public Roster ()
            {
                 ArrayList<Player> newGuy = players;
            }
             public Roster (String txtFileName)
             {
                ArrayList<Player> newDude = players;
                try
                {
                    Scanner readTxtFile = new Scanner(new File(txtFileName));
                    while (readTxtFile.hasNextLine())
                    {
                        String firstName = readTxtFile.next();
                        String lastName = readTxtFile.next();
                        double blockScore = Double.parseDouble(readTxtFile.next());
                        double attackScore = Double.parseDouble(readTxtFile.next());
                        String fullName = firstName+" "+lastName;
                        //add player to list
                        players.add(new Player(fullName,blockScore,attackScore));
                    }
                }
                catch (FileNotFoundException | NumberFormatException ex)
                {
                    System.err.println(ex.getMessage());
                }
             }

            public void addPlayer(String fullName, double block, double attack)
            {
                players.add(new Player(fullName,block,attack));
            }
            public int getPlayerCount()
            {
                int playerCount = players.size();
                return playerCount;
            }

            public Player getPlayer(String name)
            {
                for (Player dude : players)
                {
                    if(dude.getName().equalsIgnoreCase(name))
                    {
                        return dude;
                    }
                }
                return null;

            }

            public void displayTopBlockers()
            {
                double bestOne = 0.0;
                double bestTwo = 0.0;
                double blockPs;
                    for(Player allBlockers : players)
                    {
                        blockPs = allBlockers.getBlockScore();
                        if(bestOne < blockPs)
                        {
                            bestTwo = bestOne;
                            bestOne = blockPs;
                        }
                        else if(bestTwo < blockPs)
                        {
                            bestTwo = blockPs;
                        }
                    }
                    for (Player allBlockers: players)
                    {
                        if (allBlockers.getBlockScore() == bestOne)
                        {
                            allBlockers.displayPlayerInfo();
                        }
                    }
                    for (Player allBlockers : players)
                    {
                        if(allBlockers.getBlockScore() == bestTwo)
                        {
                            allBlockers.displayPlayerInfo();
                        }
                    }
            }
            public void displayTopAttackers()
            {
               Player secondBiggest = players.get(getPlayerCount()-1);
               Player biggest = players.get(0);
               for (int i = 0; i < players.size(); i++)
               {
                   if(players.get(i).getAttackScore() > biggest.getAttackScore())
                   {
                       biggest = players.get(i);
                   }
                   if(players.get(i).getAttackScore() > secondBiggest.getAttackScore()
                           && players.get(i).getAttackScore() != biggest.getAttackScore())
                   {
                       secondBiggest = players.get(i);
                   }
               }
               biggest.displayPlayerInfo();
               secondBiggest.displayPlayerInfo();
            }
            public void displayAllPlayers()
            {
                for (Player dude : players)
                {
                    dude.displayPlayerInfo();
                }
            }

        }
