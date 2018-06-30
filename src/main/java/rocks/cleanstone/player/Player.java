package rocks.cleanstone.player;

import java.net.InetAddress;
import java.util.Collection;
import java.util.Locale;

import rocks.cleanstone.game.chat.message.Text;
import rocks.cleanstone.game.command.CommandSender;
import rocks.cleanstone.game.entity.vanilla.Human;
import rocks.cleanstone.game.gamemode.GameMode;
import rocks.cleanstone.net.packet.Packet;
import rocks.cleanstone.game.chat.ChatMode;
import rocks.cleanstone.net.packet.enums.DisplayedSkinPart;
import rocks.cleanstone.game.inventory.MainHandSide;
import rocks.cleanstone.net.packet.enums.PlayerAbilities;

public interface Player extends CommandSender {

    PlayerID getId();

    void sendPacket(Packet packet);

    InetAddress getAddress();

    int getPing();

    void kick(Text reason);

    Human getEntity();

    void setEntity(Human entity);

    GameMode getGameMode();

    void setGameMode(GameMode gameMode);

    boolean isOp();

    void setOp(boolean state);

    void sendMessage(Text message);

    Collection<UserProperty> getUserProperties();

    boolean isFlying();

    void setFlying(boolean flying);

    float getFlyingSpeed();

    void setFlyingSpeed(float flyingSpeed);

    int getViewDistance();

    void setViewDistance(int viewDistance);

    Locale getLocale();

    void setLocale(Locale locale);

    ChatMode getChatMode();

    void setChatMode(ChatMode chatMode);

    MainHandSide getMainHandSide();

    void setMainHandSide(MainHandSide mainHandSide);

    Collection<DisplayedSkinPart> getDisplayedSkinParts();

    void setDisplayedSkinParts(Collection<DisplayedSkinPart> displayedSkinParts);

    Collection<PlayerAbilities> getAbilities();
}
