package com.benyji.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.benyji.core.gui.ApplyGUI;

public class Test implements Listener {
	
	@EventHandler
	public void test(PlayerJoinEvent e) {
		ApplyGUI a = new ApplyGUI();
				a.applyUIVer(e.getPlayer());
	}

}
