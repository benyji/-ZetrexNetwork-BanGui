package com.benyji.core.events;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import com.benyji.core.Main;
import com.benyji.core.cmds.Punish;
import com.benyji.core.gui.ApplyGUI;
import com.benyji.core.utils.TranslateColorCodes;

public class InteractionListener implements Listener {
	Main main = Main.getPlugin(Main.class);

	Plugin plugin = Bukkit.getPluginManager().getPlugin("ZetrexNetwork-BanGUI");
	TranslateColorCodes c = new TranslateColorCodes();
	ApplyGUI a = new ApplyGUI();

	@EventHandler
	public void uiInteract(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (p.getOpenInventory().getTitle().equalsIgnoreCase(c.translate(plugin.getConfig().getString("guiTitle")))) {
			if (e.getCurrentItem() != null) {
				if (e.getCurrentItem().hasItemMeta()) {
					if (!(e.getCurrentItem().getItemMeta().getLocalizedName().equals("MENU_CLOSE_BUTTON"))) {
						String m = e.getCurrentItem().getItemMeta().getLocalizedName();

						if (m.equals(plugin.getConfig().getString("advertising_icon"))) {
							registerBanCommand(p, "advertising_time", "advertising_reason");

						} else if (m.equals(plugin.getConfig().getString("alts_10_icon"))) {
							registerBanCommand(p, "alts_10_time", "alts_10_reason");

						} else if (m.equals(plugin.getConfig().getString("afk_icon"))) {
							registerBanCommand(p, "afk_time", "afk_reason");
						}

						else if (m.equals(plugin.getConfig().getString("anti_kb_icon"))) {
							registerBanCommand(p, "anti_kb_time", "anti_kb_reason");
						}

						else if (m.equals(plugin.getConfig().getString("ban_evasion_icon"))) {
							registerBanCommand(p, "ban_evasion_time", "ban_evasion_reason");
						}

						else if (m.equals(plugin.getConfig().getString("combat_icon"))) {
							registerBanCommand(p, "combat_time", "combat_reason");
						}

						else if (m.equals(plugin.getConfig().getString("criticals_icon"))) {
							registerBanCommand(p, "criticals_time", "criticals_reason");
						}

						else if (m.equals(plugin.getConfig().getString("ddos_icon"))) {
							registerBanCommand(p, "ddos_time", "ddos_reason");
						}

						else if (m.equals(plugin.getConfig().getString("derp_icon"))) {
							registerBanCommand(p, "derp_time", "derp_reason");
						}

						else if (m.equals(plugin.getConfig().getString("discrimination_icon"))) {
							registerBanCommand(p, "discrimination_time", "discrimination_reason");
						}

						else if (m.equals(plugin.getConfig().getString("excessive_advertising_icon"))) {
							registerBanCommand(p, "excessive_advertising_time", "discrimination_time");
						}

						else if (m.equals(plugin.getConfig().getString("exploit_icon"))) {
							registerBanCommand(p, "exploit_time", "exploit_reason");
						}

						else if (m.equals(plugin.getConfig().getString("extreme_icon"))) {
							registerBanCommand(p, "extreme_time", "extreme_reason");
						}

						else if (m.equals(plugin.getConfig().getString("griefing_icon"))) {
							registerBanCommand(p, "griefing_time", "griefing_reason");
						}

						else if (m.equals(plugin.getConfig().getString("harassment_icon"))) {
							registerBanCommand(p, "harassment_time", "harassment_reason");
						}

						else if (m.equals(plugin.getConfig().getString("impersonation_icon"))) {
							registerBanCommand(p, "impersonation_time", "impersonation_reason");
						}

						else if (m.equals(plugin.getConfig().getString("inappropriate_icon"))) {
							registerBanCommand(p, "inappropriate_time", "inappropriate_reason");
						}

						else if (m.equals(plugin.getConfig().getString("scaffold_icon"))) {
							registerBanCommand(p, "scaffold_time", "scaffold_reason");
						}

						else if (m.equals(plugin.getConfig().getString("sexual_harassment_icon"))) {
							registerBanCommand(p, "sexual_harassment_time", "sexual_harassment_reason");
						}

						else if (m.equals(plugin.getConfig().getString("lag_machine_icon"))) {
							registerBanCommand(p, "lag_machine_time", "lag_machine_reason");
						}

						else if (m.equals(plugin.getConfig().getString("manual_perm_icon"))) {
							registerBanCommand(p, "manual_perm_time", "manual_perm_reason");
						}

						else if (m.equals(plugin.getConfig().getString("manual_60_icon"))) {
							registerBanCommand(p, "manual_60_time", "manual_60_reason");
						}

						else if (m.equals(plugin.getConfig().getString("mining_icon"))) {
							registerBanCommand(p, "mining_time", "mining_reason");
						}

						else if (m.equals(plugin.getConfig().getString("minor_icon"))) {
							registerBanCommand(p, "minor_time", "minor_reason");
						}

						else if (m.equals(plugin.getConfig().getString("movement_icon"))) {
							registerBanCommand(p, "movement_time", "movement_reason");
						}

						else if (m.equals(plugin.getConfig().getString("phase_icon"))) {
							registerBanCommand(p, "phase_time", "phase_reason");
						}

						else if (m.equals(plugin.getConfig().getString("repeat_discrimination_icon"))) {
							registerBanCommand(p, "repeat_discrimination_time", "repeat_discrimination_reason");
						}

						else if (m.equals(plugin.getConfig().getString("xray_icon"))) {
							registerBanCommand(p, "xray_time", "xray_reason");

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

						} else if (m.equals("KICK_BUTTON")) {
							if (Punish.preferences.get(Punish.identifier) == false) {

								Bukkit.dispatchCommand(p, "kick" + " " + nameFromUUID(Punish.identifier) + " "
										+ plugin.getConfig().getString("kick_reason"));
								p.closeInventory();
							} else {

								Bukkit.dispatchCommand(p, "kick" + " " + "-s" + " " + nameFromUUID(Punish.identifier)
										+ " " + plugin.getConfig().getString("kick_reason"));
								p.closeInventory();
							}
						} else if (m.equals("MUTE_BUTTON")) {
							if (Punish.preferences.get(Punish.identifier) == false) {

								Bukkit.dispatchCommand(p,
										"mute" + " " + nameFromUUID(Punish.identifier) + " "
												+ plugin.getConfig().getString("mute_time") + " "
												+ plugin.getConfig().getString("mute_reason"));
								p.closeInventory();
							} else {

								Bukkit.dispatchCommand(p,
										"mute" + " " + "-s" + " " + nameFromUUID(Punish.identifier) + " "
												+ plugin.getConfig().getString("mute_time") + " "
												+ plugin.getConfig().getString("mute_reason"));
								p.closeInventory();
							}
						} else if (m.equals("UNBAN_BUTTON")) {
							if (Punish.preferences.get(Punish.identifier) == false) {

								Bukkit.dispatchCommand(p, "unban" + " " + nameFromUUID(Punish.identifier));
								p.closeInventory();
							} else {

								Bukkit.dispatchCommand(p, "unban" + " " + "-s" + " " + nameFromUUID(Punish.identifier));
								p.closeInventory();
							}
						}

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

					} else {
						p.closeInventory();
					}
					e.setCancelled(true);

				}
			}
		}
	}

	public String nameFromUUID(UUID uuid) {
		String target = Bukkit.getServer().getOfflinePlayer(uuid).getName();
		return target;
	}

	public void registerBanCommand(Player p, String time, String reason) {

		if (!Punish.preferences.isEmpty() && Punish.identifier != null) {

			if (Punish.preferences.get(Punish.identifier) == false) {

				Bukkit.dispatchCommand(p, "ban" + " " + nameFromUUID(Punish.identifier) + " "
						+ plugin.getConfig().getString(time) + " " + plugin.getConfig().getString(reason));
				p.closeInventory();
			} else {

				Bukkit.dispatchCommand(p, "ban" + " " + "-s" + " " + nameFromUUID(Punish.identifier) + " "
						+ plugin.getConfig().getString(time) + " " + plugin.getConfig().getString(reason));
				p.closeInventory();
			}
		}
	}
}
