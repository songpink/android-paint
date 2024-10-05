package woowacourse.paint.model.rectangle

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import woowacourse.paint.model.Sketch

data class Rectangle(
    private val rectangleVertex: RectangleVertex,
    private val color: Int,
    private val strokeWidth: Float,
) : Sketch(color, strokeWidth) {
    private val startX = rectangleVertex.startX
    private val startY = rectangleVertex.startY
    private val endX = rectangleVertex.endX
    private val endY = rectangleVertex.endY

    private val rectF =
        RectF(
            startX.coerceAtMost(endX),
            startY.coerceAtMost(endY),
            startX.coerceAtLeast(endX),
            startY.coerceAtLeast(endY),
        )

    override fun draw(canvas: Canvas) {
        canvas.drawRect(rectF, paint)
    }
}
