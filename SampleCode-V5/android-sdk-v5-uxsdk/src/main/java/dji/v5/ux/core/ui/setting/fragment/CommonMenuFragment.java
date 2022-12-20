package dji.v5.ux.core.ui.setting.fragment;

import android.view.Menu;

import dji.v5.utils.common.ContextUtil;
import dji.v5.utils.common.StringUtils;
import dji.v5.ux.R;
import dji.v5.ux.core.ui.setting.ui.MenuFragment;

/**
 * Description :
 *
 * @author: Byte.Cai
 * date : 2022/11/21
 * <p>
 * Copyright (c) 2022, DJI All Rights Reserved.
 */
public class CommonMenuFragment extends MenuFragment {
    @Override
    protected String getPreferencesTitle() {
        return StringUtils.getResStr(ContextUtil.getContext(), R.string.uxsdk_setting_menu_title_common);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.uxsdk_fragment_not_yet_implement;
    }
}