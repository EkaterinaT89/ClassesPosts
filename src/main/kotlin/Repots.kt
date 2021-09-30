import java.util.*

class Repots (
    val count: Int, /* число пользователей, скопировавших запись */
    val userReposted: Boolean /* наличие репоста от текущего пользователя */
        ) {

    fun userReposted(userReposted: Boolean): String {
        when (userReposted) {
            true -> return "Репост от текущего пользователя"
            else -> return "Репост от другого пользователя"
        }
    }

    override fun toString(): String {
        return "Всего скопировало запись $count пользователей " + userReposted(userReposted) + " "
    }


}

