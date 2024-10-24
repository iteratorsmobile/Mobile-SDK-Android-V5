package dji.sampleV5.aircraft.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import dji.sampleV5.aircraft.R
import kotlinx.android.synthetic.main.frag_uas_page.*

/**
 * Description :无人机远程识别的演示入口页面
 *
 * @author: Byte.Cai
 *  date : 2022/6/26
 *
 * Copyright (c) 2022, DJI All Rights Reserved.
 */
class UASRemoteFragment : DJIFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_uas_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_france.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_open_uas_france_page)
        }
        btn_jp.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_open_uas_jp_pag)
        }
        btn_us.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_open_uas_us_page)
        }
        btn_eu.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_open_uas_european_page)
        }
        btn_china.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_open_uas_chin_page)
        }

    }
}