import java.util.*

fun IntRange.random() =
    Random().nextInt((endInclusive + 1) - start) + start

var countRandom: Int = (0..1000).random()
var countCommentsRandom: Int = (0..500).random()
var paidDurationRandom: Int = (0..600).random()
var copyrightIdRandom: Int = (0..1000).random()
var countLikesRandom: Int = (0..5000).random()
val reportsRandom: Int = (0..400).random()

val commentForPost = Comments(countCommentsRandom, true, true, false, true)
val views = Views(countRandom)
val donut = Donut(true, paidDurationRandom, "Заглушка", true, "Информация о донате")
val copyright = Copyright(copyrightIdRandom, "Ссылка", "John", "Close")
val likes = Likes(countLikesRandom, true, true, false)
val reports = Reports(reportsRandom, false)
val commentForPost2 = Comment(4448, 2, donut = donut, postId = 288, date = 444, text = "Текст комментария!", ownerId = 55)

val note = Note(noteId = 0, ownerId = 22, title = "Note title", text = "Note text", date = 10, viewURL = "URL")
val note2 = Note(noteId = 2, ownerId = 22, title = "Note title2", text = "Note text2", date = 10, viewURL = "URL2")
val note3 = Note(noteId = 0, ownerId = 22, title = "Note title3", text = "Note text3", date = 10, viewURL = "URL3")

val commentForNote = Comment(id = 2, noteId = 4, reply_to_user = 2666, ownerId = 2, text = "Text for comment")
val noteForEdit = Note(noteId = 1, ownerId = 52, title = "Note title4", text = "Note text4", date = 10, viewURL = "URL4")
val commentForEdit = Comment(id = 2, noteId = 4, reply_to_user = 2666, ownerId = 2, text = "Text for comment 2")

fun main() {
    val myPost = Post(
        1
    )

    val myPost2 = Post(
        1
    )

    val myPost3 = Post(
        1
    )

    val myPost4 = Post(
        25
    )

    val audio = Audio(1, 222, "URL", "FOOL URL")
    val audioAttachment = AudioAttachments(audio)

    val service = WallService
//    service.add(myPost)
//    service.add(myPost2)
//    service.add(myPost3)
//
//    service.addAttachment(audioAttachment, myPost3)
//
//    service.print()
//
//    service.createComment(commentForPost)
//    service.printCom()

    val noteService = NoteService
    noteService.addNotes(note)
    noteService.addNotes(note2)
    noteService.addNotes(note3)
    noteService.getNotes(1)
    noteService.getNotesById(1, 22)

    noteService.createCommentForNote(commentForNote)
    noteService.printNoteComment()

    noteService.deleteNote(4)
    noteService.printDeletedNotes()

    noteService.edit(noteForEdit)

    noteService.editComment(commentForEdit)
    noteService.printNoteComment()

    noteService.getComment(1, 25)
    noteService.printNoteComment()

    noteService.deleteComment(2)
    noteService.printNoteComment()
    noteService.printDeletedComments()

    noteService.restoreComment(2, 2)
    noteService.printNoteComment()
    noteService.printDeletedComments()

    service.update(myPost4)


}

