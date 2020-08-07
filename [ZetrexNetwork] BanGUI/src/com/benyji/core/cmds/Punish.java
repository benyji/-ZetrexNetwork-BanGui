package com.benyji.core.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.benyji.core.utils.TranslateColorCodes;

public class Punish implements CommandExecutor {
	// <0>
	// punish reload
	TranslateColorCodes c = new TranslateColorCodes();
	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equals("punish")) {

			if ((sender instanceof Player)) {

				Player player = (Player) sender;
				if (player.hasPermission("punish.use")) {
					if (!(args.length == 0)) {

						if (args[0].equalsIgnoreCase("reload")) {

							if (player.hasPermission("punish.reload")) {
								reloadConfig();
								player.sendMessage(c.translate(plugin.getConfig().getString("successfulReload")));

							} else {
								player.sendMessage(c.translate(plugin.getConfig().getString("noAccess")));
							}

						}

					} else {
						player.sendMessage(c.translate(plugin.getConfig().getString("invalidUsage")));

					}
				} else {
					player.sendMessage(c.translate(plugin.getConfig().getString("noAccess")));
				}

			} else if (sender instanceof ConsoleCommandSender) {
				if (!(args.length == 0)) {
					if (args[0].equalsIgnoreCase("reload")) {

						reloadConfig();
						Bukkit.getServer().getConsoleSender()
								.sendMessage(c.translate(plugin.getConfig().getString("successfulReload")));
					}
				} else {
					Bukkit.getServer().getConsoleSender()
							.sendMessage(c.translate(plugin.getConfig().getString("invalidUsage")));
				}
			}

		}
		return false;
	}

	public void reloadConfig() {
		plugin.reloadConfig();
	}
}
