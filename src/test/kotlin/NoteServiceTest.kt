import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    val noteService = NoteService

    @Test
    fun addNotes() {
        val note = Note(noteId = 1)
        val noteIdExpected = 8
        noteService.addNotes(note)
        val result = noteService.addNotes(note).noteId
        assertEquals(noteIdExpected, result)
    }

    @Test
    fun getNotes() {
        val note = Note(noteId = 0)
        noteService.addNotes(note)
        noteService.getNotes(noteId = 8)
        val result = note
        assertEquals(note, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowGetNotes() {
        val note = Note(noteId = 288)
        noteService.getNotes(noteId = 555)
    }

    @Test
    fun getNotesByID() {
        val note = Note(noteId = 0, ownerId = 2)
        noteService.addNotes(note)
        noteService.getNotesById(noteId = 8, ownerId = 2)
        val result = note
        assertEquals(note, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowGetNotesById() {
        val note = Note(noteId = 288)
        noteService.getNotes(noteId = 555)
    }

    @Test
    fun createComment() {
        val note = Note(noteId = 0)
        noteService.addNotes(note)
        val comment = Comment(noteId = 1, ownerId = 1)
        val idexpected = 1
        noteService.createCommentForNote(comment)
        val result = comment.noteId
        assertEquals(idexpected, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowCreateComment() {
        val comment = Comment(noteId = 0, ownerId = 1)
        noteService.createCommentForNote(comment)
    }

    @Test
    fun getComment() {
        val note = Note(noteId = 0)
        noteService.addNotes(note)
        val comment = Comment(noteId = 8, ownerId = 2)
        noteService.createCommentForNote(comment)
        val result = comment
        assertEquals(comment, result)
    }

    @Test(expected = CommentForNotesNotFoundException::class)
    fun shouldThrowGetComment() {
        val comment = Comment(noteId = 0, ownerId = 1)
        noteService.getComment(155)
    }

    @Test
    fun deleteNoteTrue() {
        val note = Note(0)
        noteService.addNotes(note)
        val result = noteService.deleteNote(1)
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowdeleteNote() {
        val note = Note(0)
        noteService.deleteNote(1)
    }

    @Test
    fun deleteCommentTrue() {
        val note = Note(0)
        noteService.addNotes(note)
        val comment = Comment(noteId = 1, ownerId = 2, id = 1)
        noteService.createCommentForNote(comment)
        val result = noteService.deleteComment(1)
        assertTrue(result)
    }

    @Test(expected = CommentForNotesNotFoundException::class)
    fun shouldThrowDeleteComment() {
        val comment = Comment(0, ownerId = 2)
        noteService.deleteComment(1)
    }

    @Test
    fun edit() {
        val note = Note(0)
        noteService.addNotes(note)
        val edit = Note(8)
        val result = noteService.edit(edit)
        assertTrue(result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun shouldThrowEditNote() {
        val note = Note(0)
        noteService.edit(note)
    }

    @Test
    fun editComment() {
        val note = Note(0)
        noteService.addNotes(note)
        val comment = Comment(noteId = 1, ownerId = 5, id = 2)
        noteService.createCommentForNote(comment)
        val edit = Comment(2, ownerId = 5)
        val result = noteService.editComment(edit)
        assertTrue(result)
    }

    @Test(expected = CommentForNotesNotFoundException::class)
    fun shouldThrowEditComment() {
        val comment = Comment(0, ownerId = 58)
        noteService.editComment(comment)
    }

    @Test
    fun restoreComment() {
        val note = Note(0)
        noteService.addNotes(note)
        val comment = Comment(noteId = 8, ownerId = 5, id = 2)
        noteService.createCommentForNote(comment)
        noteService.deleteComment(2)
        val restore = Comment(2, ownerId = 5)

        val result = noteService.restoreComment(2, 5)
        assertTrue(result)
    }

    @Test(expected = CommentForNotesNotFoundException::class)
    fun shouldThrowRestoreComment() {
        val comment = Comment(0, ownerId = 58)
        noteService.restoreComment(1, 50)
    }

}
