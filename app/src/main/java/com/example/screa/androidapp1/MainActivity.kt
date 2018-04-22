package com.example.screa.androidapp1

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.media.AudioManager
import android.media.SoundPool
import android.media.SoundPool.OnLoadCompleteListener
import java.io.IOException

import kotlinx.android.synthetic.main.content_main.*
import android.app.Activity
import android.widget.TextView


/*class MainActivity : AppCompatActivity(),TextToSpeech.OnInitListener {
    private var  soundPool:SoundPool?=null

    private val  soundID:Int?=null

     var plays: Boolean  = false
     var loaded :Boolean = false

     var actVolume:Float?=null
     var maxVolume:Float?=null
     var volume:Float?=null

     var audioManager:AudioManager?=null

    var counter:Int?=null

    private var tts: TextToSpeech? = null
    private var buttonSpeak: Button? = null
    private var editText: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        buttonSpeak = this.pl_b

        buttonSpeak!!.isEnabled = false
        tts = TextToSpeech(this, this)

        buttonSpeak!!.setOnClickListener {
            for ( i in 1..100){
            speakOut() }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.pb -> {
                val it = Intent(this,playback::class.java)
                startActivity(it)
            }
            R.id.vs -> {
                val it = Intent(this,voice::class.java)
                startActivity(it)
            }
            R.id.h -> {
                val it = Intent(this,help::class.java)
                startActivity(it)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            Log.e("TTS","very very bad")
            // set US English as language for tts

            val result = tts!!.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                buttonSpeak!!.isEnabled = true
            }

        } else {
            Log.e("TTS", "Initilization Failed!")
        }

    }

    private fun speakOut() {
        val text = "fuck you"
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
        tts!!.playSilentUtterance(10, TextToSpeech.QUEUE_ADD, null)
    }

    public override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
    fun pl(view: View){

    }

    fun st(view: View){

        //stop playing sound
    }
}*/
class MainActivity : Activity(), OnLoadCompleteListener {

    internal val LOG_TAG = "myLogs"
    internal val MAX_STREAMS = 5
    var  tvView:TextView?=null
    internal var sp: SoundPool?=null
    internal var sound1: Int = 0
    internal var sound2: Int = 0
    internal var sound3: Int = 0
    internal var sound4: Int = 0
    internal var sound5: Int = 0
    internal var sound6: Int = 0
    internal var sound7: Int = 0
    private var buttonPlay: Button? = null
    private var buttonStop: Button? = null
    internal var streamIDShot: Int = 0
    internal var streamIDExplosion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0)
        sp!!.setOnLoadCompleteListener(this)
        tvView =  findViewById<TextView>(R.id.textView)

        val s_1 = intent.getStringExtra("s_1")
        val s_2 = intent.getStringExtra("s_2")

        if(s_1!=null&&s_2==null)
            tvView!!.setText("Выбран звук: " + s_1)
        if(s_1!=null&&s_2!=null)
            tvView!!.setText("Выбраны звуки: " + s_1+" "+s_2 )



        sound1 = sp!!.load(this, R.raw.forest, 1)
        sound2 = sp!!.load(this, R.raw.sea, 1)
        sound3 = sp!!.load(this, R.raw.river, 1)
        sound4 = sp!!.load(this, R.raw.fire, 1)
        sound5 = sp!!.load(this, R.raw.vilage, 1)
        buttonPlay = this.pl_b
        buttonStop=this.st



        buttonPlay!!.setOnClickListener {
            if(s_1!=null&&s_2==null)
            {
                if(s_1=="forest")
                    sp!!.play(sound1, 1f, 1f, 0, -1, 1f)
                if(s_1=="sea")
                    sp!!.play(sound2, 1f, 1f, 0, -1, 1f)
                if(s_1=="river")
                    sp!!.play(sound3, 1f, 1f, 0, -1, 1f)
                if(s_1=="fire")
                    sp!!.play(sound4, 1f, 1f, 0, -1, 1f)
                if(s_1=="vilage")
                    sp!!.play(sound5, 1f, 1f, 0, -1, 1f)

            }
            if(s_1!=null&&s_2!=null)
            {
                if(s_1=="forest")
                {
                    if(s_2=="sea")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="river")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="fire")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="vilage")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }

                }
                if(s_1=="sea")
                {
                    if(s_2=="forest")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="river")
                    {
                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="fire")
                    {
                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="vilage")
                    {
                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }
                }
                if(s_1=="river")
                {
                    if(s_2=="forest")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="sea")
                    {
                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="fire")
                    {
                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="vilage")
                    {
                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }

                }
                if(s_1=="fire")
                {
                    if(s_2=="forest")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="sea")
                    {
                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="sea")
                    {
                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="vilage")
                    {
                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }

                }
                if(s_1=="vilage")
                {
                    if(s_2=="forest")
                    {
                        sp!!.play(sound1, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="sea")
                    {
                        sp!!.play(sound2, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="sea")
                    {
                        sp!!.play(sound3, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }
                    if(s_2=="fire")
                    {
                        sp!!.play(sound4, 1f, 1f, 0, -1, 1f)

                        sp!!.play(sound5, 1f, 1f, 0, -1, 1f)
                    }

                }

            }


        }

        buttonStop!!.setOnClickListener{
            sp!!.stop(sound1)
            sp!!.stop(sound2)
            sp!!.stop(sound3)
            sp!!.stop(sound4)
            sp!!.stop(sound5)
            sp!!.stop(sound6)
            sp!!.stop(sound7)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.pb -> {
                val it = Intent(this,playback::class.java)
                startActivity(it)
            }
            R.id.vs -> {
                val it = Intent(this,voice::class.java)
                startActivity(it)
            }
            R.id.h -> {
                val it = Intent(this,help::class.java)
                startActivity(it)
            }

        }
        return super.onOptionsItemSelected(item)
    }

   /* fun onClick(view: View) {
        sp!!.play(soundIdShot, 1f, 1f, 0, 0, 1f)
        sp!!.play(soundIdExplosion, 1f, 1f, 0, 0, 1f)
    }*/

    override fun onLoadComplete(soundPool: SoundPool, sampleId: Int, status: Int) {
        Log.d(LOG_TAG, "onLoadComplete, sampleId = $sampleId, status = $status")

    }

}