package com.uninorte.hojadevida


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.uninorte.hojadevida.model.UserPersonalModel

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var userPersonalModel1: UserPersonalModel
    lateinit var userPersonalModel2: UserPersonalModel
    lateinit var userPersonalModel3: UserPersonalModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        userPersonalModel1 = UserPersonalModel("Juanita Perez",20,"Ver TV", 2)
        userPersonalModel2 = UserPersonalModel("cris Perez",20,"Ver TV", 2)
        userPersonalModel3 = UserPersonalModel("andres Perez",20,"Ver TV", 2)
        view.findViewById<Button>(R.id.button_persona1).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_persona2).setOnClickListener(this)
        view.findViewById<Button>(R.id.button_persona3).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v!!.id){

           R.id.button_persona1 -> {
               val bundle = bundleOf("data" to userPersonalModel1, "nombre" to userPersonalModel1.name)
               navController!!.navigate(R.id.action_mainFragment_to_personalFragment,bundle)
           }

           R.id.button_persona2 -> {
               val bundle = bundleOf("data" to userPersonalModel2, "nombre" to userPersonalModel2.name)
               navController!!.navigate(R.id.action_mainFragment_to_personalFragment,bundle)
           }

           R.id.button_persona3 -> {
               val bundle = bundleOf("data" to userPersonalModel3, "nombre" to userPersonalModel3.name)
               navController!!.navigate(R.id.action_mainFragment_to_personalFragment,bundle)
           }
       }
    }
}
