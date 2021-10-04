object NoteService {

    private val notes: MutableList<Note> = mutableListOf()
    private val commentsForNotes: MutableList<Comment> = mutableListOf()

    private val deletedNotes: MutableList<Note> = mutableListOf()
    private val deletedCommentsForNotes: MutableList<Comment> = mutableListOf()

    fun addNotes(note: Note): Note {
        notes.add(note)
        for (note in notes) {
            if (notes.isNotEmpty()) notes.last().noteId++ else 0
        }
        return notes.last()
    }

    fun getNotes(noteId: Int, count: Int = 20): Note {
        if (count > 100) {
            throw NoteNotFoundException("Слишком большое число заметок.")
        }
        for (note in notes) {
            if (note.noteId == noteId) {
                println(note.toString())
                return note
            }
        }
        throw NoteNotFoundException("Заметка с таким ID не найдена!")
    }

    fun getNotesById(noteId: Int, ownerId: Int): Note {
        for (note in notes) {
            if (note.noteId == noteId && note.ownerId == ownerId) {
                println(note.toString() + note.privacy + note.CommentPrivacy + note.canComment)
                return note
            }
        }
        throw NoteNotFoundException("Заметка с таким ID не найдена!")
    }

    fun createCommentForNote(comment: Comment): Comment {
        if (comment.reply_to_user != null) println("Ответ пользователю " + comment.reply_to_user)
        for (note in notes) {
            if (note.noteId == comment.noteId) {
                commentsForNotes += comment
                return commentsForNotes.last()
            }
        }
        throw NoteNotFoundException("Заметка с таким ID не найдена!")
    }

    fun getComment(noteId: Int, count: Int = 20): Comment {
        if (count > 100) {
            throw CommentForNotesNotFoundException("Слишком большое число комментариев.")
        }
        for (note in notes) {
            if (note.noteId == noteId) {
                println(commentsForNotes.toString())
                return commentsForNotes.last()
            }
        }
        throw CommentForNotesNotFoundException("Заметка с таким ID не найдена!")
    }

    fun printNoteComment() {
        println(commentsForNotes.toString())
    }

    fun deleteNote(idForDelete: Int): Boolean {
        for (note in notes) {
            if (idForDelete == note.noteId) {
                deletedNotes.add(note)
                notes.remove(note)
                return true
            }
        }
        throw NoteNotFoundException("Заметка с таким ID не найдена!")
    }

    fun printDeletedNotes() {
        println(deletedNotes.toString())
    }

    fun deleteComment(idForDelete: Int): Boolean {
        for (comment in commentsForNotes) {
            if (idForDelete == comment.id) {
                deletedCommentsForNotes += comment
                commentsForNotes.remove(comment)
                return true
            }
        }
        throw CommentForNotesNotFoundException("Комментарий с таким ID не найден!")
    }

    fun printDeletedComments() {
        println(deletedCommentsForNotes.toString())
    }

    fun edit(editedNote: Note): Boolean {
        for(note in notes) {
            if (editedNote.noteId == note.noteId) {
                note.title = editedNote.title
                note.text = editedNote.text
                return true
            }
        }
        throw NoteNotFoundException("Заметка с таким ID не найдена!")
    }

    fun editComment(editedComment: Comment): Boolean {
        for(comment in commentsForNotes) {
            if (editedComment.id == comment.id && editedComment.ownerId == comment.ownerId) {
                comment.text = editedComment.text
                return true
            }
        }
        throw CommentForNotesNotFoundException("Комментарий не найден!")
    }

    fun restoreComment(id: Int, ownerId: Int): Boolean {
        for (comment in deletedCommentsForNotes) {
            if (id == comment.id && ownerId == comment.ownerId) {
                commentsForNotes += comment
                deletedCommentsForNotes.remove(comment)
                return true
            }
        }
        throw CommentForNotesNotFoundException("Комментарий с таким ID не найден!")
    }

}