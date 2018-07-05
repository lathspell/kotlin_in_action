package my.prodfac2

import kotlin.test.Test
import kotlin.test.assertEquals

class ProdFac2Test {

    @Test
    fun test1() {
        val prodIdList = listOf(2, 1)
        val prodList = prodIdList.map { Product.byId(it) }

        assertEquals("Green", prodList[0].helper.getColor())
        assertEquals("Red", prodList[1].helper.getColor())
    }
}