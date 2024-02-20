package stone.lib.tas;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

import java.lang.InterruptedException;
import java.lang.Thread;

public class LibTAS {

    public static void breakBlock(BlockPos pos) {
        new Thread(() -> {
                startBreaking(pos);
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {};
                stopBreaking(pos);
                System.out.println("broken");
        }).start();
    }

    public static void startBreaking(BlockPos pos) {
        CPacketPlayerDigging packet = new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, pos, EnumFacing.DOWN);
        Minecraft.getMinecraft().getConnection().sendPacket(packet);
    }

    public static void stopBreaking(BlockPos pos) {
        CPacketPlayerDigging packet = new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, pos, EnumFacing.DOWN);
        Minecraft.getMinecraft().getConnection().sendPacket(packet);
    }
}
