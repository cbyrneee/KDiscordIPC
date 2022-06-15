package dev.cbyrne.kdiscordipc.core.packet.serialization

import dev.cbyrne.kdiscordipc.core.packet.inbound.InboundPacket
import dev.cbyrne.kdiscordipc.core.packet.inbound.impl.*
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.*

object InboundPacketSerializer : JsonContentPolymorphicSerializer<InboundPacket>(InboundPacket::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out InboundPacket> =
        when (val evt = element.contentOrNull("evt")) {
            "READY" -> DispatchEventPacket.Ready.serializer()
            "CURRENT_USER_UPDATE" -> DispatchEventPacket.UserUpdate.serializer()
            "VOICE_SETTINGS_UPDATE" -> DispatchEventPacket.VoiceSettingsUpdate.serializer()
            "ACTIVITY_JOIN" -> DispatchEventPacket.ActivityJoin.serializer()
            "ACTIVITY_INVITE" -> DispatchEventPacket.ActivityInvite.serializer()
            "ERROR" -> DispatchEventPacket.Error.serializer()
            else -> when (val command = element.contentOrNull("cmd")) {
                "SET_ACTIVITY" -> SetActivityPacket.serializer()
                "AUTHENTICATE" -> AuthenticatePacket.serializer()
                "AUTHORIZE" -> AuthorizePacket.serializer()
                "GET_VOICE_SETTINGS" -> GetVoiceSettingsPacket.serializer()
                "SET_VOICE_SETTINGS" -> SetVoiceSettingsPacket.serializer()
                "GET_USER" -> GetUserPacket.serializer()
                "GET_RELATIONSHIPS" -> GetRelationshipsPacket.serializer()
                "SUBSCRIBE" -> SubscribePacket.serializer()
                "ACCEPT_ACTIVITY_INVITE" -> AcceptActivityInvitePacket.serializer()
                "CREATE_LOBBY" -> CreateLobbyPacket.serializer()
                else -> error("Unknown packet command: $command | Event: $evt")
            }
        }

    private fun JsonElement.contentOrNull(key: String) =
        jsonObject[key]?.jsonPrimitive?.contentOrNull
}