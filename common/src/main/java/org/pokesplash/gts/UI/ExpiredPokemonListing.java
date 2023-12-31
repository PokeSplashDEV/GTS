package org.pokesplash.gts.UI;

import ca.landonjw.gooeylibs2.api.UIManager;
import ca.landonjw.gooeylibs2.api.button.Button;
import ca.landonjw.gooeylibs2.api.button.FlagType;
import ca.landonjw.gooeylibs2.api.button.GooeyButton;
import ca.landonjw.gooeylibs2.api.page.GooeyPage;
import ca.landonjw.gooeylibs2.api.page.Page;
import ca.landonjw.gooeylibs2.api.template.types.ChestTemplate;
import com.cobblemon.mod.common.item.PokemonItem;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import org.pokesplash.gts.Gts;
import org.pokesplash.gts.Listing.PokemonListing;
import org.pokesplash.gts.UI.module.PokemonInfo;
import org.pokesplash.gts.api.GtsAPI;
import org.pokesplash.gts.util.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * UI of the Expired Pokemon Listing page.
 */
public class ExpiredPokemonListing {

	/**
	 * Method that returns the page.
	 * @return SinglePokemonListing page.
	 */
	public Page getPage(PokemonListing listing) {

		Collection<Component> lore = new ArrayList<>();

		lore.add(Component.literal(Gts.language.getSeller() + listing.getSellerName()));
		lore.add(Component.literal(Gts.language.getPrice() + listing.getPriceAsString()));
		lore.add(Component.literal(Gts.language.getTime_remaining() + Utils.parseLongDate(listing.getEndTime() - new Date().getTime())));
		lore.addAll(PokemonInfo.parse(listing));

		Button pokemon = GooeyButton.builder()
				.display(PokemonItem.from(listing.getListing(), 1))
				.title(listing.getDisplayName())
				.lore(Component.class, lore)
				.build();

		Button receiveListing = GooeyButton.builder()
				.display(Utils.parseItemId(Gts.language.getPurchase_button()))
				.title(Gts.language.getReceive_listing())
				.onClick((action) -> {
					boolean success = GtsAPI.returnListing(action.getPlayer(), listing);

					String message = "";

					if (success) {
						message = Utils.formatPlaceholders(Gts.language.getReturn_listing_success(),
								0, listing.getListing().getDisplayName().getString(), listing.getSellerName(),
								action.getPlayer().getName().getString());
						action.getPlayer().sendSystemMessage(Component.literal(message));
					} else {
						message = Utils.formatPlaceholders(Gts.language.getReturn_listing_fail(),
								0, listing.getListing().getDisplayName().getString(), listing.getSellerName(),
								action.getPlayer().getName().getString());
						action.getPlayer().sendSystemMessage(Component.literal(message));
					}
					UIManager.openUIForcefully(action.getPlayer(), new ExpiredListings().getPage(action.getPlayer().getUUID()));
				})
				.build();

		Button cancel = GooeyButton.builder()
				.display(Utils.parseItemId(Gts.language.getCancel_button()))
				.title(Gts.language.getCancel_purchase())
				.onClick((action) -> {
					ServerPlayer sender = action.getPlayer();
					Page page = new ExpiredListings().getPage(action.getPlayer().getUUID());
					UIManager.openUIForcefully(sender, page);
				})
				.build();

		Button filler = GooeyButton.builder()
				.display(Utils.parseItemId(Gts.language.getFiller_item()))
				.hideFlags(FlagType.All)
				.lore(new ArrayList<>())
				.title("")
				.build();

		ChestTemplate.Builder template = ChestTemplate.builder(3)
				.fill(filler)
				.set(11, receiveListing)
				.set(13, pokemon)
				.set(15, cancel);


		GooeyPage page = GooeyPage.builder()
				.template(template.build())
				.title("§3" + Gts.language.getTitle() + " - Pokemon")
				.build();

		return page;
	}
}
