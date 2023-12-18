package org.pokesplash.gts.Listing;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.ItemStack;
import org.pokesplash.gts.Gts;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Class that holds a single listing.
 */
public class ItemListing implements Listing<ItemStack> {
	// Unique id.
	private final UUID id;
	// The UUID of the person selling the Pokemon.
	private final UUID sellerUuid;
	// The name of the seller.
	private final String sellerName;
	// The price the Pokemon is selling for.
	private final double price;
	// The time the listing ends.
	private final long endTime;
	// The item that is being listed.
	private final String item;

	/**
	 * Constructor to create a new listing.
	 * @param sellerUuid The UUID of the person selling the Pokemon.
	 * @param sellerName The name of the seller.
	 * @param price The price the Pokemon is selling for.
	 * @param item The item to sell.
	 */
	public ItemListing(UUID sellerUuid, String sellerName, double price, int amount, ItemStack item) {
		this.id = UUID.randomUUID();
		this.sellerUuid = sellerUuid;
		this.sellerName = sellerName;
		this.price = price;
		this.endTime = new Date().getTime() + (Gts.config.getListing_duration() * 3600000L);
		this.item = item.save(new CompoundTag()).getAsString();
	}

	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public UUID getSellerUuid() {
		return sellerUuid;
	}

	@Override
	public String getSellerName() {
		return sellerName;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getPriceAsString() {
		DecimalFormat df = new DecimalFormat("0.##");
		return df.format(price);
	}

	@Override
	public long getEndTime() {
		return endTime;
	}

	@Override
	public ItemStack getListing() {
		try {
			return ItemStack.of(TagParser.parseTag(item));
		} catch (CommandSyntaxException e) {
			Gts.LOGGER.fatal("Failed to parse item for NBT: " + item);
			Gts.LOGGER.fatal("Stacktrace: ");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MutableComponent getDisplayName() {
		Style dark_aqua = Style.EMPTY.withColor(TextColor.parseColor("dark_aqua"));
		ItemStack item = this.getListing();
		return Component.empty().setStyle(dark_aqua).append(item.getHoverName());
	}

	@Override
	public boolean isPokemon() {
		return false;
	}
}
