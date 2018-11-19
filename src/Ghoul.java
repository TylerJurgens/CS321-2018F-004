import java.util.Random;

/**
 * Requirement #704: As a game designer, I want a ghoul to wander around the map so that the game is more interesting.
 * had beacuse a huge strong monster in real meaning......
*/


public class Ghoul{

	private int angryLevel; //Measure of a ghoul's anger on a scale of 0(calm) to 10(furious)
	private int currentRoom;
	private final int id;
	private static int totalGhoul = 0;
	private String ghoulName = null;

        /**
	 * Summon a new Ghoul. New Ghoul will always very claim.
	 * Will given a cool random name to Ghoul, and summon it to room wished.
	 * @param room The room id which you wish to put Ghoul in. 
	 */
	public Ghoul(int room){
		Random rand = new Random();
		this.currentRoom = room;
		this.angryLevel = 0;
		this.id = Ghoul.totalGhoul;
		Ghoul.totalGhoul += 1;	
		int magic = rand.nextInt(0xfffffff)+this.id;
		String ghoulName = "";		
		while(magic > 0){
			//totally 94 chars can be used in ascii; #33 - #126
			char a = (char)(33 + (magic % 94));
			magic = magic / 94;
			ghoulName += a;
		}
		this.ghoulName = "["+ghoulName+"]";
	}

	/**
	 * get the angrylevel of ghoul
	 * @return the angrylevel of ghoul
	 */
	public int getAngryLevel(){
		return this.angryLevel;
	}

	/**
	 * get the room id of ghoul
	 * @return the room id of ghoul
	 */
	public int getRoom(){
		return this.currentRoom;
	}

	/**
	 * get the id of ghoul
	 * @return the id of ghoul
	*/
	public int getId(){
		return this.id;
	}

	/**
	 * check if two ghoul are same, via their id. Same id meaning same ghoul.
	 * @param g the ghoul wish to compare 
	 * @return A boolean value tell you if two ghoul are same.
	*/
	public boolean equals(Ghoul g){
		return (this.id == g.getId());
	}

	/**
	 * get the True name of ghoul
	 * @return the True name of ghoul
	*/
	public String getTrueName(){
		return this.ghoulName;
	}

	/**
	 * set the room id of ghoul
	 * @param room the room id wish to given ghoul
	*/
	public void setRoom(int room){
		this.currentRoom = room;
	}
	
	/**
	 * add amount of the angrylevel value to ghoul
	 * @param amount The amount of angrylevel value wish to add to this ghoul
	*/
	public void modifyAngryLevel(int amount) {
		this.angryLevel += amount;

		//add some error check......
		if(this.angryLevel > 10){
			this.angryLevel = 10;
		}else if (this.angryLevel < 0){
			this.angryLevel = 0;
		}
		
		return; 
	}
	
	/**
	 * drag some player to first map and take one of his/her item. 
	 * @param p The victim. 
	*/
	public void Drag(Player p){
		if (this.angryLevel >= 7) {
		p.getReplyWriter().println("A Ghoul is about to drag you! Try to calm it down!");
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p.getReplyWriter().println("The Ghoul knocks you unconscious!");
		modifyAngryLevel(-1);
		
		}
	}

}
