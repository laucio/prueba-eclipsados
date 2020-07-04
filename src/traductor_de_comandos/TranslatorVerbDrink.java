package traductor_de_comandos;

import java.util.ArrayList;

import juego_de_aventura.*;

public class TranslatorVerbDrink implements CommandTranslator {

	private final static String[] VERBO_BEBER = { " beber ", " escabiar ", " hidratarse ", " trasegar ", " ingerir " };

	private CommandTranslator next = null;

	public TranslatorVerbDrink(CommandTranslator next) {
		this.next = next;
	}

	@Override
	public void translateCommand(String command, Action action, Game game) {

		boolean translated = false;

		int i = 0;
		while (!translated && i < VERBO_BEBER.length) {

			if (command.contains(VERBO_BEBER[i])) {
				translated = true;
				action.setAction("beber");
			}

			i++;
		}
		
		
		if(translated) {
				ArrayList<String> objs = new ArrayList<String>();
				Adventure adventure = game.getAdventure();
 				adventure.ItemsOcurrences(command, objs);
				int cant = objs.size();
				switch(cant) {
				case 0:
					action.setCondition("unknown");
					break;
				case 1:
					action.setCondition("item");
					action.setThing(objs.get(0));
					action.setTarget("self");
					action.setEffect_over("self");
					break;
				case 2:
					action.setCondition("tooManyThings");
					break;
				}
			}
			

		if (!translated) {
			next.translateCommand(command, action, game);
		}

	}

}
