import java.util.*

class Donut (
    val isDonut: Boolean, /* запись доступна только платным подписчикам VK Donut */
    val paidDuration: Int, /* время, в течение которого запись будет доступна только платным подписчикам */
    val placeholder: String, /*заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи. */
    val canPublishFreeCopy: Boolean, /* можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut */
    val editMode: String, /* информация о том, какие значения VK Donut можно изменить в записи //all — всю информацию о VK Donut.
//duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut. */
        ) {

    fun isDonut(isDonut: Boolean): String {
        if (isDonut == true) return "Запись доступна только платным подписчикам."
            else return "Запиcь доступна всем!"
    }

    fun canPublishFreeCopy(canPublishFreeCopy: Boolean): String {
        if (canPublishFreeCopy == true ) return "Запись открыта для копирования всеми пользователями."
            else return "Запиcь закрыта для копирования всеми."

    }

    override fun toString(): String {
        return "Запись доступна платным подписчикам в течении - $paidDuration часов, " + isDonut(isDonut) +
                "Заглушка - '$placeholder' " + canPublishFreeCopy(canPublishFreeCopy) + " \n Информация о донате $editMode"
    }


}
