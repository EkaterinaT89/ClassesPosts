class DocAttachments (
    val doc: Doc = Doc()

): Attachments {

    override var type: String = "doc"
        set(value) {
            if (type == "doc") {
                type as Doc
            }
            field = value
        }
        get() = field

    override fun toString(): String {
        return "$type" + doc.toString()
    }

}