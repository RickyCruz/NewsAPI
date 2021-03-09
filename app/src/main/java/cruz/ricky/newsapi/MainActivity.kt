package cruz.ricky.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import cruz.ricky.newsapi.databinding.ActivityMainBinding
import cruz.ricky.newsapi.presentation.viewmodel.NewsViewModel
import cruz.ricky.newsapi.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var newsViewModelFactory: NewsViewModelFactory
    lateinit var newsViewModel: NewsViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavView.setupWithNavController(
            nav_host_fragment.findNavController()
        )

        newsViewModel =ViewModelProvider(this, newsViewModelFactory)
            .get(NewsViewModel::class.java)
    }

}