<!-- Here is complete explaination of problem & solution code -->

<!-- problem overview -->

Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0.
Any two player can fight a match in the arena. Players attack in turns. Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack” value multiplied by the outcome of the attacking dice roll is the damage created by the attacker. The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender. Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender. Game ends when any players health reaches 0

<!-- Rule of the game -->

Player with lower health attacks first at the start of a match.

<!-- Example:  -->

Assume two players A & B.
Player A 50 health 5 strength 10 attack
Player B 100 health 10 stregnth and 5 attack
Attacking die and Defending die are both 6 sided die with values ranging from 1- 6

Player A attacks and rolls die. Die roll : 5. Player B defends and rolls die. Die roll 2.
Attack damage is 5 x 10 = 50; Defending strength = 10 x 2 = 20; Player B health reduced by 30 to 70
Player B attacks and rolls die. Die roll : 4. Player A defends and rolls die. Die Roll 3.
Attack damage is 4 x 5 = 20; Defending strength = 5 x 3 = 15; Player A health reduced by 5 to 45

And so on..

<!-- Solution Code Explaination -->

1. Implemented class Player to get player objects with attributes of health, strength & attack.
   Inside Player class a parameterized constructor is implemented to initialize the player objects.
   Here the constructor takes 3 arguments while creating a new player object & initialize those values to the object.

2. Implemented rollDie() method to get a random integer value, a player gets after rolling a die ranging from 1 to 6.
   Here the rollDie method does not take any parameter & returns a integer value.
   Random value is generated using random() method provided by Math class which returns a double value which is in range (0,1).
   Further this random value is multiplied by 10 to get values in range (0, 10).
   Further to get values only from 1 to 6, applied the modulus operator by 6 to the random value recieved earlier & added 1 to it.

3. Implemented fight() method which takes two parameters of Player type, one as attacker & other as defender.

   First the attackerRollValue & defenderRollValue is generated using rollDie() method by calling it for both players.
   Then attackDamage is calculated for attacker player using his attack attribute value & his attackRollValue by following expression as --> {attacker.attack x attackerRollValue}
   Then defenseStrength is calculated for defender player using his strength attribute value & his defenderRollValue by following expression as --> {defender.strength x defenderRollValue}

   Now the damageTaken by defender player is calculated using expression {attackDamage - defenseStrength} & if damageTaken is negative value, then 0 damage is taken in that case using expression {Math.max(0, attackDamage - defenseStrength)}

   Finally defender's final health is calculated using expression {defender.health - damageTaken}

   If defender's health touches 0 becomes negative then fight() method returns the attacker as the winner & defender as loser player.
   Else figth() method is invoked again recursive by swapping attacker & defender.

4. Implemented getInitiaPlayers() method to get the initial players as the player with lower health at 0 index & with higher health at 1 index.

5. Implemented main method starting with taking input values for playerA & playerB.
   Checking for any negative values entered, if so, an error is thrown else moving forward.
   Two new player objects created using input values & Player constructor.

   Checking for player with lower health by using getInitiaPlayers() method and deciding player with lower health as initial attacker.
   If both player are at same health level, playerA is chosen at attacker in that case.

   Invoked fight() method by passing attacker as first parameter & defender as second to get winner among the two.
   Finally winner is announced.

<!-- Execution flow - Steps to execute code -->

1. Run MainClass.java file to play the 'Magical Arena' game.

2. Enter values for player A

3. Enter values for player B
   Only positive values are allowed. Otherwise error will be thrown.

4. Using these values, two player objects will be created using Player constuctor & sent to getInitiaPlayers() method to get the players as initial attacker & defenders. And then these are passed to fight() method.

5. In fight() method main login happens.
   Starting with getting random Die value from 1 to 6 using rollDie() method for each player.
   Then calculating attackDamage for attacker & defenseStrength for defender.
   Finally damageTaken will be calculated for defender.
   At the end if defender heatlh is 0 or negative then attacker is return as winner & defender as loser player, else again figth() method is invoked recursively by swapping attacker & defender.

6. At the end winner will be announed from the returned value of fight() method in main method.

<!-- Testing of the program : Magical Arena -->

To test the program run MainClassTest.java file

This file includes unit tests written as :

@test testRollDie() - to test rollDie() method, to check the die value to be in between 1 and 6

@test testPlayerObjectCreation() - to test players to be created with provided values

@test testLowerHealthInitialAttacker() - to test getInitiaPlayers() method, to get correct players for initial attacker & defender

@test testLoserHealthZeroOrNegative() - to test fight() method, to check the loser player should have 0 or negative health

@test testWinnerHealthPositive() - to test fight() method, to check the winner player should have positive health
