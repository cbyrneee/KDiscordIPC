@file:Suppress("unused")

package dev.cbyrne.kdiscordipc.data.lobby

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@Serializable
enum class Region {
    @JsonNames("amsterdam")
    Amsterdam,
    @JsonNames("brazil")
    Brazil,
    @JsonNames("dubai")
    Dubai,
    @JsonNames("rotterdam")
    Rotterdam,
    @JsonNames("frankfurt")
    Frankfurt,
    @JsonNames("hongkong")
    Hongkong,
    @JsonNames("india")
    India,
    @JsonNames("japan")
    Japan,
    @JsonNames("london")
    London,
    @JsonNames("russia")
    Russia,
    @JsonNames("singapore")
    Singapore,
    @JsonNames("southafrica")
    SouthAfrica,
    @JsonNames("south-korea")
    SouthKorea,
    @JsonNames("stockholm")
    Stockholm,
    @JsonNames("sydney")
    Sydney,
    @JsonNames("us-central")
    UsCentral,
    @JsonNames("us-east")
    UsEast,
    @JsonNames("us-south")
    UsSouth,
    @JsonNames("us-west")
    UsWest,
    @JsonNames("vip-amsterdam")
    VipAmsterdam,
    @JsonNames("vip-us-east")
    VipUsEast,
    @JsonNames("vip-us-west")
    VipUsWest
}