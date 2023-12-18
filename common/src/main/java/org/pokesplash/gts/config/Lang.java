package org.pokesplash.gts.config;

import com.google.gson.Gson;
import org.pokesplash.gts.Gts;
import org.pokesplash.gts.util.Utils;

import java.util.concurrent.CompletableFuture;

public class Lang {
	// placeholders
	// {listing}
	// {seller}
	// {buyer}
	// {max_listings}
	// {min_price}
	// {max_price}
	private String title; // Title shown on the top of the UI
	private String purchase_message_buyer; // Message that is sent to the buyer of a listing
	private String cancel_listing; // Message sent to the player that cancels a listing.
	private String return_listing_success; // Message sent to the player that gets a listing returned
	private String return_listing_fail; // Message sent to the player that gets a failed receive listing
	private String maximum_listings; // Message for when a player exceeds their maximum amount of listings.
	private String minimum_listing_amount; // Message to inform the player of the minimum listing amount for that
	private String maximum_listing_price; // Message to inform player of the maximum listing amount.
	private String listing_success; // Message to confirm a listing.
	private String listing_fail; // Message to confirm a listing.
	private String no_pokemon_in_slot; // No listing in the given slot.
	private String no_item_in_hand; // No item in the players hand.
	private String item_is_banned; // The item they're trying to list is banned.
	private String not_enough_items; // Not enough items in the players inventory
	private String no_item_id_found; // Couldn't find the item ID of the given item.
	private String item_amount_is_zero; // If the item amount given is 0.
	private String reload_message; // Message sent when reload command is executed.
	private String insufficient_funds; // Not enough monies.
	private String listing_bought; // Message sent to seller when their listing is bought.
	private String item_listing_display; // The display item for the "item listings" menu.
	private String pokemon_listing_display; // The display item for the "pokemon listings" menu.
	private String manage_listing_display; // The display item for the "manage listings" menu.
	private String expired_listing_display; // The material for the expired listings button.
	private String next_page_display; // The display item for the "next page" button.
	private String previous_page_display; // The display item for the "previous page" button.
	private String filler_item; // The filler item for the UI.
	private String purchase_button; // The material for the purchase button.
	private String cancel_button; // The material for the cancel button.
	private String remove_listing_button; // The material for the remove listing moderation button.
	private String sort_price_button; // The material for the sort by price button.
	private String sort_newest_button; // The material for the sort by newest button.
	private String sort_name_button; // The material for the sort by name button.
	private String broadcast_message; // Message sent when a new listing is added.
	private String seller; // Seller of the listing.
	private String price; // Price of the listing.
	private String time_remaining; // Time Remaining for the listing.
	private String confirm_purchase; // The name of the "Confirm Purchase" button.
	private String cancel_purchase; // The name of the "Cancel Purchase" button.
	private String remove_listing; // The name of the "Remove Listing" button.
	private String see_item_listings; // The name of the "See Item Listings" button.
	private String see_pokemon_listings; // The name of the "See Pokemon Listings" button.
	private String manage_listings; // The name of the "Manage Listings" button.
	private String next_page; // The name of the "Next Page" button.
	private String previous_page; // The name of the "Previous Page" button.
	private String sort_by_price; // The name of the "Sort By Price" button.
	private String sort_by_newest; // The name of the "Sort By Newest" button.
	private String sort_by_pokemon; // The name of the "Sort By Pokemon" button.
	private String sort_by_name; // The name of the "Sort By Name" button.
	private String receive_listing; // The name of the "Receive Listing" button.
	private String ball; // Ball type lore.


