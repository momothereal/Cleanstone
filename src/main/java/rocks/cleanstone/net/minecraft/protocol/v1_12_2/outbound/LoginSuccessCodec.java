package rocks.cleanstone.net.minecraft.protocol.v1_12_2.outbound;

import io.netty.buffer.ByteBuf;
import rocks.cleanstone.net.packet.Packet;
import rocks.cleanstone.net.packet.outbound.LoginSuccessPacket;
import rocks.cleanstone.net.protocol.PacketCodec;
import rocks.cleanstone.net.utils.ByteBufUtils;

import java.io.IOException;

public class LoginSuccessCodec implements PacketCodec {

    @Override
    public Packet decode(ByteBuf byteBuf) {
        throw new UnsupportedOperationException("LoginSuccess is outbound and cannot be decoded");
    }

    @Override
    public ByteBuf encode(ByteBuf byteBuf, Packet packet) throws IOException {
        LoginSuccessPacket loginSuccessPacket = (LoginSuccessPacket) packet;

        ByteBufUtils.writeUTF8(byteBuf, loginSuccessPacket.getUUID().toString());
        ByteBufUtils.writeUTF8(byteBuf, loginSuccessPacket.getUserName());
        return byteBuf;
    }
}
