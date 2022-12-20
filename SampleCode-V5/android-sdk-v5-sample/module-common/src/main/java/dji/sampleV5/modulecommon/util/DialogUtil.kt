package dji.sampleV5.modulecommon.util

import android.app.Activity
import android.app.AlertDialog
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
import dji.sampleV5.modulecommon.R
import dji.v5.common.callback.CommonCallbacks

/**
 * @author feel.feng
 * @time 2022/10/13 8:57 下午
 * @description: Dialog工具类
 */
object DialogUtil {

    fun showInputDialog(
        context: Activity,
        title: String?,
        msg: String?,
        hint: String?,
        singleLine: Boolean,
        callback: CommonCallbacks.CompletionCallbackWithParam<String>
    ) {
        val dialogView: View = context.layoutInflater.inflate(R.layout.dialog_param_input, null)
        dialogView.setBackgroundColor(context.resources.getColor(R.color.gray))
        val dialog = AlertDialog.Builder(context).setView(dialogView).create()
        dialog!!.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        val tvTitle = dialogView.findViewById<TextView>(R.id.title)
        tvTitle.text = title
        val input = dialogView.findViewById<EditText>(R.id.input)
        input.isSingleLine = singleLine
        if (Util.isNotBlank(msg)) {
            input.setText(msg)
        }
        if (Util.isNotBlank(hint)) {
            input.hint = hint
        }
        input.movementMethod = ScrollingMovementMethod.getInstance()
        dialogView.findViewById<View>(R.id.confirm).setOnClickListener {
            callback.onSuccess(input.text.toString())
            if (dialog != null) {
                dialog.dismiss()
            }
        }
        dialogView.findViewById<View>(R.id.cancel).setOnClickListener {
            callback?.onSuccess(null)
            if (dialog != null) {
                dialog.dismiss()
            }
        }
        dialog.show()
    }
}