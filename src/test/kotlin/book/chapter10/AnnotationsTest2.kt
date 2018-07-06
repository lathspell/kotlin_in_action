package book.chapter10

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties
import kotlin.test.Test
import kotlin.test.assertNotNull

class AnnotationsTest2 {

    //@Retention(AnnotationRetention.RUNTIME)
    //@Target(AnnotationTarget.FIELD)
    annotation class SpecialTreatment(val reason: String)

    data class Person(
            val name: String,
            @SpecialTreatment("privacy")
            val yob: Int)

    @Test
    fun testSpecialTreatmentAnnotation() {
        val p1 = Person("Tim", 1930)

        val yobProp = p1::class.memberProperties.first { it.name == "yob" }
        assertNotNull(yobProp)

        val yobAnnotation = yobProp.findAnnotation<SpecialTreatment>()
        assertNotNull(yobAnnotation)
    }

}