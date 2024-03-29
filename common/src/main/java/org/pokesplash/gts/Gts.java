package org.pokesplash.gts;

import net.minecraft.server.MinecraftServer;
import org.pokesplash.gts.Listing.ListingsProvider;
import org.pokesplash.gts.command.basecommand.GtsCommand;
import org.pokesplash.gts.config.Config;
import org.pokesplash.gts.config.Lang;
import org.pokesplash.gts.history.HistoryProvider;
import org.pokesplash.gts.timer.TimerProvider;
import org.pokesplash.gts.util.CommandsRegistry;
import org.pokesplash.gts.util.GtsLogger;
import org.pokesplash.gts.util.Permissions;

public class Gts
{
	public static final String MOD_ID = "gts";
	public static final String LISTING_FILE_VERSION = "2.0";
	public static final String HISTORY_FILE_VERSION = "2.0";
	public static Config config;
	public static final Permissions permissions = new Permissions();
	public static ListingsProvider listings;
	public static HistoryProvider history;
	public static TimerProvider timers = new TimerProvider();
	public static final GtsLogger LOGGER = new GtsLogger();
	public static Lang language;
	public static MinecraftServer server;

	public static void init() {
		CommandsRegistry.addCommand(new GtsCommand());
		reload();
	}

	public static void reload() {
		config = new Config();
		listings = new ListingsProvider();
		history = new HistoryProvider();
		language = new Lang();
		config.init();
		listings.init();
		history.init();
		language.init();
	}
}
