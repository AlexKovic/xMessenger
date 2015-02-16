package com.experiencepvp.kits.utils;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.experiencepvp.effects.GladiatorEffect;
import com.experiencepvp.kits.Main;

import de.slikey.effectlib.effect.FlameEffect;
import de.slikey.effectlib.util.ParticleEffect;

public class Gladiator
/*      */ {
/*   14 */   private static Gladiator instance = new Gladiator();
/*   23 */   public static HashMap<String, Location> lastLocation = new HashMap<String, Location>();
/*      */ 
/*      */   private Gladiator()
/*      */   {
/*      */   }
/*      */ 
/*      */   public static Gladiator getInstance()
/*      */   {
/*   17 */     return instance;
/*      */   }
/*      */ 

/*      */ 
/*      */   public static void setBlock(Player p, int NumberX, int NumberZ) {
/*   25 */     int x = p.getLocation().getBlockX();
/*   26 */     int y = p.getLocation().getBlockY();
/*   27 */     int z = p.getLocation().getBlockZ();
/*   28 */     Location l = new Location(p.getWorld(), x + NumberX, y + 100, z + NumberZ);
/*   29 */     Block block = l.getBlock();
/*   30 */     block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX(Player p, int NumberX) {
/*   33 */     int x = p.getLocation().getBlockX();
/*   34 */     int y = p.getLocation().getBlockY();
/*   35 */     int z = p.getLocation().getBlockZ();
/*   36 */     Location l = new Location(p.getWorld(), x + NumberX, y + 100, z);
/*   37 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ(Player p, int NumberZ) {
/*   40 */     int x = p.getLocation().getBlockX();
/*   41 */     int y = p.getLocation().getBlockY();
/*   42 */     int z = p.getLocation().getBlockZ();
/*   43 */     Location l = new Location(p.getWorld(), x, y + 100, z + NumberZ);
/*   44 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ1(Player p, int NumberZ) {
/*   47 */     int x = p.getLocation().getBlockX();
/*   48 */     int y = p.getLocation().getBlockY();
/*   49 */     int z = p.getLocation().getBlockZ();
/*   50 */     Location l = new Location(p.getWorld(), x + 1, y + 100, z + NumberZ + 1);
/*   51 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ2(Player p, int NumberZ) {
/*   54 */     int x = p.getLocation().getBlockX();
/*   55 */     int y = p.getLocation().getBlockY();
/*   56 */     int z = p.getLocation().getBlockZ();
/*   57 */     Location l = new Location(p.getWorld(), x + 2, y + 100, z + NumberZ + 2);
/*   58 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ3(Player p, int NumberZ) {
/*   61 */     int x = p.getLocation().getBlockX();
/*   62 */     int y = p.getLocation().getBlockY();
/*   63 */     int z = p.getLocation().getBlockZ();
/*   64 */     Location l = new Location(p.getWorld(), x + 3, y + 100, z + NumberZ + 3);
/*   65 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ4(Player p, int NumberZ) {
/*   68 */     int x = p.getLocation().getBlockX();
/*   69 */     int y = p.getLocation().getBlockY();
/*   70 */     int z = p.getLocation().getBlockZ();
/*   71 */     Location l = new Location(p.getWorld(), x + 4, y + 100, z + NumberZ + 4);
/*   72 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ5(Player p, int NumberZ) {
/*   75 */     int x = p.getLocation().getBlockX();
/*   76 */     int y = p.getLocation().getBlockY();
/*   77 */     int z = p.getLocation().getBlockZ();
/*   78 */     Location l = new Location(p.getWorld(), x + 5, y + 100, z + NumberZ + 5);
/*   79 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ6(Player p, int NumberZ) {
/*   82 */     int x = p.getLocation().getBlockX();
/*   83 */     int y = p.getLocation().getBlockY();
/*   84 */     int z = p.getLocation().getBlockZ();
/*   85 */     Location l = new Location(p.getWorld(), x + 6, y + 100, z + NumberZ + 6);
/*   86 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setZ7(Player p, int NumberZ) {
/*   89 */     int x = p.getLocation().getBlockX();
/*   90 */     int y = p.getLocation().getBlockY();
/*   91 */     int z = p.getLocation().getBlockZ();
/*   92 */     Location l = new Location(p.getWorld(), x + 7, y + 100, z + NumberZ + 7);
/*   93 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBZ1(Player p, int NumberZ) {
/*   96 */     int x = p.getLocation().getBlockX();
/*   97 */     int y = p.getLocation().getBlockY();
/*   98 */     int z = p.getLocation().getBlockZ();
/*   99 */     Location l = new Location(p.getWorld(), x - 1, y + 100, z + NumberZ + 1);
/*  100 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBZ2(Player p, int NumberZ) {
/*  103 */     int x = p.getLocation().getBlockX();
/*  104 */     int y = p.getLocation().getBlockY();
/*  105 */     int z = p.getLocation().getBlockZ();
/*  106 */     Location l = new Location(p.getWorld(), x - 2, y + 100, z + NumberZ + 2);
/*  107 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBZ3(Player p, int NumberZ) {
/*  110 */     int x = p.getLocation().getBlockX();
/*  111 */     int y = p.getLocation().getBlockY();
/*  112 */     int z = p.getLocation().getBlockZ();
/*  113 */     Location l = new Location(p.getWorld(), x - 3, y + 100, z + NumberZ + 3);
/*  114 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX1(Player p, int X) {
/*  117 */     int x = p.getLocation().getBlockX();
/*  118 */     int y = p.getLocation().getBlockY();
/*  119 */     int z = p.getLocation().getBlockZ();
/*  120 */     Location l = new Location(p.getWorld(), x + X + 1, y + 100, z + 1);
/*  121 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX2(Player p, int X) {
/*  124 */     int x = p.getLocation().getBlockX();
/*  125 */     int y = p.getLocation().getBlockY();
/*  126 */     int z = p.getLocation().getBlockZ();
/*  127 */     Location l = new Location(p.getWorld(), x + X + 2, y + 100, z + 2);
/*  128 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX3(Player p, int X) {
/*  131 */     int x = p.getLocation().getBlockX();
/*  132 */     int y = p.getLocation().getBlockY();
/*  133 */     int z = p.getLocation().getBlockZ();
/*  134 */     Location l = new Location(p.getWorld(), x + X + 3, y + 100, z + 3);
/*  135 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX4(Player p, int X) {
/*  138 */     int x = p.getLocation().getBlockX();
/*  139 */     int y = p.getLocation().getBlockY();
/*  140 */     int z = p.getLocation().getBlockZ();
/*  141 */     Location l = new Location(p.getWorld(), x + X + 4, y + 100, z + 4);
/*  142 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX5(Player p, int X) {
/*  145 */     int x = p.getLocation().getBlockX();
/*  146 */     int y = p.getLocation().getBlockY();
/*  147 */     int z = p.getLocation().getBlockZ();
/*  148 */     Location l = new Location(p.getWorld(), x + X + 5, y + 100, z + 5);
/*  149 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX6(Player p, int X) {
/*  152 */     int x = p.getLocation().getBlockX();
/*  153 */     int y = p.getLocation().getBlockY();
/*  154 */     int z = p.getLocation().getBlockZ();
/*  155 */     Location l = new Location(p.getWorld(), x + X + 6, y + 100, z + 6);
/*  156 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setX7(Player p, int X) {
/*  159 */     int x = p.getLocation().getBlockX();
/*  160 */     int y = p.getLocation().getBlockY();
/*  161 */     int z = p.getLocation().getBlockZ();
/*  162 */     Location l = new Location(p.getWorld(), x + X + 7, y + 100, z + 7);
/*  163 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBX1(Player p, int X) {
/*  166 */     int x = p.getLocation().getBlockX();
/*  167 */     int y = p.getLocation().getBlockY();
/*  168 */     int z = p.getLocation().getBlockZ();
/*  169 */     Location l = new Location(p.getWorld(), x + X + 1, y + 100, z - 1);
/*  170 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBX2(Player p, int X) {
/*  173 */     int x = p.getLocation().getBlockX();
/*  174 */     int y = p.getLocation().getBlockY();
/*  175 */     int z = p.getLocation().getBlockZ();
/*  176 */     Location l = new Location(p.getWorld(), x + X + 2, y + 100, z - 2);
/*  177 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBX3(Player p, int X) {
/*  180 */     int x = p.getLocation().getBlockX();
/*  181 */     int y = p.getLocation().getBlockY();
/*  182 */     int z = p.getLocation().getBlockZ();
/*  183 */     Location l = new Location(p.getWorld(), x + X + 3, y + 100, z - 3);
/*  184 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBX4(Player p, int X) {
/*  187 */     int x = p.getLocation().getBlockX();
/*  188 */     int y = p.getLocation().getBlockY();
/*  189 */     int z = p.getLocation().getBlockZ();
/*  190 */     Location l = new Location(p.getWorld(), x + X + 4, y + 100, z - 4);
/*  191 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBX5(Player p, int X) {
/*  194 */     int x = p.getLocation().getBlockX();
/*  195 */     int y = p.getLocation().getBlockY();
/*  196 */     int z = p.getLocation().getBlockZ();
/*  197 */     Location l = new Location(p.getWorld(), x + X + 5, y + 100, z - 5);
/*  198 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBX6(Player p, int X) {
/*  201 */     int x = p.getLocation().getBlockX();
/*  202 */     int y = p.getLocation().getBlockY();
/*  203 */     int z = p.getLocation().getBlockZ();
/*  204 */     Location l = new Location(p.getWorld(), x + X + 6, y + 100, z - 6);
/*  205 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setBX7(Player p, int X) {
/*  208 */     int x = p.getLocation().getBlockX();
/*  209 */     int y = p.getLocation().getBlockY();
/*  210 */     int z = p.getLocation().getBlockZ();
/*  211 */     Location l = new Location(p.getWorld(), x + X + 7, y + 100, z - 7);
/*  212 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void b(Player p, int one) {
/*  215 */     int x = p.getLocation().getBlockX();
/*  216 */     int y = p.getLocation().getBlockY();
/*  217 */     int z = p.getLocation().getBlockZ();
/*  218 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z - 8);
/*  219 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void bb(Player p, int one) {
/*  222 */     int x = p.getLocation().getBlockX();
/*  223 */     int y = p.getLocation().getBlockY();
/*  224 */     int z = p.getLocation().getBlockZ();
/*  225 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 7);
/*  226 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setWall1(Player p, int one) {
/*  229 */     int x = p.getLocation().getBlockX();
/*  230 */     int y = p.getLocation().getBlockY();
/*  231 */     int z = p.getLocation().getBlockZ();
/*  232 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 8);
/*  233 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setWall2(Player p, int one) {
/*  236 */     int x = p.getLocation().getBlockX();
/*  237 */     int y = p.getLocation().getBlockY();
/*  238 */     int z = p.getLocation().getBlockZ();
/*  239 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 8);
/*  240 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void s(Player p, int one) {
/*  243 */     int x = p.getLocation().getBlockX();
/*  244 */     int y = p.getLocation().getBlockY();
/*  245 */     int z = p.getLocation().getBlockZ();
/*  246 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 7);
/*  247 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void ss(Player p, int one) {
/*  250 */     int x = p.getLocation().getBlockX();
/*  251 */     int y = p.getLocation().getBlockY();
/*  252 */     int z = p.getLocation().getBlockZ();
/*  253 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z - 8);
/*  254 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void c(Player p, int one) {
/*  257 */     int x = p.getLocation().getBlockX();
/*  258 */     int y = p.getLocation().getBlockY();
/*  259 */     int z = p.getLocation().getBlockZ();
/*  260 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 7);
/*  261 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void cc(Player p, int one) {
/*  264 */     int x = p.getLocation().getBlockX();
/*  265 */     int y = p.getLocation().getBlockY();
/*  266 */     int z = p.getLocation().getBlockZ();
/*  267 */     Location l = new Location(p.getWorld(), x + 7, y + 100 + one, z + 8);
/*  268 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void d(Player p, int one) {
/*  271 */     int x = p.getLocation().getBlockX();
/*  272 */     int y = p.getLocation().getBlockY();
/*  273 */     int z = p.getLocation().getBlockZ();
/*  274 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 7);
/*  275 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void dd(Player p, int one) {
/*  278 */     int x = p.getLocation().getBlockX();
/*  279 */     int y = p.getLocation().getBlockY();
/*  280 */     int z = p.getLocation().getBlockZ();
/*  281 */     Location l = new Location(p.getWorld(), x + 7, y + 100 + one, z - 8);
/*  282 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void e(Player p, int one) {
/*  285 */     int x = p.getLocation().getBlockX();
/*  286 */     int y = p.getLocation().getBlockY();
/*  287 */     int z = p.getLocation().getBlockZ();
/*  288 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z + 8);
/*  289 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void ee(Player p, int one) {
/*  292 */     int x = p.getLocation().getBlockX();
/*  293 */     int y = p.getLocation().getBlockY();
/*  294 */     int z = p.getLocation().getBlockZ();
/*  295 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 7);
/*  296 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setWall3(Player p, int one) {
/*  299 */     int x = p.getLocation().getBlockX();
/*  300 */     int y = p.getLocation().getBlockY();
/*  301 */     int z = p.getLocation().getBlockZ();
/*  302 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 8);
/*  303 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void aa(Player p, int one) {
/*  306 */     int x = p.getLocation().getBlockX();
/*  307 */     int y = p.getLocation().getBlockY();
/*  308 */     int z = p.getLocation().getBlockZ();
/*  309 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z - 8);
/*  310 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void aaa(Player p, int one) {
/*  313 */     int x = p.getLocation().getBlockX();
/*  314 */     int y = p.getLocation().getBlockY();
/*  315 */     int z = p.getLocation().getBlockZ();
/*  316 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 7);
/*  317 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setWall4(Player p, int one) {
/*  320 */     int x = p.getLocation().getBlockX();
/*  321 */     int y = p.getLocation().getBlockY();
/*  322 */     int z = p.getLocation().getBlockZ();
/*  323 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 8);
/*  324 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void set1(Player p, int one) {
/*  327 */     int x = p.getLocation().getBlockX();
/*  328 */     int y = p.getLocation().getBlockY();
/*  329 */     int z = p.getLocation().getBlockZ();
/*  330 */     Location l = new Location(p.getWorld(), x, y + 100 + one, z - 8);
/*  331 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */ 
/*      */   public static void set2(Player p, int one) {
/*  335 */     int x = p.getLocation().getBlockX();
/*  336 */     int y = p.getLocation().getBlockY();
/*  337 */     int z = p.getLocation().getBlockZ();
/*  338 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z);
/*  339 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */ 
/*      */   public static void set3(Player p, int one) {
/*  343 */     int x = p.getLocation().getBlockX();
/*  344 */     int y = p.getLocation().getBlockY();
/*  345 */     int z = p.getLocation().getBlockZ();
/*  346 */     Location l = new Location(p.getWorld(), x + 7, y + 100 + one, z);
/*  347 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc2(Player p, int one) {
/*  350 */     int x = p.getLocation().getBlockX();
/*  351 */     int y = p.getLocation().getBlockY();
/*  352 */     int z = p.getLocation().getBlockZ();
/*  353 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 1);
/*  354 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc3(Player p, int one) {
/*  357 */     int x = p.getLocation().getBlockX();
/*  358 */     int y = p.getLocation().getBlockY();
/*  359 */     int z = p.getLocation().getBlockZ();
/*  360 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 2);
/*  361 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc4(Player p, int one) {
/*  364 */     int x = p.getLocation().getBlockX();
/*  365 */     int y = p.getLocation().getBlockY();
/*  366 */     int z = p.getLocation().getBlockZ();
/*  367 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 3);
/*  368 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc5(Player p, int one) {
/*  371 */     int x = p.getLocation().getBlockX();
/*  372 */     int y = p.getLocation().getBlockY();
/*  373 */     int z = p.getLocation().getBlockZ();
/*  374 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 4);
/*  375 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc6(Player p, int one) {
/*  378 */     int x = p.getLocation().getBlockX();
/*  379 */     int y = p.getLocation().getBlockY();
/*  380 */     int z = p.getLocation().getBlockZ();
/*  381 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 5);
/*  382 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc7(Player p, int one) {
/*  385 */     int x = p.getLocation().getBlockX();
/*  386 */     int y = p.getLocation().getBlockY();
/*  387 */     int z = p.getLocation().getBlockZ();
/*  388 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 6);
/*  389 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc8(Player p, int one) {
/*  392 */     int x = p.getLocation().getBlockX();
/*  393 */     int y = p.getLocation().getBlockY();
/*  394 */     int z = p.getLocation().getBlockZ();
/*  395 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 1);
/*  396 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc9(Player p, int one) {
/*  399 */     int x = p.getLocation().getBlockX();
/*  400 */     int y = p.getLocation().getBlockY();
/*  401 */     int z = p.getLocation().getBlockZ();
/*  402 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 2);
/*  403 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc10(Player p, int one) {
/*  406 */     int x = p.getLocation().getBlockX();
/*  407 */     int y = p.getLocation().getBlockY();
/*  408 */     int z = p.getLocation().getBlockZ();
/*  409 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 3);
/*  410 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc11(Player p, int one) {
/*  413 */     int x = p.getLocation().getBlockX();
/*  414 */     int y = p.getLocation().getBlockY();
/*  415 */     int z = p.getLocation().getBlockZ();
/*  416 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 4);
/*  417 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc12(Player p, int one) {
/*  420 */     int x = p.getLocation().getBlockX();
/*  421 */     int y = p.getLocation().getBlockY();
/*  422 */     int z = p.getLocation().getBlockZ();
/*  423 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 5);
/*  424 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setc13(Player p, int one) {
/*  427 */     int x = p.getLocation().getBlockX();
/*  428 */     int y = p.getLocation().getBlockY();
/*  429 */     int z = p.getLocation().getBlockZ();
/*  430 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 6);
/*  431 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void set4(Player p, int one) {
/*  434 */     int x = p.getLocation().getBlockX();
/*  435 */     int y = p.getLocation().getBlockY();
/*  436 */     int z = p.getLocation().getBlockZ();
/*  437 */     Location l = new Location(p.getWorld(), x, y + 100 + one, z + 8);
/*  438 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void seta1(Player p, int one) {
/*  441 */     int x = p.getLocation().getBlockX();
/*  442 */     int y = p.getLocation().getBlockY();
/*  443 */     int z = p.getLocation().getBlockZ();
/*  444 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 6);
/*  445 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void seta2(Player p, int one) {
/*  448 */     int x = p.getLocation().getBlockX();
/*  449 */     int y = p.getLocation().getBlockY();
/*  450 */     int z = p.getLocation().getBlockZ();
/*  451 */     Location l = new Location(p.getWorld(), x - 6, y + 100 + one, z - 8);
/*  452 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaa2(Player p, int one) {
/*  455 */     int x = p.getLocation().getBlockX();
/*  456 */     int y = p.getLocation().getBlockY();
/*  457 */     int z = p.getLocation().getBlockZ();
/*  458 */     Location l = new Location(p.getWorld(), x - 5, y + 100 + one, z - 8);
/*  459 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaaa2(Player p, int one) {
/*  462 */     int x = p.getLocation().getBlockX();
/*  463 */     int y = p.getLocation().getBlockY();
/*  464 */     int z = p.getLocation().getBlockZ();
/*  465 */     Location l = new Location(p.getWorld(), x - 4, y + 100 + one, z - 8);
/*  466 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaaaa2(Player p, int one) {
/*  469 */     int x = p.getLocation().getBlockX();
/*  470 */     int y = p.getLocation().getBlockY();
/*  471 */     int z = p.getLocation().getBlockZ();
/*  472 */     Location l = new Location(p.getWorld(), x - 3, y + 100 + one, z - 8);
/*  473 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setab2(Player p, int one) {
/*  476 */     int x = p.getLocation().getBlockX();
/*  477 */     int y = p.getLocation().getBlockY();
/*  478 */     int z = p.getLocation().getBlockZ();
/*  479 */     Location l = new Location(p.getWorld(), x - 2, y + 100 + one, z - 8);
/*  480 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setabb2(Player p, int one) {
/*  483 */     int x = p.getLocation().getBlockX();
/*  484 */     int y = p.getLocation().getBlockY();
/*  485 */     int z = p.getLocation().getBlockZ();
/*  486 */     Location l = new Location(p.getWorld(), x - 1, y + 100 + one, z - 8);
/*  487 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setabbb2(Player p, int one) {
/*  490 */     int x = p.getLocation().getBlockX();
/*  491 */     int y = p.getLocation().getBlockY();
/*  492 */     int z = p.getLocation().getBlockZ();
/*  493 */     Location l = new Location(p.getWorld(), x + 1, y + 100 + one, z - 8);
/*  494 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setac2(Player p, int one) {
/*  497 */     int x = p.getLocation().getBlockX();
/*  498 */     int y = p.getLocation().getBlockY();
/*  499 */     int z = p.getLocation().getBlockZ();
/*  500 */     Location l = new Location(p.getWorld(), x + 2, y + 100 + one, z - 8);
/*  501 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setacc2(Player p, int one) {
/*  504 */     int x = p.getLocation().getBlockX();
/*  505 */     int y = p.getLocation().getBlockY();
/*  506 */     int z = p.getLocation().getBlockZ();
/*  507 */     Location l = new Location(p.getWorld(), x + 3, y + 100 + one, z - 8);
/*  508 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaccc2(Player p, int one) {
/*  511 */     int x = p.getLocation().getBlockX();
/*  512 */     int y = p.getLocation().getBlockY();
/*  513 */     int z = p.getLocation().getBlockZ();
/*  514 */     Location l = new Location(p.getWorld(), x + 4, y + 100 + one, z - 8);
/*  515 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setac3(Player p, int one) {
/*  518 */     int x = p.getLocation().getBlockX();
/*  519 */     int y = p.getLocation().getBlockY();
/*  520 */     int z = p.getLocation().getBlockZ();
/*  521 */     Location l = new Location(p.getWorld(), x + 5, y + 100 + one, z - 8);
/*  522 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setacc3(Player p, int one) {
/*  525 */     int x = p.getLocation().getBlockX();
/*  526 */     int y = p.getLocation().getBlockY();
/*  527 */     int z = p.getLocation().getBlockZ();
/*  528 */     Location l = new Location(p.getWorld(), x + 6, y + 100 + one, z - 8);
/*  529 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void seta3(Player p, int one) {
/*  532 */     int x = p.getLocation().getBlockX();
/*  533 */     int y = p.getLocation().getBlockY();
/*  534 */     int z = p.getLocation().getBlockZ();
/*  535 */     Location l = new Location(p.getWorld(), x - 6, y + 100 + one, z + 8);
/*  536 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setb1(Player p, int one) {
/*  539 */     int x = p.getLocation().getBlockX();
/*  540 */     int y = p.getLocation().getBlockY();
/*  541 */     int z = p.getLocation().getBlockZ();
/*  542 */     Location l = new Location(p.getWorld(), x - 5, y + 100 + one, z + 8);
/*  543 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbb1(Player p, int one) {
/*  546 */     int x = p.getLocation().getBlockX();
/*  547 */     int y = p.getLocation().getBlockY();
/*  548 */     int z = p.getLocation().getBlockZ();
/*  549 */     Location l = new Location(p.getWorld(), x - 4, y + 100 + one, z + 8);
/*  550 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbbb1(Player p, int one) {
/*  553 */     int x = p.getLocation().getBlockX();
/*  554 */     int y = p.getLocation().getBlockY();
/*  555 */     int z = p.getLocation().getBlockZ();
/*  556 */     Location l = new Location(p.getWorld(), x - 3, y + 100 + one, z + 8);
/*  557 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbbbb1(Player p, int one) {
/*  560 */     int x = p.getLocation().getBlockX();
/*  561 */     int y = p.getLocation().getBlockY();
/*  562 */     int z = p.getLocation().getBlockZ();
/*  563 */     Location l = new Location(p.getWorld(), x - 2, y + 100 + one, z + 8);
/*  564 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setb2(Player p, int one) {
/*  567 */     int x = p.getLocation().getBlockX();
/*  568 */     int y = p.getLocation().getBlockY();
/*  569 */     int z = p.getLocation().getBlockZ();
/*  570 */     Location l = new Location(p.getWorld(), x - 1, y + 100 + one, z + 8);
/*  571 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbb2(Player p, int one) {
/*  574 */     int x = p.getLocation().getBlockX();
/*  575 */     int y = p.getLocation().getBlockY();
/*  576 */     int z = p.getLocation().getBlockZ();
/*  577 */     Location l = new Location(p.getWorld(), x + 1, y + 100 + one, z + 8);
/*  578 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbbb2(Player p, int one) {
/*  581 */     int x = p.getLocation().getBlockX();
/*  582 */     int y = p.getLocation().getBlockY();
/*  583 */     int z = p.getLocation().getBlockZ();
/*  584 */     Location l = new Location(p.getWorld(), x + 2, y + 100 + one, z + 8);
/*  585 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbbbb2(Player p, int one) {
/*  588 */     int x = p.getLocation().getBlockX();
/*  589 */     int y = p.getLocation().getBlockY();
/*  590 */     int z = p.getLocation().getBlockZ();
/*  591 */     Location l = new Location(p.getWorld(), x + 3, y + 100 + one, z + 8);
/*  592 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setb3(Player p, int one) {
/*  595 */     int x = p.getLocation().getBlockX();
/*  596 */     int y = p.getLocation().getBlockY();
/*  597 */     int z = p.getLocation().getBlockZ();
/*  598 */     Location l = new Location(p.getWorld(), x + 4, y + 100 + one, z + 8);
/*  599 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbb3(Player p, int one) {
/*  602 */     int x = p.getLocation().getBlockX();
/*  603 */     int y = p.getLocation().getBlockY();
/*  604 */     int z = p.getLocation().getBlockZ();
/*  605 */     Location l = new Location(p.getWorld(), x + 5, y + 100 + one, z + 8);
/*  606 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setbbb3(Player p, int one) {
/*  609 */     int x = p.getLocation().getBlockX();
/*  610 */     int y = p.getLocation().getBlockY();
/*  611 */     int z = p.getLocation().getBlockZ();
/*  612 */     Location l = new Location(p.getWorld(), x + 6, y + 100 + one, z + 8);
/*  613 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */ 
/*      */   public static void seta4(Player p, int one) {
/*  617 */     int x = p.getLocation().getBlockX();
/*  618 */     int y = p.getLocation().getBlockY();
/*  619 */     int z = p.getLocation().getBlockZ();
/*  620 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 6);
/*  621 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaa4(Player p, int one) {
/*  624 */     int x = p.getLocation().getBlockX();
/*  625 */     int y = p.getLocation().getBlockY();
/*  626 */     int z = p.getLocation().getBlockZ();
/*  627 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 5);
/*  628 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaaa4(Player p, int one) {
/*  631 */     int x = p.getLocation().getBlockX();
/*  632 */     int y = p.getLocation().getBlockY();
/*  633 */     int z = p.getLocation().getBlockZ();
/*  634 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 4);
/*  635 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaaaa4(Player p, int one) {
/*  638 */     int x = p.getLocation().getBlockX();
/*  639 */     int y = p.getLocation().getBlockY();
/*  640 */     int z = p.getLocation().getBlockZ();
/*  641 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 3);
/*  642 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void seta5(Player p, int one) {
/*  645 */     int x = p.getLocation().getBlockX();
/*  646 */     int y = p.getLocation().getBlockY();
/*  647 */     int z = p.getLocation().getBlockZ();
/*  648 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 2);
/*  649 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaa5(Player p, int one) {
/*  652 */     int x = p.getLocation().getBlockX();
/*  653 */     int y = p.getLocation().getBlockY();
/*  654 */     int z = p.getLocation().getBlockZ();
/*  655 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 1);
/*  656 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */ 
/*      */   public static void setaaa5(Player p, int one) {
/*  660 */     int x = p.getLocation().getBlockX();
/*  661 */     int y = p.getLocation().getBlockY();
/*  662 */     int z = p.getLocation().getBlockZ();
/*  663 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 1);
/*  664 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaaaa5(Player p, int one) {
/*  667 */     int x = p.getLocation().getBlockX();
/*  668 */     int y = p.getLocation().getBlockY();
/*  669 */     int z = p.getLocation().getBlockZ();
/*  670 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 2);
/*  671 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaa6(Player p, int one) {
/*  674 */     int x = p.getLocation().getBlockX();
/*  675 */     int y = p.getLocation().getBlockY();
/*  676 */     int z = p.getLocation().getBlockZ();
/*  677 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 3);
/*  678 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaaa6(Player p, int one) {
/*  681 */     int x = p.getLocation().getBlockX();
/*  682 */     int y = p.getLocation().getBlockY();
/*  683 */     int z = p.getLocation().getBlockZ();
/*  684 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 4);
/*  685 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void setaaaa6(Player p, int one) {
/*  688 */     int x = p.getLocation().getBlockX();
/*  689 */     int y = p.getLocation().getBlockY();
/*  690 */     int z = p.getLocation().getBlockZ();
/*  691 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 5);
/*  692 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */ 
/*      */   public static void asetBlock(Player p, int NumberX, int NumberZ) {
/*  696 */     int x = p.getLocation().getBlockX();
/*  697 */     int y = p.getLocation().getBlockY();
/*  698 */     int z = p.getLocation().getBlockZ();
/*  699 */     Location l = new Location(p.getWorld(), x + NumberX, y + 105, z + NumberZ);
/*  700 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX(Player p, int NumberX) {
/*  703 */     int x = p.getLocation().getBlockX();
/*  704 */     int y = p.getLocation().getBlockY();
/*  705 */     int z = p.getLocation().getBlockZ();
/*  706 */     Location l = new Location(p.getWorld(), x + NumberX, y + 105, z);
/*  707 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ(Player p, int NumberZ) {
/*  710 */     int x = p.getLocation().getBlockX();
/*  711 */     int y = p.getLocation().getBlockY();
/*  712 */     int z = p.getLocation().getBlockZ();
/*  713 */     Location l = new Location(p.getWorld(), x, y + 105, z + NumberZ);
/*  714 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ1(Player p, int NumberZ) {
/*  717 */     int x = p.getLocation().getBlockX();
/*  718 */     int y = p.getLocation().getBlockY();
/*  719 */     int z = p.getLocation().getBlockZ();
/*  720 */     Location l = new Location(p.getWorld(), x + 1, y + 105, z + NumberZ + 1);
/*  721 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ2(Player p, int NumberZ) {
/*  724 */     int x = p.getLocation().getBlockX();
/*  725 */     int y = p.getLocation().getBlockY();
/*  726 */     int z = p.getLocation().getBlockZ();
/*  727 */     Location l = new Location(p.getWorld(), x + 2, y + 105, z + NumberZ + 2);
/*  728 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ3(Player p, int NumberZ) {
/*  731 */     int x = p.getLocation().getBlockX();
/*  732 */     int y = p.getLocation().getBlockY();
/*  733 */     int z = p.getLocation().getBlockZ();
/*  734 */     Location l = new Location(p.getWorld(), x + 3, y + 105, z + NumberZ + 3);
/*  735 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ4(Player p, int NumberZ) {
/*  738 */     int x = p.getLocation().getBlockX();
/*  739 */     int y = p.getLocation().getBlockY();
/*  740 */     int z = p.getLocation().getBlockZ();
/*  741 */     Location l = new Location(p.getWorld(), x + 4, y + 105, z + NumberZ + 4);
/*  742 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ5(Player p, int NumberZ) {
/*  745 */     int x = p.getLocation().getBlockX();
/*  746 */     int y = p.getLocation().getBlockY();
/*  747 */     int z = p.getLocation().getBlockZ();
/*  748 */     Location l = new Location(p.getWorld(), x + 5, y + 105, z + NumberZ + 5);
/*  749 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ6(Player p, int NumberZ) {
/*  752 */     int x = p.getLocation().getBlockX();
/*  753 */     int y = p.getLocation().getBlockY();
/*  754 */     int z = p.getLocation().getBlockZ();
/*  755 */     Location l = new Location(p.getWorld(), x + 6, y + 105, z + NumberZ + 6);
/*  756 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetZ7(Player p, int NumberZ) {
/*  759 */     int x = p.getLocation().getBlockX();
/*  760 */     int y = p.getLocation().getBlockY();
/*  761 */     int z = p.getLocation().getBlockZ();
/*  762 */     Location l = new Location(p.getWorld(), x + 7, y + 105, z + NumberZ + 7);
/*  763 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBZ1(Player p, int NumberZ) {
/*  766 */     int x = p.getLocation().getBlockX();
/*  767 */     int y = p.getLocation().getBlockY();
/*  768 */     int z = p.getLocation().getBlockZ();
/*  769 */     Location l = new Location(p.getWorld(), x - 1, y + 105, z + NumberZ + 1);
/*  770 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBZ2(Player p, int NumberZ) {
/*  773 */     int x = p.getLocation().getBlockX();
/*  774 */     int y = p.getLocation().getBlockY();
/*  775 */     int z = p.getLocation().getBlockZ();
/*  776 */     Location l = new Location(p.getWorld(), x - 2, y + 105, z + NumberZ + 2);
/*  777 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBZ3(Player p, int NumberZ) {
/*  780 */     int x = p.getLocation().getBlockX();
/*  781 */     int y = p.getLocation().getBlockY();
/*  782 */     int z = p.getLocation().getBlockZ();
/*  783 */     Location l = new Location(p.getWorld(), x - 3, y + 105, z + NumberZ + 3);
/*  784 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX1(Player p, int X) {
/*  787 */     int x = p.getLocation().getBlockX();
/*  788 */     int y = p.getLocation().getBlockY();
/*  789 */     int z = p.getLocation().getBlockZ();
/*  790 */     Location l = new Location(p.getWorld(), x + X + 1, y + 105, z + 1);
/*  791 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX2(Player p, int X) {
/*  794 */     int x = p.getLocation().getBlockX();
/*  795 */     int y = p.getLocation().getBlockY();
/*  796 */     int z = p.getLocation().getBlockZ();
/*  797 */     Location l = new Location(p.getWorld(), x + X + 2, y + 105, z + 2);
/*  798 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX3(Player p, int X) {
/*  801 */     int x = p.getLocation().getBlockX();
/*  802 */     int y = p.getLocation().getBlockY();
/*  803 */     int z = p.getLocation().getBlockZ();
/*  804 */     Location l = new Location(p.getWorld(), x + X + 3, y + 105, z + 3);
/*  805 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX4(Player p, int X) {
/*  808 */     int x = p.getLocation().getBlockX();
/*  809 */     int y = p.getLocation().getBlockY();
/*  810 */     int z = p.getLocation().getBlockZ();
/*  811 */     Location l = new Location(p.getWorld(), x + X + 4, y + 105, z + 4);
/*  812 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX5(Player p, int X) {
/*  815 */     int x = p.getLocation().getBlockX();
/*  816 */     int y = p.getLocation().getBlockY();
/*  817 */     int z = p.getLocation().getBlockZ();
/*  818 */     Location l = new Location(p.getWorld(), x + X + 5, y + 105, z + 5);
/*  819 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX6(Player p, int X) {
/*  822 */     int x = p.getLocation().getBlockX();
/*  823 */     int y = p.getLocation().getBlockY();
/*  824 */     int z = p.getLocation().getBlockZ();
/*  825 */     Location l = new Location(p.getWorld(), x + X + 6, y + 105, z + 6);
/*  826 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetX7(Player p, int X) {
/*  829 */     int x = p.getLocation().getBlockX();
/*  830 */     int y = p.getLocation().getBlockY();
/*  831 */     int z = p.getLocation().getBlockZ();
/*  832 */     Location l = new Location(p.getWorld(), x + X + 7, y + 105, z + 7);
/*  833 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBX1(Player p, int X) {
/*  836 */     int x = p.getLocation().getBlockX();
/*  837 */     int y = p.getLocation().getBlockY();
/*  838 */     int z = p.getLocation().getBlockZ();
/*  839 */     Location l = new Location(p.getWorld(), x + X + 1, y + 105, z - 1);
/*  840 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBX2(Player p, int X) {
/*  843 */     int x = p.getLocation().getBlockX();
/*  844 */     int y = p.getLocation().getBlockY();
/*  845 */     int z = p.getLocation().getBlockZ();
/*  846 */     Location l = new Location(p.getWorld(), x + X + 2, y + 105, z - 2);
/*  847 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBX3(Player p, int X) {
/*  850 */     int x = p.getLocation().getBlockX();
/*  851 */     int y = p.getLocation().getBlockY();
/*  852 */     int z = p.getLocation().getBlockZ();
/*  853 */     Location l = new Location(p.getWorld(), x + X + 3, y + 105, z - 3);
/*  854 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBX4(Player p, int X) {
/*  857 */     int x = p.getLocation().getBlockX();
/*  858 */     int y = p.getLocation().getBlockY();
/*  859 */     int z = p.getLocation().getBlockZ();
/*  860 */     Location l = new Location(p.getWorld(), x + X + 4, y + 105, z - 4);
/*  861 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBX5(Player p, int X) {
/*  864 */     int x = p.getLocation().getBlockX();
/*  865 */     int y = p.getLocation().getBlockY();
/*  866 */     int z = p.getLocation().getBlockZ();
/*  867 */     Location l = new Location(p.getWorld(), x + X + 5, y + 105, z - 5);
/*  868 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBX6(Player p, int X) {
/*  871 */     int x = p.getLocation().getBlockX();
/*  872 */     int y = p.getLocation().getBlockY();
/*  873 */     int z = p.getLocation().getBlockZ();
/*  874 */     Location l = new Location(p.getWorld(), x + X + 6, y + 105, z - 6);
/*  875 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void asetBX7(Player p, int X) {
/*  878 */     int x = p.getLocation().getBlockX();
/*  879 */     int y = p.getLocation().getBlockY();
/*  880 */     int z = p.getLocation().getBlockZ();
/*  881 */     Location l = new Location(p.getWorld(), x + X + 7, y + 105, z - 7);
/*  882 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */   public static void a(Player p, int Test) {
/*  885 */     int x = p.getLocation().getBlockX();
/*  886 */     int y = p.getLocation().getBlockY();
/*  887 */     int z = p.getLocation().getBlockZ();
/*  888 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + Test, z);
/*  889 */     Block block = l.getBlock(); block.setType(Material.GLASS);
/*      */   }
/*      */ 
/*      */   @SuppressWarnings("deprecation")
public static void SetGladiatorArena(Player p) {
/*  893 */     int x = p.getLocation().getBlockX();
/*  894 */     int y = p.getLocation().getBlockY();
/*  895 */     int z = p.getLocation().getBlockZ();
/*  896 */     Location l1 = new Location(p.getWorld(), x, y + 100, z);
/*  897 */     Location a1 = new Location(p.getWorld(), x + 7, y + 101, z);
/*  898 */     Location b1 = new Location(p.getWorld(), x + 7, y + 102, z);
/*  899 */     Location c1 = new Location(p.getWorld(), x + 7, y + 103, z);
/*  900 */     Location d1 = new Location(p.getWorld(), x + 7, y + 104, z);
/*  901 */     a1.getBlock().setType(Material.AIR);
/*  902 */     b1.getBlock().setType(Material.AIR);
/*  903 */     c1.getBlock().setType(Material.AIR);
/*  904 */     d1.getBlock().setType(Material.AIR);
/*  905 */     Location l2 = new Location(p.getWorld(), x, y + 105, z);
/*  906 */     if (KitHandler.getKit(p.getName()) == KitType.GLADIATOR && 
/* 2012 */       (!com.experiencepvp.kits.listeners.cmds.Gladiator.GladiatorBattle.containsKey(p.getName())) && 
/* 2013 */       (p.getItemInHand().getType() == Material.getMaterial(101))) {
/*  909 */       l1.getBlock().setType(Material.GLASS);
/*  910 */       l2.getBlock().setType(Material.GLASS);
/*  911 */       s(p, 1);
/*  912 */       s(p, 2);
/*  913 */       s(p, 3);
/*  914 */       s(p, 4);
/*  915 */       s(p, 5);
/*  916 */       ss(p, 1);
/*  917 */       ss(p, 2);
/*  918 */       ss(p, 3);
/*  919 */       ss(p, 4);
/*  920 */       ss(p, 5);
/*  921 */       a(p, 1);
/*  922 */       a(p, 2);
/*  923 */       a(p, 3);
/*  924 */       a(p, 4);
/*  925 */       a(p, 5);
/*  926 */       aa(p, 1);
/*  927 */       aa(p, 2);
/*  928 */       aa(p, 3);
/*  929 */       aa(p, 4);
/*  930 */       aa(p, 5);
/*  931 */       b(p, 1);
/*  932 */       b(p, 2);
/*  933 */       b(p, 3);
/*  934 */       b(p, 4);
/*  935 */       b(p, 5);
/*  936 */       bb(p, 1);
/*  937 */       bb(p, 2);
/*  938 */       bb(p, 3);
/*  939 */       bb(p, 4);
/*  940 */       bb(p, 5);
/*  941 */       c(p, 1);
/*  942 */       c(p, 2);
/*  943 */       c(p, 3);
/*  944 */       c(p, 4);
/*  945 */       c(p, 5);
/*  946 */       cc(p, 1);
/*  947 */       cc(p, 2);
/*  948 */       cc(p, 3);
/*  949 */       cc(p, 4);
/*  950 */       cc(p, 5);
/*  951 */       d(p, 1);
/*  952 */       d(p, 2);
/*  953 */       d(p, 3);
/*  954 */       d(p, 4);
/*  955 */       d(p, 5);
/*  956 */       dd(p, 1);
/*  957 */       dd(p, 2);
/*  958 */       dd(p, 3);
/*  959 */       dd(p, 4);
/*  960 */       dd(p, 5);
/*  961 */       e(p, 1);
/*  962 */       e(p, 2);
/*  963 */       e(p, 3);
/*  964 */       e(p, 4);
/*  965 */       e(p, 5);
/*  966 */       ee(p, 1);
/*  967 */       ee(p, 2);
/*  968 */       ee(p, 3);
/*  969 */       ee(p, 4);
/*  970 */       ee(p, 5);
/*      */ 
/*  972 */       setBZ1(p, 1);
/*  973 */       setBZ2(p, 1);
/*  974 */       setBZ3(p, 1);
/*  975 */       setBZ1(p, -1);
/*  976 */       setBZ2(p, -1);
/*  977 */       setBZ3(p, -1);
/*  978 */       setZ1(p, 1);
/*  979 */       setZ2(p, 1);
/*  980 */       setZ3(p, 1);
/*  981 */       setZ1(p, -1);
/*  982 */       setZ2(p, -1);
/*  983 */       setZ3(p, -1);
/*      */ 
/*  985 */       setBZ1(p, 2);
/*  986 */       setBZ2(p, 2);
/*  987 */       setBZ3(p, 2);
/*  988 */       setBZ1(p, -2);
/*  989 */       setBZ2(p, -2);
/*  990 */       setBZ3(p, -2);
/*  991 */       setZ1(p, 2);
/*  992 */       setZ2(p, 2);
/*  993 */       setZ3(p, 2);
/*  994 */       setZ1(p, -2);
/*  995 */       setZ2(p, -2);
/*  996 */       setZ3(p, -2);
/*      */ 
/*  998 */       setBZ1(p, 3);
/*  999 */       setBZ2(p, 3);
/* 1000 */       setBZ3(p, 3);
/* 1001 */       setBZ1(p, -3);
/* 1002 */       setBZ2(p, -3);
/* 1003 */       setBZ3(p, -3);
/* 1004 */       setZ1(p, 3);
/* 1005 */       setZ2(p, 3);
/* 1006 */       setZ3(p, 3);
/* 1007 */       setZ1(p, -3);
/* 1008 */       setZ2(p, -3);
/* 1009 */       setZ3(p, -3);
/*      */ 
/* 1011 */       setBZ1(p, 4);
/* 1012 */       setBZ2(p, 4);
/* 1013 */       setBZ3(p, 4);
/* 1014 */       setBZ1(p, -4);
/* 1015 */       setBZ2(p, -4);
/* 1016 */       setBZ3(p, -4);
/* 1017 */       setBZ3(p, -5);
/* 1018 */       setBZ3(p, -6);
/* 1019 */       setBZ3(p, -7);
/* 1020 */       setBZ3(p, -8);
/* 1021 */       setBZ3(p, -9);
/* 1022 */       setBZ3(p, -10);
/* 1023 */       setZ1(p, 4);
/* 1024 */       setZ2(p, 4);
/* 1025 */       setZ3(p, 4);
/* 1026 */       setZ1(p, -4);
/* 1027 */       setZ2(p, -4);
/* 1028 */       setZ3(p, -4);
/*      */ 
/* 1030 */       setBZ1(p, 5);
/* 1031 */       setBZ2(p, 5);
/* 1032 */       setBZ1(p, -5);
/* 1033 */       setBZ2(p, -5);
/* 1034 */       setBZ2(p, -6);
/* 1035 */       setBZ2(p, -7);
/* 1036 */       setBZ2(p, -8);
/* 1037 */       setBZ2(p, -9);
/* 1038 */       setZ1(p, 5);
/* 1039 */       setZ2(p, 5);
/* 1040 */       setZ1(p, -5);
/* 1041 */       setZ2(p, -5);
/* 1042 */       setZ3(p, -5);
/*      */ 
/* 1044 */       setZ1(p, 6);
/* 1045 */       setZ1(p, -6);
/* 1046 */       setBZ1(p, 6);
/* 1047 */       setBZ1(p, -7);
/* 1048 */       setBZ1(p, -6);
/* 1049 */       setBZ1(p, -8);
/* 1050 */       setZ2(p, -6);
/* 1051 */       setZ3(p, -6);
/*      */ 
/* 1053 */       setZ1(p, -7);
/* 1054 */       setZ1(p, -8);
/* 1055 */       setZ2(p, -7);
/* 1056 */       setZ2(p, -8);
/* 1057 */       setZ2(p, -9);
/* 1058 */       setZ3(p, -7);
/* 1059 */       setZ3(p, -8);
/* 1060 */       setZ3(p, -9);
/* 1061 */       setZ3(p, -10);
/*      */ 
/* 1063 */       setZ4(p, 1);
/* 1064 */       setZ4(p, 2);
/* 1065 */       setZ4(p, 3);
/* 1066 */       setZ4(p, -1);
/* 1067 */       setZ4(p, -2);
/* 1068 */       setZ4(p, -3);
/* 1069 */       setZ4(p, -4);
/* 1070 */       setZ4(p, -5);
/* 1071 */       setZ4(p, -6);
/* 1072 */       setZ4(p, -7);
/* 1073 */       setZ4(p, -8);
/* 1074 */       setZ4(p, -9);
/* 1075 */       setZ4(p, -10);
/* 1076 */       setZ4(p, -11);
/* 1077 */       setZ5(p, 1);
/* 1078 */       setZ5(p, 2);
/* 1079 */       setZ5(p, -1);
/* 1080 */       setZ5(p, -2);
/* 1081 */       setZ5(p, -3);
/* 1082 */       setZ5(p, -4);
/* 1083 */       setZ5(p, -5);
/* 1084 */       setZ5(p, -6);
/* 1085 */       setZ5(p, -7);
/* 1086 */       setZ5(p, -8);
/* 1087 */       setZ5(p, -9);
/* 1088 */       setZ5(p, -10);
/* 1089 */       setZ5(p, -11);
/* 1090 */       setZ5(p, -12);
/* 1091 */       setZ6(p, -1);
/* 1092 */       setZ6(p, -2);
/* 1093 */       setZ6(p, -3);
/* 1094 */       setZ6(p, -4);
/* 1095 */       setZ6(p, -5);
/* 1096 */       setZ6(p, -6);
/* 1097 */       setZ6(p, -7);
/* 1098 */       setZ6(p, -8);
/* 1099 */       setZ6(p, -9);
/* 1100 */       setZ6(p, -10);
/* 1101 */       setZ6(p, -11);
/* 1102 */       setZ6(p, -12);
/* 1103 */       setZ6(p, -13);
/* 1104 */       setZ5(p, -1);
/* 1105 */       setZ5(p, -2);
/* 1106 */       setZ5(p, -3);
/* 1107 */       setZ5(p, -4);
/* 1108 */       setZ5(p, -5);
/* 1109 */       setZ5(p, -6);
/* 1110 */       setZ5(p, -7);
/* 1111 */       setZ5(p, -8);
/* 1112 */       setZ5(p, -9);
/* 1113 */       setZ5(p, -10);
/* 1114 */       setZ5(p, -11);
/* 1115 */       setZ5(p, -12);
/* 1116 */       setZ7(p, -1);
/* 1117 */       setZ7(p, -2);
/* 1118 */       setZ7(p, -3);
/* 1119 */       setZ7(p, -4);
/* 1120 */       setZ7(p, -5);
/* 1121 */       setZ7(p, -6);
/* 1122 */       setZ7(p, -7);
/* 1123 */       setZ7(p, -8);
/* 1124 */       setZ7(p, -9);
/* 1125 */       setZ7(p, -10);
/* 1126 */       setZ7(p, -11);
/* 1127 */       setZ7(p, -12);
/* 1128 */       setZ7(p, -13);
/* 1129 */       setZ7(p, -14);
/*      */ 
/* 1131 */       setX1(p, -1);
/* 1132 */       setX1(p, -2);
/* 1133 */       setX1(p, -3);
/* 1134 */       setX1(p, -4);
/* 1135 */       setX1(p, -5);
/* 1136 */       setX1(p, -6);
/* 1137 */       setX1(p, -7);
/* 1138 */       setX1(p, -8);
/* 1139 */       setX2(p, -1);
/* 1140 */       setX2(p, -2);
/* 1141 */       setX2(p, -3);
/* 1142 */       setX2(p, -4);
/* 1143 */       setX2(p, -5);
/* 1144 */       setX2(p, -6);
/* 1145 */       setX2(p, -7);
/* 1146 */       setX2(p, -8);
/* 1147 */       setX2(p, -9);
/* 1148 */       setX3(p, -1);
/* 1149 */       setX3(p, -2);
/* 1150 */       setX3(p, -3);
/* 1151 */       setX3(p, -4);
/* 1152 */       setX3(p, -5);
/* 1153 */       setX3(p, -6);
/* 1154 */       setX3(p, -7);
/* 1155 */       setX3(p, -8);
/* 1156 */       setX3(p, -9);
/* 1157 */       setX3(p, -10);
/* 1158 */       setX4(p, -1);
/* 1159 */       setX4(p, -2);
/* 1160 */       setX4(p, -3);
/* 1161 */       setX4(p, -4);
/* 1162 */       setX4(p, -5);
/* 1163 */       setX4(p, -6);
/* 1164 */       setX4(p, -7);
/* 1165 */       setX4(p, -8);
/* 1166 */       setX4(p, -9);
/* 1167 */       setX4(p, -10);
/* 1168 */       setX4(p, -11);
/* 1169 */       setX5(p, -1);
/* 1170 */       setX5(p, -2);
/* 1171 */       setX5(p, -3);
/* 1172 */       setX5(p, -4);
/* 1173 */       setX5(p, -5);
/* 1174 */       setX5(p, -6);
/* 1175 */       setX5(p, -7);
/* 1176 */       setX5(p, -8);
/* 1177 */       setX5(p, -9);
/* 1178 */       setX5(p, -10);
/* 1179 */       setX5(p, -11);
/* 1180 */       setX5(p, -12);
/* 1181 */       setX6(p, -1);
/* 1182 */       setX6(p, -2);
/* 1183 */       setX6(p, -3);
/* 1184 */       setX6(p, -4);
/* 1185 */       setX6(p, -5);
/* 1186 */       setX6(p, -6);
/* 1187 */       setX6(p, -7);
/* 1188 */       setX6(p, -8);
/* 1189 */       setX6(p, -9);
/* 1190 */       setX6(p, -10);
/* 1191 */       setX6(p, -11);
/* 1192 */       setX6(p, -12);
/* 1193 */       setX6(p, -13);
/* 1194 */       setX7(p, -1);
/* 1195 */       setX7(p, -2);
/* 1196 */       setX7(p, -3);
/* 1197 */       setX7(p, -4);
/* 1198 */       setX7(p, -5);
/* 1199 */       setX7(p, -6);
/* 1200 */       setX7(p, -7);
/* 1201 */       setX7(p, -8);
/* 1202 */       setX7(p, -9);
/* 1203 */       setX7(p, -10);
/* 1204 */       setX7(p, -11);
/* 1205 */       setX7(p, -12);
/* 1206 */       setX7(p, -13);
/* 1207 */       setBX1(p, -1);
/* 1208 */       setBX1(p, -2);
/* 1209 */       setBX1(p, -3);
/* 1210 */       setBX1(p, -4);
/* 1211 */       setBX1(p, -5);
/* 1212 */       setBX1(p, -6);
/* 1213 */       setBX1(p, -7);
/* 1214 */       setBX1(p, -8);
/* 1215 */       setBX2(p, -1);
/* 1216 */       setBX2(p, -2);
/* 1217 */       setBX2(p, -3);
/* 1218 */       setBX2(p, -4);
/* 1219 */       setBX2(p, -5);
/* 1220 */       setBX2(p, -6);
/* 1221 */       setBX2(p, -7);
/* 1222 */       setBX2(p, -8);
/* 1223 */       setBX2(p, -9);
/* 1224 */       setBX3(p, -1);
/* 1225 */       setBX3(p, -2);
/* 1226 */       setBX3(p, -3);
/* 1227 */       setBX3(p, -4);
/* 1228 */       setBX3(p, -5);
/* 1229 */       setBX3(p, -6);
/* 1230 */       setBX3(p, -7);
/* 1231 */       setBX3(p, -8);
/* 1232 */       setBX3(p, -9);
/* 1233 */       setBX3(p, -10);
/*      */ 
/* 1235 */       setBX4(p, -1);
/* 1236 */       setBX4(p, -2);
/* 1237 */       setBX4(p, -3);
/* 1238 */       setBX4(p, -4);
/* 1239 */       setBX4(p, -5);
/* 1240 */       setBX4(p, -6);
/* 1241 */       setBX4(p, -7);
/* 1242 */       setBX4(p, -8);
/* 1243 */       setBX4(p, -9);
/* 1244 */       setBX4(p, -10);
/* 1245 */       setBX4(p, -11);
/*      */ 
/* 1247 */       setBX5(p, -1);
/* 1248 */       setBX5(p, -2);
/* 1249 */       setBX5(p, -3);
/* 1250 */       setBX5(p, -4);
/* 1251 */       setBX5(p, -5);
/* 1252 */       setBX5(p, -6);
/* 1253 */       setBX5(p, -7);
/* 1254 */       setBX5(p, -8);
/* 1255 */       setBX5(p, -9);
/* 1256 */       setBX5(p, -10);
/* 1257 */       setBX5(p, -11);
/* 1258 */       setBX5(p, -12);
/*      */ 
/* 1260 */       setBX6(p, -1);
/* 1261 */       setBX6(p, -2);
/* 1262 */       setBX6(p, -3);
/* 1263 */       setBX6(p, -4);
/* 1264 */       setBX6(p, -5);
/* 1265 */       setBX6(p, -6);
/* 1266 */       setBX6(p, -7);
/* 1267 */       setBX6(p, -8);
/* 1268 */       setBX6(p, -9);
/* 1269 */       setBX6(p, -10);
/* 1270 */       setBX6(p, -11);
/* 1271 */       setBX6(p, -12);
/* 1272 */       setBX6(p, -13);
/*      */ 
/* 1274 */       setBX7(p, -1);
/* 1275 */       setBX7(p, -2);
/* 1276 */       setBX7(p, -3);
/* 1277 */       setBX7(p, -4);
/* 1278 */       setBX7(p, -5);
/* 1279 */       setBX7(p, -6);
/* 1280 */       setBX7(p, -7);
/* 1281 */       setBX7(p, -8);
/* 1282 */       setBX7(p, -9);
/* 1283 */       setBX7(p, -10);
/* 1284 */       setBX7(p, -11);
/* 1285 */       setBX7(p, -12);
/* 1286 */       setBX7(p, -13);
/* 1287 */       setBX7(p, -14);
/*      */ 
/* 1289 */       setWall1(p, 1);
/* 1290 */       setWall1(p, 2);
/* 1291 */       setWall1(p, 3);
/* 1292 */       setWall1(p, 4);
/* 1293 */       setWall1(p, 4);
/* 1294 */       setWall2(p, 1);
/* 1295 */       setWall2(p, 2);
/* 1296 */       setWall2(p, 3);
/* 1297 */       setWall2(p, 4);
/* 1298 */       setWall2(p, 4);
/* 1299 */       setWall3(p, 1);
/* 1300 */       setWall3(p, 2);
/* 1301 */       setWall3(p, 3);
/* 1302 */       setWall3(p, 4);
/* 1303 */       setWall3(p, 4);
/* 1304 */       setWall4(p, 1);
/* 1305 */       setWall4(p, 2);
/* 1306 */       setWall4(p, 3);
/* 1307 */       setWall4(p, 4);
/* 1308 */       setWall4(p, 4);
/*      */ 
/* 1310 */       set1(p, 1);
/* 1311 */       set1(p, 2);
/* 1312 */       set1(p, 3);
/* 1313 */       set1(p, 4);
/* 1314 */       set1(p, 4);
/* 1315 */       set2(p, 1);
/* 1316 */       set2(p, 2);
/* 1317 */       set2(p, 3);
/* 1318 */       set2(p, 4);
/* 1319 */       set2(p, 4);
/* 1320 */       set3(p, 1);
/* 1321 */       set3(p, 2);
/* 1322 */       set3(p, 3);
/* 1323 */       set3(p, 4);
/* 1324 */       set3(p, 4);
/* 1325 */       set4(p, 1);
/* 1326 */       set4(p, 2);
/* 1327 */       set4(p, 3);
/* 1328 */       set4(p, 4);
/* 1329 */       set4(p, 4);
/* 1330 */       seta1(p, 1);
/* 1331 */       seta1(p, 2);
/* 1332 */       seta1(p, 3);
/* 1333 */       seta1(p, 4);
/* 1334 */       seta1(p, 4);
/* 1335 */       seta2(p, 1);
/* 1336 */       seta2(p, 2);
/* 1337 */       seta2(p, 3);
/* 1338 */       seta2(p, 4);
/* 1339 */       seta2(p, 4);
/* 1340 */       seta3(p, 1);
/* 1341 */       seta3(p, 2);
/* 1342 */       seta3(p, 3);
/* 1343 */       seta3(p, 4);
/* 1344 */       seta3(p, 4);
/* 1345 */       seta4(p, 1);
/* 1346 */       seta4(p, 2);
/* 1347 */       seta4(p, 3);
/* 1348 */       seta4(p, 4);
/* 1349 */       seta4(p, 4);
/* 1350 */       setaa4(p, 1);
/* 1351 */       setaa4(p, 2);
/* 1352 */       setaa4(p, 3);
/* 1353 */       setaa4(p, 4);
/* 1354 */       setaa4(p, 4);
/* 1355 */       setaaa4(p, 1);
/* 1356 */       setaaa4(p, 2);
/* 1357 */       setaaa4(p, 3);
/* 1358 */       setaaa4(p, 4);
/* 1359 */       setaaa4(p, 4);
/* 1360 */       setaaaa4(p, 1);
/* 1361 */       setaaaa4(p, 2);
/* 1362 */       setaaaa4(p, 3);
/* 1363 */       setaaaa4(p, 4);
/* 1364 */       setaaaa4(p, 4);
/* 1365 */       seta5(p, 1);
/* 1366 */       seta5(p, 2);
/* 1367 */       seta5(p, 3);
/* 1368 */       seta5(p, 4);
/* 1369 */       seta5(p, 4);
/* 1370 */       setaa5(p, 1);
/* 1371 */       setaa5(p, 2);
/* 1372 */       setaa5(p, 3);
/* 1373 */       setaa5(p, 4);
/* 1374 */       setaa5(p, 4);
/* 1375 */       setaaa5(p, 1);
/* 1376 */       setaaa5(p, 2);
/* 1377 */       setaaa5(p, 3);
/* 1378 */       setaaa5(p, 4);
/* 1379 */       setaaa5(p, 4);
/* 1380 */       setaaaa5(p, 1);
/* 1381 */       setaaaa5(p, 2);
/* 1382 */       setaaaa5(p, 3);
/* 1383 */       setaaaa5(p, 4);
/* 1384 */       setaaaa5(p, 4);
/* 1385 */       setaa6(p, 1);
/* 1386 */       setaa6(p, 2);
/* 1387 */       setaa6(p, 3);
/* 1388 */       setaa6(p, 4);
/* 1389 */       setaa6(p, 4);
/* 1390 */       setaaa6(p, 1);
/* 1391 */       setaaa6(p, 2);
/* 1392 */       setaaa6(p, 3);
/* 1393 */       setaaa6(p, 4);
/* 1394 */       setaaa6(p, 4);
/* 1395 */       setaaaa6(p, 1);
/* 1396 */       setaaaa6(p, 2);
/* 1397 */       setaaaa6(p, 3);
/* 1398 */       setaaaa6(p, 4);
/* 1399 */       setaaaa6(p, 4);
/*      */ 
/* 1401 */       setb1(p, 1);
/* 1402 */       setb1(p, 2);
/* 1403 */       setb1(p, 3);
/* 1404 */       setb1(p, 4); setb1(p, 4);
/* 1405 */       setbb1(p, 1);
/* 1406 */       setbb1(p, 2);
/* 1407 */       setbb1(p, 3);
/* 1408 */       setbb1(p, 4); setbb1(p, 4);
/* 1409 */       setbb1(p, 1);
/* 1410 */       setbbb1(p, 1);
/* 1411 */       setbbb1(p, 2);
/* 1412 */       setbbb1(p, 3);
/* 1413 */       setbbb1(p, 4); setbbb1(p, 4);
/* 1414 */       setbbbb1(p, 1);
/* 1415 */       setbbbb1(p, 2);
/* 1416 */       setbbbb1(p, 3);
/* 1417 */       setbbbb1(p, 4); setbbbb1(p, 4);
/* 1418 */       setb2(p, 1);
/* 1419 */       setb2(p, 2);
/* 1420 */       setb2(p, 3);
/* 1421 */       setb2(p, 4); setb2(p, 4);
/* 1422 */       setbb2(p, 1);
/* 1423 */       setbb2(p, 2);
/* 1424 */       setbb2(p, 3);
/* 1425 */       setbb2(p, 4); setbb2(p, 4);
/* 1426 */       setbbb2(p, 1);
/* 1427 */       setbbb2(p, 2);
/* 1428 */       setbbb2(p, 3);
/* 1429 */       setbbb2(p, 4); setbbb2(p, 4);
/* 1430 */       setbbbb2(p, 1);
/* 1431 */       setbbbb2(p, 2);
/* 1432 */       setbbbb2(p, 3);
/* 1433 */       setbbbb2(p, 4); setbbbb2(p, 4);
/* 1434 */       setb3(p, 1);
/* 1435 */       setb3(p, 2);
/* 1436 */       setb3(p, 3);
/* 1437 */       setb3(p, 4);
/* 1438 */       setbb3(p, 1);
/* 1439 */       setbb3(p, 2);
/* 1440 */       setbb3(p, 3);
/* 1441 */       setbb3(p, 4);
/* 1442 */       setbbb3(p, 1);
/* 1443 */       setbbb3(p, 2);
/* 1444 */       setbbb3(p, 3);
/* 1445 */       setbbb3(p, 4);
/*      */ 
/* 1447 */       setaa2(p, 1);
/* 1448 */       setaa2(p, 2);
/* 1449 */       setaa2(p, 3);
/* 1450 */       setaa2(p, 4);
/* 1451 */       setaaa2(p, 1);
/* 1452 */       setaaa2(p, 2);
/* 1453 */       setaaa2(p, 3);
/* 1454 */       setaaa2(p, 4);
/* 1455 */       setaaaa2(p, 1);
/* 1456 */       setaaaa2(p, 2);
/* 1457 */       setaaaa2(p, 3);
/* 1458 */       setaaaa2(p, 4);
/* 1459 */       setab2(p, 1);
/* 1460 */       setab2(p, 2);
/* 1461 */       setab2(p, 3);
/* 1462 */       setab2(p, 4);
/* 1463 */       setabb2(p, 1);
/* 1464 */       setabb2(p, 2);
/* 1465 */       setabb2(p, 3);
/* 1466 */       setabb2(p, 4);
/* 1467 */       setabbb2(p, 1);
/* 1468 */       setabbb2(p, 2);
/* 1469 */       setabbb2(p, 3);
/* 1470 */       setabbb2(p, 4);
/* 1471 */       setac2(p, 1);
/* 1472 */       setac2(p, 2);
/* 1473 */       setac2(p, 3);
/* 1474 */       setac2(p, 4);
/* 1475 */       setacc2(p, 1);
/* 1476 */       setacc2(p, 2);
/* 1477 */       setacc2(p, 3);
/* 1478 */       setacc2(p, 4);
/* 1479 */       setaccc2(p, 1);
/* 1480 */       setaccc2(p, 2);
/* 1481 */       setaccc2(p, 3);
/* 1482 */       setaccc2(p, 4);
/* 1483 */       setac3(p, 1);
/* 1484 */       setac3(p, 2);
/* 1485 */       setac3(p, 3);
/* 1486 */       setac3(p, 4);
/* 1487 */       setacc3(p, 1);
/* 1488 */       setacc3(p, 2);
/* 1489 */       setacc3(p, 3);
/* 1490 */       setacc3(p, 4);
/*      */ 
/* 1492 */       setc2(p, 1);
/* 1493 */       setc2(p, 2);
/* 1494 */       setc2(p, 3);
/* 1495 */       setc2(p, 4);
/* 1496 */       setc3(p, 1);
/* 1497 */       setc3(p, 2);
/* 1498 */       setc3(p, 3);
/* 1499 */       setc3(p, 4);
/* 1500 */       setc4(p, 1);
/* 1501 */       setc4(p, 2);
/* 1502 */       setc4(p, 3);
/* 1503 */       setc4(p, 4);
/* 1504 */       setc5(p, 1);
/* 1505 */       setc5(p, 2);
/* 1506 */       setc5(p, 3);
/* 1507 */       setc5(p, 4);
/* 1508 */       setc6(p, 1);
/* 1509 */       setc6(p, 2);
/* 1510 */       setc6(p, 3);
/* 1511 */       setc6(p, 4);
/* 1512 */       setc7(p, 1);
/* 1513 */       setc7(p, 2);
/* 1514 */       setc7(p, 3);
/* 1515 */       setc7(p, 4);
/*      */ 
/* 1517 */       setc8(p, 1);
/* 1518 */       setc8(p, 2);
/* 1519 */       setc8(p, 3);
/* 1520 */       setc8(p, 4);
/* 1521 */       setc9(p, 1);
/* 1522 */       setc9(p, 2);
/* 1523 */       setc9(p, 3);
/* 1524 */       setc9(p, 4);
/* 1525 */       setc10(p, 1);
/* 1526 */       setc10(p, 2);
/* 1527 */       setc10(p, 3);
/* 1528 */       setc10(p, 4);
/* 1529 */       setc11(p, 1);
/* 1530 */       setc11(p, 2);
/* 1531 */       setc11(p, 3);
/* 1532 */       setc11(p, 4);
/* 1533 */       setc12(p, 1);
/* 1534 */       setc12(p, 2);
/* 1535 */       setc12(p, 3);
/* 1536 */       setc12(p, 4);
/* 1537 */       setc13(p, 1);
/* 1538 */       setc13(p, 2);
/* 1539 */       setc13(p, 3);
/* 1540 */       setc13(p, 4);
/*      */ 
/* 1542 */       setBlock(p, 1, 1);
/* 1543 */       setBlock(p, 1, -1);
/* 1544 */       setBlock(p, -1, 1);
/* 1545 */       setBlock(p, -1, -1);
/* 1546 */       setZ(p, 1);
/* 1547 */       setZ(p, -1);
/* 1548 */       setX(p, 1);
/* 1549 */       setX(p, -1);
/*      */ 
/* 1551 */       setBlock(p, 2, 2);
/* 1552 */       setBlock(p, 2, -2);
/* 1553 */       setBlock(p, -2, 2);
/* 1554 */       setBlock(p, -2, -2);
/* 1555 */       setZ(p, 2);
/* 1556 */       setZ(p, -2);
/* 1557 */       setX(p, 2);
/* 1558 */       setX(p, -2);
/*      */ 
/* 1560 */       setBlock(p, 3, 3);
/* 1561 */       setBlock(p, 3, -3);
/* 1562 */       setBlock(p, -3, 3);
/* 1563 */       setBlock(p, -3, -3);
/* 1564 */       setZ(p, 3);
/* 1565 */       setZ(p, -3);
/* 1566 */       setX(p, 3);
/* 1567 */       setX(p, -3);
/*      */ 
/* 1569 */       setBlock(p, 4, 4);
/* 1570 */       setBlock(p, 4, -4);
/* 1571 */       setBlock(p, -4, 4);
/* 1572 */       setBlock(p, -4, -4);
/* 1573 */       setZ(p, 4);
/* 1574 */       setZ(p, -4);
/* 1575 */       setX(p, 4);
/* 1576 */       setX(p, -4);
/*      */ 
/* 1578 */       setBlock(p, 5, 5);
/* 1579 */       setBlock(p, 5, -5);
/* 1580 */       setBlock(p, -5, 5);
/* 1581 */       setBlock(p, -5, -5);
/* 1582 */       setZ(p, 5);
/* 1583 */       setZ(p, -5);
/* 1584 */       setX(p, 5);
/* 1585 */       setX(p, -5);
/*      */ 
/* 1587 */       setBlock(p, 6, 6);
/* 1588 */       setBlock(p, 6, -6);
/* 1589 */       setBlock(p, -6, 6);
/* 1590 */       setBlock(p, -6, -6);
/* 1591 */       setZ(p, 6);
/* 1592 */       setZ(p, -6);
/* 1593 */       setX(p, 6);
/* 1594 */       setX(p, -6);
/*      */ 
/* 1596 */       setBlock(p, 7, 7);
/* 1597 */       setBlock(p, 7, -7);
/* 1598 */       setBlock(p, -7, 7);
/* 1599 */       setBlock(p, -7, -7);
/* 1600 */       setZ(p, 7);
/* 1601 */       setZ(p, -7);
/* 1602 */       setX(p, 7);
/* 1603 */       setX(p, -7);
/*      */ 
/* 1605 */       asetBZ1(p, 1);
/* 1606 */       asetBZ2(p, 1);
/* 1607 */       asetBZ3(p, 1);
/* 1608 */       asetBZ1(p, -1);
/* 1609 */       asetBZ2(p, -1);
/* 1610 */       asetBZ3(p, -1);
/* 1611 */       asetZ1(p, 1);
/* 1612 */       asetZ2(p, 1);
/* 1613 */       asetZ3(p, 1);
/* 1614 */       asetZ1(p, -1);
/* 1615 */       asetZ2(p, -1);
/* 1616 */       asetZ3(p, -1);
/*      */ 
/* 1618 */       asetBZ1(p, 2);
/* 1619 */       asetBZ2(p, 2);
/* 1620 */       asetBZ3(p, 2);
/* 1621 */       asetBZ1(p, -2);
/* 1622 */       asetBZ2(p, -2);
/* 1623 */       asetBZ3(p, -2);
/* 1624 */       asetZ1(p, 2);
/* 1625 */       asetZ2(p, 2);
/* 1626 */       asetZ3(p, 2);
/* 1627 */       asetZ1(p, -2);
/* 1628 */       asetZ2(p, -2);
/* 1629 */       asetZ3(p, -2);
/*      */ 
/* 1631 */       asetBZ1(p, 3);
/* 1632 */       asetBZ2(p, 3);
/* 1633 */       asetBZ3(p, 3);
/* 1634 */       asetBZ1(p, -3);
/* 1635 */       asetBZ2(p, -3);
/* 1636 */       asetBZ3(p, -3);
/* 1637 */       asetZ1(p, 3);
/* 1638 */       asetZ2(p, 3);
/* 1639 */       asetZ3(p, 3);
/* 1640 */       asetZ1(p, -3);
/* 1641 */       asetZ2(p, -3);
/* 1642 */       asetZ3(p, -3);
/*      */ 
/* 1644 */       asetBZ1(p, 4);
/* 1645 */       asetBZ2(p, 4);
/* 1646 */       asetBZ3(p, 4);
/* 1647 */       asetBZ1(p, -4);
/* 1648 */       asetBZ2(p, -4);
/* 1649 */       asetBZ3(p, -4);
/* 1650 */       asetBZ3(p, -5);
/* 1651 */       asetBZ3(p, -6);
/* 1652 */       asetBZ3(p, -7);
/* 1653 */       asetBZ3(p, -8);
/* 1654 */       asetBZ3(p, -9);
/* 1655 */       asetBZ3(p, -10);
/* 1656 */       asetZ1(p, 4);
/* 1657 */       asetZ2(p, 4);
/* 1658 */       asetZ3(p, 4);
/* 1659 */       asetZ1(p, -4);
/* 1660 */       asetZ2(p, -4);
/* 1661 */       asetZ3(p, -4);
/*      */ 
/* 1663 */       asetBZ1(p, 5);
/* 1664 */       asetBZ2(p, 5);
/* 1665 */       asetBZ1(p, -5);
/* 1666 */       asetBZ2(p, -5);
/* 1667 */       asetBZ2(p, -6);
/* 1668 */       asetBZ2(p, -7);
/* 1669 */       asetBZ2(p, -8);
/* 1670 */       asetBZ2(p, -9);
/* 1671 */       asetZ1(p, 5);
/* 1672 */       asetZ2(p, 5);
/* 1673 */       asetZ1(p, -5);
/* 1674 */       asetZ2(p, -5);
/* 1675 */       asetZ3(p, -5);
/*      */ 
/* 1677 */       asetZ1(p, 6);
/* 1678 */       asetZ1(p, -6);
/* 1679 */       asetBZ1(p, 6);
/* 1680 */       asetBZ1(p, -7);
/* 1681 */       asetBZ1(p, -6);
/* 1682 */       asetBZ1(p, -8);
/* 1683 */       asetZ2(p, -6);
/* 1684 */       asetZ3(p, -6);
/*      */ 
/* 1686 */       asetZ1(p, -7);
/* 1687 */       asetZ1(p, -8);
/* 1688 */       asetZ2(p, -7);
/* 1689 */       asetZ2(p, -8);
/* 1690 */       asetZ2(p, -9);
/* 1691 */       asetZ3(p, -7);
/* 1692 */       asetZ3(p, -8);
/* 1693 */       asetZ3(p, -9);
/* 1694 */       asetZ3(p, -10);
/*      */ 
/* 1696 */       asetZ4(p, 1);
/* 1697 */       asetZ4(p, 2);
/* 1698 */       asetZ4(p, 3);
/* 1699 */       asetZ4(p, -1);
/* 1700 */       asetZ4(p, -2);
/* 1701 */       asetZ4(p, -3);
/* 1702 */       asetZ4(p, -4);
/* 1703 */       asetZ4(p, -5);
/* 1704 */       asetZ4(p, -6);
/* 1705 */       asetZ4(p, -7);
/* 1706 */       asetZ4(p, -8);
/* 1707 */       asetZ4(p, -9);
/* 1708 */       asetZ4(p, -10);
/* 1709 */       asetZ4(p, -11);
/* 1710 */       asetZ5(p, 1);
/* 1711 */       asetZ5(p, 2);
/* 1712 */       asetZ5(p, -1);
/* 1713 */       asetZ5(p, -2);
/* 1714 */       asetZ5(p, -3);
/* 1715 */       asetZ5(p, -4);
/* 1716 */       asetZ5(p, -5);
/* 1717 */       asetZ5(p, -6);
/* 1718 */       asetZ5(p, -7);
/* 1719 */       asetZ5(p, -8);
/* 1720 */       asetZ5(p, -9);
/* 1721 */       asetZ5(p, -10);
/* 1722 */       asetZ5(p, -11);
/* 1723 */       asetZ5(p, -12);
/* 1724 */       asetZ6(p, -1);
/* 1725 */       asetZ6(p, -2);
/* 1726 */       asetZ6(p, -3);
/* 1727 */       asetZ6(p, -4);
/* 1728 */       asetZ6(p, -5);
/* 1729 */       asetZ6(p, -6);
/* 1730 */       asetZ6(p, -7);
/* 1731 */       asetZ6(p, -8);
/* 1732 */       asetZ6(p, -9);
/* 1733 */       asetZ6(p, -10);
/* 1734 */       asetZ6(p, -11);
/* 1735 */       asetZ6(p, -12);
/* 1736 */       asetZ6(p, -13);
/* 1737 */       asetZ5(p, -1);
/* 1738 */       asetZ5(p, -2);
/* 1739 */       asetZ5(p, -3);
/* 1740 */       asetZ5(p, -4);
/* 1741 */       asetZ5(p, -5);
/* 1742 */       asetZ5(p, -6);
/* 1743 */       asetZ5(p, -7);
/* 1744 */       asetZ5(p, -8);
/* 1745 */       asetZ5(p, -9);
/* 1746 */       asetZ5(p, -10);
/* 1747 */       asetZ5(p, -11);
/* 1748 */       asetZ5(p, -12);
/* 1749 */       asetZ7(p, -1);
/* 1750 */       asetZ7(p, -2);
/* 1751 */       asetZ7(p, -3);
/* 1752 */       asetZ7(p, -4);
/* 1753 */       asetZ7(p, -5);
/* 1754 */       asetZ7(p, -6);
/* 1755 */       asetZ7(p, -7);
/* 1756 */       asetZ7(p, -8);
/* 1757 */       asetZ7(p, -9);
/* 1758 */       asetZ7(p, -10);
/* 1759 */       asetZ7(p, -11);
/* 1760 */       asetZ7(p, -12);
/* 1761 */       asetZ7(p, -13);
/* 1762 */       asetZ7(p, -14);
/*      */ 
/* 1764 */       asetX1(p, -1);
/* 1765 */       asetX1(p, -2);
/* 1766 */       asetX1(p, -3);
/* 1767 */       asetX1(p, -4);
/* 1768 */       asetX1(p, -5);
/* 1769 */       asetX1(p, -6);
/* 1770 */       asetX1(p, -7);
/* 1771 */       asetX1(p, -8);
/* 1772 */       asetX2(p, -1);
/* 1773 */       asetX2(p, -2);
/* 1774 */       asetX2(p, -3);
/* 1775 */       asetX2(p, -4);
/* 1776 */       asetX2(p, -5);
/* 1777 */       asetX2(p, -6);
/* 1778 */       asetX2(p, -7);
/* 1779 */       asetX2(p, -8);
/* 1780 */       asetX2(p, -9);
/* 1781 */       asetX3(p, -1);
/* 1782 */       asetX3(p, -2);
/* 1783 */       asetX3(p, -3);
/* 1784 */       asetX3(p, -4);
/* 1785 */       asetX3(p, -5);
/* 1786 */       asetX3(p, -6);
/* 1787 */       asetX3(p, -7);
/* 1788 */       asetX3(p, -8);
/* 1789 */       asetX3(p, -9);
/* 1790 */       asetX3(p, -10);
/* 1791 */       asetX4(p, -1);
/* 1792 */       asetX4(p, -2);
/* 1793 */       asetX4(p, -3);
/* 1794 */       asetX4(p, -4);
/* 1795 */       asetX4(p, -5);
/* 1796 */       asetX4(p, -6);
/* 1797 */       asetX4(p, -7);
/* 1798 */       asetX4(p, -8);
/* 1799 */       asetX4(p, -9);
/* 1800 */       asetX4(p, -10);
/* 1801 */       asetX4(p, -11);
/* 1802 */       asetX5(p, -1);
/* 1803 */       asetX5(p, -2);
/* 1804 */       asetX5(p, -3);
/* 1805 */       asetX5(p, -4);
/* 1806 */       asetX5(p, -5);
/* 1807 */       asetX5(p, -6);
/* 1808 */       asetX5(p, -7);
/* 1809 */       asetX5(p, -8);
/* 1810 */       asetX5(p, -9);
/* 1811 */       asetX5(p, -10);
/* 1812 */       asetX5(p, -11);
/* 1813 */       asetX5(p, -12);
/* 1814 */       asetX6(p, -1);
/* 1815 */       asetX6(p, -2);
/* 1816 */       asetX6(p, -3);
/* 1817 */       asetX6(p, -4);
/* 1818 */       asetX6(p, -5);
/* 1819 */       asetX6(p, -6);
/* 1820 */       asetX6(p, -7);
/* 1821 */       asetX6(p, -8);
/* 1822 */       asetX6(p, -9);
/* 1823 */       asetX6(p, -10);
/* 1824 */       asetX6(p, -11);
/* 1825 */       asetX6(p, -12);
/* 1826 */       asetX6(p, -13);
/* 1827 */       asetX7(p, -1);
/* 1828 */       asetX7(p, -2);
/* 1829 */       asetX7(p, -3);
/* 1830 */       asetX7(p, -4);
/* 1831 */       asetX7(p, -5);
/* 1832 */       asetX7(p, -6);
/* 1833 */       asetX7(p, -7);
/* 1834 */       asetX7(p, -8);
/* 1835 */       asetX7(p, -9);
/* 1836 */       asetX7(p, -10);
/* 1837 */       asetX7(p, -11);
/* 1838 */       asetX7(p, -12);
/* 1839 */       asetX7(p, -13);
/* 1840 */       asetBX1(p, -1);
/* 1841 */       asetBX1(p, -2);
/* 1842 */       asetBX1(p, -3);
/* 1843 */       asetBX1(p, -4);
/* 1844 */       asetBX1(p, -5);
/* 1845 */       asetBX1(p, -6);
/* 1846 */       asetBX1(p, -7);
/* 1847 */       asetBX1(p, -8);
/* 1848 */       asetBX2(p, -1);
/* 1849 */       asetBX2(p, -2);
/* 1850 */       asetBX2(p, -3);
/* 1851 */       asetBX2(p, -4);
/* 1852 */       asetBX2(p, -5);
/* 1853 */       asetBX2(p, -6);
/* 1854 */       asetBX2(p, -7);
/* 1855 */       asetBX2(p, -8);
/* 1856 */       asetBX2(p, -9);
/* 1857 */       asetBX3(p, -1);
/* 1858 */       asetBX3(p, -2);
/* 1859 */       asetBX3(p, -3);
/* 1860 */       asetBX3(p, -4);
/* 1861 */       asetBX3(p, -5);
/* 1862 */       asetBX3(p, -6);
/* 1863 */       asetBX3(p, -7);
/* 1864 */       asetBX3(p, -8);
/* 1865 */       asetBX3(p, -9);
/* 1866 */       asetBX3(p, -10);
/*      */ 
/* 1868 */       asetBX4(p, -1);
/* 1869 */       asetBX4(p, -2);
/* 1870 */       asetBX4(p, -3);
/* 1871 */       asetBX4(p, -4);
/* 1872 */       asetBX4(p, -5);
/* 1873 */       asetBX4(p, -6);
/* 1874 */       asetBX4(p, -7);
/* 1875 */       asetBX4(p, -8);
/* 1876 */       asetBX4(p, -9);
/* 1877 */       asetBX4(p, -10);
/* 1878 */       asetBX4(p, -11);
/*      */ 
/* 1880 */       asetBX5(p, -1);
/* 1881 */       asetBX5(p, -2);
/* 1882 */       asetBX5(p, -3);
/* 1883 */       asetBX5(p, -4);
/* 1884 */       asetBX5(p, -5);
/* 1885 */       asetBX5(p, -6);
/* 1886 */       asetBX5(p, -7);
/* 1887 */       asetBX5(p, -8);
/* 1888 */       asetBX5(p, -9);
/* 1889 */       asetBX5(p, -10);
/* 1890 */       asetBX5(p, -11);
/* 1891 */       asetBX5(p, -12);
/*      */ 
/* 1893 */       asetBX6(p, -1);
/* 1894 */       asetBX6(p, -2);
/* 1895 */       asetBX6(p, -3);
/* 1896 */       asetBX6(p, -4);
/* 1897 */       asetBX6(p, -5);
/* 1898 */       asetBX6(p, -6);
/* 1899 */       asetBX6(p, -7);
/* 1900 */       asetBX6(p, -8);
/* 1901 */       asetBX6(p, -9);
/* 1902 */       asetBX6(p, -10);
/* 1903 */       asetBX6(p, -11);
/* 1904 */       asetBX6(p, -12);
/* 1905 */       asetBX6(p, -13);
/*      */ 
/* 1907 */       asetBX7(p, -1);
/* 1908 */       asetBX7(p, -2);
/* 1909 */       asetBX7(p, -3);
/* 1910 */       asetBX7(p, -4);
/* 1911 */       asetBX7(p, -5);
/* 1912 */       asetBX7(p, -6);
/* 1913 */       asetBX7(p, -7);
/* 1914 */       asetBX7(p, -8);
/* 1915 */       asetBX7(p, -9);
/* 1916 */       asetBX7(p, -10);
/* 1917 */       asetBX7(p, -11);
/* 1918 */       asetBX7(p, -12);
/* 1919 */       asetBX7(p, -13);
/* 1920 */       asetBX7(p, -14);
/* 1921 */       asetBlock(p, 1, 1);
/* 1922 */       asetBlock(p, 1, -1);
/* 1923 */       asetBlock(p, -1, 1);
/* 1924 */       asetBlock(p, -1, -1);
/* 1925 */       asetZ(p, 1);
/* 1926 */       asetZ(p, -1);
/* 1927 */       asetX(p, 1);
/* 1928 */       asetX(p, -1);
/*      */ 
/* 1930 */       asetBlock(p, 2, 2);
/* 1931 */       asetBlock(p, 2, -2);
/* 1932 */       asetBlock(p, -2, 2);
/* 1933 */       asetBlock(p, -2, -2);
/* 1934 */       asetZ(p, 2);
/* 1935 */       asetZ(p, -2);
/* 1936 */       asetX(p, 2);
/* 1937 */       asetX(p, -2);
/*      */ 
/* 1939 */       asetBlock(p, 3, 3);
/* 1940 */       asetBlock(p, 3, -3);
/* 1941 */       asetBlock(p, -3, 3);
/* 1942 */       asetBlock(p, -3, -3);
/* 1943 */       asetZ(p, 3);
/* 1944 */       asetZ(p, -3);
/* 1945 */       asetX(p, 3);
/* 1946 */       asetX(p, -3);
/*      */ 
/* 1948 */       asetBlock(p, 4, 4);
/* 1949 */       asetBlock(p, 4, -4);
/* 1950 */       asetBlock(p, -4, 4);
/* 1951 */       asetBlock(p, -4, -4);
/* 1952 */       asetZ(p, 4);
/* 1953 */       asetZ(p, -4);
/* 1954 */       asetX(p, 4);
/* 1955 */       asetX(p, -4);
/*      */ 
/* 1957 */       asetBlock(p, 5, 5);
/* 1958 */       asetBlock(p, 5, -5);
/* 1959 */       asetBlock(p, -5, 5);
/* 1960 */       asetBlock(p, -5, -5);
/* 1961 */       asetZ(p, 5);
/* 1962 */       asetZ(p, -5);
/* 1963 */       asetX(p, 5);
/* 1964 */       asetX(p, -5);
/*      */ 
/* 1966 */       asetBlock(p, 6, 6);
/* 1967 */       asetBlock(p, 6, -6);
/* 1968 */       asetBlock(p, -6, 6);
/* 1969 */       asetBlock(p, -6, -6);
/* 1970 */       asetZ(p, 6);
/* 1971 */       asetZ(p, -6);
/* 1972 */       asetX(p, 6);
/* 1973 */       asetX(p, -6);
/*      */ 
/* 1975 */       asetBlock(p, 7, 7);
/* 1976 */       asetBlock(p, 7, -7);
/* 1977 */       asetBlock(p, -7, 7);
/* 1978 */       asetBlock(p, -7, -7);
/* 1979 */       asetZ(p, 7);
/* 1980 */       asetZ(p, -7);
/* 1981 */       asetX(p, 7);
/* 1982 */       asetX(p, -7);
/* 1983 */       a(p, 1);
/* 1984 */       a(p, 2);
/* 1985 */       a(p, 3);
/* 1986 */       a(p, 4);
/* 1987 */       a(p, 5);
/* 1988 */       a1.getBlock().setType(Material.AIR);
/* 1989 */       b1.getBlock().setType(Material.AIR);
/* 1990 */       c1.getBlock().setType(Material.AIR);
/* 1991 */       d1.getBlock().setType(Material.AIR);
/*      */     }
/*      */   }
/*      */ 
/*      */   @SuppressWarnings("deprecation")
			 public static void SetGladiatorArena2(Player p)
/*      */   {
/* 1998 */     int x = p.getLocation().getBlockX();
/* 1999 */     int y = p.getLocation().getBlockY();
/* 2000 */     int z = p.getLocation().getBlockZ();
/* 2001 */     Location l1 = new Location(p.getWorld(), x, y + 100 + 5, z);
/* 2002 */     Location a1 = new Location(p.getWorld(), x + 7, y + 101 + 5, z);
/* 2003 */     Location b1 = new Location(p.getWorld(), x + 7, y + 102 + 5, z);
/* 2004 */     Location c1 = new Location(p.getWorld(), x + 7, y + 103 + 5, z);
/* 2005 */     Location d1 = new Location(p.getWorld(), x + 7, y + 104 + 5, z);
/* 2006 */     a1.getBlock().setType(Material.AIR);
/* 2007 */     b1.getBlock().setType(Material.AIR);
/* 2008 */     c1.getBlock().setType(Material.AIR);
/* 2009 */     d1.getBlock().setType(Material.AIR);
/* 2010 */     Location l2 = new Location(p.getWorld(), x, y + 105 + 5, z);
/* 2011 */     if (KitHandler.getKit(p.getName()) == KitType.GLADIATOR && 
/* 2012 */       (!com.experiencepvp.kits.listeners.cmds.Gladiator.GladiatorBattle.containsKey(p.getName())) && 
/* 2013 */       (p.getItemInHand().getType() == Material.getMaterial(101))) {
/* 2014 */       l1.getBlock().setType(Material.GLASS);
/* 2015 */       l2.getBlock().setType(Material.GLASS);
/* 2016 */       s(p, 6);
/* 2017 */       s(p, 7);
/* 2018 */       s(p, 8);
/* 2019 */       s(p, 9);
/* 2020 */       s(p, 10);
/* 2021 */       ss(p, 6);
/* 2022 */       ss(p, 7);
/* 2023 */       ss(p, 8);
/* 2024 */       ss(p, 9);
/* 2025 */       ss(p, 10);
/* 2026 */       a(p, 6);
/* 2027 */       a(p, 7);
/* 2028 */       a(p, 8);
/* 2029 */       a(p, 9);
/* 2030 */       a(p, 10);
/* 2031 */       aa(p, 6);
/* 2032 */       aa(p, 7);
/* 2033 */       aa(p, 8);
/* 2034 */       aa(p, 9);
/* 2035 */       aa(p, 10);
/* 2036 */       b(p, 6);
/* 2037 */       b(p, 7);
/* 2038 */       b(p, 8);
/* 2039 */       b(p, 9);
/* 2040 */       b(p, 10);
/* 2041 */       bb(p, 6);
/* 2042 */       bb(p, 7);
/* 2043 */       bb(p, 8);
/* 2044 */       bb(p, 9);
/* 2045 */       bb(p, 10);
/* 2046 */       c(p, 6);
/* 2047 */       c(p, 7);
/* 2048 */       c(p, 8);
/* 2049 */       c(p, 9);
/* 2050 */       c(p, 10);
/* 2051 */       cc(p, 6);
/* 2052 */       cc(p, 7);
/* 2053 */       cc(p, 8);
/* 2054 */       cc(p, 9);
/* 2055 */       cc(p, 10);
/* 2056 */       d(p, 6);
/* 2057 */       d(p, 7);
/* 2058 */       d(p, 8);
/* 2059 */       d(p, 9);
/* 2060 */       d(p, 10);
/* 2061 */       dd(p, 6);
/* 2062 */       dd(p, 7);
/* 2063 */       dd(p, 8);
/* 2064 */       dd(p, 9);
/* 2065 */       dd(p, 10);
/* 2066 */       e(p, 6);
/* 2067 */       e(p, 7);
/* 2068 */       e(p, 8);
/* 2069 */       e(p, 9);
/* 2070 */       e(p, 10);
/* 2071 */       ee(p, 6);
/* 2072 */       ee(p, 7);
/* 2073 */       ee(p, 8);
/* 2074 */       ee(p, 9);
/* 2075 */       ee(p, 10);
/*      */ 
/* 2077 */       setBZ1(p, 6);
/* 2078 */       setBZ2(p, 6);
/* 2079 */       setBZ3(p, 6);
/* 2080 */       setBZ1(p, 4);
/* 2081 */       setBZ2(p, 4);
/* 2082 */       setBZ3(p, 4);
/* 2083 */       setZ1(p, 6);
/* 2084 */       setZ2(p, 6);
/* 2085 */       setZ3(p, 6);
/* 2086 */       setZ1(p, 4);
/* 2087 */       setZ2(p, 4);
/* 2088 */       setZ3(p, 4);
/*      */ 
/* 2090 */       setBZ1(p, 7);
/* 2091 */       setBZ2(p, 7);
/* 2092 */       setBZ3(p, 7);
/* 2093 */       setBZ1(p, 3);
/* 2094 */       setBZ2(p, 3);
/* 2095 */       setBZ3(p, 3);
/* 2096 */       setZ1(p, 7);
/* 2097 */       setZ2(p, 7);
/* 2098 */       setZ3(p, 7);
/* 2099 */       setZ1(p, 3);
/* 2100 */       setZ2(p, 3);
/* 2101 */       setZ3(p, 3);
/*      */ 
/* 2103 */       setBZ1(p, 8);
/* 2104 */       setBZ2(p, 8);
/* 2105 */       setBZ3(p, 8);
/* 2106 */       setBZ1(p, 2);
/* 2107 */       setBZ2(p, 2);
/* 2108 */       setBZ3(p, 2);
/* 2109 */       setZ1(p, 8);
/* 2110 */       setZ2(p, 8);
/* 2111 */       setZ3(p, 8);
/* 2112 */       setZ1(p, 2);
/* 2113 */       setZ2(p, 2);
/* 2114 */       setZ3(p, 2);
/*      */ 
/* 2116 */       setBZ1(p, 9);
/* 2117 */       setBZ2(p, 9);
/* 2118 */       setBZ3(p, 9);
/* 2119 */       setBZ1(p, 1);
/* 2120 */       setBZ2(p, 1);
/* 2121 */       setBZ3(p, 1);
/* 2122 */       setBZ3(p, 0);
/* 2123 */       setBZ3(p, -1);
/* 2124 */       setBZ3(p, -2);
/* 2125 */       setBZ3(p, -3);
/* 2126 */       setBZ3(p, -4);
/* 2127 */       setBZ3(p, -5);
/* 2128 */       setZ1(p, 9);
/* 2129 */       setZ2(p, 9);
/* 2130 */       setZ3(p, 9);
/* 2131 */       setZ1(p, 1);
/* 2132 */       setZ2(p, 1);
/* 2133 */       setZ3(p, 1);
/*      */ 
/* 2135 */       setBZ1(p, 10);
/* 2136 */       setBZ2(p, 10);
/* 2137 */       setBZ1(p, 0);
/* 2138 */       setBZ2(p, 0);
/* 2139 */       setBZ2(p, -1);
/* 2140 */       setBZ2(p, -2);
/* 2141 */       setBZ2(p, -3);
/* 2142 */       setBZ2(p, -4);
/* 2143 */       setZ1(p, 10);
/* 2144 */       setZ2(p, 10);
/* 2145 */       setZ1(p, 0);
/* 2146 */       setZ2(p, 0);
/* 2147 */       setZ3(p, 0);
/*      */ 
/* 2149 */       setZ1(p, 11);
/* 2150 */       setZ1(p, -1);
/* 2151 */       setBZ1(p, 11);
/* 2152 */       setBZ1(p, -2);
/* 2153 */       setBZ1(p, -1);
/* 2154 */       setBZ1(p, -3);
/* 2155 */       setZ2(p, -1);
/* 2156 */       setZ3(p, -1);
/*      */ 
/* 2158 */       setZ1(p, -2);
/* 2159 */       setZ1(p, -3);
/* 2160 */       setZ2(p, -2);
/* 2161 */       setZ2(p, -3);
/* 2162 */       setZ2(p, -4);
/* 2163 */       setZ3(p, -2);
/* 2164 */       setZ3(p, -3);
/* 2165 */       setZ3(p, -4);
/* 2166 */       setZ3(p, -5);
/*      */ 
/* 2168 */       setZ4(p, 6);
/* 2169 */       setZ4(p, 7);
/* 2170 */       setZ4(p, 8);
/* 2171 */       setZ4(p, 4);
/* 2172 */       setZ4(p, 3);
/* 2173 */       setZ4(p, 2);
/* 2174 */       setZ4(p, 1);
/* 2175 */       setZ4(p, 0);
/* 2176 */       setZ4(p, -1);
/* 2177 */       setZ4(p, -2);
/* 2178 */       setZ4(p, -3);
/* 2179 */       setZ4(p, -4);
/* 2180 */       setZ4(p, -5);
/* 2181 */       setZ4(p, -6);
/* 2182 */       setZ5(p, 6);
/* 2183 */       setZ5(p, 7);
/* 2184 */       setZ5(p, 4);
/* 2185 */       setZ5(p, 3);
/* 2186 */       setZ5(p, 2);
/* 2187 */       setZ5(p, 1);
/* 2188 */       setZ5(p, 0);
/* 2189 */       setZ5(p, -1);
/* 2190 */       setZ5(p, -2);
/* 2191 */       setZ5(p, -3);
/* 2192 */       setZ5(p, -4);
/* 2193 */       setZ5(p, -5);
/* 2194 */       setZ5(p, -6);
/* 2195 */       setZ5(p, -7);
/* 2196 */       setZ6(p, 4);
/* 2197 */       setZ6(p, 3);
/* 2198 */       setZ6(p, 2);
/* 2199 */       setZ6(p, 1);
/* 2200 */       setZ6(p, 0);
/* 2201 */       setZ6(p, -1);
/* 2202 */       setZ6(p, -2);
/* 2203 */       setZ6(p, -3);
/* 2204 */       setZ6(p, -4);
/* 2205 */       setZ6(p, -5);
/* 2206 */       setZ6(p, -6);
/* 2207 */       setZ6(p, -7);
/* 2208 */       setZ6(p, -8);
/* 2209 */       setZ5(p, 4);
/* 2210 */       setZ5(p, 3);
/* 2211 */       setZ5(p, 2);
/* 2212 */       setZ5(p, 1);
/* 2213 */       setZ5(p, 0);
/* 2214 */       setZ5(p, -1);
/* 2215 */       setZ5(p, -2);
/* 2216 */       setZ5(p, -3);
/* 2217 */       setZ5(p, -4);
/* 2218 */       setZ5(p, -5);
/* 2219 */       setZ5(p, -6);
/* 2220 */       setZ5(p, -7);
/* 2221 */       setZ7(p, 4);
/* 2222 */       setZ7(p, 3);
/* 2223 */       setZ7(p, 2);
/* 2224 */       setZ7(p, 1);
/* 2225 */       setZ7(p, 0);
/* 2226 */       setZ7(p, -1);
/* 2227 */       setZ7(p, -2);
/* 2228 */       setZ7(p, -3);
/* 2229 */       setZ7(p, -4);
/* 2230 */       setZ7(p, -5);
/* 2231 */       setZ7(p, -6);
/* 2232 */       setZ7(p, -7);
/* 2233 */       setZ7(p, -8);
/* 2234 */       setZ7(p, -9);
/*      */ 
/* 2236 */       setX1(p, 4);
/* 2237 */       setX1(p, 3);
/* 2238 */       setX1(p, 2);
/* 2239 */       setX1(p, 1);
/* 2240 */       setX1(p, 0);
/* 2241 */       setX1(p, -1);
/* 2242 */       setX1(p, -2);
/* 2243 */       setX1(p, -3);
/* 2244 */       setX2(p, 4);
/* 2245 */       setX2(p, 3);
/* 2246 */       setX2(p, 2);
/* 2247 */       setX2(p, 1);
/* 2248 */       setX2(p, 0);
/* 2249 */       setX2(p, -1);
/* 2250 */       setX2(p, -2);
/* 2251 */       setX2(p, -3);
/* 2252 */       setX2(p, -4);
/* 2253 */       setX3(p, 4);
/* 2254 */       setX3(p, 3);
/* 2255 */       setX3(p, 2);
/* 2256 */       setX3(p, 1);
/* 2257 */       setX3(p, 0);
/* 2258 */       setX3(p, -1);
/* 2259 */       setX3(p, -2);
/* 2260 */       setX3(p, -3);
/* 2261 */       setX3(p, -4);
/* 2262 */       setX3(p, -5);
/* 2263 */       setX4(p, 4);
/* 2264 */       setX4(p, 3);
/* 2265 */       setX4(p, 2);
/* 2266 */       setX4(p, 1);
/* 2267 */       setX4(p, 0);
/* 2268 */       setX4(p, -1);
/* 2269 */       setX4(p, -2);
/* 2270 */       setX4(p, -3);
/* 2271 */       setX4(p, -4);
/* 2272 */       setX4(p, -5);
/* 2273 */       setX4(p, -6);
/* 2274 */       setX5(p, 4);
/* 2275 */       setX5(p, 3);
/* 2276 */       setX5(p, 2);
/* 2277 */       setX5(p, 1);
/* 2278 */       setX5(p, 0);
/* 2279 */       setX5(p, -1);
/* 2280 */       setX5(p, -2);
/* 2281 */       setX5(p, -3);
/* 2282 */       setX5(p, -4);
/* 2283 */       setX5(p, -5);
/* 2284 */       setX5(p, -6);
/* 2285 */       setX5(p, -7);
/* 2286 */       setX6(p, 4);
/* 2287 */       setX6(p, 3);
/* 2288 */       setX6(p, 2);
/* 2289 */       setX6(p, 1);
/* 2290 */       setX6(p, 0);
/* 2291 */       setX6(p, -1);
/* 2292 */       setX6(p, -2);
/* 2293 */       setX6(p, -3);
/* 2294 */       setX6(p, -4);
/* 2295 */       setX6(p, -5);
/* 2296 */       setX6(p, -6);
/* 2297 */       setX6(p, -7);
/* 2298 */       setX6(p, -8);
/* 2299 */       setX7(p, 4);
/* 2300 */       setX7(p, 3);
/* 2301 */       setX7(p, 2);
/* 2302 */       setX7(p, 1);
/* 2303 */       setX7(p, 0);
/* 2304 */       setX7(p, -1);
/* 2305 */       setX7(p, -2);
/* 2306 */       setX7(p, -3);
/* 2307 */       setX7(p, -4);
/* 2308 */       setX7(p, -5);
/* 2309 */       setX7(p, -6);
/* 2310 */       setX7(p, -7);
/* 2311 */       setX7(p, -8);
/* 2312 */       setBX1(p, 4);
/* 2313 */       setBX1(p, 3);
/* 2314 */       setBX1(p, 2);
/* 2315 */       setBX1(p, 1);
/* 2316 */       setBX1(p, 0);
/* 2317 */       setBX1(p, -1);
/* 2318 */       setBX1(p, -2);
/* 2319 */       setBX1(p, -3);
/* 2320 */       setBX2(p, 4);
/* 2321 */       setBX2(p, 3);
/* 2322 */       setBX2(p, 2);
/* 2323 */       setBX2(p, 1);
/* 2324 */       setBX2(p, 0);
/* 2325 */       setBX2(p, -1);
/* 2326 */       setBX2(p, -2);
/* 2327 */       setBX2(p, -3);
/* 2328 */       setBX2(p, -4);
/* 2329 */       setBX3(p, 4);
/* 2330 */       setBX3(p, 3);
/* 2331 */       setBX3(p, 2);
/* 2332 */       setBX3(p, 1);
/* 2333 */       setBX3(p, 0);
/* 2334 */       setBX3(p, -1);
/* 2335 */       setBX3(p, -2);
/* 2336 */       setBX3(p, -3);
/* 2337 */       setBX3(p, -4);
/* 2338 */       setBX3(p, -5);
/*      */ 
/* 2340 */       setBX4(p, 4);
/* 2341 */       setBX4(p, 3);
/* 2342 */       setBX4(p, 2);
/* 2343 */       setBX4(p, 1);
/* 2344 */       setBX4(p, 0);
/* 2345 */       setBX4(p, -1);
/* 2346 */       setBX4(p, -2);
/* 2347 */       setBX4(p, -3);
/* 2348 */       setBX4(p, -4);
/* 2349 */       setBX4(p, -5);
/* 2350 */       setBX4(p, -6);
/*      */ 
/* 2352 */       setBX5(p, 4);
/* 2353 */       setBX5(p, 3);
/* 2354 */       setBX5(p, 2);
/* 2355 */       setBX5(p, 1);
/* 2356 */       setBX5(p, 0);
/* 2357 */       setBX5(p, -1);
/* 2358 */       setBX5(p, -2);
/* 2359 */       setBX5(p, -3);
/* 2360 */       setBX5(p, -4);
/* 2361 */       setBX5(p, -5);
/* 2362 */       setBX5(p, -6);
/* 2363 */       setBX5(p, -7);
/*      */ 
/* 2365 */       setBX6(p, 4);
/* 2366 */       setBX6(p, 3);
/* 2367 */       setBX6(p, 2);
/* 2368 */       setBX6(p, 1);
/* 2369 */       setBX6(p, 0);
/* 2370 */       setBX6(p, -1);
/* 2371 */       setBX6(p, -2);
/* 2372 */       setBX6(p, -3);
/* 2373 */       setBX6(p, -4);
/* 2374 */       setBX6(p, -5);
/* 2375 */       setBX6(p, -6);
/* 2376 */       setBX6(p, -7);
/* 2377 */       setBX6(p, -8);
/*      */ 
/* 2379 */       setBX7(p, 4);
/* 2380 */       setBX7(p, 3);
/* 2381 */       setBX7(p, 2);
/* 2382 */       setBX7(p, 1);
/* 2383 */       setBX7(p, 0);
/* 2384 */       setBX7(p, -1);
/* 2385 */       setBX7(p, -2);
/* 2386 */       setBX7(p, -3);
/* 2387 */       setBX7(p, -4);
/* 2388 */       setBX7(p, -5);
/* 2389 */       setBX7(p, -6);
/* 2390 */       setBX7(p, -7);
/* 2391 */       setBX7(p, -8);
/* 2392 */       setBX7(p, -9);
/*      */ 
/* 2394 */       setWall1(p, 6);
/* 2395 */       setWall1(p, 7);
/* 2396 */       setWall1(p, 8);
/* 2397 */       setWall1(p, 9);
/* 2398 */       setWall1(p, 9);
/* 2399 */       setWall2(p, 6);
/* 2400 */       setWall2(p, 7);
/* 2401 */       setWall2(p, 8);
/* 2402 */       setWall2(p, 9);
/* 2403 */       setWall2(p, 9);
/* 2404 */       setWall3(p, 6);
/* 2405 */       setWall3(p, 7);
/* 2406 */       setWall3(p, 8);
/* 2407 */       setWall3(p, 9);
/* 2408 */       setWall3(p, 9);
/* 2409 */       setWall4(p, 6);
/* 2410 */       setWall4(p, 7);
/* 2411 */       setWall4(p, 8);
/* 2412 */       setWall4(p, 9);
/* 2413 */       setWall4(p, 9);
/*      */ 
/* 2415 */       set1(p, 6);
/* 2416 */       set1(p, 7);
/* 2417 */       set1(p, 8);
/* 2418 */       set1(p, 9);
/* 2419 */       set1(p, 9);
/* 2420 */       set2(p, 6);
/* 2421 */       set2(p, 7);
/* 2422 */       set2(p, 8);
/* 2423 */       set2(p, 9);
/* 2424 */       set2(p, 9);
/* 2425 */       set3(p, 6);
/* 2426 */       set3(p, 7);
/* 2427 */       set3(p, 8);
/* 2428 */       set3(p, 9);
/* 2429 */       set3(p, 9);
/* 2430 */       set4(p, 6);
/* 2431 */       set4(p, 7);
/* 2432 */       set4(p, 8);
/* 2433 */       set4(p, 9);
/* 2434 */       set4(p, 9);
/* 2435 */       seta1(p, 6);
/* 2436 */       seta1(p, 7);
/* 2437 */       seta1(p, 8);
/* 2438 */       seta1(p, 9);
/* 2439 */       seta1(p, 9);
/* 2440 */       seta2(p, 6);
/* 2441 */       seta2(p, 7);
/* 2442 */       seta2(p, 8);
/* 2443 */       seta2(p, 9);
/* 2444 */       seta2(p, 9);
/* 2445 */       seta3(p, 6);
/* 2446 */       seta3(p, 7);
/* 2447 */       seta3(p, 8);
/* 2448 */       seta3(p, 9);
/* 2449 */       seta3(p, 9);
/* 2450 */       seta4(p, 6);
/* 2451 */       seta4(p, 7);
/* 2452 */       seta4(p, 8);
/* 2453 */       seta4(p, 9);
/* 2454 */       seta4(p, 9);
/* 2455 */       setaa4(p, 6);
/* 2456 */       setaa4(p, 7);
/* 2457 */       setaa4(p, 8);
/* 2458 */       setaa4(p, 9);
/* 2459 */       setaa4(p, 9);
/* 2460 */       setaaa4(p, 6);
/* 2461 */       setaaa4(p, 7);
/* 2462 */       setaaa4(p, 8);
/* 2463 */       setaaa4(p, 9);
/* 2464 */       setaaa4(p, 9);
/* 2465 */       setaaaa4(p, 6);
/* 2466 */       setaaaa4(p, 7);
/* 2467 */       setaaaa4(p, 8);
/* 2468 */       setaaaa4(p, 9);
/* 2469 */       setaaaa4(p, 9);
/* 2470 */       seta5(p, 6);
/* 2471 */       seta5(p, 7);
/* 2472 */       seta5(p, 8);
/* 2473 */       seta5(p, 9);
/* 2474 */       seta5(p, 9);
/* 2475 */       setaa5(p, 6);
/* 2476 */       setaa5(p, 7);
/* 2477 */       setaa5(p, 8);
/* 2478 */       setaa5(p, 9);
/* 2479 */       setaa5(p, 9);
/* 2480 */       setaaa5(p, 6);
/* 2481 */       setaaa5(p, 7);
/* 2482 */       setaaa5(p, 8);
/* 2483 */       setaaa5(p, 9);
/* 2484 */       setaaa5(p, 9);
/* 2485 */       setaaaa5(p, 6);
/* 2486 */       setaaaa5(p, 7);
/* 2487 */       setaaaa5(p, 8);
/* 2488 */       setaaaa5(p, 9);
/* 2489 */       setaaaa5(p, 9);
/* 2490 */       setaa6(p, 6);
/* 2491 */       setaa6(p, 7);
/* 2492 */       setaa6(p, 8);
/* 2493 */       setaa6(p, 9);
/* 2494 */       setaa6(p, 9);
/* 2495 */       setaaa6(p, 6);
/* 2496 */       setaaa6(p, 7);
/* 2497 */       setaaa6(p, 8);
/* 2498 */       setaaa6(p, 9);
/* 2499 */       setaaa6(p, 9);
/* 2500 */       setaaaa6(p, 6);
/* 2501 */       setaaaa6(p, 7);
/* 2502 */       setaaaa6(p, 8);
/* 2503 */       setaaaa6(p, 9);
/* 2504 */       setaaaa6(p, 9);
/*      */ 
/* 2506 */       setb1(p, 6);
/* 2507 */       setb1(p, 7);
/* 2508 */       setb1(p, 8);
/* 2509 */       setb1(p, 9); setb1(p, 9);
/* 2510 */       setbb1(p, 6);
/* 2511 */       setbb1(p, 7);
/* 2512 */       setbb1(p, 8);
/* 2513 */       setbb1(p, 9); setbb1(p, 9);
/* 2514 */       setbb1(p, 6);
/* 2515 */       setbbb1(p, 6);
/* 2516 */       setbbb1(p, 7);
/* 2517 */       setbbb1(p, 8);
/* 2518 */       setbbb1(p, 9); setbbb1(p, 9);
/* 2519 */       setbbbb1(p, 6);
/* 2520 */       setbbbb1(p, 7);
/* 2521 */       setbbbb1(p, 8);
/* 2522 */       setbbbb1(p, 9); setbbbb1(p, 9);
/* 2523 */       setb2(p, 6);
/* 2524 */       setb2(p, 7);
/* 2525 */       setb2(p, 8);
/* 2526 */       setb2(p, 9); setb2(p, 9);
/* 2527 */       setbb2(p, 6);
/* 2528 */       setbb2(p, 7);
/* 2529 */       setbb2(p, 8);
/* 2530 */       setbb2(p, 9); setbb2(p, 9);
/* 2531 */       setbbb2(p, 6);
/* 2532 */       setbbb2(p, 7);
/* 2533 */       setbbb2(p, 8);
/* 2534 */       setbbb2(p, 9); setbbb2(p, 9);
/* 2535 */       setbbbb2(p, 6);
/* 2536 */       setbbbb2(p, 7);
/* 2537 */       setbbbb2(p, 8);
/* 2538 */       setbbbb2(p, 9); setbbbb2(p, 9);
/* 2539 */       setb3(p, 6);
/* 2540 */       setb3(p, 7);
/* 2541 */       setb3(p, 8);
/* 2542 */       setb3(p, 9);
/* 2543 */       setbb3(p, 6);
/* 2544 */       setbb3(p, 7);
/* 2545 */       setbb3(p, 8);
/* 2546 */       setbb3(p, 9);
/* 2547 */       setbbb3(p, 6);
/* 2548 */       setbbb3(p, 7);
/* 2549 */       setbbb3(p, 8);
/* 2550 */       setbbb3(p, 9);
/*      */ 
/* 2552 */       setaa2(p, 6);
/* 2553 */       setaa2(p, 7);
/* 2554 */       setaa2(p, 8);
/* 2555 */       setaa2(p, 9);
/* 2556 */       setaaa2(p, 6);
/* 2557 */       setaaa2(p, 7);
/* 2558 */       setaaa2(p, 8);
/* 2559 */       setaaa2(p, 9);
/* 2560 */       setaaaa2(p, 6);
/* 2561 */       setaaaa2(p, 7);
/* 2562 */       setaaaa2(p, 8);
/* 2563 */       setaaaa2(p, 9);
/* 2564 */       setab2(p, 6);
/* 2565 */       setab2(p, 7);
/* 2566 */       setab2(p, 8);
/* 2567 */       setab2(p, 9);
/* 2568 */       setabb2(p, 6);
/* 2569 */       setabb2(p, 7);
/* 2570 */       setabb2(p, 8);
/* 2571 */       setabb2(p, 9);
/* 2572 */       setabbb2(p, 6);
/* 2573 */       setabbb2(p, 7);
/* 2574 */       setabbb2(p, 8);
/* 2575 */       setabbb2(p, 9);
/* 2576 */       setac2(p, 6);
/* 2577 */       setac2(p, 7);
/* 2578 */       setac2(p, 8);
/* 2579 */       setac2(p, 9);
/* 2580 */       setacc2(p, 6);
/* 2581 */       setacc2(p, 7);
/* 2582 */       setacc2(p, 8);
/* 2583 */       setacc2(p, 9);
/* 2584 */       setaccc2(p, 6);
/* 2585 */       setaccc2(p, 7);
/* 2586 */       setaccc2(p, 8);
/* 2587 */       setaccc2(p, 9);
/* 2588 */       setac3(p, 6);
/* 2589 */       setac3(p, 7);
/* 2590 */       setac3(p, 8);
/* 2591 */       setac3(p, 9);
/* 2592 */       setacc3(p, 6);
/* 2593 */       setacc3(p, 7);
/* 2594 */       setacc3(p, 8);
/* 2595 */       setacc3(p, 9);
/*      */ 
/* 2597 */       setc2(p, 6);
/* 2598 */       setc2(p, 7);
/* 2599 */       setc2(p, 8);
/* 2600 */       setc2(p, 9);
/* 2601 */       setc3(p, 6);
/* 2602 */       setc3(p, 7);
/* 2603 */       setc3(p, 8);
/* 2604 */       setc3(p, 9);
/* 2605 */       setc4(p, 6);
/* 2606 */       setc4(p, 7);
/* 2607 */       setc4(p, 8);
/* 2608 */       setc4(p, 9);
/* 2609 */       setc5(p, 6);
/* 2610 */       setc5(p, 7);
/* 2611 */       setc5(p, 8);
/* 2612 */       setc5(p, 9);
/* 2613 */       setc6(p, 6);
/* 2614 */       setc6(p, 7);
/* 2615 */       setc6(p, 8);
/* 2616 */       setc6(p, 9);
/* 2617 */       setc7(p, 6);
/* 2618 */       setc7(p, 7);
/* 2619 */       setc7(p, 8);
/* 2620 */       setc7(p, 9);
/*      */ 
/* 2622 */       setc8(p, 6);
/* 2623 */       setc8(p, 7);
/* 2624 */       setc8(p, 8);
/* 2625 */       setc8(p, 9);
/* 2626 */       setc9(p, 6);
/* 2627 */       setc9(p, 7);
/* 2628 */       setc9(p, 8);
/* 2629 */       setc9(p, 9);
/* 2630 */       setc10(p, 6);
/* 2631 */       setc10(p, 7);
/* 2632 */       setc10(p, 8);
/* 2633 */       setc10(p, 9);
/* 2634 */       setc11(p, 6);
/* 2635 */       setc11(p, 7);
/* 2636 */       setc11(p, 8);
/* 2637 */       setc11(p, 9);
/* 2638 */       setc12(p, 6);
/* 2639 */       setc12(p, 7);
/* 2640 */       setc12(p, 8);
/* 2641 */       setc12(p, 9);
/* 2642 */       setc13(p, 6);
/* 2643 */       setc13(p, 7);
/* 2644 */       setc13(p, 8);
/* 2645 */       setc13(p, 9);
/*      */ 
/* 2647 */       setBlock(p, 1, 6);
/* 2648 */       setBlock(p, 1, 4);
/* 2649 */       setBlock(p, -1, 6);
/* 2650 */       setBlock(p, -1, 4);
/* 2651 */       setZ(p, 6);
/* 2652 */       setZ(p, 4);
/* 2653 */       setX(p, 6);
/* 2654 */       setX(p, 4);
/*      */ 
/* 2656 */       setBlock(p, 2, 7);
/* 2657 */       setBlock(p, 2, 3);
/* 2658 */       setBlock(p, -2, 7);
/* 2659 */       setBlock(p, -2, 3);
/* 2660 */       setZ(p, 7);
/* 2661 */       setZ(p, 3);
/* 2662 */       setX(p, 7);
/* 2663 */       setX(p, 3);
/*      */ 
/* 2665 */       setBlock(p, 3, 8);
/* 2666 */       setBlock(p, 3, 2);
/* 2667 */       setBlock(p, -3, 8);
/* 2668 */       setBlock(p, -3, 2);
/* 2669 */       setZ(p, 8);
/* 2670 */       setZ(p, 2);
/* 2671 */       setX(p, 8);
/* 2672 */       setX(p, 2);
/*      */ 
/* 2674 */       setBlock(p, 4, 9);
/* 2675 */       setBlock(p, 4, 1);
/* 2676 */       setBlock(p, -4, 9);
/* 2677 */       setBlock(p, -4, 1);
/* 2678 */       setZ(p, 9);
/* 2679 */       setZ(p, 1);
/* 2680 */       setX(p, 9);
/* 2681 */       setX(p, 1);
/*      */ 
/* 2683 */       setBlock(p, 5, 10);
/* 2684 */       setBlock(p, 5, 0);
/* 2685 */       setBlock(p, -5, 10);
/* 2686 */       setBlock(p, -5, 0);
/* 2687 */       setZ(p, 10);
/* 2688 */       setZ(p, 0);
/* 2689 */       setX(p, 10);
/* 2690 */       setX(p, 0);
/*      */ 
/* 2692 */       setBlock(p, 6, 11);
/* 2693 */       setBlock(p, 6, -1);
/* 2694 */       setBlock(p, -6, 11);
/* 2695 */       setBlock(p, -6, -1);
/* 2696 */       setZ(p, 11);
/* 2697 */       setZ(p, -1);
/* 2698 */       setX(p, 11);
/* 2699 */       setX(p, -1);
/*      */ 
/* 2701 */       setBlock(p, 7, 12);
/* 2702 */       setBlock(p, 7, -2);
/* 2703 */       setBlock(p, -7, 12);
/* 2704 */       setBlock(p, -7, -2);
/* 2705 */       setZ(p, 12);
/* 2706 */       setZ(p, -2);
/* 2707 */       setX(p, 12);
/* 2708 */       setX(p, -2);
/*      */ 
/* 2710 */       asetBZ1(p, 6);
/* 2711 */       asetBZ2(p, 6);
/* 2712 */       asetBZ3(p, 6);
/* 2713 */       asetBZ1(p, 4);
/* 2714 */       asetBZ2(p, 4);
/* 2715 */       asetBZ3(p, 4);
/* 2716 */       asetZ1(p, 6);
/* 2717 */       asetZ2(p, 6);
/* 2718 */       asetZ3(p, 6);
/* 2719 */       asetZ1(p, 4);
/* 2720 */       asetZ2(p, 4);
/* 2721 */       asetZ3(p, 4);
/*      */ 
/* 2723 */       asetBZ1(p, 7);
/* 2724 */       asetBZ2(p, 7);
/* 2725 */       asetBZ3(p, 7);
/* 2726 */       asetBZ1(p, 3);
/* 2727 */       asetBZ2(p, 3);
/* 2728 */       asetBZ3(p, 3);
/* 2729 */       asetZ1(p, 7);
/* 2730 */       asetZ2(p, 7);
/* 2731 */       asetZ3(p, 7);
/* 2732 */       asetZ1(p, 3);
/* 2733 */       asetZ2(p, 3);
/* 2734 */       asetZ3(p, 3);
/*      */ 
/* 2736 */       asetBZ1(p, 8);
/* 2737 */       asetBZ2(p, 8);
/* 2738 */       asetBZ3(p, 8);
/* 2739 */       asetBZ1(p, 2);
/* 2740 */       asetBZ2(p, 2);
/* 2741 */       asetBZ3(p, 2);
/* 2742 */       asetZ1(p, 8);
/* 2743 */       asetZ2(p, 8);
/* 2744 */       asetZ3(p, 8);
/* 2745 */       asetZ1(p, 2);
/* 2746 */       asetZ2(p, 2);
/* 2747 */       asetZ3(p, 2);
/*      */ 
/* 2749 */       asetBZ1(p, 9);
/* 2750 */       asetBZ2(p, 9);
/* 2751 */       asetBZ3(p, 9);
/* 2752 */       asetBZ1(p, 1);
/* 2753 */       asetBZ2(p, 1);
/* 2754 */       asetBZ3(p, 1);
/* 2755 */       asetBZ3(p, 0);
/* 2756 */       asetBZ3(p, -1);
/* 2757 */       asetBZ3(p, -2);
/* 2758 */       asetBZ3(p, -3);
/* 2759 */       asetBZ3(p, -4);
/* 2760 */       asetBZ3(p, -5);
/* 2761 */       asetZ1(p, 9);
/* 2762 */       asetZ2(p, 9);
/* 2763 */       asetZ3(p, 9);
/* 2764 */       asetZ1(p, 1);
/* 2765 */       asetZ2(p, 1);
/* 2766 */       asetZ3(p, 1);
/*      */ 
/* 2768 */       asetBZ1(p, 10);
/* 2769 */       asetBZ2(p, 10);
/* 2770 */       asetBZ1(p, 0);
/* 2771 */       asetBZ2(p, 0);
/* 2772 */       asetBZ2(p, -1);
/* 2773 */       asetBZ2(p, -2);
/* 2774 */       asetBZ2(p, -3);
/* 2775 */       asetBZ2(p, -4);
/* 2776 */       asetZ1(p, 10);
/* 2777 */       asetZ2(p, 10);
/* 2778 */       asetZ1(p, 0);
/* 2779 */       asetZ2(p, 0);
/* 2780 */       asetZ3(p, 0);
/*      */ 
/* 2782 */       asetZ1(p, 11);
/* 2783 */       asetZ1(p, -1);
/* 2784 */       asetBZ1(p, 11);
/* 2785 */       asetBZ1(p, -2);
/* 2786 */       asetBZ1(p, -1);
/* 2787 */       asetBZ1(p, -3);
/* 2788 */       asetZ2(p, -1);
/* 2789 */       asetZ3(p, -1);
/*      */ 
/* 2791 */       asetZ1(p, -2);
/* 2792 */       asetZ1(p, -3);
/* 2793 */       asetZ2(p, -2);
/* 2794 */       asetZ2(p, -3);
/* 2795 */       asetZ2(p, -4);
/* 2796 */       asetZ3(p, -2);
/* 2797 */       asetZ3(p, -3);
/* 2798 */       asetZ3(p, -4);
/* 2799 */       asetZ3(p, -5);
/*      */ 
/* 2801 */       asetZ4(p, 6);
/* 2802 */       asetZ4(p, 7);
/* 2803 */       asetZ4(p, 8);
/* 2804 */       asetZ4(p, 4);
/* 2805 */       asetZ4(p, 3);
/* 2806 */       asetZ4(p, 2);
/* 2807 */       asetZ4(p, 1);
/* 2808 */       asetZ4(p, 0);
/* 2809 */       asetZ4(p, -1);
/* 2810 */       asetZ4(p, -2);
/* 2811 */       asetZ4(p, -3);
/* 2812 */       asetZ4(p, -4);
/* 2813 */       asetZ4(p, -5);
/* 2814 */       asetZ4(p, -6);
/* 2815 */       asetZ5(p, 6);
/* 2816 */       asetZ5(p, 7);
/* 2817 */       asetZ5(p, 4);
/* 2818 */       asetZ5(p, 3);
/* 2819 */       asetZ5(p, 2);
/* 2820 */       asetZ5(p, 1);
/* 2821 */       asetZ5(p, 0);
/* 2822 */       asetZ5(p, -1);
/* 2823 */       asetZ5(p, -2);
/* 2824 */       asetZ5(p, -3);
/* 2825 */       asetZ5(p, -4);
/* 2826 */       asetZ5(p, -5);
/* 2827 */       asetZ5(p, -6);
/* 2828 */       asetZ5(p, -7);
/* 2829 */       asetZ6(p, 4);
/* 2830 */       asetZ6(p, 3);
/* 2831 */       asetZ6(p, 2);
/* 2832 */       asetZ6(p, 1);
/* 2833 */       asetZ6(p, 0);
/* 2834 */       asetZ6(p, -1);
/* 2835 */       asetZ6(p, -2);
/* 2836 */       asetZ6(p, -3);
/* 2837 */       asetZ6(p, -4);
/* 2838 */       asetZ6(p, -5);
/* 2839 */       asetZ6(p, -6);
/* 2840 */       asetZ6(p, -7);
/* 2841 */       asetZ6(p, -8);
/* 2842 */       asetZ5(p, 4);
/* 2843 */       asetZ5(p, 3);
/* 2844 */       asetZ5(p, 2);
/* 2845 */       asetZ5(p, 1);
/* 2846 */       asetZ5(p, 0);
/* 2847 */       asetZ5(p, -1);
/* 2848 */       asetZ5(p, -2);
/* 2849 */       asetZ5(p, -3);
/* 2850 */       asetZ5(p, -4);
/* 2851 */       asetZ5(p, -5);
/* 2852 */       asetZ5(p, -6);
/* 2853 */       asetZ5(p, -7);
/* 2854 */       asetZ7(p, 4);
/* 2855 */       asetZ7(p, 3);
/* 2856 */       asetZ7(p, 2);
/* 2857 */       asetZ7(p, 1);
/* 2858 */       asetZ7(p, 0);
/* 2859 */       asetZ7(p, -1);
/* 2860 */       asetZ7(p, -2);
/* 2861 */       asetZ7(p, -3);
/* 2862 */       asetZ7(p, -4);
/* 2863 */       asetZ7(p, -5);
/* 2864 */       asetZ7(p, -6);
/* 2865 */       asetZ7(p, -7);
/* 2866 */       asetZ7(p, -8);
/* 2867 */       asetZ7(p, -9);
/*      */ 
/* 2869 */       asetX1(p, 4);
/* 2870 */       asetX1(p, 3);
/* 2871 */       asetX1(p, 2);
/* 2872 */       asetX1(p, 1);
/* 2873 */       asetX1(p, 0);
/* 2874 */       asetX1(p, -1);
/* 2875 */       asetX1(p, -2);
/* 2876 */       asetX1(p, -3);
/* 2877 */       asetX2(p, 4);
/* 2878 */       asetX2(p, 3);
/* 2879 */       asetX2(p, 2);
/* 2880 */       asetX2(p, 1);
/* 2881 */       asetX2(p, 0);
/* 2882 */       asetX2(p, -1);
/* 2883 */       asetX2(p, -2);
/* 2884 */       asetX2(p, -3);
/* 2885 */       asetX2(p, -4);
/* 2886 */       asetX3(p, 4);
/* 2887 */       asetX3(p, 3);
/* 2888 */       asetX3(p, 2);
/* 2889 */       asetX3(p, 1);
/* 2890 */       asetX3(p, 0);
/* 2891 */       asetX3(p, -1);
/* 2892 */       asetX3(p, -2);
/* 2893 */       asetX3(p, -3);
/* 2894 */       asetX3(p, -4);
/* 2895 */       asetX3(p, -5);
/* 2896 */       asetX4(p, 4);
/* 2897 */       asetX4(p, 3);
/* 2898 */       asetX4(p, 2);
/* 2899 */       asetX4(p, 1);
/* 2900 */       asetX4(p, 0);
/* 2901 */       asetX4(p, -1);
/* 2902 */       asetX4(p, -2);
/* 2903 */       asetX4(p, -3);
/* 2904 */       asetX4(p, -4);
/* 2905 */       asetX4(p, -5);
/* 2906 */       asetX4(p, -6);
/* 2907 */       asetX5(p, 4);
/* 2908 */       asetX5(p, 3);
/* 2909 */       asetX5(p, 2);
/* 2910 */       asetX5(p, 1);
/* 2911 */       asetX5(p, 0);
/* 2912 */       asetX5(p, -1);
/* 2913 */       asetX5(p, -2);
/* 2914 */       asetX5(p, -3);
/* 2915 */       asetX5(p, -4);
/* 2916 */       asetX5(p, -5);
/* 2917 */       asetX5(p, -6);
/* 2918 */       asetX5(p, -7);
/* 2919 */       asetX6(p, 4);
/* 2920 */       asetX6(p, 3);
/* 2921 */       asetX6(p, 2);
/* 2922 */       asetX6(p, 1);
/* 2923 */       asetX6(p, 0);
/* 2924 */       asetX6(p, -1);
/* 2925 */       asetX6(p, -2);
/* 2926 */       asetX6(p, -3);
/* 2927 */       asetX6(p, -4);
/* 2928 */       asetX6(p, -5);
/* 2929 */       asetX6(p, -6);
/* 2930 */       asetX6(p, -7);
/* 2931 */       asetX6(p, -8);
/* 2932 */       asetX7(p, 4);
/* 2933 */       asetX7(p, 3);
/* 2934 */       asetX7(p, 2);
/* 2935 */       asetX7(p, 1);
/* 2936 */       asetX7(p, 0);
/* 2937 */       asetX7(p, -1);
/* 2938 */       asetX7(p, -2);
/* 2939 */       asetX7(p, -3);
/* 2940 */       asetX7(p, -4);
/* 2941 */       asetX7(p, -5);
/* 2942 */       asetX7(p, -6);
/* 2943 */       asetX7(p, -7);
/* 2944 */       asetX7(p, -8);
/* 2945 */       asetBX1(p, 4);
/* 2946 */       asetBX1(p, 3);
/* 2947 */       asetBX1(p, 2);
/* 2948 */       asetBX1(p, 1);
/* 2949 */       asetBX1(p, 0);
/* 2950 */       asetBX1(p, -1);
/* 2951 */       asetBX1(p, -2);
/* 2952 */       asetBX1(p, -3);
/* 2953 */       asetBX2(p, 4);
/* 2954 */       asetBX2(p, 3);
/* 2955 */       asetBX2(p, 2);
/* 2956 */       asetBX2(p, 1);
/* 2957 */       asetBX2(p, 0);
/* 2958 */       asetBX2(p, -1);
/* 2959 */       asetBX2(p, -2);
/* 2960 */       asetBX2(p, -3);
/* 2961 */       asetBX2(p, -4);
/* 2962 */       asetBX3(p, 4);
/* 2963 */       asetBX3(p, 3);
/* 2964 */       asetBX3(p, 2);
/* 2965 */       asetBX3(p, 1);
/* 2966 */       asetBX3(p, 0);
/* 2967 */       asetBX3(p, -1);
/* 2968 */       asetBX3(p, -2);
/* 2969 */       asetBX3(p, -3);
/* 2970 */       asetBX3(p, -4);
/* 2971 */       asetBX3(p, -5);
/*      */ 
/* 2973 */       asetBX4(p, 4);
/* 2974 */       asetBX4(p, 3);
/* 2975 */       asetBX4(p, 2);
/* 2976 */       asetBX4(p, 1);
/* 2977 */       asetBX4(p, 0);
/* 2978 */       asetBX4(p, -1);
/* 2979 */       asetBX4(p, -2);
/* 2980 */       asetBX4(p, -3);
/* 2981 */       asetBX4(p, -4);
/* 2982 */       asetBX4(p, -5);
/* 2983 */       asetBX4(p, -6);
/*      */ 
/* 2985 */       asetBX5(p, 4);
/* 2986 */       asetBX5(p, 3);
/* 2987 */       asetBX5(p, 2);
/* 2988 */       asetBX5(p, 1);
/* 2989 */       asetBX5(p, 0);
/* 2990 */       asetBX5(p, -1);
/* 2991 */       asetBX5(p, -2);
/* 2992 */       asetBX5(p, -3);
/* 2993 */       asetBX5(p, -4);
/* 2994 */       asetBX5(p, -5);
/* 2995 */       asetBX5(p, -6);
/* 2996 */       asetBX5(p, -7);
/*      */ 
/* 2998 */       asetBX6(p, 4);
/* 2999 */       asetBX6(p, 3);
/* 3000 */       asetBX6(p, 2);
/* 3001 */       asetBX6(p, 1);
/* 3002 */       asetBX6(p, 0);
/* 3003 */       asetBX6(p, -1);
/* 3004 */       asetBX6(p, -2);
/* 3005 */       asetBX6(p, -3);
/* 3006 */       asetBX6(p, -4);
/* 3007 */       asetBX6(p, -5);
/* 3008 */       asetBX6(p, -6);
/* 3009 */       asetBX6(p, -7);
/* 3010 */       asetBX6(p, -8);
/*      */ 
/* 3012 */       asetBX7(p, 4);
/* 3013 */       asetBX7(p, 3);
/* 3014 */       asetBX7(p, 2);
/* 3015 */       asetBX7(p, 1);
/* 3016 */       asetBX7(p, 0);
/* 3017 */       asetBX7(p, -1);
/* 3018 */       asetBX7(p, -2);
/* 3019 */       asetBX7(p, -3);
/* 3020 */       asetBX7(p, -4);
/* 3021 */       asetBX7(p, -5);
/* 3022 */       asetBX7(p, -6);
/* 3023 */       asetBX7(p, -7);
/* 3024 */       asetBX7(p, -8);
/* 3025 */       asetBX7(p, -9);
/* 3026 */       asetBlock(p, 1, 6);
/* 3027 */       asetBlock(p, 1, 4);
/* 3028 */       asetBlock(p, -1, 6);
/* 3029 */       asetBlock(p, -1, 4);
/* 3030 */       asetZ(p, 6);
/* 3031 */       asetZ(p, 4);
/* 3032 */       asetX(p, 6);
/* 3033 */       asetX(p, 4);
/*      */ 
/* 3035 */       asetBlock(p, 2, 7);
/* 3036 */       asetBlock(p, 2, 3);
/* 3037 */       asetBlock(p, -2, 7);
/* 3038 */       asetBlock(p, -2, 3);
/* 3039 */       asetZ(p, 7);
/* 3040 */       asetZ(p, 3);
/* 3041 */       asetX(p, 7);
/* 3042 */       asetX(p, 3);
/*      */ 
/* 3044 */       asetBlock(p, 3, 8);
/* 3045 */       asetBlock(p, 3, 2);
/* 3046 */       asetBlock(p, -3, 8);
/* 3047 */       asetBlock(p, -3, 2);
/* 3048 */       asetZ(p, 8);
/* 3049 */       asetZ(p, 2);
/* 3050 */       asetX(p, 8);
/* 3051 */       asetX(p, 2);
/*      */ 
/* 3053 */       asetBlock(p, 4, 9);
/* 3054 */       asetBlock(p, 4, 1);
/* 3055 */       asetBlock(p, -4, 9);
/* 3056 */       asetBlock(p, -4, 1);
/* 3057 */       asetZ(p, 9);
/* 3058 */       asetZ(p, 1);
/* 3059 */       asetX(p, 9);
/* 3060 */       asetX(p, 1);
/*      */ 
/* 3062 */       asetBlock(p, 5, 10);
/* 3063 */       asetBlock(p, 5, 0);
/* 3064 */       asetBlock(p, -5, 10);
/* 3065 */       asetBlock(p, -5, 0);
/* 3066 */       asetZ(p, 10);
/* 3067 */       asetZ(p, 0);
/* 3068 */       asetX(p, 10);
/* 3069 */       asetX(p, 0);
/*      */ 
/* 3071 */       asetBlock(p, 6, 11);
/* 3072 */       asetBlock(p, 6, -1);
/* 3073 */       asetBlock(p, -6, 11);
/* 3074 */       asetBlock(p, -6, -1);
/* 3075 */       asetZ(p, 11);
/* 3076 */       asetZ(p, -1);
/* 3077 */       asetX(p, 11);
/* 3078 */       asetX(p, -1);
/*      */ 
/* 3080 */       asetBlock(p, 7, 12);
/* 3081 */       asetBlock(p, 7, -2);
/* 3082 */       asetBlock(p, -7, 12);
/* 3083 */       asetBlock(p, -7, -2);
/* 3084 */       asetZ(p, 12);
/* 3085 */       asetZ(p, -2);
/* 3086 */       asetX(p, 12);
/* 3087 */       asetX(p, -2);
/* 3088 */       a(p, 6);
/* 3089 */       a(p, 7);
/* 3090 */       a(p, 8);
/* 3091 */       a(p, 9);
/* 3092 */       a(p, 10);
/* 3093 */       a1.getBlock().setType(Material.AIR);
/* 3094 */       b1.getBlock().setType(Material.AIR);
/* 3095 */       c1.getBlock().setType(Material.AIR);
/* 3096 */       d1.getBlock().setType(Material.AIR);
/*      */     }
/*      */   }
/*      */ 
/*      */   public static void rsetBlock(Player p, int NumberX, int NumberZ)
/*      */   {
/* 3102 */     int x = p.getLocation().getBlockX();
/* 3103 */     int y = p.getLocation().getBlockY();
/* 3104 */     int z = p.getLocation().getBlockZ();
/* 3105 */     Location l = new Location(p.getWorld(), x + NumberX, y + 100, z + NumberZ);
/* 3106 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX(Player p, int NumberX) {
/* 3109 */     int x = p.getLocation().getBlockX();
/* 3110 */     int y = p.getLocation().getBlockY();
/* 3111 */     int z = p.getLocation().getBlockZ();
/* 3112 */     Location l = new Location(p.getWorld(), x + NumberX, y + 100, z);
/* 3113 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ(Player p, int NumberZ) {
/* 3116 */     int x = p.getLocation().getBlockX();
/* 3117 */     int y = p.getLocation().getBlockY();
/* 3118 */     int z = p.getLocation().getBlockZ();
/* 3119 */     Location l = new Location(p.getWorld(), x, y + 100, z + NumberZ);
/* 3120 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ1(Player p, int NumberZ) {
/* 3123 */     int x = p.getLocation().getBlockX();
/* 3124 */     int y = p.getLocation().getBlockY();
/* 3125 */     int z = p.getLocation().getBlockZ();
/* 3126 */     Location l = new Location(p.getWorld(), x + 1, y + 100, z + NumberZ + 1);
/* 3127 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ2(Player p, int NumberZ) {
/* 3130 */     int x = p.getLocation().getBlockX();
/* 3131 */     int y = p.getLocation().getBlockY();
/* 3132 */     int z = p.getLocation().getBlockZ();
/* 3133 */     Location l = new Location(p.getWorld(), x + 2, y + 100, z + NumberZ + 2);
/* 3134 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ3(Player p, int NumberZ) {
/* 3137 */     int x = p.getLocation().getBlockX();
/* 3138 */     int y = p.getLocation().getBlockY();
/* 3139 */     int z = p.getLocation().getBlockZ();
/* 3140 */     Location l = new Location(p.getWorld(), x + 3, y + 100, z + NumberZ + 3);
/* 3141 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ4(Player p, int NumberZ) {
/* 3144 */     int x = p.getLocation().getBlockX();
/* 3145 */     int y = p.getLocation().getBlockY();
/* 3146 */     int z = p.getLocation().getBlockZ();
/* 3147 */     Location l = new Location(p.getWorld(), x + 4, y + 100, z + NumberZ + 4);
/* 3148 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ5(Player p, int NumberZ) {
/* 3151 */     int x = p.getLocation().getBlockX();
/* 3152 */     int y = p.getLocation().getBlockY();
/* 3153 */     int z = p.getLocation().getBlockZ();
/* 3154 */     Location l = new Location(p.getWorld(), x + 5, y + 100, z + NumberZ + 5);
/* 3155 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ6(Player p, int NumberZ) {
/* 3158 */     int x = p.getLocation().getBlockX();
/* 3159 */     int y = p.getLocation().getBlockY();
/* 3160 */     int z = p.getLocation().getBlockZ();
/* 3161 */     Location l = new Location(p.getWorld(), x + 6, y + 100, z + NumberZ + 6);
/* 3162 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetZ7(Player p, int NumberZ) {
/* 3165 */     int x = p.getLocation().getBlockX();
/* 3166 */     int y = p.getLocation().getBlockY();
/* 3167 */     int z = p.getLocation().getBlockZ();
/* 3168 */     Location l = new Location(p.getWorld(), x + 7, y + 100, z + NumberZ + 7);
/* 3169 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBZ1(Player p, int NumberZ) {
/* 3172 */     int x = p.getLocation().getBlockX();
/* 3173 */     int y = p.getLocation().getBlockY();
/* 3174 */     int z = p.getLocation().getBlockZ();
/* 3175 */     Location l = new Location(p.getWorld(), x - 1, y + 100, z + NumberZ + 1);
/* 3176 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBZ2(Player p, int NumberZ) {
/* 3179 */     int x = p.getLocation().getBlockX();
/* 3180 */     int y = p.getLocation().getBlockY();
/* 3181 */     int z = p.getLocation().getBlockZ();
/* 3182 */     Location l = new Location(p.getWorld(), x - 2, y + 100, z + NumberZ + 2);
/* 3183 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBZ3(Player p, int NumberZ) {
/* 3186 */     int x = p.getLocation().getBlockX();
/* 3187 */     int y = p.getLocation().getBlockY();
/* 3188 */     int z = p.getLocation().getBlockZ();
/* 3189 */     Location l = new Location(p.getWorld(), x - 3, y + 100, z + NumberZ + 3);
/* 3190 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX1(Player p, int X) {
/* 3193 */     int x = p.getLocation().getBlockX();
/* 3194 */     int y = p.getLocation().getBlockY();
/* 3195 */     int z = p.getLocation().getBlockZ();
/* 3196 */     Location l = new Location(p.getWorld(), x + X + 1, y + 100, z + 1);
/* 3197 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX2(Player p, int X) {
/* 3200 */     int x = p.getLocation().getBlockX();
/* 3201 */     int y = p.getLocation().getBlockY();
/* 3202 */     int z = p.getLocation().getBlockZ();
/* 3203 */     Location l = new Location(p.getWorld(), x + X + 2, y + 100, z + 2);
/* 3204 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX3(Player p, int X) {
/* 3207 */     int x = p.getLocation().getBlockX();
/* 3208 */     int y = p.getLocation().getBlockY();
/* 3209 */     int z = p.getLocation().getBlockZ();
/* 3210 */     Location l = new Location(p.getWorld(), x + X + 3, y + 100, z + 3);
/* 3211 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX4(Player p, int X) {
/* 3214 */     int x = p.getLocation().getBlockX();
/* 3215 */     int y = p.getLocation().getBlockY();
/* 3216 */     int z = p.getLocation().getBlockZ();
/* 3217 */     Location l = new Location(p.getWorld(), x + X + 4, y + 100, z + 4);
/* 3218 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX5(Player p, int X) {
/* 3221 */     int x = p.getLocation().getBlockX();
/* 3222 */     int y = p.getLocation().getBlockY();
/* 3223 */     int z = p.getLocation().getBlockZ();
/* 3224 */     Location l = new Location(p.getWorld(), x + X + 5, y + 100, z + 5);
/* 3225 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX6(Player p, int X) {
/* 3228 */     int x = p.getLocation().getBlockX();
/* 3229 */     int y = p.getLocation().getBlockY();
/* 3230 */     int z = p.getLocation().getBlockZ();
/* 3231 */     Location l = new Location(p.getWorld(), x + X + 6, y + 100, z + 6);
/* 3232 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetX7(Player p, int X) {
/* 3235 */     int x = p.getLocation().getBlockX();
/* 3236 */     int y = p.getLocation().getBlockY();
/* 3237 */     int z = p.getLocation().getBlockZ();
/* 3238 */     Location l = new Location(p.getWorld(), x + X + 7, y + 100, z + 7);
/* 3239 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBX1(Player p, int X) {
/* 3242 */     int x = p.getLocation().getBlockX();
/* 3243 */     int y = p.getLocation().getBlockY();
/* 3244 */     int z = p.getLocation().getBlockZ();
/* 3245 */     Location l = new Location(p.getWorld(), x + X + 1, y + 100, z - 1);
/* 3246 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBX2(Player p, int X) {
/* 3249 */     int x = p.getLocation().getBlockX();
/* 3250 */     int y = p.getLocation().getBlockY();
/* 3251 */     int z = p.getLocation().getBlockZ();
/* 3252 */     Location l = new Location(p.getWorld(), x + X + 2, y + 100, z - 2);
/* 3253 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBX3(Player p, int X) {
/* 3256 */     int x = p.getLocation().getBlockX();
/* 3257 */     int y = p.getLocation().getBlockY();
/* 3258 */     int z = p.getLocation().getBlockZ();
/* 3259 */     Location l = new Location(p.getWorld(), x + X + 3, y + 100, z - 3);
/* 3260 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBX4(Player p, int X) {
/* 3263 */     int x = p.getLocation().getBlockX();
/* 3264 */     int y = p.getLocation().getBlockY();
/* 3265 */     int z = p.getLocation().getBlockZ();
/* 3266 */     Location l = new Location(p.getWorld(), x + X + 4, y + 100, z - 4);
/* 3267 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBX5(Player p, int X) {
/* 3270 */     int x = p.getLocation().getBlockX();
/* 3271 */     int y = p.getLocation().getBlockY();
/* 3272 */     int z = p.getLocation().getBlockZ();
/* 3273 */     Location l = new Location(p.getWorld(), x + X + 5, y + 100, z - 5);
/* 3274 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBX6(Player p, int X) {
/* 3277 */     int x = p.getLocation().getBlockX();
/* 3278 */     int y = p.getLocation().getBlockY();
/* 3279 */     int z = p.getLocation().getBlockZ();
/* 3280 */     Location l = new Location(p.getWorld(), x + X + 6, y + 100, z - 6);
/* 3281 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetBX7(Player p, int X) {
/* 3284 */     int x = p.getLocation().getBlockX();
/* 3285 */     int y = p.getLocation().getBlockY();
/* 3286 */     int z = p.getLocation().getBlockZ();
/* 3287 */     Location l = new Location(p.getWorld(), x + X + 7, y + 100, z - 7);
/* 3288 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetWall1(Player p, int one) {
/* 3291 */     int x = p.getLocation().getBlockX();
/* 3292 */     int y = p.getLocation().getBlockY();
/* 3293 */     int z = p.getLocation().getBlockZ();
/* 3294 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 8);
/* 3295 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetWall2(Player p, int one) {
/* 3298 */     int x = p.getLocation().getBlockX();
/* 3299 */     int y = p.getLocation().getBlockY();
/* 3300 */     int z = p.getLocation().getBlockZ();
/* 3301 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 8);
/* 3302 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetWall3(Player p, int one) {
/* 3305 */     int x = p.getLocation().getBlockX();
/* 3306 */     int y = p.getLocation().getBlockY();
/* 3307 */     int z = p.getLocation().getBlockZ();
/* 3308 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 8);
/* 3309 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetWall4(Player p, int one) {
/* 3312 */     int x = p.getLocation().getBlockX();
/* 3313 */     int y = p.getLocation().getBlockY();
/* 3314 */     int z = p.getLocation().getBlockZ();
/* 3315 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 8);
/* 3316 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rset1(Player p, int one) {
/* 3319 */     int x = p.getLocation().getBlockX();
/* 3320 */     int y = p.getLocation().getBlockY();
/* 3321 */     int z = p.getLocation().getBlockZ();
/* 3322 */     Location l = new Location(p.getWorld(), x, y + 100 + one, z - 8);
/* 3323 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */ 
/*      */   public static void rset2(Player p, int one) {
/* 3327 */     int x = p.getLocation().getBlockX();
/* 3328 */     int y = p.getLocation().getBlockY();
/* 3329 */     int z = p.getLocation().getBlockZ();
/* 3330 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z);
/* 3331 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */ 
/*      */   public static void rset3(Player p, int one) {
/* 3335 */     int x = p.getLocation().getBlockX();
/* 3336 */     int y = p.getLocation().getBlockY();
/* 3337 */     int z = p.getLocation().getBlockZ();
/* 3338 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z);
/* 3339 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc2(Player p, int one) {
/* 3342 */     int x = p.getLocation().getBlockX();
/* 3343 */     int y = p.getLocation().getBlockY();
/* 3344 */     int z = p.getLocation().getBlockZ();
/* 3345 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 1);
/* 3346 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc3(Player p, int one) {
/* 3349 */     int x = p.getLocation().getBlockX();
/* 3350 */     int y = p.getLocation().getBlockY();
/* 3351 */     int z = p.getLocation().getBlockZ();
/* 3352 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 2);
/* 3353 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc4(Player p, int one) {
/* 3356 */     int x = p.getLocation().getBlockX();
/* 3357 */     int y = p.getLocation().getBlockY();
/* 3358 */     int z = p.getLocation().getBlockZ();
/* 3359 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 3);
/* 3360 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc5(Player p, int one) {
/* 3363 */     int x = p.getLocation().getBlockX();
/* 3364 */     int y = p.getLocation().getBlockY();
/* 3365 */     int z = p.getLocation().getBlockZ();
/* 3366 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 4);
/* 3367 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc6(Player p, int one) {
/* 3370 */     int x = p.getLocation().getBlockX();
/* 3371 */     int y = p.getLocation().getBlockY();
/* 3372 */     int z = p.getLocation().getBlockZ();
/* 3373 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 5);
/* 3374 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc7(Player p, int one) {
/* 3377 */     int x = p.getLocation().getBlockX();
/* 3378 */     int y = p.getLocation().getBlockY();
/* 3379 */     int z = p.getLocation().getBlockZ();
/* 3380 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 6);
/* 3381 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc8(Player p, int one) {
/* 3384 */     int x = p.getLocation().getBlockX();
/* 3385 */     int y = p.getLocation().getBlockY();
/* 3386 */     int z = p.getLocation().getBlockZ();
/* 3387 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 1);
/* 3388 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc9(Player p, int one) {
/* 3391 */     int x = p.getLocation().getBlockX();
/* 3392 */     int y = p.getLocation().getBlockY();
/* 3393 */     int z = p.getLocation().getBlockZ();
/* 3394 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 2);
/* 3395 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc10(Player p, int one) {
/* 3398 */     int x = p.getLocation().getBlockX();
/* 3399 */     int y = p.getLocation().getBlockY();
/* 3400 */     int z = p.getLocation().getBlockZ();
/* 3401 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 3);
/* 3402 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc11(Player p, int one) {
/* 3405 */     int x = p.getLocation().getBlockX();
/* 3406 */     int y = p.getLocation().getBlockY();
/* 3407 */     int z = p.getLocation().getBlockZ();
/* 3408 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 4);
/* 3409 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc12(Player p, int one) {
/* 3412 */     int x = p.getLocation().getBlockX();
/* 3413 */     int y = p.getLocation().getBlockY();
/* 3414 */     int z = p.getLocation().getBlockZ();
/* 3415 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 5);
/* 3416 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetc13(Player p, int one) {
/* 3419 */     int x = p.getLocation().getBlockX();
/* 3420 */     int y = p.getLocation().getBlockY();
/* 3421 */     int z = p.getLocation().getBlockZ();
/* 3422 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 6);
/* 3423 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rset4(Player p, int one) {
/* 3426 */     int x = p.getLocation().getBlockX();
/* 3427 */     int y = p.getLocation().getBlockY();
/* 3428 */     int z = p.getLocation().getBlockZ();
/* 3429 */     Location l = new Location(p.getWorld(), x, y + 100 + one, z + 8);
/* 3430 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rseta1(Player p, int one) {
/* 3433 */     int x = p.getLocation().getBlockX();
/* 3434 */     int y = p.getLocation().getBlockY();
/* 3435 */     int z = p.getLocation().getBlockZ();
/* 3436 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 6);
/* 3437 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rseta2(Player p, int one) {
/* 3440 */     int x = p.getLocation().getBlockX();
/* 3441 */     int y = p.getLocation().getBlockY();
/* 3442 */     int z = p.getLocation().getBlockZ();
/* 3443 */     Location l = new Location(p.getWorld(), x - 6, y + 100 + one, z - 8);
/* 3444 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaa2(Player p, int one) {
/* 3447 */     int x = p.getLocation().getBlockX();
/* 3448 */     int y = p.getLocation().getBlockY();
/* 3449 */     int z = p.getLocation().getBlockZ();
/* 3450 */     Location l = new Location(p.getWorld(), x - 5, y + 100 + one, z - 8);
/* 3451 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaa2(Player p, int one) {
/* 3454 */     int x = p.getLocation().getBlockX();
/* 3455 */     int y = p.getLocation().getBlockY();
/* 3456 */     int z = p.getLocation().getBlockZ();
/* 3457 */     Location l = new Location(p.getWorld(), x - 4, y + 100 + one, z - 8);
/* 3458 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaaa2(Player p, int one) {
/* 3461 */     int x = p.getLocation().getBlockX();
/* 3462 */     int y = p.getLocation().getBlockY();
/* 3463 */     int z = p.getLocation().getBlockZ();
/* 3464 */     Location l = new Location(p.getWorld(), x - 3, y + 100 + one, z - 8);
/* 3465 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetab2(Player p, int one) {
/* 3468 */     int x = p.getLocation().getBlockX();
/* 3469 */     int y = p.getLocation().getBlockY();
/* 3470 */     int z = p.getLocation().getBlockZ();
/* 3471 */     Location l = new Location(p.getWorld(), x - 2, y + 100 + one, z - 8);
/* 3472 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetabb2(Player p, int one) {
/* 3475 */     int x = p.getLocation().getBlockX();
/* 3476 */     int y = p.getLocation().getBlockY();
/* 3477 */     int z = p.getLocation().getBlockZ();
/* 3478 */     Location l = new Location(p.getWorld(), x - 1, y + 100 + one, z - 8);
/* 3479 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetabbb2(Player p, int one) {
/* 3482 */     int x = p.getLocation().getBlockX();
/* 3483 */     int y = p.getLocation().getBlockY();
/* 3484 */     int z = p.getLocation().getBlockZ();
/* 3485 */     Location l = new Location(p.getWorld(), x + 1, y + 100 + one, z - 8);
/* 3486 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetac2(Player p, int one) {
/* 3489 */     int x = p.getLocation().getBlockX();
/* 3490 */     int y = p.getLocation().getBlockY();
/* 3491 */     int z = p.getLocation().getBlockZ();
/* 3492 */     Location l = new Location(p.getWorld(), x + 2, y + 100 + one, z - 8);
/* 3493 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetacc2(Player p, int one) {
/* 3496 */     int x = p.getLocation().getBlockX();
/* 3497 */     int y = p.getLocation().getBlockY();
/* 3498 */     int z = p.getLocation().getBlockZ();
/* 3499 */     Location l = new Location(p.getWorld(), x + 3, y + 100 + one, z - 8);
/* 3500 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaccc2(Player p, int one) {
/* 3503 */     int x = p.getLocation().getBlockX();
/* 3504 */     int y = p.getLocation().getBlockY();
/* 3505 */     int z = p.getLocation().getBlockZ();
/* 3506 */     Location l = new Location(p.getWorld(), x + 4, y + 100 + one, z - 8);
/* 3507 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetac3(Player p, int one) {
/* 3510 */     int x = p.getLocation().getBlockX();
/* 3511 */     int y = p.getLocation().getBlockY();
/* 3512 */     int z = p.getLocation().getBlockZ();
/* 3513 */     Location l = new Location(p.getWorld(), x + 5, y + 100 + one, z - 8);
/* 3514 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetacc3(Player p, int one) {
/* 3517 */     int x = p.getLocation().getBlockX();
/* 3518 */     int y = p.getLocation().getBlockY();
/* 3519 */     int z = p.getLocation().getBlockZ();
/* 3520 */     Location l = new Location(p.getWorld(), x + 6, y + 100 + one, z - 8);
/* 3521 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rseta3(Player p, int one) {
/* 3524 */     int x = p.getLocation().getBlockX();
/* 3525 */     int y = p.getLocation().getBlockY();
/* 3526 */     int z = p.getLocation().getBlockZ();
/* 3527 */     Location l = new Location(p.getWorld(), x - 6, y + 100 + one, z + 8);
/* 3528 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetb1(Player p, int one) {
/* 3531 */     int x = p.getLocation().getBlockX();
/* 3532 */     int y = p.getLocation().getBlockY();
/* 3533 */     int z = p.getLocation().getBlockZ();
/* 3534 */     Location l = new Location(p.getWorld(), x - 5, y + 100 + one, z + 8);
/* 3535 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbb1(Player p, int one) {
/* 3538 */     int x = p.getLocation().getBlockX();
/* 3539 */     int y = p.getLocation().getBlockY();
/* 3540 */     int z = p.getLocation().getBlockZ();
/* 3541 */     Location l = new Location(p.getWorld(), x - 4, y + 100 + one, z + 8);
/* 3542 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbbb1(Player p, int one) {
/* 3545 */     int x = p.getLocation().getBlockX();
/* 3546 */     int y = p.getLocation().getBlockY();
/* 3547 */     int z = p.getLocation().getBlockZ();
/* 3548 */     Location l = new Location(p.getWorld(), x - 3, y + 100 + one, z + 8);
/* 3549 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbbbb1(Player p, int one) {
/* 3552 */     int x = p.getLocation().getBlockX();
/* 3553 */     int y = p.getLocation().getBlockY();
/* 3554 */     int z = p.getLocation().getBlockZ();
/* 3555 */     Location l = new Location(p.getWorld(), x - 2, y + 100 + one, z + 8);
/* 3556 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetb2(Player p, int one) {
/* 3559 */     int x = p.getLocation().getBlockX();
/* 3560 */     int y = p.getLocation().getBlockY();
/* 3561 */     int z = p.getLocation().getBlockZ();
/* 3562 */     Location l = new Location(p.getWorld(), x - 1, y + 100 + one, z + 8);
/* 3563 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbb2(Player p, int one) {
/* 3566 */     int x = p.getLocation().getBlockX();
/* 3567 */     int y = p.getLocation().getBlockY();
/* 3568 */     int z = p.getLocation().getBlockZ();
/* 3569 */     Location l = new Location(p.getWorld(), x + 1, y + 100 + one, z + 8);
/* 3570 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbbb2(Player p, int one) {
/* 3573 */     int x = p.getLocation().getBlockX();
/* 3574 */     int y = p.getLocation().getBlockY();
/* 3575 */     int z = p.getLocation().getBlockZ();
/* 3576 */     Location l = new Location(p.getWorld(), x + 2, y + 100 + one, z + 8);
/* 3577 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbbbb2(Player p, int one) {
/* 3580 */     int x = p.getLocation().getBlockX();
/* 3581 */     int y = p.getLocation().getBlockY();
/* 3582 */     int z = p.getLocation().getBlockZ();
/* 3583 */     Location l = new Location(p.getWorld(), x + 3, y + 100 + one, z + 8);
/* 3584 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetb3(Player p, int one) {
/* 3587 */     int x = p.getLocation().getBlockX();
/* 3588 */     int y = p.getLocation().getBlockY();
/* 3589 */     int z = p.getLocation().getBlockZ();
/* 3590 */     Location l = new Location(p.getWorld(), x + 4, y + 100 + one, z + 8);
/* 3591 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbb3(Player p, int one) {
/* 3594 */     int x = p.getLocation().getBlockX();
/* 3595 */     int y = p.getLocation().getBlockY();
/* 3596 */     int z = p.getLocation().getBlockZ();
/* 3597 */     Location l = new Location(p.getWorld(), x + 5, y + 100 + one, z + 8);
/* 3598 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetbbb3(Player p, int one) {
/* 3601 */     int x = p.getLocation().getBlockX();
/* 3602 */     int y = p.getLocation().getBlockY();
/* 3603 */     int z = p.getLocation().getBlockZ();
/* 3604 */     Location l = new Location(p.getWorld(), x + 6, y + 100 + one, z + 8);
/* 3605 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */ 
/*      */   public static void rseta4(Player p, int one) {
/* 3609 */     int x = p.getLocation().getBlockX();
/* 3610 */     int y = p.getLocation().getBlockY();
/* 3611 */     int z = p.getLocation().getBlockZ();
/* 3612 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 6);
/* 3613 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaa4(Player p, int one) {
/* 3616 */     int x = p.getLocation().getBlockX();
/* 3617 */     int y = p.getLocation().getBlockY();
/* 3618 */     int z = p.getLocation().getBlockZ();
/* 3619 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 5);
/* 3620 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaa4(Player p, int one) {
/* 3623 */     int x = p.getLocation().getBlockX();
/* 3624 */     int y = p.getLocation().getBlockY();
/* 3625 */     int z = p.getLocation().getBlockZ();
/* 3626 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 4);
/* 3627 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaaa4(Player p, int one) {
/* 3630 */     int x = p.getLocation().getBlockX();
/* 3631 */     int y = p.getLocation().getBlockY();
/* 3632 */     int z = p.getLocation().getBlockZ();
/* 3633 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 3);
/* 3634 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rseta5(Player p, int one) {
/* 3637 */     int x = p.getLocation().getBlockX();
/* 3638 */     int y = p.getLocation().getBlockY();
/* 3639 */     int z = p.getLocation().getBlockZ();
/* 3640 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 2);
/* 3641 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaa5(Player p, int one) {
/* 3644 */     int x = p.getLocation().getBlockX();
/* 3645 */     int y = p.getLocation().getBlockY();
/* 3646 */     int z = p.getLocation().getBlockZ();
/* 3647 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 1);
/* 3648 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaa5(Player p, int one) {
/* 3651 */     int x = p.getLocation().getBlockX();
/* 3652 */     int y = p.getLocation().getBlockY();
/* 3653 */     int z = p.getLocation().getBlockZ();
/* 3654 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 1);
/* 3655 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaaa5(Player p, int one) {
/* 3658 */     int x = p.getLocation().getBlockX();
/* 3659 */     int y = p.getLocation().getBlockY();
/* 3660 */     int z = p.getLocation().getBlockZ();
/* 3661 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 2);
/* 3662 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaa6(Player p, int one) {
/* 3665 */     int x = p.getLocation().getBlockX();
/* 3666 */     int y = p.getLocation().getBlockY();
/* 3667 */     int z = p.getLocation().getBlockZ();
/* 3668 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 3);
/* 3669 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaa6(Player p, int one) {
/* 3672 */     int x = p.getLocation().getBlockX();
/* 3673 */     int y = p.getLocation().getBlockY();
/* 3674 */     int z = p.getLocation().getBlockZ();
/* 3675 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 4);
/* 3676 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rsetaaaa6(Player p, int one) {
/* 3679 */     int x = p.getLocation().getBlockX();
/* 3680 */     int y = p.getLocation().getBlockY();
/* 3681 */     int z = p.getLocation().getBlockZ();
/* 3682 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 5);
/* 3683 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */ 
/*      */   public static void arsetBlock(Player p, int NumberX, int NumberZ) {
/* 3687 */     int x = p.getLocation().getBlockX();
/* 3688 */     int y = p.getLocation().getBlockY();
/* 3689 */     int z = p.getLocation().getBlockZ();
/* 3690 */     Location l = new Location(p.getWorld(), x + NumberX, y + 105, z + NumberZ);
/* 3691 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX(Player p, int NumberX) {
/* 3694 */     int x = p.getLocation().getBlockX();
/* 3695 */     int y = p.getLocation().getBlockY();
/* 3696 */     int z = p.getLocation().getBlockZ();
/* 3697 */     Location l = new Location(p.getWorld(), x + NumberX, y + 105, z);
/* 3698 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ(Player p, int NumberZ) {
/* 3701 */     int x = p.getLocation().getBlockX();
/* 3702 */     int y = p.getLocation().getBlockY();
/* 3703 */     int z = p.getLocation().getBlockZ();
/* 3704 */     Location l = new Location(p.getWorld(), x, y + 105, z + NumberZ);
/* 3705 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ1(Player p, int NumberZ) {
/* 3708 */     int x = p.getLocation().getBlockX();
/* 3709 */     int y = p.getLocation().getBlockY();
/* 3710 */     int z = p.getLocation().getBlockZ();
/* 3711 */     Location l = new Location(p.getWorld(), x + 1, y + 105, z + NumberZ + 1);
/* 3712 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ2(Player p, int NumberZ) {
/* 3715 */     int x = p.getLocation().getBlockX();
/* 3716 */     int y = p.getLocation().getBlockY();
/* 3717 */     int z = p.getLocation().getBlockZ();
/* 3718 */     Location l = new Location(p.getWorld(), x + 2, y + 105, z + NumberZ + 2);
/* 3719 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ3(Player p, int NumberZ) {
/* 3722 */     int x = p.getLocation().getBlockX();
/* 3723 */     int y = p.getLocation().getBlockY();
/* 3724 */     int z = p.getLocation().getBlockZ();
/* 3725 */     Location l = new Location(p.getWorld(), x + 3, y + 105, z + NumberZ + 3);
/* 3726 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ4(Player p, int NumberZ) {
/* 3729 */     int x = p.getLocation().getBlockX();
/* 3730 */     int y = p.getLocation().getBlockY();
/* 3731 */     int z = p.getLocation().getBlockZ();
/* 3732 */     Location l = new Location(p.getWorld(), x + 4, y + 105, z + NumberZ + 4);
/* 3733 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ5(Player p, int NumberZ) {
/* 3736 */     int x = p.getLocation().getBlockX();
/* 3737 */     int y = p.getLocation().getBlockY();
/* 3738 */     int z = p.getLocation().getBlockZ();
/* 3739 */     Location l = new Location(p.getWorld(), x + 5, y + 105, z + NumberZ + 5);
/* 3740 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ6(Player p, int NumberZ) {
/* 3743 */     int x = p.getLocation().getBlockX();
/* 3744 */     int y = p.getLocation().getBlockY();
/* 3745 */     int z = p.getLocation().getBlockZ();
/* 3746 */     Location l = new Location(p.getWorld(), x + 6, y + 105, z + NumberZ + 6);
/* 3747 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetZ7(Player p, int NumberZ) {
/* 3750 */     int x = p.getLocation().getBlockX();
/* 3751 */     int y = p.getLocation().getBlockY();
/* 3752 */     int z = p.getLocation().getBlockZ();
/* 3753 */     Location l = new Location(p.getWorld(), x + 7, y + 105, z + NumberZ + 7);
/* 3754 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetBZ1(Player p, int NumberZ) {
/* 3757 */     int x = p.getLocation().getBlockX();
/* 3758 */     int y = p.getLocation().getBlockY();
/* 3759 */     int z = p.getLocation().getBlockZ();
/* 3760 */     Location l = new Location(p.getWorld(), x - 1, y + 105, z + NumberZ + 1);
/* 3761 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetBZ2(Player p, int NumberZ) {
/* 3764 */     int x = p.getLocation().getBlockX();
/* 3765 */     int y = p.getLocation().getBlockY();
/* 3766 */     int z = p.getLocation().getBlockZ();
/* 3767 */     Location l = new Location(p.getWorld(), x - 2, y + 105, z + NumberZ + 2);
/* 3768 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetBZ3(Player p, int NumberZ) {
/* 3771 */     int x = p.getLocation().getBlockX();
/* 3772 */     int y = p.getLocation().getBlockY();
/* 3773 */     int z = p.getLocation().getBlockZ();
/* 3774 */     Location l = new Location(p.getWorld(), x - 3, y + 105, z + NumberZ + 3);
/* 3775 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX1(Player p, int X) {
/* 3778 */     int x = p.getLocation().getBlockX();
/* 3779 */     int y = p.getLocation().getBlockY();
/* 3780 */     int z = p.getLocation().getBlockZ();
/* 3781 */     Location l = new Location(p.getWorld(), x + X + 1, y + 105, z + 1);
/* 3782 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX2(Player p, int X) {
/* 3785 */     int x = p.getLocation().getBlockX();
/* 3786 */     int y = p.getLocation().getBlockY();
/* 3787 */     int z = p.getLocation().getBlockZ();
/* 3788 */     Location l = new Location(p.getWorld(), x + X + 2, y + 105, z + 2);
/* 3789 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX3(Player p, int X) {
/* 3792 */     int x = p.getLocation().getBlockX();
/* 3793 */     int y = p.getLocation().getBlockY();
/* 3794 */     int z = p.getLocation().getBlockZ();
/* 3795 */     Location l = new Location(p.getWorld(), x + X + 3, y + 105, z + 3);
/* 3796 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX4(Player p, int X) {
/* 3799 */     int x = p.getLocation().getBlockX();
/* 3800 */     int y = p.getLocation().getBlockY();
/* 3801 */     int z = p.getLocation().getBlockZ();
/* 3802 */     Location l = new Location(p.getWorld(), x + X + 4, y + 105, z + 4);
/* 3803 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX5(Player p, int X) {
/* 3806 */     int x = p.getLocation().getBlockX();
/* 3807 */     int y = p.getLocation().getBlockY();
/* 3808 */     int z = p.getLocation().getBlockZ();
/* 3809 */     Location l = new Location(p.getWorld(), x + X + 5, y + 105, z + 5);
/* 3810 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX6(Player p, int X) {
/* 3813 */     int x = p.getLocation().getBlockX();
/* 3814 */     int y = p.getLocation().getBlockY();
/* 3815 */     int z = p.getLocation().getBlockZ();
/* 3816 */     Location l = new Location(p.getWorld(), x + X + 6, y + 105, z + 6);
/* 3817 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void arsetX7(Player p, int X) {
/* 3820 */     int x = p.getLocation().getBlockX();
/* 3821 */     int y = p.getLocation().getBlockY();
/* 3822 */     int z = p.getLocation().getBlockZ();
/* 3823 */     Location l = new Location(p.getWorld(), x + X + 7, y + 105, z + 7);
/* 3824 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rarsetBX1(Player p, int X) {
/* 3827 */     int x = p.getLocation().getBlockX();
/* 3828 */     int y = p.getLocation().getBlockY();
/* 3829 */     int z = p.getLocation().getBlockZ();
/* 3830 */     Location l = new Location(p.getWorld(), x + X + 1, y + 105, z - 1);
/* 3831 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rarsetBX2(Player p, int X) {
/* 3834 */     int x = p.getLocation().getBlockX();
/* 3835 */     int y = p.getLocation().getBlockY();
/* 3836 */     int z = p.getLocation().getBlockZ();
/* 3837 */     Location l = new Location(p.getWorld(), x + X + 2, y + 105, z - 2);
/* 3838 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rarsetBX3(Player p, int X) {
/* 3841 */     int x = p.getLocation().getBlockX();
/* 3842 */     int y = p.getLocation().getBlockY();
/* 3843 */     int z = p.getLocation().getBlockZ();
/* 3844 */     Location l = new Location(p.getWorld(), x + X + 3, y + 105, z - 3);
/* 3845 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rarsetBX4(Player p, int X) {
/* 3848 */     int x = p.getLocation().getBlockX();
/* 3849 */     int y = p.getLocation().getBlockY();
/* 3850 */     int z = p.getLocation().getBlockZ();
/* 3851 */     Location l = new Location(p.getWorld(), x + X + 4, y + 105, z - 4);
/* 3852 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rarsetBX5(Player p, int X) {
/* 3855 */     int x = p.getLocation().getBlockX();
/* 3856 */     int y = p.getLocation().getBlockY();
/* 3857 */     int z = p.getLocation().getBlockZ();
/* 3858 */     Location l = new Location(p.getWorld(), x + X + 5, y + 105, z - 5);
/* 3859 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rarsetBX6(Player p, int X) {
/* 3862 */     int x = p.getLocation().getBlockX();
/* 3863 */     int y = p.getLocation().getBlockY();
/* 3864 */     int z = p.getLocation().getBlockZ();
/* 3865 */     Location l = new Location(p.getWorld(), x + X + 6, y + 105, z - 6);
/* 3866 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rarsetBX7(Player p, int X) {
/* 3869 */     int x = p.getLocation().getBlockX();
/* 3870 */     int y = p.getLocation().getBlockY();
/* 3871 */     int z = p.getLocation().getBlockZ();
/* 3872 */     Location l = new Location(p.getWorld(), x + X + 7, y + 105, z - 7);
/* 3873 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void ra(Player p, int Test) {
/* 3876 */     int x = p.getLocation().getBlockX();
/* 3877 */     int y = p.getLocation().getBlockY();
/* 3878 */     int z = p.getLocation().getBlockZ();
/* 3879 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + Test, z);
/* 3880 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rb(Player p, int one) {
/* 3883 */     int x = p.getLocation().getBlockX();
/* 3884 */     int y = p.getLocation().getBlockY();
/* 3885 */     int z = p.getLocation().getBlockZ();
/* 3886 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z - 8);
/* 3887 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rbb(Player p, int one) {
/* 3890 */     int x = p.getLocation().getBlockX();
/* 3891 */     int y = p.getLocation().getBlockY();
/* 3892 */     int z = p.getLocation().getBlockZ();
/* 3893 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 7);
/* 3894 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rs(Player p, int one) {
/* 3897 */     int x = p.getLocation().getBlockX();
/* 3898 */     int y = p.getLocation().getBlockY();
/* 3899 */     int z = p.getLocation().getBlockZ();
/* 3900 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z - 7);
/* 3901 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rss(Player p, int one) {
/* 3904 */     int x = p.getLocation().getBlockX();
/* 3905 */     int y = p.getLocation().getBlockY();
/* 3906 */     int z = p.getLocation().getBlockZ();
/* 3907 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z - 8);
/* 3908 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rc(Player p, int one) {
/* 3911 */     int x = p.getLocation().getBlockX();
/* 3912 */     int y = p.getLocation().getBlockY();
/* 3913 */     int z = p.getLocation().getBlockZ();
/* 3914 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z + 7);
/* 3915 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rcc(Player p, int one) {
/* 3918 */     int x = p.getLocation().getBlockX();
/* 3919 */     int y = p.getLocation().getBlockY();
/* 3920 */     int z = p.getLocation().getBlockZ();
/* 3921 */     Location l = new Location(p.getWorld(), x + 7, y + 100 + one, z + 8);
/* 3922 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rd(Player p, int one) {
/* 3925 */     int x = p.getLocation().getBlockX();
/* 3926 */     int y = p.getLocation().getBlockY();
/* 3927 */     int z = p.getLocation().getBlockZ();
/* 3928 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 7);
/* 3929 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void rdd(Player p, int one) {
/* 3932 */     int x = p.getLocation().getBlockX();
/* 3933 */     int y = p.getLocation().getBlockY();
/* 3934 */     int z = p.getLocation().getBlockZ();
/* 3935 */     Location l = new Location(p.getWorld(), x + 7, y + 100 + one, z - 8);
/* 3936 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void re(Player p, int one) {
/* 3939 */     int x = p.getLocation().getBlockX();
/* 3940 */     int y = p.getLocation().getBlockY();
/* 3941 */     int z = p.getLocation().getBlockZ();
/* 3942 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z + 8);
/* 3943 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void ree(Player p, int one) {
/* 3946 */     int x = p.getLocation().getBlockX();
/* 3947 */     int y = p.getLocation().getBlockY();
/* 3948 */     int z = p.getLocation().getBlockZ();
/* 3949 */     Location l = new Location(p.getWorld(), x + 8, y + 100 + one, z - 7);
/* 3950 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void raa(Player p, int one) {
/* 3953 */     int x = p.getLocation().getBlockX();
/* 3954 */     int y = p.getLocation().getBlockY();
/* 3955 */     int z = p.getLocation().getBlockZ();
/* 3956 */     Location l = new Location(p.getWorld(), x - 7, y + 100 + one, z - 8);
/* 3957 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void raaa(Player p, int one) {
/* 3960 */     int x = p.getLocation().getBlockX();
/* 3961 */     int y = p.getLocation().getBlockY();
/* 3962 */     int z = p.getLocation().getBlockZ();
/* 3963 */     Location l = new Location(p.getWorld(), x - 8, y + 100 + one, z + 7);
/* 3964 */     Block block = l.getBlock(); block.setType(Material.AIR);
/*      */   }
/*      */   public static void DeleteGladiatorArena(Player p) {
/* 3967 */     int x = p.getLocation().getBlockX();
/* 3968 */     int y = p.getLocation().getBlockY();
/* 3969 */     int z = p.getLocation().getBlockZ();
/* 3970 */     Location endBlock1 = new Location(p.getWorld(), x, y + 100, z);
/* 3971 */     Location endBlock2 = new Location(p.getWorld(), x, y + 105, z);
/* 3972 */     Location a = new Location(p.getWorld(), x + 7, y + 101, z);
/* 3973 */     Location b = new Location(p.getWorld(), x + 7, y + 102, z);
/* 3974 */     Location c = new Location(p.getWorld(), x + 7, y + 103, z);
/* 3975 */     Location ct = new Location(p.getWorld(), x + 7, y + 104, z);
/* 3976 */     Location d = new Location(p.getWorld(), x + 7, y + 105, z);
/* 3977 */     a.getBlock().setType(Material.AIR);
/* 3978 */     ct.getBlock().setType(Material.AIR);
/* 3979 */     b.getBlock().setType(Material.AIR);
/* 3980 */     c.getBlock().setType(Material.AIR);
/* 3981 */     d.getBlock().setType(Material.AIR);
/* 3982 */     endBlock1.getBlock().setType(Material.AIR);
/* 3983 */     endBlock2.getBlock().setType(Material.AIR);
/* 3984 */     rsetBZ1(p, 1);
/* 3985 */     rsetBZ2(p, 1);
/* 3986 */     rsetBZ3(p, 1);
/* 3987 */     rsetBZ1(p, -1);
/* 3988 */     rsetBZ2(p, -1);
/* 3989 */     rsetBZ3(p, -1);
/* 3990 */     rsetZ1(p, 1);
/* 3991 */     rsetZ2(p, 1);
/* 3992 */     rsetZ3(p, 1);
/* 3993 */     rsetZ1(p, -1);
/* 3994 */     rsetZ2(p, -1);
/* 3995 */     rsetZ3(p, -1);
/*      */ 
/* 3997 */     rsetBZ1(p, 2);
/* 3998 */     rsetBZ2(p, 2);
/* 3999 */     rsetBZ3(p, 2);
/* 4000 */     rsetBZ1(p, -2);
/* 4001 */     rsetBZ2(p, -2);
/* 4002 */     rsetBZ3(p, -2);
/* 4003 */     rsetZ1(p, 2);
/* 4004 */     rsetZ2(p, 2);
/* 4005 */     rsetZ3(p, 2);
/* 4006 */     rsetZ1(p, -2);
/* 4007 */     rsetZ2(p, -2);
/* 4008 */     rsetZ3(p, -2);
/*      */ 
/* 4010 */     rsetBZ1(p, 3);
/* 4011 */     rsetBZ2(p, 3);
/* 4012 */     rsetBZ3(p, 3);
/* 4013 */     rsetBZ1(p, -3);
/* 4014 */     rsetBZ2(p, -3);
/* 4015 */     rsetBZ3(p, -3);
/* 4016 */     rsetZ1(p, 3);
/* 4017 */     rsetZ2(p, 3);
/* 4018 */     rsetZ3(p, 3);
/* 4019 */     rsetZ1(p, -3);
/* 4020 */     rsetZ2(p, -3);
/* 4021 */     rsetZ3(p, -3);
/*      */ 
/* 4023 */     rsetBZ1(p, 4);
/* 4024 */     rsetBZ2(p, 4);
/* 4025 */     rsetBZ3(p, 4);
/* 4026 */     rsetBZ1(p, -4);
/* 4027 */     rsetBZ2(p, -4);
/* 4028 */     rsetBZ3(p, -4);
/* 4029 */     rsetBZ3(p, -5);
/* 4030 */     rsetBZ3(p, -6);
/* 4031 */     rsetBZ3(p, -7);
/* 4032 */     rsetBZ3(p, -8);
/* 4033 */     rsetBZ3(p, -9);
/* 4034 */     rsetBZ3(p, -10);
/* 4035 */     rsetZ1(p, 4);
/* 4036 */     rsetZ2(p, 4);
/* 4037 */     rsetZ3(p, 4);
/* 4038 */     rsetZ1(p, -4);
/* 4039 */     rsetZ2(p, -4);
/* 4040 */     rsetZ3(p, -4);
/*      */ 
/* 4042 */     rsetBZ1(p, 5);
/* 4043 */     rsetBZ2(p, 5);
/* 4044 */     rsetBZ1(p, -5);
/* 4045 */     rsetBZ2(p, -5);
/* 4046 */     rsetBZ2(p, -6);
/* 4047 */     rsetBZ2(p, -7);
/* 4048 */     rsetBZ2(p, -8);
/* 4049 */     rsetBZ2(p, -9);
/* 4050 */     rsetZ1(p, 5);
/* 4051 */     rsetZ2(p, 5);
/* 4052 */     rsetZ1(p, -5);
/* 4053 */     rsetZ2(p, -5);
/* 4054 */     rsetZ3(p, -5);
/*      */ 
/* 4056 */     rsetZ1(p, 6);
/* 4057 */     rsetZ1(p, -6);
/* 4058 */     rsetBZ1(p, 6);
/* 4059 */     rsetBZ1(p, -7);
/* 4060 */     rsetBZ1(p, -6);
/* 4061 */     rsetBZ1(p, -8);
/* 4062 */     rsetZ2(p, -6);
/* 4063 */     rsetZ3(p, -6);
/*      */ 
/* 4065 */     rsetZ1(p, -7);
/* 4066 */     rsetZ1(p, -8);
/* 4067 */     rsetZ2(p, -7);
/* 4068 */     rsetZ2(p, -8);
/* 4069 */     rsetZ2(p, -9);
/* 4070 */     rsetZ3(p, -7);
/* 4071 */     rsetZ3(p, -8);
/* 4072 */     rsetZ3(p, -9);
/* 4073 */     rsetZ3(p, -10);
/*      */ 
/* 4075 */     rsetZ4(p, 1);
/* 4076 */     rsetZ4(p, 2);
/* 4077 */     rsetZ4(p, 3);
/* 4078 */     rsetZ4(p, -1);
/* 4079 */     rsetZ4(p, -2);
/* 4080 */     rsetZ4(p, -3);
/* 4081 */     rsetZ4(p, -4);
/* 4082 */     rsetZ4(p, -5);
/* 4083 */     rsetZ4(p, -6);
/* 4084 */     rsetZ4(p, -7);
/* 4085 */     rsetZ4(p, -8);
/* 4086 */     rsetZ4(p, -9);
/* 4087 */     rsetZ4(p, -10);
/* 4088 */     rsetZ4(p, -11);
/* 4089 */     rsetZ5(p, 1);
/* 4090 */     rsetZ5(p, 2);
/* 4091 */     rsetZ5(p, -1);
/* 4092 */     rsetZ5(p, -2);
/* 4093 */     rsetZ5(p, -3);
/* 4094 */     rsetZ5(p, -4);
/* 4095 */     rsetZ5(p, -5);
/* 4096 */     rsetZ5(p, -6);
/* 4097 */     rsetZ5(p, -7);
/* 4098 */     rsetZ5(p, -8);
/* 4099 */     rsetZ5(p, -9);
/* 4100 */     rsetZ5(p, -10);
/* 4101 */     rsetZ5(p, -11);
/* 4102 */     rsetZ5(p, -12);
/* 4103 */     rsetZ6(p, -1);
/* 4104 */     rsetZ6(p, -2);
/* 4105 */     rsetZ6(p, -3);
/* 4106 */     rsetZ6(p, -4);
/* 4107 */     rsetZ6(p, -5);
/* 4108 */     rsetZ6(p, -6);
/* 4109 */     rsetZ6(p, -7);
/* 4110 */     rsetZ6(p, -8);
/* 4111 */     rsetZ6(p, -9);
/* 4112 */     rsetZ6(p, -10);
/* 4113 */     rsetZ6(p, -11);
/* 4114 */     rsetZ6(p, -12);
/* 4115 */     rsetZ6(p, -13);
/* 4116 */     rsetZ5(p, -1);
/* 4117 */     rsetZ5(p, -2);
/* 4118 */     rsetZ5(p, -3);
/* 4119 */     rsetZ5(p, -4);
/* 4120 */     rsetZ5(p, -5);
/* 4121 */     rsetZ5(p, -6);
/* 4122 */     rsetZ5(p, -7);
/* 4123 */     rsetZ5(p, -8);
/* 4124 */     rsetZ5(p, -9);
/* 4125 */     rsetZ5(p, -10);
/* 4126 */     rsetZ5(p, -11);
/* 4127 */     rsetZ5(p, -12);
/* 4128 */     rsetZ7(p, -1);
/* 4129 */     rsetZ7(p, -2);
/* 4130 */     rsetZ7(p, -3);
/* 4131 */     rsetZ7(p, -4);
/* 4132 */     rsetZ7(p, -5);
/* 4133 */     rsetZ7(p, -6);
/* 4134 */     rsetZ7(p, -7);
/* 4135 */     rsetZ7(p, -8);
/* 4136 */     rsetZ7(p, -9);
/* 4137 */     rsetZ7(p, -10);
/* 4138 */     rsetZ7(p, -11);
/* 4139 */     rsetZ7(p, -12);
/* 4140 */     rsetZ7(p, -13);
/* 4141 */     rsetZ7(p, -14);
/*      */ 
/* 4143 */     rsetX1(p, -1);
/* 4144 */     rsetX1(p, -2);
/* 4145 */     rsetX1(p, -3);
/* 4146 */     rsetX1(p, -4);
/* 4147 */     rsetX1(p, -5);
/* 4148 */     rsetX1(p, -6);
/* 4149 */     rsetX1(p, -7);
/* 4150 */     rsetX1(p, -8);
/* 4151 */     rsetX2(p, -1);
/* 4152 */     rsetX2(p, -2);
/* 4153 */     rsetX2(p, -3);
/* 4154 */     rsetX2(p, -4);
/* 4155 */     rsetX2(p, -5);
/* 4156 */     rsetX2(p, -6);
/* 4157 */     rsetX2(p, -7);
/* 4158 */     rsetX2(p, -8);
/* 4159 */     rsetX2(p, -9);
/* 4160 */     rsetX3(p, -1);
/* 4161 */     rsetX3(p, -2);
/* 4162 */     rsetX3(p, -3);
/* 4163 */     rsetX3(p, -4);
/* 4164 */     rsetX3(p, -5);
/* 4165 */     rsetX3(p, -6);
/* 4166 */     rsetX3(p, -7);
/* 4167 */     rsetX3(p, -8);
/* 4168 */     rsetX3(p, -9);
/* 4169 */     rsetX3(p, -10);
/* 4170 */     rsetX4(p, -1);
/* 4171 */     rsetX4(p, -2);
/* 4172 */     rsetX4(p, -3);
/* 4173 */     rsetX4(p, -4);
/* 4174 */     rsetX4(p, -5);
/* 4175 */     rsetX4(p, -6);
/* 4176 */     rsetX4(p, -7);
/* 4177 */     rsetX4(p, -8);
/* 4178 */     rsetX4(p, -9);
/* 4179 */     rsetX4(p, -10);
/* 4180 */     rsetX4(p, -11);
/* 4181 */     rsetX5(p, -1);
/* 4182 */     rsetX5(p, -2);
/* 4183 */     rsetX5(p, -3);
/* 4184 */     rsetX5(p, -4);
/* 4185 */     rsetX5(p, -5);
/* 4186 */     rsetX5(p, -6);
/* 4187 */     rsetX5(p, -7);
/* 4188 */     rsetX5(p, -8);
/* 4189 */     rsetX5(p, -9);
/* 4190 */     rsetX5(p, -10);
/* 4191 */     rsetX5(p, -11);
/* 4192 */     rsetX5(p, -12);
/* 4193 */     rsetX6(p, -1);
/* 4194 */     rsetX6(p, -2);
/* 4195 */     rsetX6(p, -3);
/* 4196 */     rsetX6(p, -4);
/* 4197 */     rsetX6(p, -5);
/* 4198 */     rsetX6(p, -6);
/* 4199 */     rsetX6(p, -7);
/* 4200 */     rsetX6(p, -8);
/* 4201 */     rsetX6(p, -9);
/* 4202 */     rsetX6(p, -10);
/* 4203 */     rsetX6(p, -11);
/* 4204 */     rsetX6(p, -12);
/* 4205 */     rsetX6(p, -13);
/* 4206 */     rsetX7(p, -1);
/* 4207 */     rsetX7(p, -2);
/* 4208 */     rsetX7(p, -3);
/* 4209 */     rsetX7(p, -4);
/* 4210 */     rsetX7(p, -5);
/* 4211 */     rsetX7(p, -6);
/* 4212 */     rsetX7(p, -7);
/* 4213 */     rsetX7(p, -8);
/* 4214 */     rsetX7(p, -9);
/* 4215 */     rsetX7(p, -10);
/* 4216 */     rsetX7(p, -11);
/* 4217 */     rsetX7(p, -12);
/* 4218 */     rsetX7(p, -13);
/* 4219 */     rsetBX1(p, -1);
/* 4220 */     rsetBX1(p, -2);
/* 4221 */     rsetBX1(p, -3);
/* 4222 */     rsetBX1(p, -4);
/* 4223 */     rsetBX1(p, -5);
/* 4224 */     rsetBX1(p, -6);
/* 4225 */     rsetBX1(p, -7);
/* 4226 */     rsetBX1(p, -8);
/* 4227 */     rsetBX2(p, -1);
/* 4228 */     rsetBX2(p, -2);
/* 4229 */     rsetBX2(p, -3);
/* 4230 */     rsetBX2(p, -4);
/* 4231 */     rsetBX2(p, -5);
/* 4232 */     rsetBX2(p, -6);
/* 4233 */     rsetBX2(p, -7);
/* 4234 */     rsetBX2(p, -8);
/* 4235 */     rsetBX2(p, -9);
/* 4236 */     rsetBX3(p, -1);
/* 4237 */     rsetBX3(p, -2);
/* 4238 */     rsetBX3(p, -3);
/* 4239 */     rsetBX3(p, -4);
/* 4240 */     rsetBX3(p, -5);
/* 4241 */     rsetBX3(p, -6);
/* 4242 */     rsetBX3(p, -7);
/* 4243 */     rsetBX3(p, -8);
/* 4244 */     rsetBX3(p, -9);
/* 4245 */     rsetBX3(p, -10);
/*      */ 
/* 4247 */     rsetBX4(p, -1);
/* 4248 */     rsetBX4(p, -2);
/* 4249 */     rsetBX4(p, -3);
/* 4250 */     rsetBX4(p, -4);
/* 4251 */     rsetBX4(p, -5);
/* 4252 */     rsetBX4(p, -6);
/* 4253 */     rsetBX4(p, -7);
/* 4254 */     rsetBX4(p, -8);
/* 4255 */     rsetBX4(p, -9);
/* 4256 */     rsetBX4(p, -10);
/* 4257 */     rsetBX4(p, -11);
/*      */ 
/* 4259 */     rsetBX5(p, -1);
/* 4260 */     rsetBX5(p, -2);
/* 4261 */     rsetBX5(p, -3);
/* 4262 */     rsetBX5(p, -4);
/* 4263 */     rsetBX5(p, -5);
/* 4264 */     rsetBX5(p, -6);
/* 4265 */     rsetBX5(p, -7);
/* 4266 */     rsetBX5(p, -8);
/* 4267 */     rsetBX5(p, -9);
/* 4268 */     rsetBX5(p, -10);
/* 4269 */     rsetBX5(p, -11);
/* 4270 */     rsetBX5(p, -12);
/*      */ 
/* 4272 */     rsetBX6(p, -1);
/* 4273 */     rsetBX6(p, -2);
/* 4274 */     rsetBX6(p, -3);
/* 4275 */     rsetBX6(p, -4);
/* 4276 */     rsetBX6(p, -5);
/* 4277 */     rsetBX6(p, -6);
/* 4278 */     rsetBX6(p, -7);
/* 4279 */     rsetBX6(p, -8);
/* 4280 */     rsetBX6(p, -9);
/* 4281 */     rsetBX6(p, -10);
/* 4282 */     rsetBX6(p, -11);
/* 4283 */     rsetBX6(p, -12);
/* 4284 */     rsetBX6(p, -13);
/*      */ 
/* 4286 */     rsetBX7(p, -1);
/* 4287 */     rsetBX7(p, -2);
/* 4288 */     rsetBX7(p, -3);
/* 4289 */     rsetBX7(p, -4);
/* 4290 */     rsetBX7(p, -5);
/* 4291 */     rsetBX7(p, -6);
/* 4292 */     rsetBX7(p, -7);
/* 4293 */     rsetBX7(p, -8);
/* 4294 */     rsetBX7(p, -9);
/* 4295 */     rsetBX7(p, -10);
/* 4296 */     rsetBX7(p, -11);
/* 4297 */     rsetBX7(p, -12);
/* 4298 */     rsetBX7(p, -13);
/* 4299 */     rsetBX7(p, -14);
/*      */ 
/* 4301 */     rsetWall1(p, 1);
/* 4302 */     rsetWall1(p, 2);
/* 4303 */     rsetWall1(p, 3);
/* 4304 */     rsetWall1(p, 4);
/* 4305 */     rsetWall2(p, 1);
/* 4306 */     rsetWall2(p, 2);
/* 4307 */     rsetWall2(p, 3);
/* 4308 */     rsetWall2(p, 4);
/* 4309 */     rsetWall3(p, 1);
/* 4310 */     rsetWall3(p, 2);
/* 4311 */     rsetWall3(p, 3);
/* 4312 */     rsetWall3(p, 4);
/* 4313 */     rsetWall4(p, 1);
/* 4314 */     rsetWall4(p, 2);
/* 4315 */     rsetWall4(p, 3);
/* 4316 */     rsetWall4(p, 4);
/*      */ 
/* 4318 */     rset1(p, 1);
/* 4319 */     rset1(p, 2);
/* 4320 */     rset1(p, 3);
/* 4321 */     rset1(p, 4);
/* 4322 */     rset2(p, 1);
/* 4323 */     rset2(p, 2);
/* 4324 */     rset2(p, 3);
/* 4325 */     rset2(p, 4);
/* 4326 */     rset3(p, 1);
/* 4327 */     rset3(p, 2);
/* 4328 */     rset3(p, 3);
/* 4329 */     rset3(p, 4);
/* 4330 */     rset4(p, 1);
/* 4331 */     rset4(p, 2);
/* 4332 */     rset4(p, 3);
/* 4333 */     rset4(p, 4);
/* 4334 */     rseta1(p, 1);
/* 4335 */     rseta1(p, 2);
/* 4336 */     rseta1(p, 3);
/* 4337 */     rseta1(p, 4);
/* 4338 */     rseta2(p, 1);
/* 4339 */     rseta2(p, 2);
/* 4340 */     rseta2(p, 3);
/* 4341 */     rseta2(p, 4);
/* 4342 */     rseta3(p, 1);
/* 4343 */     rseta3(p, 2);
/* 4344 */     rseta3(p, 3);
/* 4345 */     rseta3(p, 4);
/* 4346 */     rseta4(p, 1);
/* 4347 */     rseta4(p, 2);
/* 4348 */     rseta4(p, 3);
/* 4349 */     rseta4(p, 4);
/* 4350 */     rsetaa4(p, 1);
/* 4351 */     rsetaa4(p, 2);
/* 4352 */     rsetaa4(p, 3);
/* 4353 */     rsetaa4(p, 4);
/* 4354 */     rsetaaa4(p, 1);
/* 4355 */     rsetaaa4(p, 2);
/* 4356 */     rsetaaa4(p, 3);
/* 4357 */     rsetaaa4(p, 4);
/* 4358 */     rsetaaaa4(p, 1);
/* 4359 */     rsetaaaa4(p, 2);
/* 4360 */     rsetaaaa4(p, 3);
/* 4361 */     rsetaaaa4(p, 4);
/* 4362 */     rseta5(p, 1);
/* 4363 */     rseta5(p, 2);
/* 4364 */     rseta5(p, 3);
/* 4365 */     rseta5(p, 4);
/* 4366 */     rsetaa5(p, 1);
/* 4367 */     rsetaa5(p, 2);
/* 4368 */     rsetaa5(p, 3);
/* 4369 */     rsetaa5(p, 4);
/* 4370 */     rsetaaa5(p, 1);
/* 4371 */     rsetaaa5(p, 2);
/* 4372 */     rsetaaa5(p, 3);
/* 4373 */     rsetaaa5(p, 4);
/* 4374 */     rsetaaaa5(p, 1);
/* 4375 */     rsetaaaa5(p, 2);
/* 4376 */     rsetaaaa5(p, 3);
/* 4377 */     rsetaaaa5(p, 4);
/* 4378 */     rsetaa6(p, 1);
/* 4379 */     rsetaa6(p, 2);
/* 4380 */     rsetaa6(p, 3);
/* 4381 */     rsetaa6(p, 4);
/* 4382 */     rsetaaa6(p, 1);
/* 4383 */     rsetaaa6(p, 2);
/* 4384 */     rsetaaa6(p, 3);
/* 4385 */     rsetaaa6(p, 4);
/* 4386 */     rsetaaaa6(p, 1);
/* 4387 */     rsetaaaa6(p, 2);
/* 4388 */     rsetaaaa6(p, 3);
/* 4389 */     rsetaaaa6(p, 4);
/*      */ 
/* 4391 */     rsetb1(p, 1);
/* 4392 */     rsetb1(p, 2);
/* 4393 */     rsetb1(p, 3);
/* 4394 */     rsetb1(p, 4);
/* 4395 */     rsetbb1(p, 1);
/* 4396 */     rsetbb1(p, 2);
/* 4397 */     rsetbb1(p, 3);
/* 4398 */     rsetbb1(p, 4);
/* 4399 */     rsetbb1(p, 1);
/* 4400 */     rsetbbb1(p, 1);
/* 4401 */     rsetbbb1(p, 2);
/* 4402 */     rsetbbb1(p, 3);
/* 4403 */     rsetbbb1(p, 4);
/* 4404 */     rsetbbbb1(p, 1);
/* 4405 */     rsetbbbb1(p, 2);
/* 4406 */     rsetbbbb1(p, 3);
/* 4407 */     rsetbbbb1(p, 4);
/* 4408 */     rsetb2(p, 1);
/* 4409 */     rsetb2(p, 2);
/* 4410 */     rsetb2(p, 3);
/* 4411 */     rsetb2(p, 4);
/* 4412 */     rsetbb2(p, 1);
/* 4413 */     rsetbb2(p, 2);
/* 4414 */     rsetbb2(p, 3);
/* 4415 */     rsetbb2(p, 4);
/* 4416 */     rsetbbb2(p, 1);
/* 4417 */     rsetbbb2(p, 2);
/* 4418 */     rsetbbb2(p, 3);
/* 4419 */     rsetbbb2(p, 4);
/* 4420 */     rsetbbbb2(p, 1);
/* 4421 */     rsetbbbb2(p, 2);
/* 4422 */     rsetbbbb2(p, 3);
/* 4423 */     rsetbbbb2(p, 4);
/* 4424 */     rsetb3(p, 1);
/* 4425 */     rsetb3(p, 2);
/* 4426 */     rsetb3(p, 3);
/* 4427 */     rsetb3(p, 4);
/* 4428 */     rsetbb3(p, 1);
/* 4429 */     rsetbb3(p, 2);
/* 4430 */     rsetbb3(p, 3);
/* 4431 */     rsetbb3(p, 4);
/* 4432 */     rsetbbb3(p, 1);
/* 4433 */     rsetbbb3(p, 2);
/* 4434 */     rsetbbb3(p, 3);
/* 4435 */     rsetbbb3(p, 4);
/*      */ 
/* 4437 */     rsetaa2(p, 1);
/* 4438 */     rsetaa2(p, 2);
/* 4439 */     rsetaa2(p, 3);
/* 4440 */     rsetaa2(p, 4);
/* 4441 */     rsetaaa2(p, 1);
/* 4442 */     rsetaaa2(p, 2);
/* 4443 */     rsetaaa2(p, 3);
/* 4444 */     rsetaaa2(p, 4);
/* 4445 */     rsetaaaa2(p, 1);
/* 4446 */     rsetaaaa2(p, 2);
/* 4447 */     rsetaaaa2(p, 3);
/* 4448 */     rsetaaaa2(p, 4);
/* 4449 */     rsetab2(p, 1);
/* 4450 */     rsetab2(p, 2);
/* 4451 */     rsetab2(p, 3);
/* 4452 */     rsetab2(p, 4);
/* 4453 */     rsetabb2(p, 1);
/* 4454 */     rsetabb2(p, 2);
/* 4455 */     rsetabb2(p, 3);
/* 4456 */     rsetabb2(p, 4);
/* 4457 */     rsetabbb2(p, 1);
/* 4458 */     rsetabbb2(p, 2);
/* 4459 */     rsetabbb2(p, 3);
/* 4460 */     rsetabbb2(p, 4);
/* 4461 */     rsetac2(p, 1);
/* 4462 */     rsetac2(p, 2);
/* 4463 */     rsetac2(p, 3);
/* 4464 */     rsetac2(p, 4);
/* 4465 */     rsetacc2(p, 1);
/* 4466 */     rsetacc2(p, 2);
/* 4467 */     rsetacc2(p, 3);
/* 4468 */     rsetacc2(p, 4);
/* 4469 */     rsetaccc2(p, 1);
/* 4470 */     rsetaccc2(p, 2);
/* 4471 */     rsetaccc2(p, 3);
/* 4472 */     rsetaccc2(p, 4);
/* 4473 */     rsetac3(p, 1);
/* 4474 */     rsetac3(p, 2);
/* 4475 */     rsetac3(p, 3);
/* 4476 */     rsetac3(p, 4);
/* 4477 */     rsetacc3(p, 1);
/* 4478 */     rsetacc3(p, 2);
/* 4479 */     rsetacc3(p, 3);
/* 4480 */     rsetacc3(p, 4);
/*      */ 
/* 4483 */     rsetc2(p, 1);
/* 4484 */     rsetc2(p, 2);
/* 4485 */     rsetc2(p, 3);
/* 4486 */     rsetc2(p, 4);
/* 4487 */     rsetc3(p, 1);
/* 4488 */     rsetc3(p, 2);
/* 4489 */     rsetc3(p, 3);
/* 4490 */     rsetc3(p, 4);
/* 4491 */     rsetc4(p, 1);
/* 4492 */     rsetc4(p, 2);
/* 4493 */     rsetc4(p, 3);
/* 4494 */     rsetc4(p, 4);
/* 4495 */     rsetc5(p, 1);
/* 4496 */     rsetc5(p, 2);
/* 4497 */     rsetc5(p, 3);
/* 4498 */     rsetc5(p, 4);
/* 4499 */     rsetc6(p, 1);
/* 4500 */     rsetc6(p, 2);
/* 4501 */     rsetc6(p, 3);
/* 4502 */     rsetc6(p, 4);
/* 4503 */     rsetc7(p, 1);
/* 4504 */     rsetc7(p, 2);
/* 4505 */     rsetc7(p, 3);
/* 4506 */     rsetc7(p, 4);
/*      */ 
/* 4508 */     rsetc8(p, 1);
/* 4509 */     rsetc8(p, 2);
/* 4510 */     rsetc8(p, 3);
/* 4511 */     rsetc8(p, 4);
/* 4512 */     rsetc9(p, 1);
/* 4513 */     rsetc9(p, 2);
/* 4514 */     rsetc9(p, 3);
/* 4515 */     rsetc9(p, 4);
/* 4516 */     rsetc10(p, 1);
/* 4517 */     rsetc10(p, 2);
/* 4518 */     rsetc10(p, 3);
/* 4519 */     rsetc10(p, 4);
/* 4520 */     rsetc11(p, 1);
/* 4521 */     rsetc11(p, 2);
/* 4522 */     rsetc11(p, 3);
/* 4523 */     rsetc11(p, 4);
/* 4524 */     rsetc12(p, 1);
/* 4525 */     rsetc12(p, 2);
/* 4526 */     rsetc12(p, 3);
/* 4527 */     rsetc12(p, 4);
/* 4528 */     rsetc13(p, 1);
/* 4529 */     rsetc13(p, 2);
/* 4530 */     rsetc13(p, 3);
/* 4531 */     rsetc13(p, 4);
/*      */ 
/* 4534 */     rsetBlock(p, 1, 1);
/* 4535 */     rsetBlock(p, 1, -1);
/* 4536 */     rsetBlock(p, -1, 1);
/* 4537 */     rsetBlock(p, -1, -1);
/* 4538 */     rsetZ(p, 1);
/* 4539 */     rsetZ(p, -1);
/* 4540 */     rsetX(p, 1);
/* 4541 */     rsetX(p, -1);
/*      */ 
/* 4543 */     rsetBlock(p, 2, 2);
/* 4544 */     rsetBlock(p, 2, -2);
/* 4545 */     rsetBlock(p, -2, 2);
/* 4546 */     rsetBlock(p, -2, -2);
/* 4547 */     rsetZ(p, 2);
/* 4548 */     rsetZ(p, -2);
/* 4549 */     rsetX(p, 2);
/* 4550 */     rsetX(p, -2);
/*      */ 
/* 4552 */     rsetBlock(p, 3, 3);
/* 4553 */     rsetBlock(p, 3, -3);
/* 4554 */     rsetBlock(p, -3, 3);
/* 4555 */     rsetBlock(p, -3, -3);
/* 4556 */     rsetZ(p, 3);
/* 4557 */     rsetZ(p, -3);
/* 4558 */     rsetX(p, 3);
/* 4559 */     rsetX(p, -3);
/*      */ 
/* 4561 */     rsetBlock(p, 4, 4);
/* 4562 */     rsetBlock(p, 4, -4);
/* 4563 */     rsetBlock(p, -4, 4);
/* 4564 */     rsetBlock(p, -4, -4);
/* 4565 */     rsetZ(p, 4);
/* 4566 */     rsetZ(p, -4);
/* 4567 */     rsetX(p, 4);
/* 4568 */     rsetX(p, -4);
/*      */ 
/* 4570 */     rsetBlock(p, 5, 5);
/* 4571 */     rsetBlock(p, 5, -5);
/* 4572 */     rsetBlock(p, -5, 5);
/* 4573 */     rsetBlock(p, -5, -5);
/* 4574 */     rsetZ(p, 5);
/* 4575 */     rsetZ(p, -5);
/* 4576 */     rsetX(p, 5);
/* 4577 */     rsetX(p, -5);
/*      */ 
/* 4579 */     rsetBlock(p, 6, 6);
/* 4580 */     rsetBlock(p, 6, -6);
/* 4581 */     rsetBlock(p, -6, 6);
/* 4582 */     rsetBlock(p, -6, -6);
/* 4583 */     rsetZ(p, 6);
/* 4584 */     rsetZ(p, -6);
/* 4585 */     rsetX(p, 6);
/* 4586 */     rsetX(p, -6);
/*      */ 
/* 4588 */     rsetBlock(p, 7, 7);
/* 4589 */     rsetBlock(p, 7, -7);
/* 4590 */     rsetBlock(p, -7, 7);
/* 4591 */     rsetBlock(p, -7, -7);
/* 4592 */     rsetZ(p, 7);
/* 4593 */     rsetZ(p, -7);
/* 4594 */     rsetX(p, 7);
/* 4595 */     rsetX(p, -7);
/*      */ 
/* 4597 */     arsetBZ1(p, 1);
/* 4598 */     arsetBZ2(p, 1);
/* 4599 */     arsetBZ3(p, 1);
/* 4600 */     arsetBZ1(p, -1);
/* 4601 */     arsetBZ2(p, -1);
/* 4602 */     arsetBZ3(p, -1);
/* 4603 */     arsetZ1(p, 1);
/* 4604 */     arsetZ2(p, 1);
/* 4605 */     arsetZ3(p, 1);
/* 4606 */     arsetZ1(p, -1);
/* 4607 */     arsetZ2(p, -1);
/* 4608 */     arsetZ3(p, -1);
/*      */ 
/* 4610 */     arsetBZ1(p, 2);
/* 4611 */     arsetBZ2(p, 2);
/* 4612 */     arsetBZ3(p, 2);
/* 4613 */     arsetBZ1(p, -2);
/* 4614 */     arsetBZ2(p, -2);
/* 4615 */     arsetBZ3(p, -2);
/* 4616 */     arsetZ1(p, 2);
/* 4617 */     arsetZ2(p, 2);
/* 4618 */     arsetZ3(p, 2);
/* 4619 */     arsetZ1(p, -2);
/* 4620 */     arsetZ2(p, -2);
/* 4621 */     arsetZ3(p, -2);
/*      */ 
/* 4623 */     arsetBZ1(p, 3);
/* 4624 */     arsetBZ2(p, 3);
/* 4625 */     arsetBZ3(p, 3);
/* 4626 */     arsetBZ1(p, -3);
/* 4627 */     arsetBZ2(p, -3);
/* 4628 */     arsetBZ3(p, -3);
/* 4629 */     arsetZ1(p, 3);
/* 4630 */     arsetZ2(p, 3);
/* 4631 */     arsetZ3(p, 3);
/* 4632 */     arsetZ1(p, -3);
/* 4633 */     arsetZ2(p, -3);
/* 4634 */     arsetZ3(p, -3);
/*      */ 
/* 4636 */     arsetBZ1(p, 4);
/* 4637 */     arsetBZ2(p, 4);
/* 4638 */     arsetBZ3(p, 4);
/* 4639 */     arsetBZ1(p, -4);
/* 4640 */     arsetBZ2(p, -4);
/* 4641 */     arsetBZ3(p, -4);
/* 4642 */     arsetBZ3(p, -5);
/* 4643 */     arsetBZ3(p, -6);
/* 4644 */     arsetBZ3(p, -7);
/* 4645 */     arsetBZ3(p, -8);
/* 4646 */     arsetBZ3(p, -9);
/* 4647 */     arsetBZ3(p, -10);
/* 4648 */     arsetZ1(p, 4);
/* 4649 */     arsetZ2(p, 4);
/* 4650 */     arsetZ3(p, 4);
/* 4651 */     arsetZ1(p, -4);
/* 4652 */     arsetZ2(p, -4);
/* 4653 */     arsetZ3(p, -4);
/*      */ 
/* 4655 */     arsetBZ1(p, 5);
/* 4656 */     arsetBZ2(p, 5);
/* 4657 */     arsetBZ1(p, -5);
/* 4658 */     arsetBZ2(p, -5);
/* 4659 */     arsetBZ2(p, -6);
/* 4660 */     arsetBZ2(p, -7);
/* 4661 */     arsetBZ2(p, -8);
/* 4662 */     arsetBZ2(p, -9);
/* 4663 */     arsetZ1(p, 5);
/* 4664 */     arsetZ2(p, 5);
/* 4665 */     arsetZ1(p, -5);
/* 4666 */     arsetZ2(p, -5);
/* 4667 */     arsetZ3(p, -5);
/*      */ 
/* 4669 */     arsetZ1(p, 6);
/* 4670 */     arsetZ1(p, -6);
/* 4671 */     arsetBZ1(p, 6);
/* 4672 */     arsetBZ1(p, -7);
/* 4673 */     arsetBZ1(p, -6);
/* 4674 */     arsetBZ1(p, -8);
/* 4675 */     arsetZ2(p, -6);
/* 4676 */     arsetZ3(p, -6);
/*      */ 
/* 4678 */     arsetZ1(p, -7);
/* 4679 */     arsetZ1(p, -8);
/* 4680 */     arsetZ2(p, -7);
/* 4681 */     arsetZ2(p, -8);
/* 4682 */     arsetZ2(p, -9);
/* 4683 */     arsetZ3(p, -7);
/* 4684 */     arsetZ3(p, -8);
/* 4685 */     arsetZ3(p, -9);
/* 4686 */     arsetZ3(p, -10);
/*      */ 
/* 4688 */     arsetZ4(p, 1);
/* 4689 */     arsetZ4(p, 2);
/* 4690 */     arsetZ4(p, 3);
/* 4691 */     arsetZ4(p, -1);
/* 4692 */     arsetZ4(p, -2);
/* 4693 */     arsetZ4(p, -3);
/* 4694 */     arsetZ4(p, -4);
/* 4695 */     arsetZ4(p, -5);
/* 4696 */     arsetZ4(p, -6);
/* 4697 */     arsetZ4(p, -7);
/* 4698 */     arsetZ4(p, -8);
/* 4699 */     arsetZ4(p, -9);
/* 4700 */     arsetZ4(p, -10);
/* 4701 */     arsetZ4(p, -11);
/* 4702 */     arsetZ5(p, 1);
/* 4703 */     arsetZ5(p, 2);
/* 4704 */     arsetZ5(p, -1);
/* 4705 */     arsetZ5(p, -2);
/* 4706 */     arsetZ5(p, -3);
/* 4707 */     arsetZ5(p, -4);
/* 4708 */     arsetZ5(p, -5);
/* 4709 */     arsetZ5(p, -6);
/* 4710 */     arsetZ5(p, -7);
/* 4711 */     arsetZ5(p, -8);
/* 4712 */     arsetZ5(p, -9);
/* 4713 */     arsetZ5(p, -10);
/* 4714 */     arsetZ5(p, -11);
/* 4715 */     arsetZ5(p, -12);
/* 4716 */     arsetZ6(p, -1);
/* 4717 */     arsetZ6(p, -2);
/* 4718 */     arsetZ6(p, -3);
/* 4719 */     arsetZ6(p, -4);
/* 4720 */     arsetZ6(p, -5);
/* 4721 */     arsetZ6(p, -6);
/* 4722 */     arsetZ6(p, -7);
/* 4723 */     arsetZ6(p, -8);
/* 4724 */     arsetZ6(p, -9);
/* 4725 */     arsetZ6(p, -10);
/* 4726 */     arsetZ6(p, -11);
/* 4727 */     arsetZ6(p, -12);
/* 4728 */     arsetZ6(p, -13);
/* 4729 */     arsetZ5(p, -1);
/* 4730 */     arsetZ5(p, -2);
/* 4731 */     arsetZ5(p, -3);
/* 4732 */     arsetZ5(p, -4);
/* 4733 */     arsetZ5(p, -5);
/* 4734 */     arsetZ5(p, -6);
/* 4735 */     arsetZ5(p, -7);
/* 4736 */     arsetZ5(p, -8);
/* 4737 */     arsetZ5(p, -9);
/* 4738 */     arsetZ5(p, -10);
/* 4739 */     arsetZ5(p, -11);
/* 4740 */     arsetZ5(p, -12);
/* 4741 */     arsetZ7(p, -1);
/* 4742 */     arsetZ7(p, -2);
/* 4743 */     arsetZ7(p, -3);
/* 4744 */     arsetZ7(p, -4);
/* 4745 */     arsetZ7(p, -5);
/* 4746 */     arsetZ7(p, -6);
/* 4747 */     arsetZ7(p, -7);
/* 4748 */     arsetZ7(p, -8);
/* 4749 */     arsetZ7(p, -9);
/* 4750 */     arsetZ7(p, -10);
/* 4751 */     arsetZ7(p, -11);
/* 4752 */     arsetZ7(p, -12);
/* 4753 */     arsetZ7(p, -13);
/* 4754 */     arsetZ7(p, -14);
/*      */ 
/* 4756 */     arsetX1(p, -1);
/* 4757 */     arsetX1(p, -2);
/* 4758 */     arsetX1(p, -3);
/* 4759 */     arsetX1(p, -4);
/* 4760 */     arsetX1(p, -5);
/* 4761 */     arsetX1(p, -6);
/* 4762 */     arsetX1(p, -7);
/* 4763 */     arsetX1(p, -8);
/* 4764 */     arsetX2(p, -1);
/* 4765 */     arsetX2(p, -2);
/* 4766 */     arsetX2(p, -3);
/* 4767 */     arsetX2(p, -4);
/* 4768 */     arsetX2(p, -5);
/* 4769 */     arsetX2(p, -6);
/* 4770 */     arsetX2(p, -7);
/* 4771 */     arsetX2(p, -8);
/* 4772 */     arsetX2(p, -9);
/* 4773 */     arsetX3(p, -1);
/* 4774 */     arsetX3(p, -2);
/* 4775 */     arsetX3(p, -3);
/* 4776 */     arsetX3(p, -4);
/* 4777 */     arsetX3(p, -5);
/* 4778 */     arsetX3(p, -6);
/* 4779 */     arsetX3(p, -7);
/* 4780 */     arsetX3(p, -8);
/* 4781 */     arsetX3(p, -9);
/* 4782 */     arsetX3(p, -10);
/* 4783 */     arsetX4(p, -1);
/* 4784 */     arsetX4(p, -2);
/* 4785 */     arsetX4(p, -3);
/* 4786 */     arsetX4(p, -4);
/* 4787 */     arsetX4(p, -5);
/* 4788 */     arsetX4(p, -6);
/* 4789 */     arsetX4(p, -7);
/* 4790 */     arsetX4(p, -8);
/* 4791 */     arsetX4(p, -9);
/* 4792 */     arsetX4(p, -10);
/* 4793 */     arsetX4(p, -11);
/* 4794 */     arsetX5(p, -1);
/* 4795 */     arsetX5(p, -2);
/* 4796 */     arsetX5(p, -3);
/* 4797 */     arsetX5(p, -4);
/* 4798 */     arsetX5(p, -5);
/* 4799 */     arsetX5(p, -6);
/* 4800 */     arsetX5(p, -7);
/* 4801 */     arsetX5(p, -8);
/* 4802 */     arsetX5(p, -9);
/* 4803 */     arsetX5(p, -10);
/* 4804 */     arsetX5(p, -11);
/* 4805 */     arsetX5(p, -12);
/* 4806 */     arsetX6(p, -1);
/* 4807 */     arsetX6(p, -2);
/* 4808 */     arsetX6(p, -3);
/* 4809 */     arsetX6(p, -4);
/* 4810 */     arsetX6(p, -5);
/* 4811 */     arsetX6(p, -6);
/* 4812 */     arsetX6(p, -7);
/* 4813 */     arsetX6(p, -8);
/* 4814 */     arsetX6(p, -9);
/* 4815 */     arsetX6(p, -10);
/* 4816 */     arsetX6(p, -11);
/* 4817 */     arsetX6(p, -12);
/* 4818 */     arsetX6(p, -13);
/* 4819 */     arsetX7(p, -1);
/* 4820 */     arsetX7(p, -2);
/* 4821 */     arsetX7(p, -3);
/* 4822 */     arsetX7(p, -4);
/* 4823 */     arsetX7(p, -5);
/* 4824 */     arsetX7(p, -6);
/* 4825 */     arsetX7(p, -7);
/* 4826 */     arsetX7(p, -8);
/* 4827 */     arsetX7(p, -9);
/* 4828 */     arsetX7(p, -10);
/* 4829 */     arsetX7(p, -11);
/* 4830 */     arsetX7(p, -12);
/* 4831 */     arsetX7(p, -13);
/* 4832 */     rarsetBX1(p, -1);
/* 4833 */     rarsetBX1(p, -2);
/* 4834 */     rarsetBX1(p, -3);
/* 4835 */     rarsetBX1(p, -4);
/* 4836 */     rarsetBX1(p, -5);
/* 4837 */     rarsetBX1(p, -6);
/* 4838 */     rarsetBX1(p, -7);
/* 4839 */     rarsetBX1(p, -8);
/* 4840 */     rarsetBX2(p, -1);
/* 4841 */     rarsetBX2(p, -2);
/* 4842 */     rarsetBX2(p, -3);
/* 4843 */     rarsetBX2(p, -4);
/* 4844 */     rarsetBX2(p, -5);
/* 4845 */     rarsetBX2(p, -6);
/* 4846 */     rarsetBX2(p, -7);
/* 4847 */     rarsetBX2(p, -8);
/* 4848 */     rarsetBX2(p, -9);
/* 4849 */     rarsetBX3(p, -1);
/* 4850 */     rarsetBX3(p, -2);
/* 4851 */     rarsetBX3(p, -3);
/* 4852 */     rarsetBX3(p, -4);
/* 4853 */     rarsetBX3(p, -5);
/* 4854 */     rarsetBX3(p, -6);
/* 4855 */     rarsetBX3(p, -7);
/* 4856 */     rarsetBX3(p, -8);
/* 4857 */     rarsetBX3(p, -9);
/* 4858 */     rarsetBX3(p, -10);
/*      */ 
/* 4860 */     rarsetBX4(p, -1);
/* 4861 */     rarsetBX4(p, -2);
/* 4862 */     rarsetBX4(p, -3);
/* 4863 */     rarsetBX4(p, -4);
/* 4864 */     rarsetBX4(p, -5);
/* 4865 */     rarsetBX4(p, -6);
/* 4866 */     rarsetBX4(p, -7);
/* 4867 */     rarsetBX4(p, -8);
/* 4868 */     rarsetBX4(p, -9);
/* 4869 */     rarsetBX4(p, -10);
/* 4870 */     rarsetBX4(p, -11);
/*      */ 
/* 4872 */     rarsetBX5(p, -1);
/* 4873 */     rarsetBX5(p, -2);
/* 4874 */     rarsetBX5(p, -3);
/* 4875 */     rarsetBX5(p, -4);
/* 4876 */     rarsetBX5(p, -5);
/* 4877 */     rarsetBX5(p, -6);
/* 4878 */     rarsetBX5(p, -7);
/* 4879 */     rarsetBX5(p, -8);
/* 4880 */     rarsetBX5(p, -9);
/* 4881 */     rarsetBX5(p, -10);
/* 4882 */     rarsetBX5(p, -11);
/* 4883 */     rarsetBX5(p, -12);
/*      */ 
/* 4885 */     rarsetBX6(p, -1);
/* 4886 */     rarsetBX6(p, -2);
/* 4887 */     rarsetBX6(p, -3);
/* 4888 */     rarsetBX6(p, -4);
/* 4889 */     rarsetBX6(p, -5);
/* 4890 */     rarsetBX6(p, -6);
/* 4891 */     rarsetBX6(p, -7);
/* 4892 */     rarsetBX6(p, -8);
/* 4893 */     rarsetBX6(p, -9);
/* 4894 */     rarsetBX6(p, -10);
/* 4895 */     rarsetBX6(p, -11);
/* 4896 */     rarsetBX6(p, -12);
/* 4897 */     rarsetBX6(p, -13);
/*      */ 
/* 4899 */     rarsetBX7(p, -1);
/* 4900 */     rarsetBX7(p, -2);
/* 4901 */     rarsetBX7(p, -3);
/* 4902 */     rarsetBX7(p, -4);
/* 4903 */     rarsetBX7(p, -5);
/* 4904 */     rarsetBX7(p, -6);
/* 4905 */     rarsetBX7(p, -7);
/* 4906 */     rarsetBX7(p, -8);
/* 4907 */     rarsetBX7(p, -9);
/* 4908 */     rarsetBX7(p, -10);
/* 4909 */     rarsetBX7(p, -11);
/* 4910 */     rarsetBX7(p, -12);
/* 4911 */     rarsetBX7(p, -13);
/* 4912 */     rarsetBX7(p, -14);
/* 4913 */     arsetBlock(p, 1, 1);
/* 4914 */     arsetBlock(p, 1, -1);
/* 4915 */     arsetBlock(p, -1, 1);
/* 4916 */     arsetBlock(p, -1, -1);
/* 4917 */     arsetZ(p, 1);
/* 4918 */     arsetZ(p, -1);
/* 4919 */     arsetX(p, 1);
/* 4920 */     arsetX(p, -1);
/*      */ 
/* 4922 */     arsetBlock(p, 2, 2);
/* 4923 */     arsetBlock(p, 2, -2);
/* 4924 */     arsetBlock(p, -2, 2);
/* 4925 */     arsetBlock(p, -2, -2);
/* 4926 */     arsetZ(p, 2);
/* 4927 */     arsetZ(p, -2);
/* 4928 */     arsetX(p, 2);
/* 4929 */     arsetX(p, -2);
/*      */ 
/* 4931 */     arsetBlock(p, 3, 3);
/* 4932 */     arsetBlock(p, 3, -3);
/* 4933 */     arsetBlock(p, -3, 3);
/* 4934 */     arsetBlock(p, -3, -3);
/* 4935 */     arsetZ(p, 3);
/* 4936 */     arsetZ(p, -3);
/* 4937 */     arsetX(p, 3);
/* 4938 */     arsetX(p, -3);
/*      */ 
/* 4940 */     arsetBlock(p, 4, 4);
/* 4941 */     arsetBlock(p, 4, -4);
/* 4942 */     arsetBlock(p, -4, 4);
/* 4943 */     arsetBlock(p, -4, -4);
/* 4944 */     arsetZ(p, 4);
/* 4945 */     arsetZ(p, -4);
/* 4946 */     arsetX(p, 4);
/* 4947 */     arsetX(p, -4);
/*      */ 
/* 4949 */     arsetBlock(p, 5, 5);
/* 4950 */     arsetBlock(p, 5, -5);
/* 4951 */     arsetBlock(p, -5, 5);
/* 4952 */     arsetBlock(p, -5, -5);
/* 4953 */     arsetZ(p, 5);
/* 4954 */     arsetZ(p, -5);
/* 4955 */     arsetX(p, 5);
/* 4956 */     arsetX(p, -5);
/*      */ 
/* 4958 */     arsetBlock(p, 6, 6);
/* 4959 */     arsetBlock(p, 6, -6);
/* 4960 */     arsetBlock(p, -6, 6);
/* 4961 */     arsetBlock(p, -6, -6);
/* 4962 */     arsetZ(p, 6);
/* 4963 */     arsetZ(p, -6);
/* 4964 */     arsetX(p, 6);
/* 4965 */     arsetX(p, -6);
/*      */ 
/* 4967 */     arsetBlock(p, 7, 7);
/* 4968 */     arsetBlock(p, 7, -7);
/* 4969 */     arsetBlock(p, -7, 7);
/* 4970 */     arsetBlock(p, -7, -7);
/* 4971 */     arsetZ(p, 7);
/* 4972 */     arsetZ(p, -7);
/* 4973 */     arsetX(p, 7);
/* 4974 */     arsetX(p, -7);
/* 4975 */     rs(p, 1);
/* 4976 */     rs(p, 2);
/* 4977 */     rs(p, 3);
/* 4978 */     rs(p, 4);
/* 4979 */     rs(p, 5);
/* 4980 */     rss(p, 1);
/* 4981 */     rss(p, 2);
/* 4982 */     rss(p, 3);
/* 4983 */     rss(p, 4);
/* 4984 */     rss(p, 5);
/* 4985 */     ra(p, 1);
/* 4986 */     ra(p, 2);
/* 4987 */     ra(p, 3);
/* 4988 */     ra(p, 4);
/* 4989 */     ra(p, 5);
/* 4990 */     rb(p, 1);
/* 4991 */     rb(p, 2);
/* 4992 */     rb(p, 3);
/* 4993 */     rb(p, 4);
/* 4994 */     rb(p, 5);
/* 4995 */     rbb(p, 1);
/* 4996 */     rbb(p, 2);
/* 4997 */     rbb(p, 3);
/* 4998 */     rbb(p, 4);
/* 4999 */     rbb(p, 5);
/* 5000 */     rc(p, 1);
/* 5001 */     rc(p, 2);
/* 5002 */     rc(p, 3);
/* 5003 */     rc(p, 4);
/* 5004 */     rc(p, 5);
/* 5005 */     rcc(p, 1);
/* 5006 */     rcc(p, 2);
/* 5007 */     rcc(p, 3);
/* 5008 */     rcc(p, 4);
/* 5009 */     rcc(p, 5);
/* 5010 */     rd(p, 1);
/* 5011 */     rd(p, 2);
/* 5012 */     rd(p, 3);
/* 5013 */     rd(p, 4);
/* 5014 */     rd(p, 5);
/* 5015 */     rdd(p, 1);
/* 5016 */     rdd(p, 2);
/* 5017 */     rdd(p, 3);
/* 5018 */     rdd(p, 4);
/* 5019 */     rdd(p, 5);
/* 5020 */     re(p, 1);
/* 5021 */     re(p, 2);
/* 5022 */     re(p, 3);
/* 5023 */     re(p, 4);
/* 5024 */     re(p, 5);
/* 5025 */     ree(p, 1);
/* 5026 */     ree(p, 2);
/* 5027 */     ree(p, 3);
/* 5028 */     ree(p, 4);
/* 5029 */     ree(p, 5);
/*      */   }
/*      */ 
/*      */   public void teleport(Player clicker, Player clicked) {
/* 5033 */     Location clickerLoc = new Location(clicker.getWorld(), clicker.getLocation().getBlockX() - 6.5D, clicker.getLocation().getBlockY() + 101, clicker.getLocation().getBlockZ() - 6.5D);
/* 5034 */     Location clickedLoc = new Location(clicker.getWorld(), clicker.getLocation().getBlockX() + 7.5D, clicker.getLocation().getBlockY() + 101, clicker.getLocation().getBlockZ() + 7.5D);
/* 5035 */     clickedLoc.setYaw(132.0F);
/* 5036 */     clickerLoc.setYaw(-42.0F);
			   GladiatorEffect ge1 = new GladiatorEffect(Main.em, ParticleEffect.HAPPY_VILLAGER);
			   ge1.setEntity(clicker);
			   ge1.start();
			   GladiatorEffect ge2 = new GladiatorEffect(Main.em, ParticleEffect.HAPPY_VILLAGER);
			   ge2.setEntity(clicked);
			   ge2.start();
/* 5037 */     clicker.teleport(clickerLoc);
/* 5038 */     clicked.teleport(clickedLoc);
/*      */   }

/*      */   public void teleport2(Player clicker, Player clicked) {
/* 5041 */     Location clickerLoc = new Location(clicker.getWorld(), clicker.getLocation().getBlockX() - 6.5D, clicker.getLocation().getBlockY() + 101 + 5, clicker.getLocation().getBlockZ() - 6.5D);
/* 5042 */     Location clickedLoc = new Location(clicker.getWorld(), clicker.getLocation().getBlockX() + 7.5D, clicker.getLocation().getBlockY() + 101 + 5, clicker.getLocation().getBlockZ() + 7.5D);
/* 5043 */     clickedLoc.setYaw(132.0F);
/* 5044 */     clickerLoc.setYaw(-42.0F);
/* 5045 */     clicker.teleport(clickerLoc);
/* 5046 */     clicked.teleport(clickedLoc);
/*      */   }
/*      */ }

