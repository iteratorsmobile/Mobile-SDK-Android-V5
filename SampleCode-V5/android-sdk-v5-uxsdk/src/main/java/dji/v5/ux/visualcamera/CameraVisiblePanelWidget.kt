package dji.v5.ux.visualcamera

import android.content.Context
import android.util.AttributeSet
import dji.sdk.keyvalue.value.common.CameraLensType
import dji.sdk.keyvalue.value.common.ComponentIndexType
import dji.v5.ux.R
import dji.v5.ux.core.base.ICameraIndex
import dji.v5.ux.core.base.widget.ConstraintLayoutWidget
import dji.v5.ux.visualcamera.aperture.CameraConfigApertureWidget
import dji.v5.ux.visualcamera.ev.CameraConfigEVWidget
import dji.v5.ux.visualcamera.iso.CameraConfigISOAndEIWidget
import dji.v5.ux.visualcamera.shutter.CameraConfigShutterWidget
import dji.v5.ux.visualcamera.storage.CameraConfigStorageWidget
import dji.v5.ux.visualcamera.wb.CameraConfigWBWidget

open class CameraVisiblePanelWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayoutWidget<Any>(context, attrs, defStyleAttr),
    ICameraIndex {

    private var widget_camera_config_iso_and_ei: CameraConfigISOAndEIWidget? = null
    private var widget_camera_config_shutter: CameraConfigShutterWidget? = null
    private var widget_camera_config_aperture: CameraConfigApertureWidget? = null
    private var widget_camera_config_ev: CameraConfigEVWidget? = null
    private var widget_camera_config_wb: CameraConfigWBWidget? = null
    private var widget_camera_config_storage: CameraConfigStorageWidget? = null


    var mCameraIndex = ComponentIndexType.LEFT_OR_MAIN
    var mLensType = CameraLensType.CAMERA_LENS_ZOOM

    override fun getCameraIndex(): ComponentIndexType {
        return mCameraIndex
    }

    override fun getLensType(): CameraLensType {
        return mLensType
    }

    override fun updateCameraSource(cameraIndex: ComponentIndexType, lensType: CameraLensType) {
        mCameraIndex = cameraIndex
        mLensType = lensType
        widget_camera_config_iso_and_ei?.updateCameraSource(cameraIndex, lensType)
        widget_camera_config_shutter?.updateCameraSource(cameraIndex, lensType)
        widget_camera_config_aperture?.updateCameraSource(cameraIndex, lensType)
        widget_camera_config_ev?.updateCameraSource(cameraIndex, lensType)
        widget_camera_config_wb?.updateCameraSource(cameraIndex, lensType)
        widget_camera_config_storage?.updateCameraSource(cameraIndex, lensType)

        //NDVI镜头下不支持这类操作
        widget_camera_config_iso_and_ei?.visibility =
            if (lensType == CameraLensType.CAMERA_LENS_MS_NDVI) INVISIBLE else VISIBLE
        widget_camera_config_shutter?.visibility =
            if (lensType == CameraLensType.CAMERA_LENS_MS_NDVI) INVISIBLE else VISIBLE
        widget_camera_config_aperture?.visibility =
            if (lensType == CameraLensType.CAMERA_LENS_MS_NDVI) INVISIBLE else VISIBLE
        widget_camera_config_ev?.visibility =
            if (lensType == CameraLensType.CAMERA_LENS_MS_NDVI) INVISIBLE else VISIBLE
        widget_camera_config_wb?.visibility =
            if (lensType == CameraLensType.CAMERA_LENS_MS_NDVI) INVISIBLE else VISIBLE
    }

    override fun initView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        inflate(context, R.layout.uxsdk_panel_common_camera, this)

        widget_camera_config_iso_and_ei = findViewById(R.id.widget_camera_config_iso_and_ei)
        widget_camera_config_shutter = findViewById(R.id.widget_camera_config_shutter)
        widget_camera_config_aperture = findViewById(R.id.widget_camera_config_aperture)
        widget_camera_config_ev = findViewById(R.id.widget_camera_config_ev)
        widget_camera_config_wb = findViewById(R.id.widget_camera_config_wb)
        widget_camera_config_storage = findViewById(R.id.widget_camera_config_storage)

        if (background == null) {
            setBackgroundResource(R.drawable.uxsdk_background_black_rectangle)
        }
    }

    override fun reactToModelChanges() {
        //do nothing
    }
}