package inc.fabudi.customprogressbar

import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import java.util.Random

class CustomProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr){
    private val progressBar: ProgressBar
    private val progressLabel: TextView
    private val button: Button
    private val randomGenerator = Random()
    init {
        inflate(context, R.layout.custom_progressbar, this)
        progressBar = findViewById(R.id.progressBar)
        progressLabel = findViewById(R.id.progressLabel)
        button = findViewById(R.id.button)
        button.setOnClickListener{
            val newProgress = randomGenerator.nextInt(1001)
            val anim = ObjectAnimator.ofInt(progressBar, "progress", progressBar.progress, newProgress)
            anim.duration = 500
            anim.interpolator = DecelerateInterpolator()
            anim.setAutoCancel(true)
            anim.start()
            progressLabel.text = "${newProgress/10}%"
        }
    }
}