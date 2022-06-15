package dev.cbyrne.kdiscordipc.core.packet.serialization

import dev.cbyrne.kdiscordipc.core.packet.outbound.OutboundPacket
import dev.cbyrne.kdiscordipc.core.packet.outbound.impl.*
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.*

object OutboundPacketSerializer : JsonContentPolymorphicSerializer<OutboundPacket>(OutboundPacket::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out OutboundPacket> {
        return when (element.contentOrNull("command")) {
            "SET_ACTIVITY" -> SetActivityPacket.serializer()
            "AUTHENTICATE" -> AuthenticatePacket.serializer()
            "GET_USER" -> GetUserPacket.serializer()
            "GET_RELATIONSHIPS" -> GetRelationshipsPacket.serializer()
            "SUBSCRIBE" -> SubscribePacket.serializer()
            "ACCEPT_ACTIVITY_INVITE" -> AcceptActivityInvitePacket.serializer()
            "CREATE_LOBBY" -> CreateLobbyPacket.serializer()
            else -> HandshakePacket.serializer()
        }
    }

    private fun JsonElement.contentOrNull(key: String) =
        jsonObject[key]?.jsonPrimitive?.contentOrNull
}