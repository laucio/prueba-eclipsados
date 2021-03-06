package traductor_de_comandos;

import juego_de_aventura.*;

public class Translator implements CommandTranslator{
	
	private CommandTranslator translatorDefault;
	private CommandTranslator verbToGoOut;
	private CommandTranslator verbToGo;
	private CommandTranslator verbToLeave;
	private CommandTranslator verbToTake;
	private CommandTranslator verbToObserve;
	private CommandTranslator verbToTalk;
	private CommandTranslator verbToUse;
	private CommandTranslator verbToOpen;
	private CommandTranslator verbToBreak;
	private CommandTranslator verbToDrink;
	private CommandTranslator verbToEat;
	private CommandTranslator verbToAttack;
	private CommandTranslator verbToGive;
	private CommandTranslator verbSenses;
	private CommandTranslator verbToWatchInventory;
	private CommandTranslator verbToSeeAround;
	private CommandTranslator translatorRidiculous;
	private CommandTranslator translatorOthers;
	
	public Translator() {
		translatorDefault = new TranslatorDefault();
		verbToGoOut = new TranslatorGoOut(translatorDefault);
		verbToGo = new TranslatorWithVerbGo(verbToGoOut);
		verbToLeave = new TranslatorVerbLeave(verbToGo);
		verbToTake = new TranslatorWithVerbTake(verbToLeave);
		verbToObserve = new TranslatorVerbObserve(verbToTake);
		verbToUse = new TranslatorWithVerbUse(verbToObserve);
		verbToOpen = new TranslatorVerbOpen(verbToUse);
		verbToBreak = new TranslatorVerbBreak(verbToOpen);
		verbToDrink = new TranslatorVerbDrink(verbToBreak);
		verbToEat = new TranslatorVerbEat(verbToDrink);
		verbToTalk = new TranslatorVerbTalkToNPC(verbToEat);
		verbToAttack = new TranslatorVerbAttack(verbToTalk);
		verbToGive = new TranslatorGive(verbToAttack);
		verbToWatchInventory = new TranslatorVerbWatchInventory(verbToGive);
		verbSenses = new TranslatorSenses(verbToWatchInventory);
		verbToSeeAround = new TranslatorVerbSeeAround(verbSenses);
		translatorRidiculous = new TranslatorRidiculous(verbToSeeAround);
		translatorOthers = new TranslatorOthers(translatorRidiculous);
	}
	
	@Override
	public void translateCommand(String command, Action action, Game game) {
		
		command = " " + command.toLowerCase() + " ";
		
		translatorOthers.translateCommand(command, action, game);
	}
	
	
}
