package Game;

import java.io.File;
import java.io.FileNotFoundException;

public class maps {
	
	static block tech = new block(128,128,true, 0,null);
	static block tech2 = new block(272,304,true, 0,null);
	static block w = new block(-1,-1,true, 19,null);
	static block d = new block(-1,-1,true, 24,null);
	static block u = new block(-1,-1,true, 14,null);
	static block r = new block(-1,-1,true, 20,null);
	static block l = new block(-1,-1,true, 18,null);
	static block rd = new block(-1,-1,true, 25,null);
	static block ru = new block(-1,-1,true, 15,null);
	static block ld = new block(-1,-1,true, 23,null);
	static block lu = new block(-1,-1,true, 13,null);
	static block dr = new block(-1,-1,true, 35,null);
	static block ur = new block(-1,-1,true, 30,null);
	static block dl = new block(-1,-1,true, 36,null);
	static block ul = new block(-1,-1,true, 31,null);
	
	static block e = new block(-1,-1,false, 0,null);
	static block D = new block(-1,-1,false, 42,new Runnable() {

		@Override
		public void run() {
			
			nextLvl();
		}
		
	});
	static block De = new block(-1,-1,false, 42,new Runnable() {

		@Override
		public void run() {
			if(!Game.player.controls) return;
			Game.level[Game.idx].x += 5;
			
			nextLvl();
		}
		
	});
	
	private static void nextLvl() {
		if(!Game.player.controls) return;
		int idx = (Game.level[Game.idx].x/16)+((Game.level[Game.idx].y/16)*Game.Gmax);
		System.out.println(idx);
		if(idx == Game.player.pidx) {
			if(Game.levelidx == 1)
				Game.loadMap(map2);
			if(Game.levelidx == 2)
				Game.loadMap(map3);
			Game.player.px = Game.level[880].x;
			Game.player.py = Game.level[880].y;
			Game.player.lvlDeaths = 0;
			Game.levelidx++;
			diologs.clearBuff();
			if(Game.levelidx == 2) {
				if(Game.player.Deaths < 3) {
					diologs.add("Молодец, ты справился!");
					diologs.add("Вот и новый уровень!");
				}else {
					diologs.add("Фуух, наконец ты прошел.");
					diologs.add("Видимо я немного перестарался.");
					diologs.add("Постараюсь чтобы следующие уровни были полегче");
					diologs.add("Надеюсь я не испортил тебе настроение...");
				}
			}
			diologs.start();
			
			}
	}
	
	
	static Runnable spikeAct = new Runnable() {

		@Override
		public void run() {
			
			if(Game.idx == Game.player.pidx) {
			Game.player.Death();
			diologs.clearBuff();
			if(Game.levelidx == 1) {
				if(player.lvlDeaths == 1) {
				
				diologs.add("Так, смотри,");
				diologs.add("Что бы пройти тебе нужно перепрыгнуть шипы");
				diologs.add("Если ты их косаешься - ты умираешь.");
				diologs.add("Ты ведь сможешь, да?");
				
				}
				if(player.lvlDeaths == 2) {
				
				diologs.add("...");
				diologs.add("Ладно, может ты не так понял.");
				diologs.add("Я гворил не \"сможешь ли ты коснуться шипов\",");
				diologs.add("а \"сможешьли ты перепрыгнуть шипы\",");
				diologs.add("понимаешь?");
				
				}
				if(player.lvlDeaths == 3) {
				Game.loadMap(map1_1);
				diologs.add("aa... Окей, кажется я сделал этот уровень слишком сложным.");
				diologs.add("Смотри, я уменьшил колличесво шипов, попробуй ещё раз");
			
				
				}
				if(player.lvlDeaths == 4) {
				Game.loadMap(map1_2);
				diologs.add("хорошо, я понял тебя...");
				diologs.add("Никаких шипов и выход будет идти к тебе автоматически!");
			
				
				}
			}
			diologs.start();
			}
			
		}
		
	};
	static block us = new block(-1,-1,false, 38, spikeAct);
	static block ds = new block(-1,-1,false, 40, spikeAct);
	static block rs = new block(-1,-1,false, 39, spikeAct);
	static block ls = new block(-1,-1,false, 41, spikeAct);
	
	
	
	static block[] map1 = {
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,dr,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,d,d,     d,d,d,d,d,     d,d,d,d,d, d,d,d,d,d, d,d,d,dl,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,us,us,us,us, us,us,us,us,e, e,e,e,e,e, e,e,e,D,e, e,e,e,l,w,
			w,ur,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,u,u,     u,u,u,u,u,     u,u,u,u,u, u,u,u,u,u, u,u,u,ul,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			                                                                
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			tech
			
			
			
	};
	static block[] map1_2 = {
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,dr,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,d,d,     d,d,d,d,d,     d,d,d,d,d, d,d,d,d,d, d,d,d,dl,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,De,e, e,e,e,l,w,
			w,ur,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,u,u,     u,u,u,u,u,     u,u,u,u,u, u,u,u,u,u, u,u,u,ul,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			                                                                
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			tech
			
			
			
	};
	static block[] map1_1 = {
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,dr,d,d,d, d,d,d,d,d, d,d,d,d,d, d,d,d,d,d,     d,d,d,d,d,     d,d,d,d,d, d,d,d,d,d, d,d,d,dl,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                                           
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,us,us,e,   e,e,e,e,e, e,e,e,D,e, e,e,e,l,w,
			w,ur,u,u,u, u,u,u,u,u, u,u,u,u,u, u,u,u,u,u,     u,u,u,u,u,     u,u,u,u,u, u,u,u,u,u, u,u,u,ul,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			                                                                
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,     w,w,w,w,w,     w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			tech
			
			
			
	};
	static block[] map2 = {
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,  w, w, w, w,    w,w,w,w, w,   w, w, w, w, w,     w,w,w,w,w, w,w,w,w,w,
			w,dr,d,d,d, d,d,d,d,d, d,d,d,d,d, d,  d, d, d, d,    d,d,d,d, d,   d, d, d, d, d,     d,d,d,d,d, d,d,d,dl,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			                                                                                                      
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, D, e,     e,e,e,e,e, e,e,e,l,w,
			                                                                                                      
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,ls,lu,  u, u, u, ru, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,ls,ld,  d, d, d, rd, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, ds,  ds,ds,ds,ds,e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, lu,  u, u, u, ru,  e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			                                                                                                   
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, ld,  d, d, d, rd,  e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, ds, ds,ds,ds,ds,   e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,ls,lu,ru, e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,ls,l,r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,  e, e, e, e,    e,e,ls,l,r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			                                                                                    
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, lu, u, u, u, u,    u,u,u,ul,r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, l,  w, w, w, w,    w,w,w,w, r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			tech2
			
			
	};
	
	static block[] map3 = {
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,   w,w,w,w,w,     w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,   w,w,w,w,w,     w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w,w,w,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			                                                              
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			                                                              
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,w,w,   w,w,w,w,w,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			                                                  
			w,w,e,e,e, e,e,e,e,e, e,e,e,w,w,   w,w,w,w,w,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,ds,ds, ds,ds,ds,ds,e, e,ls,w,w,e, e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,ls,w,w,e, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,ls,w,w,e, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,ls,w,w,e, e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			                                                  
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   w,w,w,w,w,     w,w,w,w,w,  e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   w,w,w,w,w,     w,w,w,w,w,  e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			tech2
			
			
	};
	
}
