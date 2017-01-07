package org.algo4j.graph

import org.algo4j.get
import org.algo4j.test.loop
import org.algo4j.test.println
import org.jetbrains.annotations.TestOnly
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by ice1000 on 2017/1/8.

 * @author ice1000
 */
class AdjacentMatrixTest {

	/**
	 * to prove my way of treating
	 * an one-dimension array as
	 * a two-dimension array is correct.
	 */
	@TestOnly
	@Test(timeout = 1000)
	fun testAddEdge() {
//		val graph = AdjacentMatrix(1000)
//		val a = fun AdjacentMatrix.(): IntArray {
//			return matrix
//		}
		val len = 100
		val value = 9
		val a = IntArray(len * len)
		val b = Array(len, { IntArray(len) })
		val rand = Random(System.currentTimeMillis())
		loop(300) {
			val r1 = rand.nextInt(len)
			val r2 = rand.nextInt(len)
			a[r1 * len + r2] += value
			b[r1][r2] += value
		}
		var idx = 0
		for (i in 0..len - 1) {
			for (j in 0..len - 1) {
				assertEquals(b[i][j], a[idx])
				++idx
			}
		}
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testInit() {
		val len = 10
		val graph = AdjacentMatrix(len)
		for (i in 0..len - 1) {
			assertEquals(0, graph[i, i])
		}
		graph.toString().println()
	}

	@TestOnly
	@Test(timeout = 1000)
	fun testEasyFloyd() {
		val graph = AdjacentMatrix(10)
		graph.addDirectionlessEdge(1, 3, 1)
		graph.addDirectionlessEdge(3, 5, 1)
		graph.addDirectionlessEdge(1, 5, 100)
		graph.toString().println()
		val res = graph.floyd()
		res.toString().println()
		assertEquals(2, res[1, 5])
	}

	companion object Initializer {
		@JvmStatic
		@BeforeClass
		fun loadJniLib() {
//			Loader.load()
			System.loadLibrary("jni")
		}
	}
}
