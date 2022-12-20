package net.kossler.projectcivilize.entity;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CivilizedVillager extends PathAwareEntity {
    public CivilizedVillager(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public static class Model extends EntityModel<CivilizedVillager> {
        private final ModelPart base;
        public Model(ModelPart modelPart) {
            this.base = modelPart.getChild(EntityModelPartNames.HEAD);
        }

        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData partData = modelData.getRoot();
            partData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4, -8, -4, 8, 8, 8), ModelTransform.pivot(0, 0, 0))
                    .addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 16).cuboid(-4, 0, -2, 8, 12, 4), ModelTransform.pivot(0, 0, 0))
                    .addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(0, 32).cuboid(-8, 0, -2, 4, 12, 4), ModelTransform.pivot(0, 0, 0))
                    .addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(24, 16).cuboid(4, 0, -2, 4, 12, 4), ModelTransform.pivot(0, 0, 0))
                    .addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(32, 0).cuboid(-4, 12, -2, 4, 12, 4), ModelTransform.pivot(0, 0, 0))
                    .addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(16, 32).cuboid(0, 12, -2, 4, 12, 4), ModelTransform.pivot(0, 0, 0));
            return TexturedModelData.of(modelData, 64, 64);
        }

        @Override
        public void setAngles(CivilizedVillager entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

        }

        @Override
        public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
            ImmutableList.of(this.base).forEach((modelRenderer) -> {
                modelRenderer.render(matrices, vertices, light, overlay, red, green, blue, alpha);
            });
        }
    }

    public static class Renderer extends MobEntityRenderer<CivilizedVillager, CivilizedVillager.Model> {
        public Renderer(EntityRendererFactory.Context context) {
            super(context, new Model(context.getPart(EntityTestingClient.MODEL_TEST_LAYER)),0.5f);
        }
        @Override
        public Identifier getTexture(CivilizedVillager entity) {
            return new Identifier("project-civilize", "textures/entity/civilizedvillager/civilizedvillager.png");
        }
    }
}
