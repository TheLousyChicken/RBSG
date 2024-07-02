package net.lpsy.rbsg.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lpsy.rbsg.RbsgMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ENDERITE_SCRAP = registerItem("enderite_scrap", new Item(new Item.Settings()));
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RbsgMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RbsgMod.LOGGER.info("registering mod items for " + RbsgMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup)
    }
}
