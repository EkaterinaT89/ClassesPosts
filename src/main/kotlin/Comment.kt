class Comment(
    val id: Int? = null, /* идентификатор комментария. */
    val from_id: Int? = null, /*идентификатор автора комментария. */
    val date: Int? = null, /* дата создания комментария в формате Unixtime */
    val text: String? = null, /* текст комментария. */
    val donut: Donut? = null, /* информация о VK Donut */
    val reply_to_user: Int? = null, /* идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо) */
    val reply_to_comment: Int? = null, /* идентификатор комментария, в ответ на который оставлен текущий (если применимо) */
    val attachments: Attachments? = null, /* вложения */
    var parents_stack: Array<Integer>? = emptyArray(), /* массив идентификаторов родительских комментариев */
    val thread: Thread? = null, /* Информация о вложенной ветке комментариев */
    var postId: Int /* ID поста к которому оставлен коммент. В ВК нет, для ДЗ */
) {

    override fun toString(): String {
        return "Комментарий: id $id, Автор $from_id, Дата $date, '$text', $donut, В ответ пользователю $reply_to_user, " +
                "В ответ на комментарий $reply_to_comment, Вложения $attachments, " +
                "В ответ на комментарии ${parents_stack?.contentToString()}, " +
                "Ветка $thread + ID поста $postId"
    }

}