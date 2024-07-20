package com.apass.collegeifba.s50.dsg005.positivebalance.data.auth

import java.io.Serializable

interface AuthRequest: Serializable {

    fun login(auth: AuthRequest)
}
