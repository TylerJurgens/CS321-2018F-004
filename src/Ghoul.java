import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/*
* Requirement #704: As a game designer, I want a ghoul to wander around the map so that the game is more interesting.
*/

public class Ghoul {

	private int angryLevel; // Measure of a ghoul's anger on a scale of 0(calm) to 10(furious)
	private int currentRoom;
	private final int id;
	private static int totalGhoul = 0;
	private boolean isEngaged = false;
	private LocalDateTime inputTimer;
	public LocalDateTime getInputTimer() {
		return inputTimer;
	}

	public void setInputTimer(LocalDateTime inputTimer) {
		this.inputTimer = inputTimer;
	}

	private Player challenger;


	public Player getChallenger() {
		return challenger;
	}

	public void setChallenger(Player challenger) {
		this.challenger = challenger;
	}

	public boolean isEngaged() {
		return isEngaged;
	}

	public void setEngaged(boolean isEngaged) {
		this.isEngaged = isEngaged;
	}

	private String ghoulName = null;

	// Summon a new Ghoul. New Ghoul will always very claim.
	public Ghoul(int room) {
		Random rand = new Random();
		this.currentRoom = room;
		this.angryLevel = 0;
		this.id = Ghoul.totalGhoul;
		Ghoul.totalGhoul += 1;
		int magic = rand.nextInt(0xfffffff) + this.id;
		String ghoulName = "";
		while (magic > 0) {
			// totally 94 chars can be used in ascii; #33 - #126
			char a = (char) (33 + (magic % 94));
			magic = magic / 94;
			ghoulName += a;
		}
		this.ghoulName = ghoulName;
	}

	public int getAngryLevel() {
		return this.angryLevel;
	}

	public int getRoom() {
		return this.currentRoom;
	}

	public int getId() {
		return this.id;
	}

	public boolean equals(Ghoul g) {
		return (this.id == g.getId());
	}

	public String getTrueName() {
		return this.ghoulName;
	}

	public void setRoom(int room) {
		this.currentRoom = room;
	}

	public void modifyAngryLevel(int amount) {
		this.angryLevel += amount;

		// add some error check......
		if (this.angryLevel > 10) {
			this.angryLevel = 10;
		} else if (this.angryLevel < 0) {
			this.angryLevel = 0;
		}

		return;
	}

	public boolean rpsdecision(Player p) {
		boolean answer = false;
		p.getReplyWriter().println("A Ghoul is about to drag you! Try to calm it down!");
		InputStreamReader keyboardReader = new InputStreamReader(System.in);
        BufferedReader keyboardInput = new BufferedReader(keyboardReader);
        String keyboardStatement = "";
        try {
        keyboardStatement = keyboardInput.readLine();
        } catch (IOException e) {
        	p.getReplyWriter().println("Invalid decision!");
        }
        if (keyboardStatement.toUpperCase().toCharArray()[1] != '\n') {
        	p.getReplyWriter().println("Invalid decision!");
        	answer = false;
        }
        else if (keyboardStatement.toUpperCase().toCharArray()[0] == 'Y' && (ChronoUnit.MILLIS.between(inputTimer,
				LocalDateTime.now()) <= 6000)) {
        	p.getReplyWriter().println("Get ready to R-P-S!");
    		isEngaged = true;
        	answer = true;
        }
        else {
        	p.getReplyWriter().println("You didn't accept the challenge!");
        }
        return answer;
	}

}
