package uz.abbosbek.retrofitget.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.abbosbek.retrofitget.R
import uz.abbosbek.retrofitget.databinding.ItemRvBinding
import uz.abbosbek.retrofitget.models.Post

class MyAdapter(var myList: List<Post> = emptyList()) : RecyclerView.Adapter<MyAdapter.Vh>() {

    inner class Vh(val itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(post: Post) {
            itemRv.userIdText.text = post.userId.toString()
            itemRv.idText.text = post.id.toString()
            itemRv.titleText.text = post.title
            itemRv.bodyText.text = post.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(myList[position])
    }

    fun setDate(newList:List<Post>){
        myList = newList
        notifyDataSetChanged()
    }

}