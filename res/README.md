### **Overview**
The system implemented in this project seeks to be a model for 
Jumptastic Games for their new role-playing game that will 
allow gamers to build players that can then be entered into 
an arena for one-on-one combat following this turn-based battle 
strategy. The battle begins by determining which player will 
go first.The player who did not take a total damage greater 
than or equal to their health is declared the victor.

### **List of features**
- Players can be assigned with various Gears which can enhance or
degrade some of their abilities.
- Players can be assigned any weapon from the Armory.
- Rematch option allows the players to battle with the same 
- opponent by getting new gears and weapons.
- Which Player will go first is automatically determined by the
game when the Battle starts.
- Detailed description of the Player is available when needed.
- All battle statistics are auto-printed after the Battle has ended.

### **How To Run**
In Command prompt/Terminal, navigate to the /res folder and run the 
command: **java -jar Project2_Battle.jar**

### **How to Use the Program**
In order to use the various functionalities of the program,
2 Player objects need to be created. These player objects 
are then passed to the Battle object which simulates a battle
between the players. The Example Run gives a rundown of how 
all the functionalities of the program work. You can use this 
program to create players and battle them with each other. The 
program also allows you to generate Lists of all attributes and 
gears that the Player has been assigned.

### **Description of Examples**
Final_Run_Battle.txt:

- On creating the Battle, an introduction message is printed:
```
-------------------------------------------------------------------------
Welcome to the Battle Game ! ! !
Get your Gears and Weapons and begin the battle
-------------------------------------------------------------------------
```

- On creating a Player, the Player is assigned some basic
abilities. These abilities can be printed in following format:
```
-------------------------------------------------------------------------
Players' Basic Abilities:
Player P1: Strength= 9 | Constitution= 17 | Dexterity= 15 | Charisma= 16
Player P2: Strength= 12 | Constitution= 15 | Dexterity= 15 | Charisma= 12
-------------------------------------------------------------------------
```

- You can add gears to the Equipment Bag and stock up the Armory
with weapons for the players to select for the battle. The 
output fot the same looks as follows:
```
Preparing for Battle...

Gears added to the Equipment Bag...

Weapons added to the Armory...
```
- You can also assign gears and weapons to a players. The 
outputs for the same look as follows:
```
Assigning gears to Player P1...COMPLETE

Assigning weapon to Player P1...COMPLETE

Assigning gears to Player P2...COMPLETE

Assigning weapon to Player P2...COMPLETE
```
- Each player is randomly assigned 20 gears and 1 weapon. You 
can print the list of assigned gears and weapons as follows:
```
Assigning gears to Player P1...COMPLETE
Player P1 Assigned Gears -
1. Boeotian helmet
2. Corinthian helmet
3. Montefortino helmet
4. Potion of Etherealness
5. Potion of Flying
6. Potion of Giant Strength
7. Potion of Healing
8. Potion of Slipperiness
9. Potion of Speed
10. Potion of Speed
11. Orange Belt
12. Orange Belt
13. Precision Belt
14. Weapon Belt
15. Barefoot Shoes
16. Buckled Shoes
17. Buckled Shoes
18. Combat Boots
19. Jika-tabi Shoes
20. Oxfords

Assigning weapon to Player P1...COMPLETE
Player P1 Assigned Weapon -Katana
```

- The program allows you to print the description of the 
players once they are equipped with the permitted limit of
gears and weapons. This description looks like this:p
```
-----------------------------------------------------------------------
Player details for the Battle:
-----------------------------------------------------------------------
Player P1:
Equipped Gears -
1. Corinthian helmet
2. Potion of Etherealness
3. Potion of Flying
4. Potion of Giant Strength
5. Potion of Healing
6. Potion of Slipperiness
7. Potion of Speed
8. Potion of Speed
9. Orange Belt
10. Orange Belt
11. Precision Belt
12. Weapon Belt
13. Oxfords

Weapon: Katana

Abilities: Strength= 16 | Constitution= 15 | Dexterity= 18 | Charisma= 10

Health: 59
-----------------------------------------------------------------------

```
- On starting the Battle, the battle stats are recorded and
following output can be expected once the battle is over:
```
Battle Starting ...
P2 strikes first.
Round 1: P2 attacks | Hit Successful | Damage= 20 | P1 Health= 39 | P2 Health= 80
Round 2: P1 attacks | Hit Missed 
Round 3: P2 attacks | Hit Successful | Damage= 19 | P1 Health= 20 | P2 Health= 80
Round 4: P1 attacks | Hit Missed 
Round 5: P2 attacks | Hit Successful | Damage= 19 | P1 Health= 1 | P2 Health= 80
Round 6: P1 attacks | Hit Missed 
Round 7: P2 attacks | Hit Successful | Damage= 20 | P1 Health= -19 | P2 Health= 80
Player P2 Wins !!

```

- The game also allows you to opt for a rematch with the same 
opponent. The following message is displayed asking for a 
Rematch:
```
Do you want a rematch? (Y/N): 
```
- On receiving the Y(Yes) input, the game reassigns gears and
weapons to the Players and begins the battle once again


### **Design Changes**
The earlier design of the system focussed on creating the Players 
inside the Battle once Battle is initializes. However, on further
considerations, it was decided to create a separate Interface for
Player as Players need to exist outside the battle as well.

### **Assumptions**
The program assumes few details in order to make the working less complicated. Few such assumptions 
are as follows:

- If a player is equipped with a headgear, he cannot use other
headgears assigned to him even if they enhance the abilities
more than the existing one.
- If a player is equipped with a footwear, he cannot use other 
footwears assigned to him even if they enhance the abilities
more than the existing one.
- A battle will end in tie if there is no clear winner after 200
rounds.
- All the turns of the Battle happen automatically and the result 
is available only after the battle is ended.
- On clicking of Rematch, all the gears and weapons in the Battle
arena are reloaded and new gears and weapons are assigned to the 
Players.
- If a player has been assigned Katana sword, they will automatically 
receive 2 swords and each turn of the player strike will 
consider strikes by both the swords together but with different
damage value for each sword.


### **Limitations**
The program has a few limitations that could be worked on in future versions:

- Battle results cannot be displayed after each round of the Battle.
- The result of the match remains fixed if the Gears are not 
reassigned before a rematch.


### **Citations**
Nil.