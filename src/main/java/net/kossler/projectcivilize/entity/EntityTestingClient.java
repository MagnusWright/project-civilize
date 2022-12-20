package net.kossler.projectcivilize.entity;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EntityTestingClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_TEST_LAYER = new EntityModelLayer(new Identifier("entitytesting", "test"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityTesting.CIVILIZEDVILLAGER, (context) -> {
            return new CivilizedVillager.Renderer(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_TEST_LAYER, CivilizedVillager.Model::getTexturedModelData);
    }
}
