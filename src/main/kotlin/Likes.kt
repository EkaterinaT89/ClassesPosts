import java.util.*

class Likes (
    var count: Int, /* число пользователей, которым понравилась запись */
    val userLikes: Boolean, /* наличие отметки «Мне нравится» от текущего пользователя  */
    val canLike: Boolean, /* информация о том, может ли текущий пользователь поставить отметку «Мне нравится» */
    val canPublish: Boolean, /* информация о том, может ли текущий пользователь сделать репост записи */
        ){

    fun isUserLikes(userLikes: Boolean): String {
        when (userLikes) {
            true -> return "Мне нравится!"
            else -> return " "
        }
    }

    fun canLikePost(canLike: Boolean): String {
        when (canLike) {
            true -> return "Вы можете поставить отметку 'Мне нравится'"
            else -> return "Вы не можете поставить отметку 'Мне нравится'"
        }
    }

    fun canPublishPost(canPublish: Boolean): String {
        when (canPublish) {
            true -> return "Вы можете сделать репост."
            else -> return "У вас нет прав на репост этого поста!"
        }
    }

    override fun toString(): String {
        return "Понравилось пользователям $count " + isUserLikes(userLikes) +" " + canLikePost(canLike) + " " +
         canPublishPost(canPublish) + " "
    }


}
