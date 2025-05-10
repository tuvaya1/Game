package Game;

import java.io.File;
import java.io.FileNotFoundException;

import Display.Display;
import Game.mapss.mapss;

public class maps extends mapss {
	
	
	static void nextLvl(block[] map) {
		if(!Game.player.controls) return;
		int idx = (Game.level[Game.idx].x/16)+((Game.level[Game.idx].y/16)*Game.Gmax);
		System.out.println(idx);
		if(idx == Game.player.pidx) {
			
				Game.loadMap(map);
			
			
			Game.player.px = Game.level[880].x;
			Game.player.py = Game.level[880].y;
			Game.player.lvlDeaths = 0;
			
		}
	}
	
	static void nextLvl() {
		if(!Game.player.controls) return;
		int idx = (Game.level[Game.idx].x/16)+((Game.level[Game.idx].y/16)*Game.Gmax);
		System.out.println(idx);
		if(idx == Game.player.pidx) {
			if(Game.levelidx == 1)
				Game.loadMap(mapss.map2);
			if(Game.levelidx == 2)
				Game.loadMap(mapss.map3);
			if(Game.levelidx == 3)
				Game.loadMap(mapss.map4);
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
			if(Game.levelidx == 3) {
				if(Game.player.Deaths < 2) {
					diologs.add("Ого, ты снова смог!");
					diologs.add("Кажеться все идет неплохо.");
					diologs.add("Надеюсь тебе понравиться этот уровень, я очень старался.");
				}else if(Game.player.Deaths == 2) {
					diologs.add("Отлично, ты прошел...");
					diologs.add("видимо мне нужно получше думать над дизайном уровня");
				}else {
					diologs.add("Ухх... наконец то...");
					diologs.add("Извини меня, с этим уровнем точно проблем не будет");
				}
			}
			diologs.start();
			
			}
	}
	
	
	
	
	
	
	
	
}
