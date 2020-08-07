/*
$$$$$$$\  $$$$$$$$\ $$\   $$\    $$$$$\  $$$$$$\  $$\      $$\ $$$$$$\ $$\   $$\ 
$$  __$$\ $$  _____|$$$\  $$ |   \__$$ |$$  __$$\ $$$\    $$$ |\_$$  _|$$$\  $$ |
$$ |  $$ |$$ |      $$$$\ $$ |      $$ |$$ /  $$ |$$$$\  $$$$ |  $$ |  $$$$\ $$ |
$$$$$$$\ |$$$$$\    $$ $$\$$ |      $$ |$$$$$$$$ |$$\$$\$$ $$ |  $$ |  $$ $$\$$ |
$$  __$$\ $$  __|   $$ \$$$$ |$$\   $$ |$$  __$$ |$$ \$$$  $$ |  $$ |  $$ \$$$$ |
$$ |  $$ |$$ |      $$ |\$$$ |$$ |  $$ |$$ |  $$ |$$ |\$  /$$ |  $$ |  $$ |\$$$ |
$$$$$$$  |$$$$$$$$\ $$ | \$$ |\$$$$$$  |$$ |  $$ |$$ | \_/ $$ |$$$$$$\ $$ | \$$ |
\_______/ \________|\__|  \__| \______/ \__|  \__|\__|     \__|\______|\__|  \__|
    
								     MAIN
					Responsible for: Handling all Classes
					Last edited: 08/6/20 
 */

package com.benyji.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.benyji.core.cmds.Punish;
import com.benyji.core.storage.Config;
import com.benyji.core.utils.TranslateColorCodes;

public class Main extends JavaPlugin {

	TranslateColorCodes c = new TranslateColorCodes();

	@Override
	public void onEnable() {

		if (!this.getDataFolder().exists()) {
			try {
				this.getDataFolder().mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Config e = new Config(this);
		e.Setup();

		Bukkit.getServer().getPluginManager().registerEvents(new Test(), this);

		getCommand("punish").setExecutor(new Punish());

		consoleMSG(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "Zetrex Network [BanGUI]" + ChatColor.DARK_GRAY
				+ ": " + ChatColor.GREEN + "Running latest Version '1.0'.");
	}

	public void consoleMSG(String m) {
		Bukkit.getServer().getConsoleSender().sendMessage(c.translate(m));
	}

}
