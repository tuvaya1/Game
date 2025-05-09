package Game;

public class maps {
	
	static block tech = new block(128,128,true, 0,null);
	static block w = new block(-1,-1,true, 19,null);
	static block d = new block(-1,-1,true, 24,null);
	static block u = new block(-1,-1,true, 14,null);
	static block r = new block(-1,-1,true, 20,null);
	static block l = new block(-1,-1,true, 18,null);
	static block dr = new block(-1,-1,true, 35,null);
	static block ur = new block(-1,-1,true, 30,null);
	static block dl = new block(-1,-1,true, 36,null);
	static block ul = new block(-1,-1,true, 31,null);
	static block e = new block(-1,-1,false, 0,null);
	static block D = new block(-1,-1,false, 4,new Runnable() {

		@Override
		public void run() {
			
			if(Game.idx == Game.player.pidx) {
			Game.level = map2;
			Game.player.px = Game.level[880].x;
			Game.player.py = Game.level[880].y;
			Game.player.lvlDeaths = 0;
			}
		}
		
	});
	static block s = new block(-1,-1,false, 11,new Runnable() {

		@Override
		public void run() {
			
			if(Game.idx == Game.player.pidx) {
			Game.player.Death();
			
			}
			
		}
		
	});
	
	
	
	static block[] map1 = {
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,dr,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,dl,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                  
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                  
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                  
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e, e,e,e,e,e, e,e,e,e,e, e,s,s,s,s, s,s,s,s,e, e,e,e,e,e, e,e,e,D,e, e,e,e,l,w,
			w,ur,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,ul,w,
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
