package hajicoin.hajicoin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CoinGUI implements Listener {
    private final Inventory inv;

    public CoinGUI() {
        inv = Bukkit.createInventory(null, 9, "BitCoin");
        initializeItems();
//        openInventory(); 여기가 문제
    }

    public void initializeItems() {
        inv.addItem(createGuiItem(Material.DIAMOND_SWORD, "Example Sword", "§aFirst line of the lore", "§bSecond line of the lore"));
        inv.addItem(createGuiItem(Material.IRON_HELMET, "§bExample Helmet", "§aFirst line of the lore", "§bSecond line of the lore"));
    }

    protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!e.getInventory().equals(inv)) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        p.sendMessage("당신은 클릭을 함 " + e.getRawSlot());
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inv)) {
            e.setCancelled(true);
        }
    }
}


