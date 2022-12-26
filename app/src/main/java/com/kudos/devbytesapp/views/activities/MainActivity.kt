package com.kudos.devbytesapp.views.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kudos.devbytesapp.databinding.ActivityMainBinding
import com.kudos.devbytesapp.viewmodels.DevBytesViewModel
import com.kudos.devbytesapp.views.adapters.DevBytesVideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var devBytesAdapter: DevBytesVideoAdapter
    private lateinit var binding: ActivityMainBinding
    private val devBytesViewModel: DevBytesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupDevBytesList()
        observePlaylist()
    }

    private fun observePlaylist() {
        lifecycleScope.launch {
            devBytesViewModel.playlist.observe(this@MainActivity) {
                it?.let {
                    devBytesAdapter.submitList(it)
                }
            }
        }
    }

    private fun setupDevBytesList() {
        devBytesAdapter = DevBytesVideoAdapter { item ->
            val packageManager = packageManager ?: return@DevBytesVideoAdapter

            // Try to generate a direct intent to the YouTube app
            var intent = Intent(Intent.ACTION_VIEW, item.url.toUri())
            if(intent.resolveActivity(packageManager) == null) {
                // YouTube app isn't found, use the web url
                intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            }

            startActivity(intent)
        }
        binding.devBytesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = devBytesAdapter
        }
    }
}