package fr.papergx.antistuffstack.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class Listeners implements Listener {
    List<Material> materialList;
    int max;
    String prefix;

    public Listeners(List<Material> stuff) {
        this.materialList = stuff;
        this.max = 5;
        this.prefix = "§e§LLimitation §8- §cLe stuff est limité à ";
    }
    @EventHandler
    public void equipEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        PlayerInventory inv = player.getInventory();
        if(materialList.contains(event.getCurrentItem().getType()) && event.getCurrentItem().getAmount() > max && event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
            player.sendMessage(prefix + max);
            event.setCancelled(true);
        }
        if(inv.getHelmet() !=null && materialList.contains(inv.getHelmet().getType()) && inv.getHelmet().getAmount() > max) {
            player.sendMessage(prefix + max);
            inv.addItem(inv.getHelmet());
            inv.setHelmet(null);
        }
        if(inv.getChestplate() !=null && materialList.contains(inv.getChestplate().getType()) && inv.getChestplate().getAmount() > max) {
            player.sendMessage(prefix + max);
            inv.addItem(inv.getChestplate());
            inv.setChestplate(null);
        }
        if(inv.getBoots() !=null && materialList.contains(inv.getBoots().getType()) && inv.getBoots().getAmount() > max) {
            player.sendMessage(prefix + max);
            inv.addItem(inv.getBoots());
            inv.setBoots(null);
        }
        if(inv.getLeggings() !=null && materialList.contains(inv.getLeggings().getType()) && inv.getLeggings().getAmount() > max) {
            player.sendMessage(prefix + max);
            inv.addItem(inv.getLeggings());
            inv.setLeggings(null);
        }

    }
    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent event){
        Player player = event.getPlayer();
        PlayerInventory inv = player.getInventory();
        if(event.getItem() == null) {return;}
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if(materialList.contains(event.getItem().getType())) {
                switch (event.getItem().getType()) {
                    case DIAMOND_HELMET:
                        if(inv.getHelmet() == null && event.getItem().getAmount() > max) {
                            event.setCancelled(true);
                            player.sendMessage(prefix + max);
                            player.updateInventory();
                            player.getInventory().setHelmet(null);
                        }
                        break;
                    case DIAMOND_CHESTPLATE:
                        if(inv.getChestplate() == null && event.getItem().getAmount() > max) {
                            event.setCancelled(true);
                            player.sendMessage(prefix + max);
                            player.updateInventory();
                            player.getInventory().setChestplate(null);
                        }
                        break;
                    case DIAMOND_LEGGINGS:
                        if(inv.getLeggings() == null && event.getItem().getAmount() > max) {
                            event.setCancelled(true);
                            player.sendMessage(prefix + max);
                            player.updateInventory();
                            player.getInventory().setLeggings(null);
                        }
                        break;
                    case DIAMOND_BOOTS:
                        if(inv.getBoots() == null && event.getItem().getAmount() > max) {
                            event.setCancelled(true);
                            player.sendMessage(prefix + max);
                            player.updateInventory();
                            player.getInventory().setBoots(null);
                        }
                        break;
                }
            }
        }
    }
}
