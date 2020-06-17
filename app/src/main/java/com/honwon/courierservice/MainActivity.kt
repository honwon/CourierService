package com.honwon.courierservice

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.browse
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        regionButton.setOnClickListener {
            alert("타권: 화물을 보내는 지역과 받는 지역이 다른 경우" +
                    "\n동일권: 화물을 보내는 지역과 받는 지역이 같은 경우" +
                    "\n\n동일권 지역: 수도권(서울,인천,경기) / 경남권(부산,울산) / 경북권(대구) /충남권(대전) / 충북권 / 전남권(광주) / 전북권 / 강원권 / 제주권"){
                positiveButton("예"){
                }
            }.show()
        }

        blogButton.setOnClickListener {
            browse(url = "https://blog.naver.com/hymp9800/221897314886")
        }

        resultButton.setOnClickListener {
            hideKeyboard()
            var mugae = weight.text.toString().toIntOrNull()?:0
            if(regionList.selectedItem.toString() == "타권"){
                val price = when(mugae){
                    in 1..350 -> 3100
                    in 351..400 -> 3300
                    in 401..450 -> 3400
                    in 451..500 -> 3400
                    in 501..600 -> 3500
                    in 601..700 -> 3500
                    in 701..800 -> 3500
                    in 801..900 -> 3500
                    in 901..1000 -> 3500
                    in 1001..1500 -> 4000
                    in 1501..2000 -> 4000
                    in 2001..3000 -> 4000
                    in 3001..4000 -> 4500
                    in 4001..5000 -> 4500
                    in 5001..7000 -> 5000
                    in 7001..10000 -> 6000
                    in 10001..15000 -> 6000
                    in 15001..20000 -> 7000
                    in 20001..25000 -> 8000
                    in 25001..30000 -> 8000
                    else ->""
                }
                val company = when(mugae){
                    in 1..350 -> "GS택배 & CU택배"
                    in 351..400 -> "GS택배"
                    in 401..450 -> "GS택배 & CU택배"
                    in 451..500 -> "CU택배"
                    in 501..600 -> "우체국택배"
                    in 601..700 -> "우체국택배"
                    in 701..800 -> "우체국택배"
                    in 801..900 -> "우체국택배"
                    in 901..1000 -> "우체국택배"
                    in 1001..1500 -> "우체국택배"
                    in 1501..2000 -> "우체국택배"
                    in 2001..3000 -> "우체국택배"
                    in 3001..4000 -> "우체국택배"
                    in 4001..5000 -> "우체국택배"
                    in 5001..7000 -> "우체국택배"
                    in 7001..10000 -> "GS택배 & 우체국택배"
                    in 10001..15000 -> "GS택배"
                    in 15001..20000 -> "GS택배"
                    in 20001..25000 -> "GS택배"
                    in 25001..30000 -> "GS택배"
                    else -> ""
                }
                if(price =="" || company ==""){
                    resultText.setText("잘못된 계산입니다.")
                } else {
                    resultText.setText("가장 싼 택배업체는" +
                            "\n${company} 이며" +
                            "\n택배비는 ${NumberFormat.getIntegerInstance().format(price)}원 입니다.")}


            } else {
                //동일권이면
                val price = when (mugae) {
                    in 0..350 -> 2600
                    in 351..400 -> 2800
                    in 401..450 -> 2900
                    in 451..500 -> 2900
                    in 501..600 -> 3300
                    in 601..700 -> 3400
                    in 701..800 -> 3500
                    in 801..900 -> 3500
                    in 901..1000 -> 3500
                    in 1001..1500 -> 3800
                    in 1501..2000 -> 4000
                    in 2001..3000 -> 4000
                    in 3001..4000 -> 4400
                    in 4001..5000 -> 4500
                    in 5001..7000 -> 4600
                    in 7001..10000 -> 5000
                    in 10001..15000 -> 5000
                    in 15001..20000 -> 6000
                    in 20001..25000 -> 7000
                    in 25001..30000 -> 7000
                    else -> ""
                }
                val company = when (mugae) {
                    in 1..350 -> "GS택배 & CU택배"
                    in 351..400 -> "GS택배"
                    in 401..450 -> "GS택배 & CU택배"
                    in 451..500 -> "CU택배"
                    in 501..600 -> "GS택배"
                    in 601..700 -> "GS택배"
                    in 701..800 -> "GS택배 & 우체국택배"
                    in 801..900 -> "우체국택배"
                    in 901..1000 -> "우체국택배"
                    in 1001..1500 -> "GS택배"
                    in 1501..2000 -> "우체국택배"
                    in 2001..3000 -> "우체국택배"
                    in 3001..4000 -> "GS택배"
                    in 4001..5000 -> "우체국택배"
                    in 5001..7000 -> "GS택배"
                    in 7001..10000 -> "GS택배"
                    in 10001..15000 -> "GS택배"
                    in 15001..20000 -> "GS택배"
                    in 20001..25000 -> "GS택배"
                    in 25001..30000 -> "GS택배"
                    else -> ""
                }
                if(price =="" || company ==""){
                    resultText.setText("잘못된 계산입니다.")
                } else {
                    resultText.setText("가장 싼 택배업체는" +
                            "\n${company} 이며" +
                            "\n택배비는 ${NumberFormat.getIntegerInstance().format(price)}원 입니다.")}

            }
        }
    }
    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}