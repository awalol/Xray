package fr.atesab.xray.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class RenderUtils {

        public static void renderSingleLine(PoseStack stack, VertexConsumer buffer, float x1, float y1, float z1,
                        float x2, float y2,
                        float z2, float r, float g, float b, float a) {
                Vec3 normal = new Vec3(x2 - x1, y2 - y1, z2 - z1).normalize();
                renderSingleLine(stack, buffer, x1, y1, z1, x2, y2, z2, r, g, b, a, (float) normal.x, (float) normal.y,
                                (float) normal.z);
        }

        public static void renderSingleLine(PoseStack stack, VertexConsumer buffer, float x1, float y1, float z1,
                        float x2, float y2,
                        float z2, float r, float g, float b, float a, float normalX, float normalY, float normalZ) {
//                Matrix4f matrix4f = stack.last().pose();
//                Matrix3f matrix3f = stack.last().normal();
                buffer.addVertex(stack.last(), x1, y1, z1).setColor(r, g, b, a)
                        .setNormal(stack.last(), normalX, normalY, normalZ);
                buffer.addVertex(stack.last(), x2, y2, z2).setColor(r, g, b, a)
                                .setNormal(stack.last(), normalX, normalY, normalZ);
        }

        private RenderUtils() {
        }
}
