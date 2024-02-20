package stone.lib.tas;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.IClientCommand;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public class CommandPacket implements IClientCommand {

    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 3)
            return;
        LibTAS.breakBlock(CommandBase.parseBlockPos(sender, args, 0, false));
    }

    public static void preInit() {
        ClientCommandHandler.instance.registerCommand(new CommandPacket());
    }

    /**
     * Gets the name of the command
     */
    public String getName() {
        return "packet";
    }

    /**
     * Gets the usage string for the command.
     */
    public String getUsage(ICommandSender sender) {
        return "Sends a packet";
    }

    public List<String> getAliases() {
        return Collections.<String>emptyList();
    }

    /**
     * Check if the given ICommandSender has permission to execute this command
     */
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return Collections.<String>emptyList();
    }
    /**
     * Return whether the specified command parameter index is a username parameter.
     */
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message) {
        return false;
    }

    public int compareTo(ICommand command)
    {
        return this.getName().compareTo(command.getName());
    }
                         
}

                        
