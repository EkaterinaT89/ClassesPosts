class GraffitiAttachments (
    val graffiti: Graffiti = Graffiti()

): Attachments {
    override var type: String = "graffiti"
        set(value) {
            if (type == "graffiti") {
                type as Video
            }
            field = value
        }
        get() = field

    override fun toString(): String {
        return "$type" + graffiti.toString()
    }

}