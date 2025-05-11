package Game;

import java.io.IOException;

import Display.Display;
import Game.mapss.mapss;

public class blocks {
	public static block tech = new block(128,258,true, 0,null);
	public static block tech2 = new block(272,304,true, 0,null);
	public static block tech3 = new block(128,240,true, 0,null);
	public static block tech3_1 = new block(304,32,true, 0,null);
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
	
	public static block ඞ = new block(-1,-1,false, 19,new Runnable() {

		private int tmp = 0;
		
		@Override
		public void run() {
			if (Game.player.pidx == 579 && tmp > -1) {
				tmp++;
			}
			if (tmp > 100) {
				
				diologs.clearBuff();
				diologs.add("ТЫ ИЗДЕВАЕШЬСЯ!");
				diologs.add("просто пройди уже последний уровень...");
				diologs.start();
				maps.nextLvl();
				Game.besuka++;
				tmp = -1;
			}
			
		}});
	public static block t1 = new block(-1,-1,true, 43,new Runnable() {

		@Override
		public void run() {
			if(Game.player.pidx == 179 && Game.level[Game.idx].texture < 46) {
				Game.level[Game.idx].texture++;
			}
			if(Game.level[Game.idx].texture == 46) Game.level[Game.idx].collision = false;
		}
		
	});
	
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
				Game.loadMap(mapss.map1_3);
				diologs.clearBuff();
				diologs.add("Знаешь что? вот тебе!");
				Game.besuka++;
				diologs.start();
			}
			maps.nextLvl();
		}
		
	});
	public static int toDis = 0;
	public static block Dv = new block(-1,-1,false, 42,new Runnable() {
		
		private int tmp = 0;
		
		@Override
		public void run() {
			int idx = Game.player.pidx;
			if (tmp == 0 && (idx == 468 || idx == 428 || idx == 429)) {
				
				tmp = 1;
				
				
			}
			if (tmp == 1) {
				endset();
				tmp = 2;
			}
			if(tmp > 0) {
				toDis--;
				if(toDis< 0 && Game.besuka == 3) {
					if(Game.SaveMode) {
						Display.window.dispose();
						System.exit(0);
					}else {
						try {
							Runtime.getRuntime().exec("cmd /c start \"\" RunGamе.bat");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Display.window.dispose();
						System.exit(0);
					}
				}
				Game.level[Game.idx].y += 5;
				
			}
		}
		
		
	});
	
	private static void endset() {
		Game.music.stop();
		Game.endingM.play();
		diologs.clearBuff();
		Game.ending = true;
		Game.player.controls = true;
		if (Game.besuka == 0) {
			diologs.add("Ура, ты прошел мою игру!");
			diologs.add("Ты харош!");
			diologs.add("Закрывай игру");
		}else if (Game.besuka == 3) {
			diologs.add("ТЫ УЖАСЕН!");
			diologs.add("Я НЕ МОГУ ПРЕДСТАВИТЬ НИ ОДНОГО ЧЕЛОВЕКА КОТОРЫЙ ТАК ПЛОХО ИГРАЕТ!");
			diologs.add("ЗНАЕШЬ ЧТО?!");
			diologs.add("АРИВИДЕРЧИ!");
			toDis = 800;
		}else {
			diologs.add("Хорошо");
			diologs.add("Не идеально, но хорошо");
			diologs.add("Спасибо за игру");
			diologs.add("Закрывай игру");
		}
		diologs.start();
		System.out.println("!");
	}
	
	public static block Do = new block(-1,-1,false, 42,new Runnable() {

		private int tmp = 0;

		@Override
		public void run() {
			
			
			if(Game.player.pidx == 272) {
				
				if(tmp == 0) {
				diologs.clearBuff();
				diologs.add("Стоп, ты не можешь допрыгнуть?");
				diologs.add("Мдээ... кажется я немного просчитался...");
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
			if (tmp > 2 && tmp < 800) {
				tmp++;
			}
			if(tmp > 500 && tmp < 600) {
				diologs.clearBuff();
				diologs.add("ты надо мной издеваешься?");
				diologs.add("сечас полетишь");
				diologs.start();
				
				
			}
			if (tmp == 800) {
				maps.nextLvl(mapss.map3_1);
				tmp ++;
			}
			//System.out.println(tmp);
			maps.nextLvl();
		}
		
	});
	
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
				diologs.add("Если ты их касаешься - ты умираешь.");
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
				Game.loadMap(mapss.map1_1);
				diologs.add("aa... Окей, кажется я сделал этот уровень слишком сложным.");
				diologs.add("Смотри, я уменьшил колличесво шипов, попробуй ещё раз");
			
				
				}
				if(player.lvlDeaths == 4) {
				Game.loadMap(mapss.map1_2);
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
				Game.loadMap(mapss.map2_1);
				diologs.add("Окей, хорошо.");
				diologs.add("Теперь не должно быть проблем.");
				Game.besuka++;
				
				}
				if(player.lvlDeaths == 4) {
				
				diologs.add("По твоему это смешно?");
				diologs.add("Ты делаешь это специально?");
				diologs.add("Ты должен просто дойти до двери, это так сложно?");
				diologs.add("Я сделал этот уровень более легким");
				
				}
				if(player.lvlDeaths == 5) {
					maps.nextLvl();
					diologs.add("Ладно, ладно, этот уровень будет намного лучше.");
					diologs.add("Смотри.");
				}
				
			}
			if(Game.levelidx == 3) {
				if(player.lvlDeaths == 1) {
				
				diologs.add("Попробуй ещё раз");
				
				}
				if(player.lvlDeaths == 2) {
				
				diologs.add("*вздыхает*");

				}
				if(player.lvlDeaths == 3) {
				
				diologs.add("Ладно, кажется я перестарался...");
				diologs.add("Надеюсь теперь ты его пройдешь.");
				for(int i = 0; i < Game.Gmax*Game.Gmay; i++) {
					if((Game.level[i].texture > 37 && Game.level[i].texture < 42))
					Game.level[i] = e;
				}
				}
				if(player.lvlDeaths == 4) {
					
				diologs.add("Просто иди к финишу");
				diologs.add("Я так много прошу?");
				
				}
				
				
			}
			if(Game.levelidx == 4) {
				
				diologs.add("Это почти конец, попробуй ещё");
				
			}
			diologs.start();
			}
			
		}
		
	};
	public static block us = new block(-1,-1,false, 38, spikeAct);
	public static block ds = new block(-1,-1,false, 40, spikeAct);
	public static block rs = new block(-1,-1,false, 39, spikeAct);
	public static block ls = new block(-1,-1,false, 41, spikeAct);
}
