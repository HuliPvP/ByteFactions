package org.projectbyte.factions;

import org.bukkit.plugin.java.JavaPlugin;
import org.projectbyte.factions.manager.ClaimManager;
import org.projectbyte.factions.manager.FactionManager;
import org.projectbyte.factions.util.commandapi.CommandFramework;

import lombok.Getter;

/**
 * Copyright (c) 2017, HuliPvP || Zach Sills
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * @author Zach Sills
 */
@Getter
public class ByteFactions extends JavaPlugin {
	
	@Getter
	private static ByteFactions instance;
	
	private FactionManager factionManager;
	private ClaimManager claimManager;
	
	private CommandFramework commandFramework;
	
	public void onEnable() {
		
		instance = this;
		
		factionManager = new FactionManager();
		claimManager = new ClaimManager();
		
		commandFramework = new CommandFramework(this);
		
	}

}
