package book.chapter10

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import kotlin.test.assertTrue

class AnnotationsTest1 {

    // @Rule is a JUnit rule i.e. a special class that can execute commands before and after a @Test execution.
    // In this case a temporary folder is created before and deleted afterwards
    // @Rule's scope only permits public fields or public methods. In this case though the `val` creates a private
    // field and we thus get a "The @Rule 'folder' must be public." runtime exception. By explicitly setting the
    // "use-side" of the annotation to "get" we tell Kotlin that the rule should be applied to the implicitly
    // created public getter method "getFolder()" and not the private field "folder".
    @get:Rule
    val folder = TemporaryFolder()

    @Test
    fun testTemporaryFile() {
        val createdFile = folder.newFile("testfile")
        assertTrue(createdFile.isFile)
    }
}