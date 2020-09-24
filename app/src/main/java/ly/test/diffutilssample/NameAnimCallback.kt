package ly.test.diffutilssample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ly.test.diffutilssample.databinding.ItemListRecycleBinding
import ly.test.diffutilssample.model.Student
import java.sql.Struct

class StudentAdapter (var listStudent: ArrayList<Student>): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder =
        StudentViewHolder(
            ItemListRecycleBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        listStudent.forEach {  holder.onBind(it) }
    }

    override fun getItemCount(): Int =listStudent.size

    fun submitList(newStudents: ArrayList<Student>){
        val diffResult : DiffUtil.DiffResult = DiffUtil.calculateDiff(
        NameAnimCallback(newStudents,listStudent)
    )

        listStudent.clear()
        listStudent.addAll(newStudents)
        diffResult.dispatchUpdatesTo(this)
    }


    class StudentViewHolder(private val binding: ItemListRecycleBinding): RecyclerView.ViewHolder(binding.root){

        fun onBind(student: Student){
            binding.name.text = student.studentName
            binding.number.text = student.studentNumber.toString()
        }
    }

    class NameAnimCallback(
        private var newListNameAnim: List<Student>,
        private var oldLIstNameAnim: List<Student>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldLIstNameAnim.size

        override fun getNewListSize(): Int = newListNameAnim.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldLIstNameAnim[oldItemPosition].studentNumber == newListNameAnim[newItemPosition].studentNumber

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldLIstNameAnim[oldItemPosition] == newListNameAnim[newItemPosition]

    }
}

