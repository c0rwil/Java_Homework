import java.util.*;
// CSE 110     : <Class #> / <Fridays 9:05-9:55am>
// Assignment  : <assignment #08>
// Author      : <Carlos Corral-Williams> & <studentID:1222280826>
// Description : <Player class>
public class Player
        {
            private String fullName;
            private double blockScore;
            private double attackScore;

        public Player()
        {
        this.fullName = null;
        this.blockScore = 0;
        this.attackScore = 0;
        }

        public Player(String fullName, double blockScore, double attackScore)
        {
            this.fullName = fullName;
            this.blockScore = blockScore;
            this.attackScore = attackScore;
        }

        public String getName() {return this.fullName;}

        public double getBlockScore() {return this.blockScore;}
        public void setBlockScore(double newBlock) {this.blockScore = newBlock;}

        public double getAttackScore() {return this.attackScore;}
        public void setAttackScore (double newAttack) {this.attackScore = newAttack;}

        public void displayPlayerInfo()
        {
             System.out.printf("%s (block = %.2f, attack = %.2f)", this.getName(),
                     this.getBlockScore(), this.getAttackScore());
        }

        }
