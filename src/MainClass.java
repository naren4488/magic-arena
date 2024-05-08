package src;

import java.util.Scanner;

public class MainClass {

    /*
     * method to get a random value after rolling a die
     * 
     * @returns {int} - random value ranging from 1 to 6
     */
    public static int rollDie() {
        int randomValue = (int) (Math.random() * 10);
        return (randomValue % 6) + 1;
    }

    /*
     * recursive method to update health of players after each fight
     * & returns the winner player once defender's heatlh touches zero or negative
     * 
     * @params {Player} attacker - player who is attacking with attack
     * 
     * @params {Player} defender - player who is defending with strength
     * 
     * @returns {Player []} - winner & loser players at indices 0 & 1
     */
    public static Player[] fight(Player attacker, Player defender) {
        int attackerRollValue = rollDie();
        int defenderRollValue = rollDie();

        int attackDamage = attacker.attack * attackerRollValue;
        int defenseStrength = defender.strength * defenderRollValue;

        int damageTaken = Math.max(0, attackDamage - defenseStrength);
        defender.health -= damageTaken;

        if (defender.health <= 0) {
            Player[] resultArr = new Player[2];
            resultArr[0] = attacker;
            resultArr[1] = defender;
            return resultArr;
        }
        return fight(defender, attacker);
    }

    /*
     * method to get the initial players
     * 
     * @params {Player} playerA
     * 
     * @params {Player} playerB
     * 
     * @returns {Player []} - players with lower & higher healths at 0 & 1 indices
     * respectively
     */
    public static Player[] getInitiaPlayers(Player playerA, Player playerB) {
        Player arr[] = new Player[2];
        if (playerA.health <= playerB.health) {
            arr[0] = playerA;
            arr[1] = playerB;
            return arr;
        } else {
            arr[0] = playerB;
            arr[1] = playerA;
            return arr;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter player A details for health, strength & attack :");
            int playerA_Health = sc.nextInt();
            int playerA_Strength = sc.nextInt();
            int playerA_Attack = sc.nextInt();

            System.out.println("Enter player B details for health, strength & attack :");
            int playerB_Health = sc.nextInt();
            int playerB_Strength = sc.nextInt();
            int playerB_Attack = sc.nextInt();

            if (playerA_Health <= 0 || playerA_Strength <= 0 || playerA_Attack <= 0 || playerB_Health <= 0
                    || playerB_Strength <= 0 || playerB_Attack <= 0) {
                throw new Error("Values can not be less than 1, Please enter only positive value(s).");
            }

            Player playerA = new Player(playerA_Health, playerA_Strength, playerA_Attack);
            Player playerB = new Player(playerB_Health, playerB_Strength, playerB_Attack);

            Player[] initialPlayers = getInitiaPlayers(playerA, playerB);
            Player[] winner = fight(initialPlayers[0], initialPlayers[1]);

            if (winner[0] == playerA) {
                System.err.println("Player A wins!");
            } else {
                System.err.println("Player B wins!");
            }
        } catch (Error e) {
            System.out.println("Error : " + e);
        }

        finally {
            sc.close();
        }
    }
}