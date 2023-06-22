package uz.abbosbek.retrofitget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.abbosbek.retrofitget.repository.Repository

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainVIewModel(repository) as T
    }
}