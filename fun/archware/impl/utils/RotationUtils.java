/*
 * noom (c) 2021.
 */

package fun.archware.impl.utils;

import javafx.animation.Interpolator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/**
 * Created by 1 on 02.04.2021.
 */
public class RotationUtils {
    private static float prevYaw;
    private static final Minecraft mc = Minecraft.getMinecraft();
    public static float[] getRotation(Entity entity){
        final double speed = Math.abs(Math.hypot(mc.player.posX - mc.player.prevPosX, mc.player.posZ - mc.player.prevPosZ)) * 15;
        final Vec3d eyesPos = new Vec3d(mc.player.posX, mc.player.posY + mc.player.getEyeHeight(), mc.player.posZ);
        final double X = entity.getPositionVector().xCoord - eyesPos.xCoord - 1 + (Math.random() * 0.4);
        final double Y = entity.getPositionVector().yCoord + entity.getEyeHeight() - eyesPos.yCoord - 1 + (Math.random() * 0.4);
        final double Z = entity.getPositionVector().zCoord - eyesPos.zCoord - 1 + (Math.random() * 0.4);
        final double XZ = Math.sqrt(X * X + Z * Z);
        float yaw = MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(Z, X)) - 90.0f );
        float pitch = MathHelper.wrapDegrees((float)(-Math.toDegrees(Math.atan2(Y, XZ))) + 5);

        float f = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
        float gcd = (f * f * f) * 10;
        yaw -= yaw % gcd;
        pitch -= pitch % gcd;

        return new float[]{MathHelper.clamp(yaw,-360,360), MathHelper.clamp(pitch,-90,90)};
    }

    public static float[] getVisualRotations(final Entity entity){
        final int speed = (int)(Math.abs(Math.hypot(mc.player.posX - mc.player.prevPosX, mc.player.posZ - mc.player.prevPosZ)) * 15);
        final Vec3d eyesPos = new Vec3d(mc.player.posX, mc.player.posY + mc.player.getEyeHeight(), mc.player.posZ);
        final double X = entity.getPositionVector().xCoord - eyesPos.xCoord + (speed > 0 ? (long)(Math.random()*0.8) : 0);
        final double Y = entity.getPositionVector().yCoord + entity.getEyeHeight() - eyesPos.yCoord + (speed > 0 ? (long)(Math.random()*0.6) : 0);
        final double Z = entity.getPositionVector().zCoord - eyesPos.zCoord + (speed > 0 ? (long)(Math.random()*0.8) : 0);
        final double XZ = Math.sqrt(X * X + Z * Z);
        float yaw = MathHelper.wrapDegrees((float)Math.toDegrees(Math.atan2(Z, X)) - 90.0f );
        float pitch = MathHelper.wrapDegrees((float)(-Math.toDegrees(Math.atan2(Y, XZ))) + 5);

        float f = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
        float gcd = (f * f * f) * 10;
        yaw -= yaw % gcd;
        pitch -= pitch % gcd;

        return new float[]{MathHelper.clamp(yaw,-360,360), MathHelper.clamp(pitch,-90,90)};
    }

}
