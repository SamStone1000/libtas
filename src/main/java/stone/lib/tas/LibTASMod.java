package stone.lib.tas;

import stone.lib.tas.Tags;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Tags.MODID, name = Tags.MODNAME, version = Tags.VERSION)
public class LibTASMod {

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if (event.getSide() == Side.CLIENT)
        CommandPacket.preInit();
    }
}
