package net.lpsy.rbsg.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lpsy.rbsg.RbsgMod;
import net.lpsy.rbsg.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RBSG_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RbsgMod.MOD_ID, "rbsg"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rbsg"))
                    // CHANGE THE ITEMSTACK() TO THE CREATIVE TAB ICON
                    .icon(() -> new ItemStack(ModItems.ENDERITE_SCRAP )).entries((displayContext, entries) -> {
                        entries.add(ModItems.ENDERITE_SCRAP);
                        entries.add(ModItems.ENDERITE_INGOT);

                        entries.add(ModBlocks.ANCIENT_ARTIFACT);
                        entries.add(ModBlocks.ENDERITE_BLOCK);
                        entries.add(ModBlocks.REFINER_BLOCK);


                    }).build());

    public static void registerItemGroups() {
        RbsgMod.LOGGER.info("registering item groups for " + RbsgMod.MOD_ID);
    }
}
