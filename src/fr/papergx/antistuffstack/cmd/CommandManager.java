package fr.papergx.antistuffstack.cmd;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {return false;}
        Player player = (Player) commandSender;

        ItemStack casque = new ItemStack(Material.DIAMOND_HELMET, 64);
        ItemStack plastron = new ItemStack(Material.DIAMOND_CHESTPLATE, 64);
        ItemStack jambe = new ItemStack(Material.DIAMOND_LEGGINGS, 64);
        ItemStack bottes = new ItemStack(Material.DIAMOND_BOOTS, 64);

        player.getInventory().addItem(casque, plastron, jambe, bottes);
        return false;
    }
}
