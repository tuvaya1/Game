package Game;

public class block {
	
	int x;
	int y;
	boolean collision;
	int texture;
	Runnable action;
	int idx;
	
	public block(int x, int y, boolean collision, int texture, Runnable r) {
		
		this.x = x;
		this.y = y;
		this.collision = collision;
		this.texture = texture;
		this.action = r;
		
	}

	public block(block block) {
		this.x = block.x;
		this.y = block.y;
		this.collision = block.collision;
		this.texture = block.texture;
		this.action = block.action;
	}
	
	
}
