package uz.abbosbek.retrofitget

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import uz.abbosbek.retrofitget.models.Post
import uz.abbosbek.retrofitget.repository.Repository

class MainVIewModel(private val repository:Repository ):ViewModel() {

    val myResponse:MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2:MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomPosts:MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts2:MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun pushPost(post: Post){
        viewModelScope.launch{
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun pushPost2(userId: Int, id: Int, title: String, body: String){
        viewModelScope.launch{
            val response = repository.pushPost2(userId, id, title, body)
            myResponse.value = response
        }
    }
    fun getPost(auth:String){
        viewModelScope.launch {
            val response = repository.getPost(auth)
            myResponse.value = response
        }
    }

    fun getPost2(number:Int){
        viewModelScope.launch {
            val response = repository.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPosts(userId:Int, sort:String, order:String){
        viewModelScope.launch {
            val response = repository.getCustomPosts(userId,sort,order)
            myCustomPosts.value = response
        }
    }

    fun getCustomPost2(userId: Int, options:Map<String,String>){
        viewModelScope.launch {
            val response = repository.getCustomPost2(userId, options)
            myCustomPosts2.value = response
        }
    }
}