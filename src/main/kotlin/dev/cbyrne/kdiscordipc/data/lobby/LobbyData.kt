package dev.cbyrne.kdiscordipc.data.lobby

import dev.cbyrne.kdiscordipc.core.packet.inbound.InboundPacket
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LobbyData(
    @SerialName("application_id")
    val applicationID: String,
    @SerialName("owner_id")
    val ownerID: String,
    @SerialName("voice_states")
    val voiceStates: List<VoiceState>,
    val capacity: Int,
    val id: String,
    val locked: Boolean,
    val members: List<LobbyMember>,
    val metadata: Map<String, String>,
    val region: Region,
    val secret: String,
    val type: Int
) : InboundPacket.Data(){
    @Serializable
    data class LobbyMember(val metadata: Map<String, String>, val user: User) {
        @Serializable
        data class User(
            val avatar: String,
            val discriminator: String,
            val id: String,
            val username: String,
            val publicFlags: Int
        )
    }

    @Serializable
    data class VoiceState(
        @SerialName("channel_id")
        val channelID: String,
        @SerialName("self_deaf")
        val selfDeaf: Boolean,
        @SerialName("self_mute")
        val selfMute: Boolean,
        @SerialName("self_video")
        val selfVideo: Boolean,
        @SerialName("session_id")
        val sessionID: Boolean,
        @SerialName("suppress")
        val suppress: Boolean,
        @SerialName("user_id")
        val user_id: Boolean,
        val deaf: Boolean,
        val mute: Boolean,
    )
}