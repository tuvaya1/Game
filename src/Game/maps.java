package Game;

public class maps {
	
	static block tech = new block(128,128,true, 0,null);
	static block w = new block(-1,-1,true, 2,null);
	static block e = new block(-1,-1,false, 0,null);
	static block D = new block(-1,-1,false, 4,new Runnable() {

		@Override
		public void run() {
			
			if(Game.idx == Game.player.pidx) {
			Game.level = map2;
			Game.player.px = Game.level[880].x;
			Game.player.py = Game.level[880].y;
			}
		}
		
	});
	static block s = new block(-1,-1,false, 11,new Runnable() {

		@Override
		public void run() {
			
			if(Game.idx == Game.player.pidx) {
			Game.player.px = Game.level[880].x;
			Game.player.py = Game.level[880].y;
			}
			
		}
		
	});
	
	
	
	static block[] map1 = {
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,w,w,w, w,w,e,e,e, e,s,s,s,s, s,s,s,s,e, e,e,e,e,e, e,e,e,D,e, e,e,e,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			                                                      
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			tech
			
			
			
	};
	static block[] map2 = {
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,w, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,w, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,D,e, e,e,e,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			tech
			
			
	};
	
}
