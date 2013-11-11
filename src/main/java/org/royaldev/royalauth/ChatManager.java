// Credits to Buycraft.net for the following code

package org.royaldev.royalauth;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bukkit.entity.Player;

public class ChatManager extends Thread
{
  private HashSet<String> disabledChatSet;

  public ChatManager()
  {
    this.disabledChatSet = new HashSet();
  }

  public synchronized Boolean isDisabled(Player player) {
    return Boolean.valueOf(this.disabledChatSet.contains(player.getName()));
  }

  public synchronized void enableChat(Player player) {
    this.disabledChatSet.remove(player.getName());
  }

  public synchronized void disableChat(Player player) {
    this.disabledChatSet.add(player.getName());
  }

  public synchronized void clearPlayerSet(Set<Player> players)
  {
    Iterator it = players.iterator();

    while (it.hasNext())
      if (this.disabledChatSet.contains(((Player)it.next()).getName()))
        it.remove();
  }
}