	/**
	 * Constructor to generate a file if one doesn't exist.
	 */
	public Lang() {
		title = "Gts";
		purchase_message_buyer = "§2You have bought {listing} from {seller}!";
		cancel_listing = "§6The {listing} listing has been cancelled!";
		return_listing_success = "§2You have received the {listing} listing!";
		return_listing_fail = "§cCould not receive the {listing} listing.";
		maximum_listings = "§cYou can only have a total of {max_listings} listings.";
		minimum_listing_amount = "§cYour listing must meet the minimum price of {min_price}";
		maximum_listing_price = "§cYour listing must be below the maximum price of {max_price}";
		listing_success = "§2Successfully added your {listing} to GTS!";
		listing_fail = "§cFailed to add your {listing} to GTS!";
		no_pokemon_in_slot = "§cCould not find any Pokemon in the given slot!";
		no_item_in_hand = "§cCould not find an item in your hand!";
		item_is_banned = "§c{listing} is banned from GTS!";
		not_enough_items = "§cYou don't have enough {listing} in your inventory to list this item!";
		no_item_id_found = "§cCould not find an item!";
		item_amount_is_zero = "§cListing amount can not be zero!";
		reload_message = "§2Reloaded Configs!";
		insufficient_funds = "§cYou do not have enough money to purchase this listing!";
		listing_bought = "§2Your {listing} has been bought by {buyer}";
		item_listing_display = "cobblemon:assault_vest";
		pokemon_listing_display = "cobblemon:poke_ball";
		manage_listing_display = "cobblemon:sachet";
		next_page_display = "minecraft:arrow";
		previous_page_display = "cobblemon:poison_barb";
		filler_item = "minecraft:white_stained_glass_pane";
		purchase_button = "minecraft:green_stained_glass_pane";
		cancel_button = "minecraft:red_stained_glass_pane";
		sort_price_button = "minecraft:gold_nugget";
		sort_newest_button = "minecraft:clock";
		sort_name_button = "minecraft:oak_sign";
		expired_listing_display = "cobblemon:link_cable";
		remove_listing_button = "minecraft:orange_stained_glass_pane";
		broadcast_message = "§e{seller} §2has just added a §e{listing} §2to GTS.";
		seller = "§9Seller: §b";
		price = "§9Price: §b";
		time_remaining = "§9Time Remaining: §b";
		confirm_purchase = "§2Confirm Purchase";
		cancel_purchase = "§cCancel Purchase";
		remove_listing = "§6Remove Listing";
		see_item_listings = "§9See Item Listings";
		see_pokemon_listings = "§9See Pokemon Listings";
		manage_listings = "§dManage Listings";
		next_page = "§7Next Page";
		previous_page = "§7Previous Page";
		sort_by_price = "§eSort By Price";
		sort_by_newest = "§3Sort By Newest";
		sort_by_pokemon = "§6Sort By Pokemon";
		sort_by_name = "§6Sort By Name";
		receive_listing = "§2Receive Listing";
		ball = "§2Ball: ";
	}

	/**
	 * Bunch of getters for the fields.
	 */
	public String getPurchase_message_buyer() {
		return purchase_message_buyer;
	}
	public String getTitle() {
		return title;
	}
	public String getCancel_listing() {
		return cancel_listing;
	}
	public String getReturn_listing_success() {
		return return_listing_success;
	}
	public String getReturn_listing_fail() {
		return return_listing_fail;
	}
	public String getMaximum_listings() {
		return maximum_listings;
	}
	public String getMinimum_listing_amount() {
		return minimum_listing_amount;
	}
	public String getMaximum_listing_price() {
		return maximum_listing_price;
	}
	public String getListing_success() {
		return listing_success;
	}
	public String getListing_fail() {
		return listing_fail;
	}
	public String getNo_pokemon_in_slot() {
		return no_pokemon_in_slot;
	}
	public String getNo_item_in_hand() {
		return no_item_in_hand;
	}
	public String getItem_is_banned() {
		return item_is_banned;
	}
	public String getNot_enough_items() {
		return not_enough_items;
	}
	public String getNo_item_id_found() {
		return no_item_id_found;
	}
	public String getItem_amount_is_zero() {
		return item_amount_is_zero;
	}
	public String getReload_message() {
		return reload_message;
	}
	public String getInsufficient_funds() {
		return insufficient_funds;
	}
	public String getListing_bought() {
		return listing_bought;
	}
	public String getItem_listing_display() {
		return item_listing_display;
	}
	public String getPokemon_listing_display() {
		return pokemon_listing_display;
	}
	public String getManage_listing_display() {
		return manage_listing_display;
	}
	public String getNext_page_display() {
		return next_page_display;
	}
	public String getPrevious_page_display() {
		return previous_page_display;
	}
	public String getFiller_item() {
		return filler_item;
	}
	public String getPurchase_button() {
		return purchase_button;
	}
	public String getCancel_button() {
		return cancel_button;
	}
	public String getSort_price_button() {
		return sort_price_button;
	}
	public String getSort_newest_button() {
		return sort_newest_button;
	}
	public String getSort_name_button() {
		return sort_name_button;
	}
	public String getExpired_listing_display() {
		return expired_listing_display;
	}
	public String getRemove_listing_button() {
		return remove_listing_button;
	}
	public String getBroadcast_message() {
		return broadcast_message;
	}
	public String getSeller() {
		return seller;
	}
	public String getPrice() {
		return price;
	}
	public String getTime_remaining() {
		return time_remaining;
	}
	public String getConfirm_purchase() {
		return confirm_purchase;
	}
	public String getCancel_purchase() {
		return cancel_purchase;
	}
	public String getRemove_listing() {
		return remove_listing;
	}
	public String getSee_item_listings() {
		return see_item_listings;
	}
	public String getSee_pokemon_listings() {
		return see_pokemon_listings;
	}
	public String getManage_listings() {
		return manage_listings;
	}
	public String getNext_page() {
		return next_page;
	}
	public String getPrevious_page() {
		return previous_page;
	}
	public String getSort_by_price() {
		return sort_by_price;
	}
	public String getSort_by_newest() {
		return sort_by_newest;
	}
	public String getSort_by_pokemon() {
		return sort_by_pokemon;
	}
	public String getSort_by_name() {
		return sort_by_name;
	}
	public String getReceive_listing() {
		return receive_listing;
	}
	public String getBall() {
		return ball;
	}

