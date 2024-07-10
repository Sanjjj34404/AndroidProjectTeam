package com.threeandoiddev.racipeapp

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

import com.bumptech.glide.Glide

import com.threeandoiddev.racipeapp.databinding.ActivityRacipeBinding

class RecipeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRacipeBinding
    var imgCrop=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRacipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
        binding.tittle.text=intent.getStringExtra("tittle")

        binding.stepData.text=intent.getStringExtra("des")
        var ing = intent.getStringExtra("ing")?.split("\n".toRegex())?.dropLastWhile { it.isEmpty() }
            ?.toTypedArray()
        binding.time.text=ing?.get(0)
        for (i in 1 until ing!!.size){
                binding.ingData.text=
                    """${binding.ingData.text} 🟢 ${ing[i]}
                        
                    """.trimIndent()

        }
        binding.step.background=null
        binding.step.setTextColor(getColor(R.color.black))
        binding.step.setOnClickListener {
            binding.step.setBackgroundResource(R.drawable.btn_ing)
            binding.step.setTextColor(getColor(R.color.white))
            binding.ing.setTextColor(getColor(R.color.black))
            binding.ing.background=null
            binding.stepScroll.visibility=View.VISIBLE
            binding.ingScroll.visibility=View.GONE

        }

        binding.ing.setOnClickListener {
            binding.ing.setBackgroundResource(R.drawable.btn_ing)
            binding.ing.setTextColor(getColor(R.color.white))
            binding.step.setTextColor(getColor(R.color.black))
            binding.step.background=null
            binding.ingScroll.visibility=View.VISIBLE
            binding.stepScroll.visibility=View.GONE
        }
        binding.fullScreen.setOnClickListener {

           if (imgCrop){
               binding.itemImage.scaleType=ImageView.ScaleType.FIT_CENTER
               Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
               binding.fullScreen.setColorFilter(Color.BLACK,PorterDuff.Mode.SRC_ATOP)
               binding.shade.visibility=View.GONE
               imgCrop=!imgCrop
           }else{
               binding.itemImage.scaleType=ImageView.ScaleType.CENTER_CROP
               Glide.with(this).load(intent.getStringExtra("img")).into(binding.itemImage)
               binding.fullScreen.setColorFilter(null)
               binding.shade.visibility=View.GONE
               imgCrop=!imgCrop
           }
        }
binding.backBtn.setOnClickListener {
    finish()
}


    }
}