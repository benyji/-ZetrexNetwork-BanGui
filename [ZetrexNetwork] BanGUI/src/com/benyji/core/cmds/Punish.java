package com.benyji.core.cmds;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.benyji.core.gui.ApplyGUI;
import com.benyji.core.utils.TranslateColorCodes;

public class Punish implements CommandExecutor {
	// 	ARGS:	<0>	   <1>
	// punish <reload>
	// punish <Player> <-s>
	TranslateColorCodes c = new TranslateColorCodes();
	ApplyGUI a = new ApplyGUI();

	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");

	public HashMap<UUID, Boolean> preferences = new HashMap<>();
	// Silent = true

	@SuppressWarnings("deprecation")
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

						} else if (!args[0].equalsIgnoreCase(player.getName()) && !args[0].equalsIgnoreCase("reload")) {
							if (Bukkit.getServer().getOfflinePlayer(args[0]) != null) {
								Player target = (Player) Bukkit.getServer().getOfflinePlayer(args[0]);
								
								
								
								if (args.length == 2 && args[1].equalsIgnoreCase("-s")) {
									preferences.put(target.getUniqueId(), true); //Silent
									a.applyUIVer(player);
								} else {	
									preferences.put(target.getUniqueId(), false); //Non silent
									a.applyUIVer(player);
								}
								
								
							} else {
								player.sendMessage(c.translate(plugin.getConfig().getString("invalidUsage")));
							}
						}

					} else {
						player.sendMessage(c.translate(plugin.getConfig().getString("invalidUsage")));

					}
				} else {
					player.sendMessage(c.translate(plugin.getConfig().getString("noAccess")));
				}

			} else if (sender instanceof ConsoleCommandSender) {
				//Let console ban
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
