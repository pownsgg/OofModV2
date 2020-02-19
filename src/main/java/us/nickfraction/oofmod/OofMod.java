package us.nickfraction.oofmod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import us.nickfraction.oofmod.commands.OpenMenuCommand;
import us.nickfraction.oofmod.listeners.OofModListener;
import us.nickfraction.oofmod.modcore.ModCoreInstaller;
import us.nickfraction.oofmod.settings.Settings;

@Mod(modid = OofMod.MODID, version = OofMod.VERSION, name = OofMod.NAME)
public class OofMod {
    public static final String MODID = "refractionoof";
    public static final String VERSION = "2.0";
    public static final String NAME = "OofMod";

    private Settings settings;

    @EventHandler
    public void init(FMLInitializationEvent event) throws Exception {
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);

        MinecraftForge.EVENT_BUS.register(new OofModListener(this));
        ClientCommandHandler.instance.registerCommand(new OpenMenuCommand(this));
        settings = new Settings();
        settings.loadConfig();
    }

    public Settings getSettings() {
        return settings;
    }
}