	/**
	 * Method to initialize the config.
	 */
	public void init() {
		CompletableFuture<Boolean> futureRead = Utils.readFileAsync("/config/gts/", "lang.json",
				el -> {
					Gson gson = Utils.newGson();
					Lang lang = gson.fromJson(el, Lang.class);
					title = lang.getTitle();
					purchase_message_buyer = lang.getPurchase_message_buyer();
					cancel_listing = lang.getCancel_listing();
					return_listing_success = lang.getReturn_listing_success();
					return_listing_fail = lang.getReturn_listing_fail();
					maximum_listings = lang.getMaximum_listings();
					minimum_listing_amount = lang.getMinimum_listing_amount();
					maximum_listing_price = lang.getMaximum_listing_price();
					listing_success = lang.getListing_success();
					listing_fail = lang.getListing_fail();
					no_pokemon_in_slot = lang.getNo_pokemon_in_slot();
					no_item_in_hand = lang.getNo_item_in_hand();
					item_is_banned = lang.getItem_is_banned();
					not_enough_items = lang.getNot_enough_items();
					no_item_id_found = lang.getNo_item_id_found();
					item_amount_is_zero = lang.getItem_amount_is_zero();
					reload_message = lang.getReload_message();
					insufficient_funds = lang.getInsufficient_funds();
					listing_bought = lang.getListing_bought();
					item_listing_display = lang.getItem_listing_display();
					pokemon_listing_display = lang.getPokemon_listing_display();
					manage_listing_display = lang.getManage_listing_display();
					next_page_display = lang.getNext_page_display();
					previous_page_display = lang.getPrevious_page_display();
					filler_item = lang.getFiller_item();
					purchase_button = lang.getPurchase_button();
					cancel_button = lang.getCancel_button();
					sort_price_button = lang.getSort_price_button();
					sort_newest_button = lang.getSort_newest_button();
					sort_name_button = lang.getSort_name_button();
					expired_listing_display = lang.getExpired_listing_display();
					remove_listing_button = lang.getRemove_listing_button();
					broadcast_message = lang.getBroadcast_message();
					seller = lang.getSeller();
					price = lang.getPrice();
					time_remaining = lang.getTime_remaining();
					confirm_purchase = lang.getConfirm_purchase();
					cancel_purchase = lang.getCancel_purchase();
					remove_listing = lang.getRemove_listing();
					see_item_listings = lang.getSee_item_listings();
					see_pokemon_listings = lang.getSee_pokemon_listings();
					manage_listings = lang.getManage_listings();
					next_page = lang.getNext_page();
					previous_page = lang.getPrevious_page();
					sort_by_price = lang.getSort_by_price();
					sort_by_newest = lang.getSort_by_newest();
					sort_by_pokemon = lang.getSort_by_pokemon();
					sort_by_name = lang.getSort_by_name();
					receive_listing = lang.getReceive_listing();
					ball = lang.getBall();
		});

		if (!futureRead.join()) {
			Gts.LOGGER.info("No lang.json file found for GTS. Attempting to generate one.");
			Gson gson = Utils.newGson();
			String data = gson.toJson(this);
			CompletableFuture<Boolean> futureWrite = Utils.writeFileAsync("/config/gts/", "lang.json", data);

			if (!futureWrite.join()) {
				Gts.LOGGER.fatal("Could not write lang.json for GTS.");
			}
			return;
		}
		Gts.LOGGER.info("GTS lang file read successfully.");
	}
}
