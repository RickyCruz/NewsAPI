package cruz.ricky.newsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import cruz.ricky.newsapi.databinding.ActivityMainBinding
import cruz.ricky.newsapi.presentation.adapter.NewsAdapter
import cruz.ricky.newsapi.presentation.viewmodel.NewsViewModel
import cruz.ricky.newsapi.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var newsViewModelFactory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter

    lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()

        binding.bottomNavView.setupWithNavController(
            navController
        )

        newsViewModel = ViewModelProvider(this, newsViewModelFactory)
            .get(NewsViewModel::class.java)
    }

}