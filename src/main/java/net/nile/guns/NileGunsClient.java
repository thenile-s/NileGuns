package net.nile.guns;

import java.io.IOException;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class NileGunsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(NileGuns.BULLET, (dispatcher, context) -> {
            return new BulletEntityRenderer(dispatcher);
        });
        //I couldn't get the client package registry to register my handler, perhaps because of
        //I provided and invalid Identifier?
        //ClientSidePacketRegistry.INSTANCE.register(new Identifier(NileGuns.modid), NileGunsClient::spawnEntity);
    }

    // private static void spawnEntity(PacketContext pc, PacketByteBuf buffer) {
    //     // buffer
    //     NileGuns.logger.info("Here 2");
    //     try {
    //         EntitySpawnS2CPacket info = new EntitySpawnS2CPacket();
    //         info.read(buffer);
    //         //Registry.ENTITY_TYPE.get(info.getEntityTypeId());
    //         pc.getTaskQueue().execute(() -> {
    //             ((ClientWorld) pc.getPlayer().world).addEntity(info.getId(), new BulletEntity(NileGuns.BULLET, (ClientWorld) pc.getPlayer().world));
    //             NileGuns.logger.info("Here 1");
    //         });
            
    //     } catch (IOException e) {
    //         NileGuns.logger.error("Exception when spawning entity client-side. ", e);
    //     }
    // }
}
