package book.chapter10

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties
import kotlin.test.assertNotNull

class AnnotationsTest2 {

    //@Retention(AnnotationRetention.RUNTIME)
    //@Target(AnnotationTarget.FIELD)
    annotation class SpecialTreatment(val reason: String)

    data class AnnoPerson(
            val name: String,
            @SpecialTreatment("privacy")
            val yob: Int)

    @org.junit.Test
    fun testSpecialTreatmentAnnotation() {
        val p1 = AnnoPerson("Tim", 1930)

        val yobProp = p1::class.memberProperties.first { it.name == "yob" }
        assertNotNull(yobProp)

        val yobAnnotation = yobProp.findAnnotation<SpecialTreatment>()
        assertNotNull(yobAnnotation)
    }

}