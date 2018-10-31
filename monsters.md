# Ghosts

## Ghost Guide for Players

When a player moves to a new room, there is a small chance that a ghost will appear in that room. If a ghost appears, it will say something spooky/funny, then quickly disappear from the room.

## Ghost Guide for Developers

Two classes were modified for the implementation of ghosts in this game. They are Ghost.java and GameCore.java.

### Ghost.java
This class contains almost all of the code for ghosts. It implements the Thread interface and has the following three methods: Ghost(Player p), run(), and loadSayings().
##### Ghost(Player p)
This is the constructor, which just ininitalizes the class variables and calls loadSayings().
##### run()
This overrides the Thread interface. In this method, we have a random chance of spawning a ghost, pick a random saying from the arraylist of sayings, and write the saying to the game.
##### loadSayings()
Ths reads in a text file called "ghost_sayings.txt", and stores each line of the file as a possible saying in ArrayList<String> sayings.

### GameCore.java
The only modification made to GameCore.java is in the public String move() method, in which a Ghost is initialized and its run method is started.
