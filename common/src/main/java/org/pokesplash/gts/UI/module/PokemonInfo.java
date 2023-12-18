package org.pokesplash.gts.UI.module;

import com.cobblemon.mod.common.api.moves.Move;
import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import com.cobblemon.mod.common.api.types.ElementalType;
import com.cobblemon.mod.common.pokemon.Pokemon;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import org.pokesplash.gts.Gts;
import org.pokesplash.gts.Listing.PokemonListing;
import org.pokesplash.gts.util.Utils;

import java.util.ArrayList;
import java.util.Collection;

public abstract class PokemonInfo {
	public static Collection<Component> parse(PokemonListing listing) {
		Collection<Component> lore = new ArrayList<>();
		Pokemon pokemon = listing.getListing();
		Style dark_aqua = Style.EMPTY.withColor(TextColor.parseColor("dark_aqua"));
		Style dark_green = Style.EMPTY.withColor(TextColor.parseColor("dark_green"));
		Style dark_purple = Style.EMPTY.withColor(TextColor.parseColor("dark_purple"));
		Style gold = Style.EMPTY.withColor(TextColor.parseColor("gold"));
		Style gray = Style.EMPTY.withColor(TextColor.parseColor("gray"));
		Style green = Style.EMPTY.withColor(TextColor.parseColor("green"));
		Style red = Style.EMPTY.withColor(TextColor.parseColor("red"));
		Style light_purple = Style.EMPTY.withColor(TextColor.parseColor("light_purple"));
		Style yellow = Style.EMPTY.withColor(TextColor.parseColor("yellow"));
		Style white = Style.EMPTY.withColor(TextColor.parseColor("white"));

		Item ball = pokemon.getCaughtBall().item();
		lore.add(Component.literal(Gts.language.getBall())
				.append(Component.translatable(ball.getName(new ItemStack(ball)).getString()).setStyle(green)));

		lore.add(Component.translatable("cobblemon.ui.info.species").setStyle(dark_green).append(": ")
				.append(pokemon.getSpecies().getTranslatedName().setStyle(green)));

		MutableComponent types = Component.empty().setStyle(green);
		for (ElementalType type : pokemon.getSpecies().getTypes()) {
			types.append(" ").append(type.getDisplayName());
		}
		lore.add(Component.translatable("cobblemon.ui.info.type").setStyle(dark_green).append(":").append(types));

		lore.add(Component.translatable("cobblemon.ui.info.nature").setStyle(dark_green).append(": ")
				.append(Component.translatable(pokemon.getNature().getDisplayName()).setStyle(green)));

		MutableComponent ability = Component.translatable("cobblemon.ui.info.ability").setStyle(dark_green).append(": ")
				.append(Component.translatable(pokemon.getAbility().getDisplayName()).setStyle(green));
		if (Utils.isHA(pokemon)) {
			ability.append(Component.literal(" §b(HA)"));
		}
		lore.add(ability);

		lore.add(Component.translatable("cobblemon.ui.stats").setStyle(gray).append(": "));

		lore.add(Component.translatable("cobblemon.ui.stats.hp").setStyle(light_purple)
			.append(" §8- §3IV: §a" +
				(pokemon.getIvs().get(Stats.HP) == null ? "0" :
						pokemon.getIvs().get(Stats.HP))
				+ " §cEV: §a" + (pokemon.getEvs().get(Stats.HP) == null ? "0" : pokemon.getEvs().get(Stats.HP))));
		lore.add(Component.translatable("cobblemon.ui.stats.atk").setStyle(red)
			.append(" §8- §3IV: §a" + (pokemon.getIvs().get(Stats.ATTACK) == null ? "0" :
				+ pokemon.getIvs().get(Stats.ATTACK)) + " §cEV: §a" +
				(pokemon.getEvs().get(Stats.ATTACK) == null ? "0" : pokemon.getEvs().get(Stats.ATTACK))));
		lore.add(Component.translatable("cobblemon.ui.stats.def").setStyle(gold)
			.append(" §8- §3IV: §a" + (pokemon.getIvs().get(Stats.DEFENCE) == null ? "0" :
				+ pokemon.getIvs().get(Stats.DEFENCE)) + " §cEV: §a" +
				(pokemon.getEvs().get(Stats.DEFENCE) == null ? "0" :
						pokemon.getEvs().get(Stats.DEFENCE))));
		lore.add(Component.translatable("cobblemon.ui.stats.sp_atk").setStyle(dark_purple)
			.append(" §8- §3IV: §a" + (pokemon.getIvs().get(Stats.SPECIAL_ATTACK) == null ? "0" :
				+ pokemon.getIvs().get(Stats.SPECIAL_ATTACK)) + " §cEV: §a" +
				(pokemon.getEvs().get(Stats.SPECIAL_ATTACK) == null ? "0" :
						pokemon.getEvs().get(Stats.SPECIAL_ATTACK))));
		lore.add(Component.translatable("cobblemon.ui.stats.sp_def").setStyle(yellow)
			.append(" §8- §3IV: §a" + (pokemon.getIvs().get(Stats.SPECIAL_DEFENCE) == null ? "0" :
				+ pokemon.getIvs().get(Stats.SPECIAL_DEFENCE)) + " §cEV: §a" +
				(pokemon.getEvs().get(Stats.SPECIAL_DEFENCE) == null ? "0" :
						pokemon.getEvs().get(Stats.SPECIAL_DEFENCE))));
		lore.add(Component.translatable("cobblemon.ui.stats.speed").setStyle(dark_aqua)
			.append(" §8- §3IV: §a" + (pokemon.getIvs().get(Stats.SPEED) == null ? "0" :
				+ pokemon.getIvs().get(Stats.SPEED)) + " §cEV: §a" +
				(pokemon.getEvs().get(Stats.SPEED) == null ? "0" :
						pokemon.getEvs().get(Stats.SPEED))));

		lore.add(Component.translatable("cobblemon.ui.stats.friendship").setStyle(dark_green)
				.append(": §a" + pokemon.getFriendship()));

		lore.add(Component.translatable("cobblemon.ui.moves").setStyle(gold).append(": "));
		for (Move move : pokemon.getMoveSet().getMoves()) {
			lore.add(Component.translatable(move.getTemplate().getDisplayName().getString()).setStyle(white));
		}

		return lore;
	}
}
