class Note(
    var noteId: Int, /* идентификатор заметки */
    var ownerId: Int? = null, /* идентификатор владельца заметки */
    var title: String? = null, /* заголовок заметки */
    var text: String? = null, /* текст заметки */
    var date: Int? = null, /* дата создания заметки   */
    var countCommentsForNote: Int? = null, /* количество комментариев */
    var readComments: Int? = null, /* количество прочитанных комментариев */
    var viewURL: String? = null,  /* адрес страницы для отображения заметки */
    var privacy: Int = 2, /* уровень доступа к заметке */
    var CommentPrivacy: Int = 3, /* уровень доступа к комментированию заметки */
    var canComment: Boolean = true /* может ли текущий пользователь комментировать заметку */

) {

    override fun toString(): String {
        return "Заметка ID $noteId, владелец ID $ownerId, Заголовок $title, Текст $text, Дата создания $date, " +
                "Количество комментариев к заметке $countCommentsForNote, " +
                "Количество прочитанных комментариев $readComments, " +
                "Заметка доступна по адресу $viewURL "
    }
}

