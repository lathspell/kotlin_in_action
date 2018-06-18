package my.prodfac

import kotlin.test.Test
import kotlin.test.assertEquals

class TestProdFac {
    @Test
    fun test1() {
        assertEquals(0, ProductRegistry.registry.size)
        println(RedProduct) // necessary as classes are lazy loaded and have not registered themselves in the registry
        assertEquals(1, ProductRegistry.registry.size)

        assertEquals(RedProduct::class, ProductRegistry.fromId(1)::class)
    }
}