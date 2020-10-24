package net.nile.guns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class NileGuns implements ModInitializer {

    public static final Logger logger = LogManager.getLogger();

    public static final String modid = "nileguns";

    private static final Identifier GUNSHOTID = new Identifier(modid, "gunshot");

    public static MarineMagnumItem MARINE_MAGNUM = new MarineMagnumItem(
            new Item.Settings().maxCount(1).group(ItemGroup.COMBAT));

    public static Item FISH_GUNPARTS = new Item(
            new Item.Settings().maxCount(64).rarity(Rarity.UNCOMMON).group(ItemGroup.MISC));

    public static final EntityType<ArrowEntity> BULLET = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(modid, "bullet"),
            FabricEntityTypeBuilder.<ArrowEntity>create(SpawnGroup.MISC, ArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build());
    
    public static final SoundEvent GUNSHOT = new SoundEvent(GUNSHOTID);

    @Override
    public void onInitialize() {
        
        Registry.register(Registry.ITEM, new Identifier(modid, "marine_magnum"), MARINE_MAGNUM);
        Registry.register(Registry.ITEM, new Identifier(modid, "aquatic_gunparts"), FISH_GUNPARTS);
        Registry.register(Registry.SOUND_EVENT, GUNSHOTID, GUNSHOT);
    }
}