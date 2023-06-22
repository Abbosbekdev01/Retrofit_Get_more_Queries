package uz.abbosbek.retrofitget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import uz.abbosbek.retrofitget.databinding.ActivityMainBinding
import uz.abbosbek.retrofitget.repository.Repository

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewModel: MainVIewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainVIewModel::class.java)

        val options:HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        binding.btnGet.setOnClickListener {
            val myNumber = binding.edtText.text.toString()
            //todo:Api dan keladigan ma'lumotlarni saralab beradi<asc> 'o'sish va kamayish tartibida <desc>'
            viewModel.getCustomPost2(Integer.parseInt(myNumber), options)
            viewModel.myCustomPosts2.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    binding.textView.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("Response", it.userId.toString() )
                        Log.d("Response", it.id.toString() )
                        Log.d("Response", it.title)
                        Log.d("Response", it.body)
                        Log.d("Response", "----------------")
                    }
                }else{
                    binding.textView.text = response.code().toString()
                }
            })
        }
    }
}