package com.github.christopheml.day11

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class Heatmap {

    private val scale = 2

    private val colors = createColors()

    private fun createColors(): List<Color> {
        val grays = listOf(0, 28, 56, 85, 113, 141, 170, 198, 226, 255)
        return grays.map { Color(it, it, it) }
    }

    fun draw(source: FuelCells, output: File) {
        val dimension = 300 * scale

        val image = BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_RGB)
        val graphics = image.createGraphics()

        for (x in 0 until 300) {
            for (y in 0 until 300) {
                graphics.color = toColor(source.valueAt(x + 1, y + 1))
                graphics.drawRect(x * scale, y * scale, scale, scale)
            }
        }

        ImageIO.write(image, "png", output)
    }

    private fun toColor(value: Int): Color {
        return colors[value + 5]
    }

}
