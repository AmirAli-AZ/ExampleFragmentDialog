package com.amirali.examplefragmentdialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.amirali.examplefragmentdialog.databinding.DialogLayoutBinding

class ExampleDialogFragment : DialogFragment() {

    private lateinit var binding: DialogLayoutBinding

    private lateinit var listener: Listener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.dialog_layout, container, false)
        binding = DialogLayoutBinding.bind(rootView)

        binding.btnPositive.setOnClickListener {
            val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId

            if (selectedRadioButtonId != -1) {
                val selectedItem = rootView.findViewById<RadioButton>(selectedRadioButtonId).text
                listener.onResult(selectedItem.toString())

                dismiss()
            }else {
                Toast.makeText(context, "select an item", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnNegative.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = activity as Listener
        }catch (e: ClassCastException) {
            throw ClassCastException("implement Listener interface to activity")
        }
    }

    interface Listener {
        fun onResult(selectedItem: String)
    }
}