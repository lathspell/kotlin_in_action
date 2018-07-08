package book.chapter10

import org.junit.Test
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class MissingAnnotationTest {

    @Target(AnnotationTarget.FIELD)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Foo

    data class TestData(@field:Foo val id: Int)

    @Test
    fun test() {
        val obj = TestData(123)
        val idProp = obj::class.declaredMemberProperties.first { it.name == "id" }

        println("1 name: " + idProp) // "val ...TestData.id: kotlin.Int"
        println("1 annotations: " + idProp.annotations) // [] - but why?
        println("1 found @Foo: " + idProp.findAnnotation<Foo>()) // null - but why?

        assertTrue(idProp.name.endsWith("TestData.id: kotlin.Int"))
        assertEquals(1, idProp.annotations.size)
        assertNotNull(idProp.findAnnotation<Foo>())
    }

}