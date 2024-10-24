package dji.v5.ux.cameracore.widget.cameracontrols.exposuresettings

import android.content.Context
import android.util.AttributeSet
import android.view.View
import dji.sdk.keyvalue.value.common.CameraLensType
import dji.sdk.keyvalue.value.common.ComponentIndexType
import dji.v5.ux.R
import dji.v5.ux.core.base.ICameraIndex
import dji.v5.ux.core.base.widget.ConstraintLayoutWidget

/**
 * Class Description
 *
 * @author Hoker
 * @date 2021/10/19
 *
 * Copyright (c) 2021, DJI All Rights Reserved.
 */
open class ExposureSettingsPanel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayoutWidget<ExposureSettingsPanel.ModelState>(context, attrs, defStyleAttr),
    ICameraIndex {

    private var exposure_setting_widget: ExposureModeSettingWidget? = null
    private var iso_and_ei_setting_widget: ISOAndEISettingWidget? = null

    override fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        View.inflate(context, R.layout.uxsdk_panel_exposure_setting, this)
        exposure_setting_widget = findViewById(R.id.exposure_setting_widget)
        iso_and_ei_setting_widget = findViewById(R.id.iso_and_ei_setting_widget)
    }

    override fun reactToModelChanges() {
        //暂未实现
    }

    override fun getCameraIndex() =
        exposure_setting_widget?.getCameraIndex() ?: ComponentIndexType.LEFT_OR_MAIN

    override fun getLensType() =
        exposure_setting_widget?.getLensType() ?: CameraLensType.CAMERA_LENS_DEFAULT


    override fun updateCameraSource(cameraIndex: ComponentIndexType, lensType: CameraLensType) {
        exposure_setting_widget?.updateCameraSource(cameraIndex, lensType)
        iso_and_ei_setting_widget?.updateCameraSource(cameraIndex, lensType)
    }

    override fun getIdealDimensionRatioString(): String? {
        return null
    }

    sealed class ModelState
}