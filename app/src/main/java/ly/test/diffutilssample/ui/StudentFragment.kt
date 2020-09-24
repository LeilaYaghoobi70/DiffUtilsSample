package ly.test.diffutilssample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ly.test.diffutilssample.StudentAdapter
import ly.test.diffutilssample.databinding.StudentFragmentBinding
import ly.test.diffutilssample.model.Student
import javax.inject.Inject


class StudentFragment @Inject constructor(
) : Fragment() {

   private val viewModel: StudentViewModel by viewModels ()
   private val students = ArrayList<Student>()
   private val newList = ArrayList<Student>()
   private lateinit var adapter: StudentAdapter
   private var binding:StudentFragmentBinding? = null
   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {

      binding = StudentFragmentBinding.inflate(LayoutInflater.from(requireContext())).apply {
         recyclerview.layoutManager = LinearLayoutManager(requireContext())
         adapter = StudentAdapter(viewModel.studens)
         recyclerview.adapter = adapter
         add.setOnClickListener { addItem(binding?.studentNumber?.text.toString().toInt(),binding?.studentName?.text.toString()) }
      }
      return binding!!.root
   }


   private fun addItem(studentNumber : Int, studentName: String) {
      var student = Student()
      student.studentName = studentName
      student.studentNumber = studentNumber
      newList.add(student)
      adapter.submitList(newList)
   }
}