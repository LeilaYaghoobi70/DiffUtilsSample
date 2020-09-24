package ly.test.diffutilssample.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ly.test.diffutilssample.model.Student
import javax.inject.Inject

class StudentViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var studens = ArrayList<Student>()
}
