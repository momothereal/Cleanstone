package rocks.cleanstone.player;

import com.google.common.base.Objects;

import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

import rocks.cleanstone.game.chat.ChatMode;
import rocks.cleanstone.game.entity.vanilla.Human;
import rocks.cleanstone.game.gamemode.GameMode;
import rocks.cleanstone.game.gamemode.vanilla.VanillaGameMode;
import rocks.cleanstone.game.inventory.MainHandSide;
import rocks.cleanstone.net.packet.enums.DisplayedSkinPart;
import rocks.cleanstone.net.packet.enums.PlayerAbilities;

public abstract class AbstractPlayer implements Player {

    protected final PlayerID id;
    protected Human entity;
    private boolean op = false, flying = false;
    private GameMode gameMode = VanillaGameMode.CREATIVE;
    private float flyingSpeed = 0.4F;
    private int viewDistance = 4;
    private Locale locale = Locale.ENGLISH;
    private ChatMode chatMode = ChatMode.ENABLED;
    private MainHandSide mainHandSide = MainHandSide.RIGHT;
    private Collection<DisplayedSkinPart> displayedSkinParts = new HashSet<>();

    public AbstractPlayer(PlayerID id) {
        this.id = id;
    }

    @Override
    public PlayerID getId() {
        return id;
    }

    @Override
    public boolean isOp() {
        return op;
    }

    @Override
    public void setOp(boolean op) {
        this.op = op;
    }

    @Override
    public Human getEntity() {
        return entity;
    }

    @Override
    public void setEntity(Human entity) {
        this.entity = entity;
    }

    @Override
    public GameMode getGameMode() {
        return gameMode;
    }

    @Override
    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    @Override
    public float getFlyingSpeed() {
        return flyingSpeed;
    }

    public void setFlyingSpeed(float flyingSpeed) {
        this.flyingSpeed = flyingSpeed;
    }

    @Override
    public boolean isFlying() {
        return flying;
    }

    @Override
    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    @Override
    public Collection<PlayerAbilities> getAbilities() {
        Collection<PlayerAbilities> abilities = gameMode.getPlayerAbilities();
        if (isFlying()) abilities.add(PlayerAbilities.IS_FLYING);
        return abilities;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public void setViewDistance(int viewDistance) {
        this.viewDistance = viewDistance;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public ChatMode getChatMode() {
        return chatMode;
    }

    public void setChatMode(ChatMode chatMode) {
        this.chatMode = chatMode;
    }

    public MainHandSide getMainHandSide() {
        return mainHandSide;
    }

    public void setMainHandSide(MainHandSide mainHandSide) {
        this.mainHandSide = mainHandSide;
    }

    public Collection<DisplayedSkinPart> getDisplayedSkinParts() {
        return displayedSkinParts;
    }

    public void setDisplayedSkinParts(Collection<DisplayedSkinPart> displayedSkinParts) {
        this.displayedSkinParts = displayedSkinParts;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPlayer)) return false;
        AbstractPlayer that = (AbstractPlayer) o;
        return Objects.equal(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
