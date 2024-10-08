package com.raphael03franzen.redstoneHelper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BarrelCommand implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
		if (!(sender instanceof Player player)){
			sender.sendMessage("This command is meant to be used by a Player");
			return false;
		}

		if(args.length == 0){
			System.out.printf("Expecting 1 argument, got %d%n", args.length);
			return false;
		}

		player.sendMessage("Called barrel with argument %s".formatted(args[0]));
		player.performCommand(CommandBuilder(Integer.parseInt(args[0])));
		return true;

	}

	private @NotNull String CommandBuilder(int signalStrength) throws RuntimeException {
		int min=1,max=15;
		if(signalStrength<min||signalStrength>max){
			throw new IllegalArgumentException("Only valid between %d and %d".formatted(min, max));
		}
		Integer[] conversion= {0,1,2,4,6,9,10,12,14,16,18,20,22,24,26,27};
		int items = conversion[signalStrength];
		items-=1;
		StringBuilder command;
		command = new StringBuilder("give @s barrel[container=[");
		while (items!=0) {
			command.append("{slot:%d,item:{id:wooden_shovel,count:1}},".formatted(items--));
		}
		command.append("{slot:%d,item:{id:wooden_shovel,count:1}}]]".formatted(items));
		return command.toString();
	}
}
