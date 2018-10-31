## Log of the ghoul interactions
	A text file of ghoul interactions will be created when a player interacts with a ghoul.
---

## For Developers
      -	 GhoulLog.java can be found in the src folder. It comprises GhoulLog class. GhoulLog class has a constructor
	that creates a ghoulLog.txt file if it doesn't already exist. Within the constructor a FileHandler object 
	is created with a purpose of writing to a specified file. A Logger object is also created within the constructor 
	in order to log messages for this purpose. The newly created logger instance then calls addHandler method on a 
	newly created FileHandler object to receive logging messages. A SimpleFormatter object is also created so that
	FileHandler instance can call setFormatter method, with that SimpleFormatter instance as an argument.

      -  The class GhoulLog also contains a single method called glLog of the void type that accepts three String 
	arguments(class, method, message) respectively so that the class, method from which glLog() was called and 
	the desirable message could be displayed in the log. The body of the glLog contains a single logger call to the 
	logp method of the class Logger. logp method has four parameters: 

	level - One of the message level identifiers e.g. SEVERE
	sourceClass - name of class that issued the logging request
	sourceMethod - name of method that issued the logging request
	msg - The string message 
 
       - The method will be called from the GameCore class, within the method poke_ghoul. The message level identifiers
	will be SEVERE. The message that will be displayed in the log: "Player" + " " + playerName + " has just poked the Ghoul". 
---
## Images
	![](CS321-2018F-004/images/log_example.png)	
---
## Contributor 

- Aleksa Samardzic
