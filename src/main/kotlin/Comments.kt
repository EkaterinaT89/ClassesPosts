class Comments(
    val cout: Int, /* количество комментариев */
    val canPost: Boolean, /* информация о том, может ли текущий пользователь комментировать запись */
    val groupsCanPost: Boolean, /* информация о том, могут ли сообщества комментировать запись */
    val canClose: Boolean, /* может ли текущий пользователь закрыть комментарии к записи */
    val canOpen: Boolean, /* может ли текущий пользователь открыть комментарии к записи */

) {

    fun canPost(canPost: Boolean): String {
        when (canPost) {
            true -> return " Вы можете комментировать запись "
            else -> return " Вы не можете комментировать запись "
        }
    }

    fun groupsCanPost(groupsCanPost: Boolean): String {
        when (groupsCanPost) {
            true -> return " Запись открыта для комментирования сообществами "
            else -> return " Вы не можете комментировать запись от имени сообщества "
        }
    }

    fun canClose(canClose: Boolean): String {
        when (canClose) {
            true -> return " Вы можете ограничить комментарии к записи "
            else -> return " Вы не можете ограничить комментарии к записи "
        }
    }

    fun canOpen(canOpen: Boolean): String {
        when (canOpen) {
            true -> return " Вы можете открыть комментарии к записи "
            else -> return " Вы не можете открыть комментарии к записи "
        }
    }

    override fun toString(): String {
        return "Комментариев всего - $cout " + canPost(canPost) + groupsCanPost(groupsCanPost) + canClose(canClose) +
                canOpen(canOpen)
    }


}
