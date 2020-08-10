package com.benyji.core.cmds;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.benyji.core.gui.ApplyGUI;
import com.benyji.core.utils.TranslateColorCodes;

import net.md_5.bungee.api.ChatColor;

public class Punish implements CommandExecutor {
	// ARGS: <0> <1>
	// punish <reload>
	// punish <Player> <-s>
	TranslateColorCodes c = new TranslateColorCodes();
	ApplyGUI a = new ApplyGUI();

	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");
	public static UUID identifier;
	public static HashMap<UUID, Boolean> preferences = new HashMap<>();
	// Silent = true

	public void setID(UUID uuid) {
		identifier = uuid;
	}

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

						} else if (args[0].equalsIgnoreCase("help")) {
							if (player.hasPermission("punish.help")) {
								player.sendMessage(ChatColor.DARK_GRAY + "- - - - - - - - - - - - -");
								player.sendMessage(
										ChatColor.YELLOW + "https://github.com/benyji/-ZetrexNetwork-BanGui");
								player.sendMessage(ChatColor.GRAY + "OR");
								player.sendMessage(ChatColor.YELLOW + "benyji#4392");
								player.sendMessage(ChatColor.GRAY + "Cmds:");
								player.sendMessage(ChatColor.GREEN + "/punish <player> <-s>");
								player.sendMessage(ChatColor.BLUE + "/punish reload");
								player.sendMessage(ChatColor.DARK_GRAY + "- - - - - - - - - - - - -");

							}
						} else if (!args[0].equalsIgnoreCase(player.getName()) && !args[0].equalsIgnoreCase("reload")) {

							if (Bukkit.getServer().getOfflinePlayer(args[0]) != null) {
								OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);

								if (args.length == 2 && args[1].equalsIgnoreCase("-s")) {

									preferences.put(target.getUniqueId(), true); // Silent
									a.applyUIVer(player, target);
								} else {

									preferences.put(target.getUniqueId(), false); // Non silent
									a.applyUIVer(player, target);
								}

							} else {
								player.sendMessage(c.translate(plugin.getConfig().getString("invalidUsage")));
							}
						} else {
							player.sendMessage(c.translate(plugin.getConfig().getString("invalidUsage")));

						}

					} else {
						player.sendMessage(c.translate(plugin.getConfig().getString("invalidUsage")));

					}
				} else {
					player.sendMessage(c.translate(plugin.getConfig().getString("noAccess")));
				}

			}
		}
		return false;

	}

	public void reloadConfig() {
		plugin.reloadConfig();
	}
}
