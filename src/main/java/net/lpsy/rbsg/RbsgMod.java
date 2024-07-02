package net.lpsy.rbsg;

import net.fabricmc.api.ModInitializer;

import net.lpsy.rbsg.block.ModBlocks;
import net.lpsy.rbsg.item.ModItemGroups;
import net.lpsy.rbsg.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RbsgMod implements ModInitializer {
	public static final String MOD_ID = "rbsg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
	}
}