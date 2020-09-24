package ly.test.diffutilssample.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import ly.test.diffutilssample.di.AppFragmentFactory
import ly.test.diffutilssample.ui.StudentFragment
import kotlin.reflect.KClass

@Module
@InstallIn(ActivityComponent::class)
abstract class FragmentModule {


    @Binds
    abstract fun provideFragmentFactory(factory: AppFragmentFactory):FragmentFactory

    @Binds
    @IntoMap
    @FragmentKey(StudentFragment::class)
    abstract fun provideStudentFragment(studentFragment: StudentFragment): Fragment

}
@MapKey
annotation class FragmentKey(val clazz: KClass<out Fragment>)