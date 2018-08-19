package rocks.cleanstone.net.minecraft.protocol.v1_12_2.inbound;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import rocks.cleanstone.net.packet.Packet;
import rocks.cleanstone.net.packet.inbound.InTabCompletePacket;
import rocks.cleanstone.net.protocol.PacketCodec;
import rocks.cleanstone.net.utils.ByteBufUtils;
import rocks.cleanstone.utils.Vector;

public class InTabCompleteCodec implements PacketCodec {

    @Override
    public Packet decode(ByteBuf byteBuf) throws IOException {
        final String text = ByteBufUtils.readUTF8(byteBuf, 32767);

        final boolean assumeCommand = byteBuf.readBoolean();
        final boolean hasPosition = byteBuf.readBoolean();
        final Vector lookedAtBlock = hasPosition ? ByteBufUtils.readVector(byteBuf) : null;

        return new InTabCompletePacket(0, text, assumeCommand, lookedAtBlock);
    }

    @Override
    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        throw new UnsupportedOperationException("TabCompletion is inbound and cannot be encoded");
    }
}
