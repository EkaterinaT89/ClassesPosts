class Thread(
    val count: Int, /* количество комментариев в ветке*/
    var items: Array<Comments>? = emptyArray(), /* массив объектов комментариев к записи (только для метода wall.getComments) */
    val can_post: Boolean, /* может ли текущий пользователь оставлять комментарии в этой ветке */
    val show_reply_button: Boolean, /* нужно ли отображать кнопку «ответить» в ветке */
    val groups_can_post: Boolean /* могут ли сообщества оставлять комментарии в ветке */

) {

    fun can_post(can_post: Boolean): String {
        when (can_post) {
            true -> return " Вы можете оставлять комментарии в этой ветке "
            else -> return " Вы не можете оставлять комментарии в этой ветке "
        }
    }

    fun show_reply_button(show_reply_button: Boolean): String {
        when (show_reply_button) {
            true -> return " Кнопка ОТВЕТИТЬ "
            else -> return " Нет кнопки "
        }
    }

    fun groups_can_post(groups_can_post: Boolean): String {
        when (groups_can_post) {
            true -> return " Сообщества могут оставлять комментарии "
            else -> return " Сообщества не могут оставлять комментарии "
        }
    }

    override fun toString(): String {
        return "Комментариев всего - $count, ${items?.contentToString()}, " +
                can_post(can_post) + show_reply_button(show_reply_button) +
                groups_can_post(groups_can_post) + " "
    }


}
