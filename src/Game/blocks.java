package Game;

public class blocks {
	public static block tech = new block(128,258,true, 0,null);
	public static block tech2 = new block(272,304,true, 0,null);
	public static block tech3 = new block(128,240,true, 0,null);
	public static block tech4 = new block(48,304,true, 0,null);                
	public static block w = new block(-1,-1,true, 19,null);
	public static block d = new block(-1,-1,true, 24,null);
	public static block u = new block(-1,-1,true, 14,null);
	public static block r = new block(-1,-1,true, 20,null);
	public static block l = new block(-1,-1,true, 18,null);
	public static block rd = new block(-1,-1,true, 25,null);
	public static block ru = new block(-1,-1,true, 15,null);
	public static block ld = new block(-1,-1,true, 23,null);
	public static block lu = new block(-1,-1,true, 13,null);
	public static block dr = new block(-1,-1,true, 35,null);
	public static block ur = new block(-1,-1,true, 30,null);
	public static block dl = new block(-1,-1,true, 36,null);
	public static block ul = new block(-1,-1,true, 31,null);
	public static block rr = new block(-1,-1,true, 21,null);
	public static block t = new block(-1,-1,true, 16,null);
	public static block e = new block(-1,-1,false, 0,null);
	public static block t1 = new block(-1,-1,true, 43,null);
	public static block t2 = new block(-1,-1,true, 44,null);
	public static block t3 = new block(-1,-1,true, 45,null);
	public static block t4 = new block(-1,-1,false, 46,null);
	public static block D = new block(-1,-1,false, 42,new Runnable() {
	
	
		@Override
		public void run() {
			
			maps.nextLvl();
		}
		
	});
	public static block De = new block(-1,-1,false, 42,new Runnable() {

		@Override
		public void run() {
			if(!Game.player.controls) return;
			Game.level[Game.idx].x += 5;
			if(Game.level[Game.idx].x > Game.player.px) {
				Game.loadMap(maps.map1_3);
				diologs.clearBuff();
				diologs.add("Знаешь что? вот тебе!");
				diologs.start();
			}
			maps.nextLvl();
		}
		
	});
	public static block Do = new block(-1,-1,false, 42,new Runnable() {

		private int tmp = 0;

		@Override
		public void run() {
			
			
			if(Game.player.pidx == 272) {
				
				if(tmp == 0) {
				diologs.clearBuff();
				diologs.add("Стоп, ты не можешь добрыгнуть?");
				diologs.add("Мдээ... кажешься я немного просчитался...");
				diologs.add("Попробуем-ка вот так!");
				diologs.add("");

				diologs.add("Попробуй теперь.");
				diologs.start();
				tmp = 1;	
				}
				
				
			}
			if(tmp == 1) {
				if(Game.level[Game.idx].x > 300) {
					Game.level[Game.idx].x -= 1;
				}else if(Game.level[Game.idx].y < 300) {
					Game.level[Game.idx].y += 1;
				}else {
					tmp = 2;
				}
				
			}
			if(tmp == 2) {
				if(Game.level[Game.idx].x < 384) {
					Game.level[Game.idx].x += 1;
				}else if(Game.level[Game.idx].y > 176) {
					Game.level[Game.idx].y -= 1;
				}else {
					tmp++;
				}
			}
			if(tmp > 500 && tmp < 1000) {
				diologs.clearBuff();
				diologs.add("ты надо мной издеваешься?");
				diologs.add("сечас полетишь");
				diologs.start();
				if (tmp > 600) {
					maps.nextLvl(maps.map3_1);
				}
				
			}
			System.out.println(tmp);
			maps.nextLvl();
		}
		
	});
}
