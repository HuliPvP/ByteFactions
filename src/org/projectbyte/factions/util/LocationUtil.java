package org.projectbyte.factions.util;

import org.bukkit.Location;

public class LocationUtil {
	
	public static double distance(Location loc1, Location loc2) {
		double x1 = Math.min(loc1.getX(), loc2.getX());
		double x2 = Math.max(loc1.getX(), loc2.getX());
		double z1 = Math.min(loc1.getZ(), loc2.getZ());
		double z2 = Math.max(loc1.getZ(), loc2.getZ());

		return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((z1 - z2), 2));
	}

}
