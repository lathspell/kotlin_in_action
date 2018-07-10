package book.chapter10

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaField
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class FindingAnnotationsTest {

    @Target(AnnotationTarget.FIELD)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Foo

    @Target(AnnotationTarget.PROPERTY)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Bar

    data class TestData(@Foo val id: Int, @Bar val color: String)

    @Test
    fun test() {
        val obj = TestData(123, "red")

        // The word "property" is meant in the Kotlin sense of a combination of backing field and getter/setter.
        // "getColor()" for example is not found using ".memberFunctions", it's only a property accessor
        // Annotations for the backing field can only be reached via the "javaField"
        val idProp = obj::class.memberProperties.first { it.name == "id" }
        assertNull(idProp.findAnnotation<Foo>())
        val idField = idProp.javaField!!
        assertNotNull(idField.getAnnotation(Foo::class.java))

        // The @Bar annotation is targeted at the Kotlin property and found directly
        val colorProp = obj::class.memberProperties.first { it.name == "color" }
        assertNotNull(colorProp.findAnnotation<Bar>())

        var getColorFunc = obj::class.memberFunctions.firstOrNull { it.name == "getColor" }
        assertNull(getColorFunc)
    }

}