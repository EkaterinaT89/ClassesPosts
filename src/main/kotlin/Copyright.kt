class Copyright (
    val id: Int,
    val link: String,
    val name: String,
    val type: String
        ) {

    override fun toString(): String {
        return "Copyright - $id, ссылка $link, имя владельца $name, тип $type"
    }
}

