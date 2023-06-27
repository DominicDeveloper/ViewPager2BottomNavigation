package com.asadbek.viewpager2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Vibrator
import android.os.VibratorManager
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.asadbek.viewpager2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var list:ArrayList<String>
    lateinit var pagerAdapterMy: PagerAdapterMy
    var ikki = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        loadData()
        pagerAdapterMy = PagerAdapterMy(list,object :PagerAdapterMy.Click{
            override fun onClick(data: String) {
                Toast.makeText(this@MainActivity, data, Toast.LENGTH_SHORT).show()
            }
        })
        binding.pager2.adapter = pagerAdapterMy
        binding.pager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                Toast.makeText(this@MainActivity, "Ishlayabdi!!!", Toast.LENGTH_SHORT).show()
            }
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        binding.buttonNavi.setOnItemSelectedListener(object :NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.chiqish -> {
                        val vibe:Vibrator = this@MainActivity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                        vibe.vibrate(500)
                        qaytaIshla()

                    }
                }

                return true
            }
        })


    }

    private fun qaytaIshla() {
        ikki--
        if (ikki == 0){
            onBackPressed()
        }else{
            val handler = Handler()
            handler.postDelayed({
                ikki = 2
            },1000)
        }
    }

    private fun loadData() {
        list.add("https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcR771tnd1e8eFxnB0K6oi4BP8XsK3U7iQdHyHFwcnEv7bZbMmF6rXoRLUJDzSQFpGmSFm8-qidqtTdoI7ylXXkf4lVTVyo8NNARWqJT7aMUaw2HaNVcGowzKfmxzITs9sNgZw&usqp=CAc")
        list.add("https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwjo-emtp-P_AhWNk7IKHYgbA-IYABAGGgJscg&ohost=www.google.com&cid=CAESa-D2bE4ExhZg-Z3sheFIMSPjoRcuAmGczK2wMSX5er7yLSnkXG3JH0UwVMcrkhw-ABXMrTo4BQm3rgIVGjFeAM40C-zw7BFSFRQNcYvZ14ufTLomvgrtH1tNXtQnJnC-xNh35yqPGYgbrSK3&sig=AOD64_2Cfr0mUJLP0_39i8JcE99Qlh5t2Q&ctype=5&q=&ved=2ahUKEwiYn-Gtp-P_AhUMmIsKHe3bDFIQ9aACKAB6BAgDEA0&adurl=")
        list.add("https://storage.kun.uz/source/thumbnails/_medium/7/nQOjIed8GxqA0TgQDRG0Cyd5tVtZBwqE_medium.jpg")
    }
}