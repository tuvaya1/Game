package Game;

import java.io.File;
import java.io.FileNotFoundException;

import Display.Display;

public class maps {
	
	static block tech = new block(128,258,true, 0,null);
	static block tech2 = new block(272,304,true, 0,null);
	static block tech3 = new block(128,240,true, 0,null);
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
	static block rr = new block(-1,-1,true, 21,null);
	static block t = new block(-1,-1,true, 16,null);
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
			if(Game.level[Game.idx].x > Game.player.px) {
				Game.loadMap(map1_3);
				diologs.clearBuff();
				diologs.add("Знаешь что? вот тебе!");
				diologs.start();
			}
			nextLvl();
		}
		
	});
	static block Do = new block(-1,-1,false, 42,new Runnable() {

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
					tmp = 3;
				}
			}
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
			if(Game.levelidx == 3)
				Game.loadMap(map4);
			Game.player.px = Game.level[880].x;
			Game.player.py = Game.level[880].y;
			Game.player.lvlDeaths = 0;
			Game.levelidx++;
			diologs.clearBuff();
			if(Game.levelidx == 2) {
				if(Game.player.Deaths < 3) {
					diologs.add("Молодец, ты справился!");
					diologs.add("Вот и новый уровень!");
				}else if(Game.player.Deaths < 4) {
					diologs.add("Фуух, наконец ты прошел.");
					diologs.add("Видимо я немного перестарался.");
					diologs.add("Постараюсь чтобы следующие уровни были полегче");
					diologs.add("Надеюсь я не испортил тебе настроение...");
				}else {
					diologs.add("Наконец-то.");
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
				diologs.add("Я говорил не \"сможешь ли ты коснуться шипов\",");
				diologs.add("а \"сможешь ли ты перепрыгнуть шипы\",");
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
			if(Game.levelidx == 2) {
				if(player.lvlDeaths == 1) {
				
				diologs.add("Попробуй ещё раз");
				
				}
				if(player.lvlDeaths == 2) {
				
				diologs.add("ладно, видимо я поставил слишком много шипов.");
				diologs.add("может мне убрать парочку?.");

				
				}
				if(player.lvlDeaths == 3) {
				Game.loadMap(map2_1);
				diologs.add("Окей, хорошо.");
				diologs.add("Теперь не должно быть проблем.");
			
				
				}
				if(player.lvlDeaths == 4) {
				
				diologs.add("По твоему это смешно?");
				diologs.add("Ты делаешь это специально?");
				diologs.add("Ты должен просто дойти до двери, это так сложно?");
			
				
				}
				if(player.lvlDeaths == 5) {
					nextLvl();
					diologs.add("Ладно, ладно, этот уровень будет наного лучше.");
					diologs.add("Смотри.");
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
	static block[] map1_3 = {
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
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,e,e,     e,e,e,e,e,     e,e,e,e,e, e,e,e,e,e, e,e,e,l,w,
			                                                                
			w,r,D,D,D,  D,D,D,D,D, D,D,D,D,D, D,D,D,D,D,     D,D,D,D,D,     D,D,D,D,D, D,D,D,D,D, D,D,D,l,w,
			w,r,D,D,D,  D,D,D,D,D, D,D,D,D,D, D,D,D,D,D,     D,D,D,D,D,     D,D,D,D,D, D,D,D,D,D, D,D,D,l,w,
			tech
			
			
			
	};
	static block[] map2_1 = {
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w, w, w, w, w,    w,w,w,w, w,   w, w, w, w, w,     w,w,w,w,w, w,w,w,w,w,
			w,dr,d,d,d, d,d,d,d,d, d,d,d,d,d, d, d, d, d, d,    d,d,d,d, d,   d, d, d, d, d,     d,d,d,d,d, d,d,d,dl,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,                                                                                                    
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, D, e,     e,e,e,e,e, e,e,e,l,w,                                                                                                    
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, lu,  u, u, u, ru,e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, ld,  d, d, d, rd,e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, ds,  ds,ds,ds,ds,e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, lu,u, u, u, ru,   e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,                                                                                      
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, ld,d, d, d, rd,   e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, ds,ds,ds,ds,ds,   e,e,e,e, e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,lu,ru,  e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,l, r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,l, r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,                                                                                   
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, lu,u, u, u, u,    u,u,u,ul,r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, l, w, w, w, w,    w,w,w,w, r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			tech2
			
			
	};
	static block[] map2 = {
			w,w,w,w,w,  w,w,w,w,w, w,w,w,w,w, w, w, w, w, w,    w,w,w,w,  w,   w, w, w, w, w,     w,w,w,w,w, w,w,w,w,w,
			w,dr,d,d,d, d,d,d,d,d, d,d,d,d,d, d, d, d, d, d,    d,d,d,d,  d,   d, d, d, d, d,     d,d,d,d,d, d,d,d,dl,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,                                                                                                    
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, D, e,     e,e,e,e,e, e,e,e,l,w,                                                                                                    
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,ls, lu,  u, u, u, ru,e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,ls, ld,  d, d, d, rd,e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  ds,  ds,ds,ds,ds,e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, lu,u, u, u, ru,   e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,                                                                                      
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, ld,d, d, d, rd,   e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, ds,ds,ds,ds,ds,   e,e,e,e,  e,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,ls,lu,ru,  e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,ls,l, r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, e, e, e, e, e,    e,e,ls,l, r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,                                                                                   
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, lu,u, u, u, u,    u,u,u,ul, r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			w,r,e,e,e,  e,e,e,e,e, e,e,e,e,e, l, w, w, w, w,    w,w,w,w,  r,   e, e, e, e, e,     e,e,e,e,e, e,e,e,l,w,
			tech2
			
			
	};
	static block[] map3 = {
			w,w,w,w,w,         w,w,w,w,w,          w,w,w,w,w,        w,w,w,w,w,      w,w,w,w,w,       w,w,w,w,w,      w,w,w,w,w,        w,w,w,w,w,
			w,dr,d,d,d,        d,d,d,d,d,          d,d,d,d,d,        d,d,d,d,d,      d,d,d,d,d,       d,d,d,d,d,      d,d,d,d,d,        d,d,d,dl,w,
			w,r,ds,ds,ds,      ds,ds,ds,ds,ds,     ds,ds,ds,ds,ds,   ds,ds,ds,ds,ds, ds,ds,ds,ds,ds,  ds,ds,ds,ds,ds, ds,ds,ds,ds,ds,   ds,ds,ds,l,w,
			w,r,rs,e,e,        e,e,e,e,e,          e,e,e,e,e,        e,e,e,e,e,      e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,e,        e,e,ls,l,w,
			w,r,rs,e,e,        lu,ru,e,e,e,        e,e,e,e,e,        e,e,e,e,e,      e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,e,        e,e,ls,l,w,
			                                                                                                                               
			w,r,rs,e,e,        l,r,e,e,e,          e,e,e,e,e,       e,e,e,e,e,       e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,Do,        e,e,ls,l,w,  
			w,r,rs,e,e,        l,r,e,e,e,          e,e,e,e,lu,      u,u,u,u,u,       ru,e,e,e,e,      e,e,e,e,e,      e,e,e,lu,ru,      e,e,ls,l,w,  
			w,r,rs,e,e,        l,r,e,e,e,          e,e,e,e,ld,      d,d,d,d,dl,      r,e,e,e,e,       e,e,e,e,e,      e,e,e,l,r,        e,e,ls,l,w,  
			w,r,rs,e,e,        l,r,e,e,e,          e,e,e,e,ds,      ds,ds,ds,ds,l,   r,e,e,e,e,       e,e,e,e,e,      e,e,e,l,r,        e,e,ls,l,w,  
			w,r,rs,e,e,        ld,d,t,t,rr,        e,e,e,e,lu,      u,u,ru,ls,l,     r,e,e,e,e,       e,e,e,e,e,      e,e,e,l,r,        e,e,ls,l,w, 
			                                                                                                                                       
			w,r,rs,e,e,        ds,ds,ds,ds,ds,     e,e,e,e,ld,      d,dl,r,ls,l,     r,e,e,e,e,       e,e,e,e,e,      e,e,e,l,r,       e,e,ls,l,w, 
			w,r,rs,e,e,        e,e,e,e,e,          e,e,e,e,ds,      ds,l,r,ls,l,     r,e,e,e,e,       e,e,e,e,e,      e,e,e,l,r,       e,e,ls,l,w,  
			w,r,rs,e,e,        e,e,e,e,e,          e,e,e,e,e,       e,l,r,ls,l,      ur,u,u,u,u,      u,u,u,u,u,      u,u,u,ul,r,      e,e,ls,l,w,  
			w,r,rs,e,e,        e,e,e,e,e,          e,e,e,e,e,       e,l,r,ls,ld,     d,d,d,d,d,       d,d,d,d,d,      d,d,d,d,rd,      e,e,ls,l,w,  
			w,r,rs,e,e,        e,e,e,e,e,          lu,ru,e,e,e,     e,l,r,e,e,       e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,e,       e,e,ls,l,w,  
			                                                                                                                                        
			w,r,rs,e,e,        e,e,e,e,e,          l,r,us,us,us,    us,l,r,e,e,      e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,e,       e,e,ls,l,w,  
			w,r,rs,e,e,        lu,u,u,u,u,         ul,r,u,u,u,      u,ul,r,e,e,      e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,e,       e,e,ls,l,w, 
			w,r,rs,e,e,        l,dr,d,d,d,         d,rd,d,d,d,      d,d,rd,e,e,      e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,e,       e,e,ls,l,w, 
			w,r,rs,e,e,        l,r,ds,ds,ds,       ds,ds,ds,ds,ds,  ds,ds,ds,e,e,    e,e,e,e,e,       e,e,e,e,e,      e,e,e,e,e,       e,e,ls,l,w,  
			w,r,us,us,us,      l,r,us,us,us,       us,us,us,us,us,  us,us,us,us,us,  us,us,us,us,us,  us,us,us,us,us, us,us,us,us,us,   us,us,us,l,w,
			                                                  
			w,ur,u,u,u,     u,u,u,u,u,      u,u,u,u,u,        u,u,u,u,u,          u,u,u,u,u,       u,u,u,u,u,      u,u,u,u,u,      u,u,u,ul,w,
			w,w,w,w,w,      w,w,w,w,w,      w,w,w,w,w,        w,w,w,w,w,          w,w,w,w,w,       w,w,w,w,w,      w,w,w,w,w,      w,w,w,w,w,
			tech3                 
			
			

	};
	
	static block[] map4 = {
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
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			                                                  
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,e,e,e, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, e,e,e,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   e,e,e,e,e,     e,e,e,e,e,  e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			                                                  
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   w,w,w,w,w,     w,w,w,w,w,  e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			w,w,w,w,w, e,e,e,e,e, e,e,e,e,e,   w,w,w,w,w,     w,w,w,w,w,  e,e,e,e,e, e,e,e,e,e, w,w,w,w,w,
			tech2
			
			
	};
}
