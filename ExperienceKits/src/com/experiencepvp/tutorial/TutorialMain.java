package com.experiencepvp.tutorial;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class TutorialMain {
	
	public static ArrayList<String> following = new ArrayList<String>();
	public static ArrayList<String> nomove = new ArrayList<String>();

	public static void startTutorial(Player p){
		following.add(p.getName());
	}
}
