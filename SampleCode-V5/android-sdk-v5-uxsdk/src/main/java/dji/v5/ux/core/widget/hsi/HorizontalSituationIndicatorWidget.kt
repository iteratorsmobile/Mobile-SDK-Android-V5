package dji.v5.ux.core.widget.hsi

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import dji.sdk.keyvalue.value.common.CameraLensType
import dji.sdk.keyvalue.value.common.ComponentIndexType
import dji.v5.ux.R
import dji.v5.ux.core.base.ICameraIndex
import dji.v5.ux.core.base.widget.ConstraintLayoutWidget

/**
 * Class Description
 *
 * @author Hoker
 * @date 2021/11/25
 *
 * Copyright (c) 2021, DJI All Rights Reserved.
 */
open class HorizontalSituationIndicatorWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayoutWidget<HorizontalSituationIndicatorWidget.ModelState>(
    context,
    attrs,
    defStyleAttr
), ICameraIndex {
    private var pfd_hsi_speed_display: SpeedDisplayWidget? = null
    private var pfd_hsi_attitude_display: AttitudeDisplayWidget? = null
    private var pfd_hsi_gimbal_pitch_display: GimbalPitchBarWidget? = null
    private var pfd_hsi_laser_distance: TextView? = null

    override fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        View.inflate(context, R.layout.uxsdk_fpv_view_horizontal_situation_indicator, this)
        pfd_hsi_speed_display = findViewById(R.id.pfd_hsi_speed_display)
        pfd_hsi_attitude_display = findViewById(R.id.pfd_hsi_attitude_display)
        pfd_hsi_gimbal_pitch_display = findViewById(R.id.pfd_hsi_gimbal_pitch_display)
        pfd_hsi_laser_distance = findViewById(R.id.pfd_hsi_laser_distance)
    }

    override fun reactToModelChanges() {
//        do nothing
    }

    override fun getIdealDimensionRatioString(): String? {
        return null
    }

    fun setSimpleModeEnable(isEnable: Boolean) {
        pfd_hsi_speed_display?.visibility = if (isEnable) VISIBLE else GONE
        pfd_hsi_attitude_display?.visibility = if (isEnable) VISIBLE else GONE
        pfd_hsi_gimbal_pitch_display?.visibility = if (isEnable) VISIBLE else GONE
    }

    fun updateLaserPointDistance(distanceString: String) {
        pfd_hsi_laser_distance?.text = distanceString
    }

    sealed class ModelState

    override fun getCameraIndex(): ComponentIndexType {
        return pfd_hsi_gimbal_pitch_display?.getCameraIndex() ?: ComponentIndexType.LEFT_OR_MAIN
    }

    override fun getLensType(): CameraLensType {
        return pfd_hsi_gimbal_pitch_display?.getLensType() ?: CameraLensType.CAMERA_LENS_DEFAULT

    }

    override fun updateCameraSource(cameraIndex: ComponentIndexType, lensType: CameraLensType) {
        pfd_hsi_gimbal_pitch_display?.updateCameraSource(cameraIndex, lensType)
    }
}