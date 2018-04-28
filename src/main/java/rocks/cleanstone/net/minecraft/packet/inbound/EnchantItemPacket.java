package rocks.cleanstone.net.minecraft.packet.inbound;

import rocks.cleanstone.net.packet.Packet;
import rocks.cleanstone.net.packet.PacketType;
import rocks.cleanstone.net.minecraft.packet.MinecraftInboundPacketType;

public class EnchantItemPacket implements Packet {

    private final byte windowID;
    private final byte enchantment;

    public EnchantItemPacket(byte windowID, byte enchantment) {
        this.windowID = windowID;
        this.enchantment = enchantment;
    }

    public byte getWindowID() {
        return windowID;
    }

    public byte getEnchantment() {
        return enchantment;
    }

    @Override
    public PacketType getType() {
        return MinecraftInboundPacketType.ENCHANT_ITEM;
    }
}