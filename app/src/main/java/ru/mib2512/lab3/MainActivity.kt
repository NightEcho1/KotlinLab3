package ru.mib2512.lab3

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import ru.mib2512.lab3.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) showFragment(true)
        binding.frag1Btn.setOnClickListener { showFragment(true) }
        binding.frag2Btn.setOnClickListener { showFragment(false) }
        binding.switchBtn.setOnClickListener {
            showFragment(supportFragmentManager.findFragmentById(R.id.fragment_container_view) !is FirstFragment)
        }
    }
    private fun showFragment(first: Boolean) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, if (first) FirstFragment() else SecondFragment())
        }
    }
}
