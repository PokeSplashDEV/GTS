package org.pokesplash.gts.Listing;

import java.util.UUID;

import net.minecraft.network.chat.MutableComponent;

/**
 * Used for both Pokemon and Item listings.
 * @param <T> The type of object returned from getListing(), either ItemStack or Pokemon.
 */
public interface Listing<T> {

	public UUID getId(); // UUID of the listing.
	public UUID getSellerUuid(); // UUID of the seller.
	public String getSellerName(); // Name of the seller.
	public double getPrice(); // Price of the listing.
	public String getPriceAsString(); // Price of the listing as String.
	public long getEndTime(); // End time of the listing.
	public T getListing(); // The object that has been listed.
	public boolean isPokemon(); // Checks that the listing is a pokemon;
	public MutableComponent getDisplayName(); // Checks that the listing is a pokemon;
}
