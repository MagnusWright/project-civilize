package net.kossler.projectcivilize.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EntityTesting implements ModInitializer {
    public static final EntityType<CivilizedVillager> CIVILIZEDVILLAGER = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("project-civilize", "civilizedvillager"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CivilizedVillager::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(CIVILIZEDVILLAGER, MobEntity.createMobAttributes());
    }
}

