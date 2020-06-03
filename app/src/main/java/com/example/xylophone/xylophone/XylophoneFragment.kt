package com.example.xylophone.xylophone

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.xylophone.R
import com.example.xylophone.databinding.FragmentXylophoneBinding
import java.io.IOException
import java.time.LocalDateTime

data class Player(val id:String, var player: MediaPlayer){}

class XylophoneFragment: Fragment(), MediaPlayer.OnErrorListener {

    private lateinit var viewModel: XylophoneViewModel
    private lateinit var viewModelFactory: XylophoneViewModelFactory
    private var mediaPlayers = HashSet<Player>()

//    private val fragmentJob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + fragmentlJob)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentXylophoneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_xylophone, container, false)
        binding.lifecycleOwner = this
        viewModelFactory = XylophoneViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(XylophoneViewModel::class.java)
        binding.viewModel = viewModel
        registerObservers()
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun registerObservers(){
        viewModel.playEvent.observe(this, Observer {
            it?.let{
                val id =  LocalDateTime.now().toString()
                val mediaPlayer = MediaPlayer()
                Log.i("XylophoneFragment","Cria player com id: $id")

                // Guarda referência do player criado
                val player = Player(id, mediaPlayer)
                mediaPlayers.add(player)
                Log.i("XylophoneFragment","Conteudo do hashSet: $mediaPlayers")

                registerPlayerListeners(player)
                playSong(it.toLowerCase(),mediaPlayer)
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun playSong(musicalNote: String, player: MediaPlayer) {
        activity?.let{ activity ->
            val filename: String = "android.resource://${activity.packageName}/raw/${musicalNote.toLowerCase()}";
            Log.i("XylophoneFragment", filename)
            try{
                player.setDataSource(context, Uri.parse(filename))
            }catch(error: IOException){
                Log.i("XylophoneFragment", "Error no setDataSource: $error")
            }
            player.prepareAsync()
        }
    }

    private fun registerPlayerListeners(player: Player) {
        player.player.setOnPreparedListener {
            Log.i("XylophoneFragment","Player de id:${player.id} está pronto! tocando...")
            it.start()
        }
        player.player.setOnCompletionListener {
            Log.i("XylophoneFragment","Player de id:${player.id} terminou de tocar! Removendo...")
            it.release()
            mediaPlayers.remove(player)
            Log.i("XylophoneFragment","Conteudo do hashSet: $mediaPlayers")
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("XylophoneFragment","Fragment sendo pausado, removendo todos os players..")
        mediaPlayers.map {player ->
            player.player.release()
        }
        mediaPlayers.clear()
        Log.i("XylophoneFragment","Conteudo do hashSet: $mediaPlayers")
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        val error = when(what){
            MediaPlayer.MEDIA_ERROR_IO -> "MEDIA_ERROR_IO"
            MediaPlayer.MEDIA_ERROR_MALFORMED -> "MEDIA_ERROR_MALFORMED"
            MediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK -> "MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK"
            MediaPlayer.MEDIA_ERROR_SERVER_DIED -> "MEDIA_ERROR_SERVER_DIED"
            MediaPlayer.MEDIA_ERROR_TIMED_OUT -> "MEDIA_ERROR_TIMED_OUT"
            MediaPlayer.MEDIA_ERROR_UNKNOWN -> "MEDIA_ERROR_UNKWNOWN"
            MediaPlayer.MEDIA_ERROR_UNSUPPORTED -> "MEDIA_ERROR_UNSUPPORTED"
            else -> "MEDIA_ERROR_UNKNOWN"
        }

        Log.i("XylophoneFragment", "Erro no media player!")
        Log.i("XylophoneFragment", error)

        return false
    }
}