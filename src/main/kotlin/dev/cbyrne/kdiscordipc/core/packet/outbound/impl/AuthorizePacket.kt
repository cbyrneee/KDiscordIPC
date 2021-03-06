package dev.cbyrne.kdiscordipc.core.packet.outbound.impl

import dev.cbyrne.kdiscordipc.core.packet.outbound.OutboundPacket
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthorizePacket(
    override val args: Arguments,
    override val cmd: String = "AUTHORIZE",
    override val opcode: Int = 0x01,
    override var nonce: String = "0"
): CommandPacket() {
    constructor(scopes: Array<String>?, clientID: String?, rpcToken: String?, username: String?): this(args = Arguments(scopes, clientID, rpcToken, username))

    @Serializable
    data class Arguments(
        val scopes: Array<String>?,
        @SerialName("client_id") val clientID: String?,
        @SerialName("rpc_token") val rpcToken: String?,
        val username: String?
    ): OutboundPacket.Arguments()
}