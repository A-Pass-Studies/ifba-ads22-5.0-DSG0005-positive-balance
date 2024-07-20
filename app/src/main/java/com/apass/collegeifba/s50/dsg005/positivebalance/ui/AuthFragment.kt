package com.apass.collegeifba.s50.dsg005.positivebalance.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.apass.collegeifba.s50.dsg005.positivebalance.R
import com.apass.collegeifba.s50.dsg005.positivebalance.model.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class AuthFragment : Fragment() {

    var listeners: AuthFragmentListener? = null

    private val login: MaterialButton
        by lazy { requireView().findViewById(R.id.fragment_auth_login) }

    private val username: TextInputLayout
        by lazy { requireView().findViewById(R.id.fragment_auth_username_container) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login.setOnClickListener {
            listeners?.onSucess(
                User(username.editText?.text?.toString() ?: "", Uri.parse("http://localhost/"))
            )
        }
    }

    interface AuthFragmentListener {
        fun onSucess(user: User)
        fun onFailure(msg: String)
    }
}
